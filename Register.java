import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Register {
    public static void main (String[] args) {
        ArrayList<Student> allStudents = addStudents();
        

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
}