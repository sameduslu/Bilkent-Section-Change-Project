package tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.service;

import org.springframework.stereotype.Service;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Course;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Person;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.CourseRepository;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public void updateProgram(Student student, Course course) {
        Student dbStudent = getDBStudentById(student);
        boolean[][] courseProgram = course.getProgram();
        boolean[][] studentProgram = dbStudent.getProgram();
        //Course[][] studentSchedule = dbStudent.getSchedule();
        for (int i = 0; i < studentProgram.length; i++) {
            for (int j = 0; j < studentProgram[i].length; j++) {
                if (courseProgram[i][j]) {
                    studentProgram[i][j] = true;
                }
            }
        }
        dbStudent.setProgram(studentProgram);
        studentRepository.save(dbStudent);
    }

    private Student getDBStudentById(Student student) {
        Optional<Student> studentById = studentRepository.findById(student.getId());
        if (studentById.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return studentById.get();
    }

    public void removeCourse(Student student, Course course) {
        Student dbStudent = getDBStudentById(student);
        boolean[][] courseProgram = course.getProgram();
        boolean[][] studentProgram = dbStudent.getProgram();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 6; j++) {
                if (courseProgram[i][j]) studentProgram[i][j] = false;
            }
        }
        dbStudent.setProgram(studentProgram);
        studentRepository.save(dbStudent);
    }

    public Course[][] getSchedule(String id) {
        List<Course> coursesOfStudent = courseRepository.findCourseByStudentsId(id);
        Course[][] result = new Course[Person.rowNum][Person.columnNum];
        generateCourseSchedule(coursesOfStudent, result);
        return result;
    }

    private void generateCourseSchedule(List<Course> coursesOfStudent, Course[][] result) {
        for (Course c : coursesOfStudent) {
            boolean[][] program = c.getProgram();
            for (int i = 0; i < program.length; i++) {
                for (int j = 0; j < program[i].length; j++) {
                    if (program[i][j]) {
                        result[i][j] = c;
                    }
                }
            }
        }
    }
}
