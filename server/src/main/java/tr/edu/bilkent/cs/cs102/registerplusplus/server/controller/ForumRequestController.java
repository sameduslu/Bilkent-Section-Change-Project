package tr.edu.bilkent.cs.cs102.registerplusplus.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.ForumRequest;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.ForumRequestRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.service.CourseService;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.service.RequestProcessorService;

import java.util.List;

@RestController
public class ForumRequestController {
    private final ForumRequestRepository forumRequestRepository;

    private final CourseService courseService; // todo why not remove

    private final RequestProcessorService requestProcessorService;

    public ForumRequestController(ForumRequestRepository forumRequestRepository, CourseService courseService, RequestProcessorService requestProcessorService) {
        this.forumRequestRepository = forumRequestRepository;
        this.courseService = courseService;
        this.requestProcessorService = requestProcessorService;
    }

    @GetMapping("/forumRequests")
    public List<ForumRequest> all() {
        return forumRequestRepository.findAll();
    }

    @PostMapping("/forumRequest")
    public ForumRequest newItem(@RequestBody ForumRequest forumRequest) {
        //todo requestProcessorService call
        return forumRequestRepository.save(forumRequest);
    }

    /*someone accepts a forum request:
     *  requestProcessorService.processForumRequest();
     */

}
