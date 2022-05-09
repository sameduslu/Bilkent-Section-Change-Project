package tr.edu.bilkent.cs.cs102.registerplusplus.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    StudentController(StudentRepository repository) {
        this.studentRepository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/students")
    public List<Student> all() {
        return studentRepository.findAll();
    }

    @GetMapping("/students")
    public Student getStudentById(@RequestBody String id){
        Optional<Student> studentById = studentRepository.findById(id);
        if (studentById.isEmpty()){
            return null;
        }
        return studentById.get();
    }
    // end::get-aggregate-root[]

    @PostMapping("/student")
    public Student newItem(@RequestBody Student student) {
        return studentRepository.save(student);
    }
}
