package tr.edu.bilkent.cs.cs102.registerplusplus;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.RegisterPlusPlusServer;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.controller.CourseController;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.controller.MultipleRequestController;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.controller.SingleRequestController;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.controller.StudentController;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Course;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.MultipleRequest;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.SingleRequest;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.CourseRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.MultipleRequestRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.SingleRequestRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestPropertySource(properties = {
        "spring.data.mongodb.database=registerplusplus-test"
})
class DemoApplicationTests {

    public static final String COURSE_1A_ID = "CS102-1";
    public static final String COURSE_1B_ID = "CS102-2";


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
    MultipleRequestController multipleRequestController;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SingleRequestRepository singleRequestRepository;

    @Autowired
    MultipleRequestRepository multipleRequestRepository;

    @BeforeEach
    public void setup() {
        courseRepository.deleteAll();
        studentRepository.deleteAll();
        singleRequestRepository.deleteAll();
        multipleRequestRepository.deleteAll();
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void courseCreateTest() {
        Course course = createCourse1A();
        List<Course> all = courseController.all().getBody();
        assert all != null;
        Optional<Course> result = all.stream().filter(course1 -> course1.getId().equals(COURSE_1A_ID)).findAny();
        assertTrue(result.isPresent());
        Course dbCourse = result.get();
        assertThat(course.getName(), is(dbCourse.getName()));
    }

    private Course createCourse1A() {
        boolean[][] program = new boolean[9][6];
        program[1][5] = true;
        program[2][4] = true;
        program[3][5] = true;
        program[6][5] = true;
        return createCourse("CS102", "1", program);
    }

    private Course createCourse1B() {
        boolean[][] program = new boolean[9][6];
        program[2][5] = true;
        program[3][4] = true;
        program[3][5] = true;
        program[4][1] = true;
        return createCourse("CS102", "2", program);
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
        return createStudent("Burhan Tabak", "1");
    }

    private Student createStudent2() {
        return createStudent("Murat Kara", "2");
    }

    private Student createStudent3() {
        return createStudent("Gorkem Solun", "3");
    }

    private Student createStudent4() {
        return createStudent("Samed Uslu", "4");
    }

    private Student createStudent5() {
        return createStudent("Cenker Akan", "5");
    }

    private Student createStudent(String name, String id) {
        Student student = new Student(name, id);
        studentController.newItem(student);
        return student;
    }

    @Test
    public void studentSingleRequestTest() {
        createCourse1A();
        createStudent1();
        createSingleRequest("1", COURSE_1A_ID);
        List<SingleRequest> all = singleRequestController.all();
        Optional<SingleRequest> result = all.stream().filter(s -> s.getRequestOwner().getId().equals("1")).findAny();
        assertTrue(result.isEmpty());
        checkStudentEnrolledInCourse(COURSE_1A_ID, "1");
    }

    private void checkStudentEnrolledInCourse(String courseId, String studentId) {
        Optional<Course> anyCourse = courseController.all().getBody().stream().filter(c -> c.getId().equals(courseId)).findAny();
        assertTrue(anyCourse.isPresent());
        Course course = anyCourse.get();
        List<Student> students = course.getStudents();
        assertThat(students, is(not(nullValue())));
        Optional<Student> any = students.stream().filter(s -> s.getId().equals(studentId)).findAny();
        assertTrue(any.isPresent());
        assertThat(any.get().getId(), is(studentId));
    }

    private void createSingleRequest(String studentId, String courseId) {
        Optional<Student> anyS = studentController.all().stream().filter(s -> s.getId().equals(studentId)).findAny();
        assertTrue(anyS.isPresent());
        String studentName = anyS.get().getName();
        SingleRequest req = new SingleRequest();
        Course wantedCourse = new Course();
        wantedCourse.setId(courseId);
        req.setWantedCourse(wantedCourse);
        Student student = new Student(studentName, studentId);
        req.setRequestOwner(student);
        singleRequestController.newItem(studentId, courseId);
    }

    @Test
    public void courseOverlapTest() {
        createStudent1();
        createCourse1A();
        createCourse2();
        createSingleRequest("1", COURSE_1A_ID);
        checkStudentEnrolledInCourse(COURSE_1A_ID, "1");
        createSingleRequest("1", "MATH102-1");
        checkStudentNotEnrolledInCourse("MATH102-1", "1");
    }

    private void checkStudentNotEnrolledInCourse(String courseId, String studentId) {
        Optional<Course> anyCourse = courseController.all().getBody().stream().filter(c -> c.getId().equals(courseId)).findAny();
        assertTrue(anyCourse.isPresent());
        Course course = anyCourse.get();
        List<Student> students = course.getStudents();
        assertThat(students, is(not(nullValue())));
        Optional<Student> any = students.stream().filter(s -> s.getId().equals(studentId)).findAny();
        assertThat(any.isEmpty(), is(true));
    }

    @Test
    public void sectionChangeTest() {
        createStudent1();
        createCourse1A();
        createCourse1B();
        createSingleRequest("1", COURSE_1A_ID);
        createSingleRequest("1", COURSE_1B_ID);
        checkStudentEnrolledInCourse(COURSE_1B_ID, "1");
        checkStudentNotEnrolledInCourse(COURSE_1A_ID, "1");
    }

    @Test
    public void studentIsAlreadyInTheSectionTest() {
        createStudent1();
        createCourse1A();
        createSingleRequest("1", COURSE_1A_ID);
        createSingleRequest("1", COURSE_1A_ID);
        Course dbCourse = courseRepository.findCourseById(COURSE_1A_ID);
        List<Student> students = dbCourse.getStudents();
        assertEquals(1, students.size());
    }

    @Test
    public void studentFromFullSectionWantsToGoThereTest() {
        createStudent1();
        createStudent2();
        createStudent3();
        createStudent4();
        createStudent5();
        createCourse1A();
        createSingleRequest("1", COURSE_1A_ID);
        createSingleRequest("2", COURSE_1A_ID);
        createSingleRequest("3", COURSE_1A_ID);
        createSingleRequest("4", COURSE_1A_ID);
        createSingleRequest("5", COURSE_1A_ID);
        createSingleRequest("1", COURSE_1A_ID);
        assertTrue(singleRequestController.all().isEmpty());
        checkStudentEnrolledInCourse("CS102-1", "1");
    }

    @Test
    public void multipleRequestTest() {
        Student s1 = createStudent1();
        Course c1b = createCourse1B();
        Course c2 = createCourse2();
        createMultipleRequest("1", List.of("CS102-2", "MATH102-1"));
        checkStudentEnrolledInCourse("CS102-2", "1");
        checkStudentEnrolledInCourse("MATH102-1", "1");
    }

    public void createMultipleRequest(String studentId, List<String> courseIds) {
        Optional<Student> anyS = studentController.all().stream().filter(s -> s.getId().equals(studentId)).findAny();
        assertTrue(anyS.isPresent());
        String studentName = anyS.get().getName();
        MultipleRequest req = new MultipleRequest();
        List<Course> wantedCourses = new ArrayList<>();
        for (String cName : courseIds) {
            Course c = courseRepository.findCourseById(cName);
            wantedCourses.add(c);
        }
        req.setWantedCourses(wantedCourses);
        Student student = new Student(studentName, studentId);
        req.setRequestOwner(student);

        multipleRequestController.newItem(new Gson().toJson(req));
    }
}
