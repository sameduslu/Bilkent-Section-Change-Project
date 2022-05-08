package tr.edu.bilkent.cs.cs102.registerplusplus.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Course;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.SingleRequest;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.CourseRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.SingleRequestRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.service.CourseService;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.service.RequestProcessorService;

import java.util.List;

@RestController
public class SingleRequestController {

    private final SingleRequestRepository singleRequestRepository;
    private final CourseService courseService; //todo why not remove

    private final RequestProcessorService requestProcessorService;

    private final CourseRepository courseRepository;

    SingleRequestController(SingleRequestRepository singleRequestRepository, CourseService courseService, RequestProcessorService requestProcessorService, CourseRepository courseRepository) {
        this.singleRequestRepository = singleRequestRepository;
        this.courseService = courseService;
        this.requestProcessorService = requestProcessorService;
        this.courseRepository = courseRepository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/singleRequests")
    public List<SingleRequest> all() {
        return singleRequestRepository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/singleRequest")
    public String newItem(@RequestBody SingleRequest singleRequest) {
        Student requestOwner = singleRequest.getRequestOwner();
        List<Course> coursesOfStudent = courseRepository.findCourseByStudentsId(requestOwner.getId());
        if(!requestProcessorService.isStillValid(singleRequest.getWantedCourse(), requestOwner, coursesOfStudent)){
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
