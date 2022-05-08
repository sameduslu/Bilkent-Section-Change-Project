package tr.edu.bilkent.cs.cs102.registerplusplus.server.service;

import org.springframework.stereotype.Service;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Course;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.repo.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void updateProgram(Student student, Course course) {
        Student dbStudent = studentRepository.findById(student.getId()).get();
        boolean[][] courseProgram = course.getProgram();
        boolean[][] studentProgram = dbStudent.getProgram();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 6; j++) {
                if (courseProgram[i][j]) studentProgram[i][j] = true;
            }
        }
        dbStudent.setProgram(studentProgram);
        studentRepository.save(dbStudent);
    }

    public void removeCourse(Student student, Course course) {
        Student dbStudent = studentRepository.findById(student.getId()).get();
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
