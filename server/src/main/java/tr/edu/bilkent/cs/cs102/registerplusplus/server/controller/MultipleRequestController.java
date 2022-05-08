package tr.edu.bilkent.cs.cs102.registerplusplus.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.MultipleRequest;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.MultipleRequestRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.service.CourseService;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.service.RequestProcessorService;

import java.util.List;

@RestController
public class MultipleRequestController {
    private final MultipleRequestRepository multipleRequestRepository;

    private final CourseService courseService; //todo why not remove

    private final RequestProcessorService requestProcessorService;

    public MultipleRequestController(MultipleRequestRepository multipleRequestRepository, CourseService courseService, RequestProcessorService requestProcessorService) {
        this.multipleRequestRepository = multipleRequestRepository;
        this.courseService = courseService;
        this.requestProcessorService = requestProcessorService;
    }

    @GetMapping("/multipleRequests")
    public List<MultipleRequest> all() {
        return multipleRequestRepository.findAll();
    }

    @PostMapping("/multipleRequest")
    public MultipleRequest newItem(@RequestBody MultipleRequest multipleRequest) {
        // TODO check the request with isStillValid and the situation of containing course and the existence of request in the queue
        MultipleRequest save = multipleRequestRepository.save(multipleRequest);
        requestProcessorService.processNonForumRequests();
        return save;
    }
}
