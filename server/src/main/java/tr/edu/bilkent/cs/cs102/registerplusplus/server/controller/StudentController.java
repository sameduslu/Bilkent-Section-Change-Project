package tr.edu.bilkent.cs.cs102.registerplusplus.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.StudentRepository;

import java.util.List;

@RestController
public class StudentController {
    private final StudentRepository repository;

    StudentController(
            StudentRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/students")
    List<Student> all() {
        List<Student> all = repository.findAll();
        return all;
    }
    // end::get-aggregate-root[]

    @PostMapping("/student")
    Student newItem(@RequestBody Student student) {
        return repository.save(student);
    }
}
