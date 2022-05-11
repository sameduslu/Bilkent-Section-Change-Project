package tr.edu.bilkent.cs.cs102.registerplusplus.server.controller;

import org.springframework.web.bind.annotation.*;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Course;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.CourseRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.StudentRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    private final StudentService studentService;

    StudentController(StudentRepository repository, CourseRepository courseRepository, StudentService studentService) {
        this.studentRepository = repository;
        this.courseRepository = courseRepository;
        this.studentService = studentService;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/students")
    public List<Student> all() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable String id){
        Optional<Student> studentById = studentRepository.findById(id);
        if (studentById.isEmpty()){
            return null;
        }
        return studentById.get();
    }

    @GetMapping("/studentSchedule/{id}")
    public Course[][] getStudentCourseSchedule(@PathVariable String id){
        Optional<Student> studentById = studentRepository.findById(id);
        if (studentById.isEmpty()){
            return null;
        }
        return studentService.getSchedule(studentById.get().getId());
    }
    // end::get-aggregate-root[]

    @PostMapping("/student")
    public Student newItem(@RequestBody Student student) {
        return studentRepository.save(student);
    }
}
