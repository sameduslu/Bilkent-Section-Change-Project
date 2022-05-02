package tr.edu.bilkent.cs.cs102.registerplusplus.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.SingleRequest;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.SingleRequestRepository;

import java.util.List;

@RestController
public class SingleRequestController {

    private final SingleRequestRepository repository;

    SingleRequestController(SingleRequestRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/singleRequests")
    List<SingleRequest> all() {
        List<SingleRequest> all = repository.findAll();
        return all;
    }
    // end::get-aggregate-root[]

    @PostMapping("/singleRequest")
    SingleRequest newItem(@RequestBody SingleRequest singleRequest) {
        SingleRequest save = repository.save(singleRequest);
        return save;
    }
}
