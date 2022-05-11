package tr.edu.bilkent.cs.cs102.registerplusplus.server.controller;

import org.springframework.web.bind.annotation.*;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Course;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.ForumRequest;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.ForumRequestApproval;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.CourseRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.ForumRequestRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.StudentRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.service.CourseService;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.service.RequestProcessorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ForumRequestController {
    private final ForumRequestRepository forumRequestRepository;

    private final StudentRepository studentRepository;

    private final CourseService courseService; // todo why not remove

    private final CourseRepository courseRepository;

    private final RequestProcessorService requestProcessorService;

    public ForumRequestController(ForumRequestRepository forumRequestRepository, StudentRepository studentRepository, CourseService courseService, CourseRepository courseRepository, RequestProcessorService requestProcessorService) {
        this.forumRequestRepository = forumRequestRepository;
        this.studentRepository = studentRepository;
        this.courseService = courseService;
        this.courseRepository = courseRepository;
        this.requestProcessorService = requestProcessorService;
    }

    @GetMapping("/forumRequests")
    public List<ForumRequest> all() {
        return forumRequestRepository.findAll();
    }

    @GetMapping("/forumRequests/{id}")
    public List<ForumRequest> forStudent(@PathVariable String id){
        List<ForumRequest> all = all();
        List<ForumRequest> res = new ArrayList<>();
        for(ForumRequest req : all){
            if (requestProcessorService.isForumRequestPossible(req, studentRepository.findById(id).get())){
                res.add(req);
            }
        }
        return res;
    }

    @PostMapping("/forumRequest")
    public String newItem(@RequestParam String studentId, @RequestParam String wantedCourseId) {
        Student requestOwner = studentRepository.findById(studentId).get();
        Course wantedCourse = courseRepository.findCourseById(wantedCourseId);
        Course currentCourse = courseRepository.findCourseByStudentsId(requestOwner.getId()).stream().filter(c -> c.getName().equals(wantedCourse.getName())).findAny().get();
        List<Course> coursesOfStudent = courseRepository.findCourseByStudentsId(requestOwner.getId());
        if (!requestProcessorService.isStillValid(wantedCourse, requestOwner, coursesOfStudent)){
            return "Not compatible";
        }
        ForumRequest check = new ForumRequest();
        check.setRequestOwner(requestOwner);
        check.setWantedCourse(wantedCourse);
        check.setCurrentCourse(currentCourse);
        if (forumRequestRepository.findForumRequestByRequestOwner_Id(requestOwner.getId()).contains(check)){
            return "Request already exists";
        }
        forumRequestRepository.save(check);
        return "Saved";
    }

    @PostMapping("/forumRequest-approval")
    public boolean approve(@RequestBody ForumRequestApproval forumRequestApproval) {
        String forumRequestId = forumRequestApproval.getForumRequest().getId();
        String acceptorId = forumRequestApproval.getAcceptorId();
        Optional<Student> acceptorById = studentRepository.findById(acceptorId);
        Optional<ForumRequest> forumRequestById = forumRequestRepository.findById(forumRequestId);
        if (forumRequestById.isEmpty() || acceptorById.isEmpty()){
            return false;
            //return "Bad Request";
        }

        ForumRequest forumRequest = forumRequestById.get();
        Student acceptor = acceptorById.get();
        if (!requestProcessorService.isForumRequestPossible(forumRequest,acceptor)){
            return false;
        }
        requestProcessorService.processForumRequest(forumRequest, acceptor);
        return true;
        //return String.format("Forum request id: %s Acceptor id: %s executed", forumRequestId, acceptorId);
    }
}
