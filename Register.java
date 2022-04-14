import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Register {
    public static void main (String[] args) {
        ArrayList<Student> allStudents = addStudents();

        Courses allCourses = addCourses();

        Courses cs102Courses,math102Courses,math132Courses,eng102Courses;
        cs102Courses = new Courses();
        math102Courses = new Courses();
        math132Courses = new Courses();
        eng102Courses = new Courses();

        for (int i = 0; i < allCourses.getSize(); i++) {
            Course tempCourse = allCourses.getCourse(i);
            
            if (tempCourse.getName().equals("CS102")) {
                cs102Courses.addCourse(tempCourse);
            }
            
            if (tempCourse.getName().equals("MATH102")) {
                math102Courses.addCourse(tempCourse);
            }
            
            if (tempCourse.getName().equals("MATH132")) {
                math132Courses.addCourse(tempCourse);
            }

            if (tempCourse.getName().equals("ENG102")) {
                eng102Courses.addCourse(tempCourse);
            }
        }

        ArrayList < Courses > allPaths = new ArrayList < Courses >();

        for (int i = 0; i < cs102Courses.getSize(); i++) {
            Courses possiblePath = new Courses();
            Course csCourse = cs102Courses.getCourse(i);
            possiblePath.addCourse(csCourse);
            for(int j = 0; j < math102Courses.getSize(); j++) {
                Course math102Course = math102Courses.getCourse(j); 
                if (csCourse.doesOverlap(math102Course)) {
                    continue;
                }
                else {
                    possiblePath.addCourse(math102Course);
                }
                for(int u = 0; u < math132Courses.getSize(); u++) {
                    Course math132Course = math132Courses.getCourse(u); 
                    if (csCourse.doesOverlap(math132Course) || math102Course.doesOverlap(math132Course)) {
                        continue;
                    }
                    else {
                        possiblePath.addCourse(math132Course);
                    }
                    for(int p = 0; p < eng102Courses.getSize(); p++) {
                        Course engCourse = eng102Courses.getCourse(p); 
                        if (csCourse.doesOverlap(engCourse) || math102Course.doesOverlap(engCourse) 
                            || math132Course.doesOverlap(engCourse)) {
                            continue;
                        }
                        else {
                            possiblePath.addCourse(math132Course);
                            allPaths.add(possiblePath);
                        }
                        if(possiblePath.getSize() == 4) {
                            possiblePath.removeCourse(engCourse);
                        }
                    }
                    if(possiblePath.getSize() == 3) {
                        possiblePath.removeCourse(math132Course);
                    }
                }
                if(possiblePath.getSize() == 2) {
                    possiblePath.removeCourse(math102Course);
                }
            }
            if(possiblePath.getSize() == 1) {
                possiblePath.removeCourse(csCourse);
            }
        }
        
        

    }

    private static ArrayList<Student> addStudents() {
        ArrayList<Student> result;
        try{
            File database = new File("Names_and_IDs.txt");
            Scanner sc = new Scanner(database);
            while(sc.hasNextLine()) {
                String name = sc.next();
                String surname = sc.next();
                name += (" " + surname); 
                String id = sc.next();
                Student st = new Student (name, id);
                result.add(st);
            }
        }
        catch (FileNotFoundException err)  {
            System.out.println("Error occured!");
            err.printStackTrace();
        }


        return result;
    }

    private static Courses addCourses() {
        Courses result = new Courses();
        try{
            File database = new File("Course_Database.txt");
            Scanner sc = new Scanner(database);
            int id = 1000;
            while(sc.hasNextLine()) {
                String name, section, insName, insSurname, insID;
                Instructor instructor;
                boolean[][] program = new boolean[6][9];
                name = sc.next();
                section = sc.next();
                insName = sc.next();
                insSurname = sc.next();
                insName += (" " + insSurname);
                insID = "" + id;
                instructor = new Instructor (insName, insID);
                for (int i = 0; i <= 6; i++) {
                    for (int j = 0; j<= 9; j++) {
                        int check = sc.nextInt();
                        if(check == 1) {
                            program [i][j] = true;
                        }
                        else {
                            program [i][j] = false;
                        }
                    }
                }
                Course lesson = new Course (name, section, program, instructor);
                result.addCourse(lesson);
                id++;
            }
        }
        catch (FileNotFoundException err)  {
            System.out.println("Error occured!");
            err.printStackTrace();
        }


        return result;
    }
}