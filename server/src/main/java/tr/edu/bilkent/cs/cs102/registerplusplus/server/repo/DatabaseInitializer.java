package tr.edu.bilkent.cs.cs102.registerplusplus.server.repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.entity.*;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.service.CourseService;
import tr.edu.bilkent.cs.cs102.registerplusplus.server.service.RequestProcessorService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Configuration
public class DatabaseInitializer {

    private static final Logger log = LoggerFactory.getLogger(DatabaseInitializer.class);
    private boolean ctr = false;

    @Bean
    CommandLineRunner CredentialsInit(CredentialsRepository credentialsRepository, StudentRepository studentRepository) {
        if (ctr) return args -> {
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
        return args -> {
        };
    }

    @Bean
    CommandLineRunner addCourses(CourseRepository courseRepository) {
        if (ctr) return args -> {
            try {
                File database = new File("Course_Database.txt");
                Scanner sc = new Scanner(database);
                int id = 1000;
                while (sc.hasNextLine()) {
                    String name, section, insName, insSurname, insID;
                    Instructor instructor;
                    boolean[][] program = new boolean[Person.rowNum][Person.columnNum];
                    name = sc.next();
                    section = sc.next();
                    insName = sc.next();
                    insSurname = sc.next();
                    insName += (" " + insSurname);
                    insID = "" + id;
                    instructor = new Instructor(insName, insID);
                    for (int i = 0; i < Person.rowNum; i++) {
                        for (int j = 0; j < Person.columnNum; j++) {
                            int check = sc.nextInt();
                            program[i][j] = check == 1;
                        }
                    }
                    //Course lesson = new Course (name, section, program, instructor);
                    Course lesson = new Course();
                    lesson.setName(name);
                    String id2 = name + "-" + section;
                    lesson.setId(id2);
                    lesson.setProgram(program);
                    lesson.setInstructor(instructor);
                    lesson.setSection(section);
                    //instructor.addCourse(lesson); TODO
                    courseRepository.save(lesson);
                    id++;
                }
            } catch (FileNotFoundException err) {
                System.out.println("Error occured!");
                err.printStackTrace();
            }
        };
        return args -> {
        };
    }

    @Bean
    CommandLineRunner studentDistributor(CourseRepository courseRepository, StudentRepository studentRepository, CourseService courseService, RequestProcessorService requestProcessorService) {
        if (ctr) return args -> {
            List<Course> courses = courseRepository.findAll();
            List<Student> students = studentRepository.findAll();
            HashMap<String, ArrayList<Course>> coursesByName = new HashMap<>();
            for (Course c : courses) {
                String name = c.getName();
                if (coursesByName.containsKey(name)) {
                    List<Course> l = coursesByName.get(name);
                    l.add(c);
                } else {
                    ArrayList<Course> l = new ArrayList<>();
                    l.add(c);
                    coursesByName.put(name, l);
                }
            }
            List<ArrayList<Course>> allPaths = new ArrayList<>();
            Iterator<String> iter = coursesByName.keySet().iterator();
            List<String> names = new ArrayList<>();
            while (iter.hasNext()) {
                names.add(iter.next());
            }
            ArrayList<Course> currentPath = new ArrayList<>();
            calculateAllPaths(coursesByName, names, allPaths, currentPath);
            /*for (int i = 0; i < allPaths.size(); i++) {
                System.out.println("Path: " + (i+ 1));
                for (int j = 0; j < allPaths.get(i).size(); j++) {
                    System.out.println(allPaths.get(i).get(j).getId());
                }
                System.out.println();
            }
            System.out.println("done list");*/

            Random rand = new Random();

            for (int i = 0; i < students.size(); i++) {

                boolean isHappened = false;

                int cnt = 0;

                while (!isHappened) {

                    int pathNumber = rand.nextInt(allPaths.size());

                    if (cnt == 1000) {
                        break;
                    }

                    boolean ctr = true;

                    Student s = students.get(i);
                    for (int j = 0; j < allPaths.get(pathNumber).size(); j++) {
                        ctr &= !Course.isFull(courseRepository.findCourseById(allPaths.get(pathNumber).get(j).getId()));
                        ctr &= (requestProcessorService.isStillValid(allPaths.get(pathNumber).get(j), s, courseRepository.findCourseByStudentsId(s.getId())));
                        //System.out.println(ctr + " " + pathNumber);
                    }

                    if (ctr) {
                        for (int j = 0; j < allPaths.get(pathNumber).size(); j++) {
                            courseService.addStudentToCourse(s, allPaths.get(pathNumber).get(j));
                        }
                        isHappened = true;
                    }
                    cnt++;
                }

                if (cnt == 1000) {
                    System.out.println("It is impossible to arrange students!" + i);
                    break;
                }
            }
            System.out.println("Students distributed.");
            courses = courseRepository.findAll();
            for (int i = 0; i < courses.size(); i++) {
                String result = "";
                result += courses.get(i).getId();
                if (Course.isFull(courseRepository.findCourseById(courses.get(i).getId()))) {
                    result += " is full";
                } else {
                    result += " is not full";
                }
                System.out.println(result);
            }
//            for (int i = 0; i < students.size(); i++) {
//                System.out.println("Student" + (i + 1) + "'s program: ");
//                students.set(i, studentRepository.findById(students.get(i).getId()).get());
//                students.get(i).printSchedule();
//            }
        };
        return args -> {
        };
    }

    private void calculateAllPaths(HashMap<String, ArrayList<Course>> map, List<String> names, List<ArrayList<Course>> allPaths, ArrayList<Course> currentPath) {
        String key = names.get(currentPath.size());
        List<Course> l = map.get(key);
        for (int i = 0; i < l.size(); i++) {
            Course add = l.get(i);
            boolean canAdded = true;
            for (int j = 0; j < currentPath.size(); j++) {
                if (doesOverlap(currentPath.get(j), add)) {
                    canAdded = false;
                    break;
                }
            }
            if (!canAdded) {
                continue;
            }
            currentPath.add(l.get(i));
            if (currentPath.size() == map.keySet().size()) {
                ArrayList<Course> addThat = new ArrayList<>(currentPath);
                allPaths.add(addThat);
            } else {
                calculateAllPaths(map, names, allPaths, currentPath);
            }
            currentPath.remove(add);
        }
    }

    private boolean doesOverlap(Course c1, Course c2) {
        boolean[][] program1 = c1.getProgram();
        boolean[][] program2 = c2.getProgram();
        for (int i = 1; i < program1.length; i++) {
            for (int j = 1; j < program1[i].length; j++) {
                if (program1[i][j] && program2[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
