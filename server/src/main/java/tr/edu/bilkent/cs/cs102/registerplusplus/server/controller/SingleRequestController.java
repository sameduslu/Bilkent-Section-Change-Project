package tr.edu.bilkent.cs.cs102.registerplusplus.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Course;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.SingleRequest;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.CourseRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.SingleRequestRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.StudentRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.service.CourseService;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.service.RequestProcessorService;

import java.util.List;
import java.util.Optional;

@RestController
public class SingleRequestController {

    private final SingleRequestRepository singleRequestRepository;

    private final RequestProcessorService requestProcessorService;

    private final CourseRepository courseRepository;

    private final StudentRepository studentRepository;

    SingleRequestController(SingleRequestRepository singleRequestRepository, RequestProcessorService requestProcessorService, CourseRepository courseRepository, StudentRepository studentRepository) {
        this.singleRequestRepository = singleRequestRepository;
        this.requestProcessorService = requestProcessorService;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/singleRequests")
    public List<SingleRequest> all() {
        return singleRequestRepository.findAll();
    }


    @PostMapping("/singleRequest")
    public String newItem(@RequestParam String ownerStudentId, @RequestParam String wantedCourseId) {
        Optional<Student> reqOwnerById = studentRepository.findById(ownerStudentId);
        if (reqOwnerById.isEmpty()) {
            return "Bad Request";
        }
        Student requestOwner = reqOwnerById.get();
        Course wantedCourse = courseRepository.findCourseById(wantedCourseId);
        List<Course> coursesOfStudent = courseRepository.findCourseByStudentsId(ownerStudentId);
        if (!requestProcessorService.isStillValid(wantedCourse, requestOwner, coursesOfStudent)) {
            return "Not compatible";
        }
        SingleRequest singleRequest = new SingleRequest();
        singleRequest.setWantedCourse(wantedCourse);
        singleRequest.setRequestOwner(requestOwner);
        if (singleRequestRepository.findSingleRequestByRequestOwner_Id(requestOwner.getId()).contains(singleRequest)) {
            return "Request already exists";
        }
        singleRequestRepository.save(singleRequest);
        requestProcessorService.processNonForumRequests();
        System.out.println("saved");
        return "Saved";
    }
}
