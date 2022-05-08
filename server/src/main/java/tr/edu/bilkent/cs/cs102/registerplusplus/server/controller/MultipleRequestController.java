package tr.edu.bilkent.cs.cs102.registerplusplus.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Course;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.MultipleRequest;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.CourseRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.MultipleRequestRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.StudentRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.service.CourseService;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.service.RequestProcessorService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class MultipleRequestController {
    private final MultipleRequestRepository multipleRequestRepository;

    private final CourseService courseService; //todo why not remove

    private final CourseRepository courseRepository;

    private final RequestProcessorService requestProcessorService;

    private final StudentRepository studentRepository;

    public MultipleRequestController(MultipleRequestRepository multipleRequestRepository, CourseService courseService, CourseRepository courseRepository, RequestProcessorService requestProcessorService, StudentRepository studentRepository) {
        this.multipleRequestRepository = multipleRequestRepository;
        this.courseService = courseService;
        this.courseRepository = courseRepository;
        this.requestProcessorService = requestProcessorService;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/multipleRequests")
    public List<MultipleRequest> all() {
        return multipleRequestRepository.findAll();
    }

    @PostMapping("/multipleRequest")
    public String newItem(@RequestBody MultipleRequest multipleRequest) {
        Optional<Student> reqOwnerById = studentRepository.findById(multipleRequest.getRequestOwner().getId());
        if (reqOwnerById.isEmpty()){
            return "Bad Request";
        }
        Student requestOwner = reqOwnerById.get();
        List<Course> coursesOfStudent = courseRepository.findCourseByStudentsId(requestOwner.getId());
        if(!requestProcessorService.isStillValid(multipleRequest.getWantedCourses(), requestOwner, coursesOfStudent)){
            return "Not compatible";
        }
        if (multipleRequestRepository.findMultipleRequestsByRequestOwner_Id(requestOwner.getId()).contains(multipleRequest)){
            return "Request already exists";
        }
        Set<String> saved = new HashSet<>();
        for (Course course : multipleRequest.getWantedCourses()){
            String name = course.getName();
            if (saved.contains(name)){
                return "Invalid request";
            }
            saved.add(name);
        }
        MultipleRequest save = multipleRequestRepository.save(multipleRequest);
        requestProcessorService.processNonForumRequests();
        return "Saved.";
    }
}
