package tr.edu.bilkent.cs.cs102.registerplusplus.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Instructor;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.InstructorRepository;

import java.util.List;

@RestController
public class InstructorController {
    private final InstructorRepository repository;

    InstructorController(InstructorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/instructors")
    List<Instructor> all() {
        return repository.findAll();
    }

    @PostMapping("/instructor")
    Instructor newItem(@RequestBody Instructor instructor) {
        return repository.save(instructor);
    }
}
