package tr.edu.bilkent.cs.cs102.registerplusplus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.RegisterPlusPlusServer;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.controller.CourseController;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.controller.SingleRequestController;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.controller.StudentController;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Course;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.SingleRequest;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.CourseRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.SingleRequestRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.StudentRepository;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestPropertySource(properties = {
        "spring.data.mongodb.database=registerplusplus-test"
})
class DemoApplicationTests {

    @Configuration
    @Import(RegisterPlusPlusServer.class)
    public static class TestConfiguration {

    }

    @Autowired
    CourseController courseController;

    @Autowired
    StudentController studentController;

    @Autowired
    SingleRequestController singleRequestController;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SingleRequestRepository singleRequestRepository;

    @BeforeEach
    public void setup() {
        courseRepository.deleteAll();
        studentRepository.deleteAll();
        singleRequestRepository.deleteAll();
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void courseCreateTest() {
        Course course = createCourse1();

        List<Course> all = courseController.all();
        Optional<Course> result = all.stream().filter(course1 -> course1.getId().equals("CS102-1")).findAny();
        assertTrue(result.isPresent());
        Course dbCourse = result.get();
        assertThat(course.getName(), is(dbCourse.getName()));
    }

    private Course createCourse1() {
        boolean[][] program = new boolean[9][6];
        program[1][5] = true;
        program[2][4] = true;
        program[3][5] = true;
        program[6][5] = true;
        return createCourse("CS102", "1", program);
    }

    private Course createCourse2() {
        boolean[][] program = new boolean[9][6];
        program[1][5] = true;
        program[2][1] = true;
        return createCourse("MATH102", "1", program);
    }

    private Course createCourse(String name, String section, boolean[][] program) {
        Course course = new Course();
        course.setName(name);
        course.setSection(section);
        course.setId(name + "-" + section);

        course.setProgram(program);
        return courseController.newItem(course);
    }

    @Test
    public void studentCreateTest() {
        Student student = createStudent1();

        List<Student> all = studentController.all();
        Optional<Student> result = all.stream().filter(s -> s.getId().equals("1")).findAny();
        assertTrue(result.isPresent());
        Student dbStudent = result.get();
        assertThat(student.getName(), is(dbStudent.getName()));
    }

    private Student createStudent1() {
        Student student = createStudent("Burhan Tabak", "1");
        return student;
    }

    private Student createStudent(String name, String id) {
        Student student = new Student(name, id);
        studentController.newItem(student);
        return student;
    }

    @Test
    public void studentSingleRequestTest() {
        createCourse1();
        createStudent1();

        createSingleRequest("CS102-1", "1", "Burhan");

        List<SingleRequest> all = singleRequestController.all();
        Optional<SingleRequest> result = all.stream().filter(s -> s.getRequestOwner().getId().equals("1")).findAny();
        assertTrue(result.isEmpty());

        checkStudentEnrolledInCourse("CS102-1", "1");
    }

    private void checkStudentEnrolledInCourse(String courseId, String studentId) {
        Course course = courseController.all().stream().filter(c -> c.getId().equals(courseId)).findAny().get();
        List<Student> students = course.getStudents();
        assertThat(students, is(not(nullValue())));
        Optional<Student> any = students.stream().filter(s -> s.getId().equals(studentId)).findAny();
        assertThat(any.isPresent(), is(true));
        assertThat(any.get().getId(), is(studentId));
    }

    private void createSingleRequest(String courseId, String studentId, String studentName) {
        SingleRequest req = new SingleRequest();
        Course wantedCourse = new Course();
        wantedCourse.setId(courseId);
        req.setWantedCourse(wantedCourse);
        Student student = new Student(studentName, studentId);
        req.setRequestOwner(student);
        singleRequestController.newItem(req);
    }

    @Test
    public void courseOverlapTest() {
        createStudent1();
        createCourse1();
        createCourse2();

        createSingleRequest("CS102-1", "1", "Burhan");
        checkStudentEnrolledInCourse("CS102-1", "1");

        createSingleRequest("MATH102-1", "1", "Burhan");

        Course course = courseController.all().stream().filter(c -> c.getId().equals("MATH102-1")).findAny().get();
        List<Student> students = course.getStudents();
        assertThat(students, is(not(nullValue())));
        Optional<Student> any = students.stream().filter(s -> s.getId().equals("1")).findAny();
        assertThat(any.isEmpty(), is(true));
    }

}
