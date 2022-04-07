import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Register {
    public static void main (String[] args) {
        ArrayList<Student> allStudents = addStudents();
        Courses allCourses = addCourses();

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