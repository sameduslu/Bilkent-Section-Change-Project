package tr.edu.bilkent.cs.cs102.registerplusplus.server.service;

import org.springframework.stereotype.Service;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Course;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.StudentRepository;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void updateProgram(Student student, Course course) {
        Student dbStudent = getDBStudentById(student);
        boolean[][] courseProgram = course.getProgram();
        boolean[][] studentProgram = dbStudent.getProgram();
        Course[][] studentSchedule = dbStudent.getSchedule();
        for (int i = 0; i < studentProgram.length; i++) {
            for (int j = 0; j < studentProgram[i].length; j++) {
                if (courseProgram[i][j]){
                    studentProgram[i][j] = true;
                    studentSchedule[i][j] = course;
                }
            }
        }
        dbStudent.setSchedule(studentSchedule); 
        dbStudent.setProgram(studentProgram);
        studentRepository.save(dbStudent);
    }

    private Student getDBStudentById(Student student) {
        Optional<Student> studentById = studentRepository.findById(student.getId());
        if (studentById.isEmpty()){
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
}
