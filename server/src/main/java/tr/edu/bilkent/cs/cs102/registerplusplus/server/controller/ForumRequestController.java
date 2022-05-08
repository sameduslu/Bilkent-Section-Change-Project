package tr.edu.bilkent.cs.cs102.registerplusplus.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Course;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.ForumRequest;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.ForumRequestApproval;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.CourseRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.ForumRequestRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.StudentRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.service.CourseService;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.service.RequestProcessorService;

import java.util.List;

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

    @PostMapping("/forumRequest")
    public String newItem(@RequestBody ForumRequest forumRequest) {
        Student requestOwner = forumRequest.getRequestOwner();
        List<Course> coursesOfStudent = courseRepository.findCourseByStudentsId(requestOwner.getId());
        if (!requestProcessorService.isStillValid(forumRequest.getWantedCourse(), requestOwner, coursesOfStudent)){
            return "Not compatible";
        }
        if (forumRequestRepository.findForumRequestByRequestOwner_Id(requestOwner.getId()).contains(forumRequest)){
            return "Request already exists";
        }
        return "Saved";
    }

    @PostMapping("/forumRequest-approval")
    public String approve(@RequestBody ForumRequestApproval forumRequestApproval) {
        String forumRequestId = forumRequestApproval.getForumRequestId();
        String acceptorId = forumRequestApproval.getAcceptorId();
        ForumRequest forumRequest = forumRequestRepository.findById(forumRequestId).get(); //todo isPresent check
        Student acceptor = studentRepository.findById(acceptorId).get();//todo isPresent check
        List<Course> coursesOfStudent = courseRepository.findCourseByStudentsId(acceptorId);
        if (!coursesOfStudent.contains(forumRequest.getWantedCourse())){
            return String.format("Forum request id: %s Acceptor id: %s is not executed since acceptor does not have the wanted course", forumRequestId, acceptorId);
        }
        requestProcessorService.processForumRequest(forumRequest, acceptor);
        return String.format("Forum request id: %s Acceptor id: %s executed", forumRequestId, acceptorId);
    }
}
