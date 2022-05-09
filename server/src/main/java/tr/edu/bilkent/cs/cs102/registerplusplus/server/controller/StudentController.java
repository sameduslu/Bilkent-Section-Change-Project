package tr.edu.bilkent.cs.cs102.registerplusplus.server.controller;

import org.springframework.web.bind.annotation.*;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Course;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Person;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.CourseRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    StudentController(StudentRepository repository, CourseRepository courseRepository) {
        this.studentRepository = repository;
        this.courseRepository = courseRepository;
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
        Student student = studentById.get();
        List<Course> coursesOfStudent = courseRepository.findCourseByStudentsId(id);
        Course[][] schedule = student.getSchedule();
        for(Course c : coursesOfStudent){
            boolean[][] courseSchedule = c.getProgram();
            for (int i = 0; i < courseSchedule.length; i++) {
                for (int j = 0; j < courseSchedule[i].length; j++) {
                    if (courseSchedule[i][j]){
                        schedule[i][j] = c;
                    }
                }
            }
        }
        student.setSchedule(schedule);
        return student;
    }
    // end::get-aggregate-root[]

    @PostMapping("/student")
    public Student newItem(@RequestBody Student student) {
        return studentRepository.save(student);
    }
}
