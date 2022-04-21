import java.util.ArrayList;

/**
 * Course
 */
public class Course {
    String name;
    String section;// sectionu string aldım
    ArrayList<Student> students;
    boolean[][] program;
    Instructor instructor;
    // Queue veri yapısı gerekecek;
    static final int quota = 23;
    /******************************************************************************************* */
    /**************************** CONSTRUCTOR ************************************************** */
    /******************************************************************************************* */
    public Course(String name, String section, boolean[][] matrice, Instructor instructor){// sonradan queue alacak
        this.name = name;
        this.section = section;
        this.program = matrice;
        this.instructor=instructor;
        students = new ArrayList<Student>();
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
        return this.name;
    }
    public String getSection()
    {
        return this.section;
    }
    public ArrayList<Student> getStudents(){
        return this.students;
    }
    public boolean[][] getProgram(){
        return this.program;
    }
    public Instructor getInstructor()
    {
        return this.instructor;
    }
    public boolean doesOverlap (Course otherCourse) {
        for (int i = 0; i < program.length; i++) {
            for (int j = 0; j < program[0].length; j++) {
                if(program[i][j] == true && otherCourse.getProgram()[i][j] == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printProgram() {
        for (int i = 0; i < program.length; i++) {
            for (int j = 0; j < program[0].length; j++) {
                if(program[i][j]) {
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
        result += (this.name + " ") ;
        result += (this.section);
        return result;
    }

}