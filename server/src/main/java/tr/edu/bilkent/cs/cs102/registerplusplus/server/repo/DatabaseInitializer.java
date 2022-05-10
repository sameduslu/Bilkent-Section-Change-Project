package tr.edu.bilkent.cs.cs102.registerplusplus.server.repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Course;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Credentials;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Instructor;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Person;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.Student;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

@Configuration
public class DatabaseInitializer {

    private static final Logger log = LoggerFactory.getLogger(DatabaseInitializer.class);

    @Bean
    CommandLineRunner CredentialsInit(CredentialsRepository credentialsRepository, StudentRepository studentRepository) {
        return args -> {
            Scanner in = new Scanner(new File("D:\\cs102\\Bilkent-Section-Change-Project\\JavaApplication1\\src\\main\\resources\\Names_and_IDs_Passwords.txt"));
            while (in.hasNextLine()) {
                String[] s = in.nextLine().split(" ");
                Credentials c = new Credentials();
                c.setUsername(s[s.length - 2]);
                c.setPassword(s[s.length - 1]);
                credentialsRepository.save(c);
                String name = "";
                for (int i = 0; i < s.length - 2; i++) {
                    name += s[i] + ' ';
                }
                name = name.strip();
                studentRepository.save(new Student(name, s[s.length - 2]));
            }
        };
    }

    @Bean
    CommandLineRunner addCourses(CourseRepository courseRepository) {
        return args -> {    
            try{
                File database = new File("Course_Database.txt");
                Scanner sc = new Scanner(database);
                int id = 1000;
                while(sc.hasNextLine()) {
                    String name, section, insName, insSurname, insID;
                    Instructor instructor;
                    boolean[][] program = new boolean[Person.rowNum][Person.columnNum];
                    name = sc.next();
                    section = sc.next();
                    insName = sc.next();
                    insSurname = sc.next();
                    insName += (" " + insSurname);
                    insID = "" + id;
                    instructor = new Instructor (insName, insID);
                    for (int i = 0; i < Person.rowNum; i++) {
                        for (int j = 0; j< Person.columnNum; j++) {
                            int check = sc.nextInt();
                            if(check == 1) {
                                program [i][j] = true;
                            }
                            else {
                                program [i][j] = false;
                            }
                        }
                    }
                    //Course lesson = new Course (name, section, program, instructor);
                    Course lesson = new Course();
                    lesson.setName(name);
                    String id2 = name + "-" + section;
                    lesson.setId(id2);
                    lesson.setProgram(program);
                    lesson.setInstructor(instructor);
                    //instructor.addCourse(lesson); TODO
                    courseRepository.save(lesson);
                    id++;
                }
            }
            catch (FileNotFoundException err)  {
                System.out.println("Error occured!");
                err.printStackTrace();
            }
        };
    }

}
