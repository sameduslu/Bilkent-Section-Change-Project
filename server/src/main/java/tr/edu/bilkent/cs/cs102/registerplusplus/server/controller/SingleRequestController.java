package tr.edu.bilkent.cs.cs102.registerplusplus.server.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private final CourseService courseService; //todo why not remove

    private final RequestProcessorService requestProcessorService;

    private final CourseRepository courseRepository;

    private final StudentRepository studentRepository;

    SingleRequestController(SingleRequestRepository singleRequestRepository, CourseService courseService, RequestProcessorService requestProcessorService, CourseRepository courseRepository, StudentRepository studentRepository) {
        this.singleRequestRepository = singleRequestRepository;
        this.courseService = courseService;
        this.requestProcessorService = requestProcessorService;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/singleRequests")
    public List<SingleRequest> all() {
        return singleRequestRepository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/singleRequest")
    public String newItem(@RequestBody String singleRequestString) {
        SingleRequest singleRequest = new Gson().fromJson(singleRequestString, SingleRequest.class);
        Optional<Student> reqOwnerById = studentRepository.findById(singleRequest.getRequestOwner().getId());
        if (reqOwnerById.isEmpty()){
            return "Bad Request";
        }
        Student requestOwner = reqOwnerById.get();
        Course wantedCourse = courseRepository.findCourseById(singleRequest.getWantedCourse().getId());
        List<Course> coursesOfStudent = courseRepository.findCourseByStudentsId(requestOwner.getId());
        if(!requestProcessorService.isStillValid(wantedCourse, requestOwner, coursesOfStudent)){
            return "Not compatible";
        }
        if (singleRequestRepository.findSingleRequestByRequestOwner_Id(requestOwner.getId()).contains(singleRequest)){
            return "Request already exists";
        }
        SingleRequest save = singleRequestRepository.save(singleRequest);
        requestProcessorService.processNonForumRequests();
        return "Saved";
    }
}
