package tr.edu.bilkent.cs.cs102.registerplusplus.server.service;

import org.springframework.stereotype.Service;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Course;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.CourseRepository;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository repository;

    private final StudentService studentService;

    public CourseService(CourseRepository repository, StudentService studentService) {
        this.repository = repository;
        this.studentService = studentService;
    }

    public Course addStudentToCourse(Student student, Course course){
        Course dbCourse = repository.findCourseById(course.getId());
        List<Student> students = dbCourse.getStudents();
        students.add(student);
        dbCourse.setStudents(students);
        studentService.updateProgram(student, course);
        return repository.save(dbCourse);
    }

    public List<Course> getCourseByStudentId(Student student) {
        return repository.findCourseByStudentsId(student.getId());
    }
}
