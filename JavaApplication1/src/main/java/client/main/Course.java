package client.main;
import java.util.ArrayList;

/**
 * Course
 */
public class Course {
    private final String NAME;
    private final String SECTION;
    private final ArrayList<Student> students;
    private final boolean[][] PROGRAM;
    private final Instructor INSTRUCTOR;
    
    static final int quota = 25;
    /******************************************************************************************* */
    /**************************** CONSTRUCTOR ************************************************** */
    /******************************************************************************************* */
    public Course(String name, String section, boolean[][] matrice, Instructor instructor){// sonradan queue alacak
        this.NAME = name;
        this.SECTION = section;
        this.PROGRAM = matrice;
        this.INSTRUCTOR = instructor;
        students = new ArrayList<Student>();
    }
    /****************************************************************************************** */
    /**************************** METHODS ***************************************************** */
    /****************************************************************************************** */
    public void addStudent(Student newStudent)
    {
        students.add(newStudent);
        newStudent.addCourse(this);     
    }

    public void removeStudent (Student removedStudent) {
        students.remove(removedStudent);
        removedStudent.removeCourse(this);
    }

    public boolean isThereQuota() {
        boolean areThereQuota = true;
        if(students.size()==quota)
        {
            areThereQuota= false;
        } 
        else if(students.size()>=quota)
        {
            areThereQuota= false;
            System.out.println("ERROR! STUDENT NUMBER HAS ALREADY EXCEEDED THE QUOTA");
        }
        return areThereQuota;
    }

    public int getAvailableQuota() {
        return quota-students.size();
    }
    //                            GET METHODS
    public String getName() {
        return this.NAME;
    }

    public String getSection() {
        return this.SECTION;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public boolean[][] getProgram() {
        return this.PROGRAM;
    }

    public Instructor getInstructor() {
        return this.INSTRUCTOR;
    }

    public boolean doesOverlap (Course otherCourse) {
        for (int i = 0; i < PROGRAM.length; i++) {
            for (int j = 0; j < PROGRAM[j].length; j++) {
                if(PROGRAM[i][j] == true && otherCourse.getProgram()[i][j] == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printProgram() {
        for (int i = 0; i < PROGRAM.length; i++) {
            for (int j = 0; j < PROGRAM[0].length; j++) {
                if(PROGRAM[i][j]) {
                    System.out.print("1 ");
                }
                else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public String toString () {
        String result = "";
        result += (this.NAME + " ") ;
        result += (this.SECTION);
        return result;
    }
}