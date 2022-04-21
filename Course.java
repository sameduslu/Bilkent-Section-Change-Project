import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Course
 */
public class Course {
    private final String NAME;
    private final String SECTION;
    private final ArrayList<Student> students;
    private final boolean[][] PROGRAM;
    private final Instructor INSTRUCTOR;
    private Queue <Request> requestQueue = new LinkedList<>();
    private boolean[] requestCheck;
    
    static final int quota = 25;
    /******************************************************************************************* */
    /**************************** CONSTRUCTOR ************************************************** */
    /******************************************************************************************* */
    public Course(String name, String section, boolean[][] matrice, Instructor instructor){// sonradan queue alacak
        this.NAME = name;
        this.SECTION = section;
        this.PROGRAM = matrice;
        this.INSTRUCTOR=instructor;
        students = new ArrayList<Student>();
        requestCheck = new boolean[150001];
    }
    /****************************************************************************************** */
    /**************************** METHODS ***************************************************** */
    /****************************************************************************************** */
    public boolean addStudent(Student newStudent)
    {
        if(this.isThereQuota() && !newStudent.doesOverlap(this))
        {
            students.add(newStudent);
            newStudent.addCourse(this);
            return true;
        }
        else if (!this.isThereQuota()){
            System.out.println("Quota is full, student cannot added to desired course!");
            return false;
        }
        else {
            System.out.println("This course overlapping with your current courses!");
            return false;
        }
        
    }
    public boolean isThereQuota()
    {
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
    public int getAvailableQuota()
    {
        return quota-students.size();
    }
    //                            GET METHODS
    public String getName()
    {
        return this.NAME;
    }
    public String getSection()
    {
        return this.SECTION;
    }
    public ArrayList<Student> getStudents(){
        return this.students;
    }
    public boolean[][] getProgram(){
        return this.PROGRAM;
    }
    public Instructor getInstructor()
    {
        return this.INSTRUCTOR;
    }
    public boolean doesOverlap (Course otherCourse) {
        for (int i = 0; i < PROGRAM.length; i++) {
            for (int j = 0; j < PROGRAM[0].length; j++) {
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

    public void addRequestToQueue (Request r) {
        requestQueue.add(r);
        requestCheck[r.getID()] = true; 
    }

    //TODO checking the requests in every second
}