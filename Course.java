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
    static final int quota = 20;
    /******************************************************************************************* */
    /**************************** CONSTRUCTOR ************************************************** */
    /******************************************************************************************* */
    public Course(String name, String section, boolean[][] matrice, Instructor instructor){// sonradan queue alacak
        this.name = name;
        this.section = section;
        this.program = matrice;
        this.instructor=instructor;
    }
    /****************************************************************************************** */
    /**************************** METHODS ***************************************************** */
    /****************************************************************************************** */
    public void addStudent(Student newStudent)
    {
        if(this.isThereQuota())
        {
            students.add(newStudent);
        }else{
            System.out.println("Quota Full, student cannot added to desired course");
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
            System.out.println("HATA! STUDENT SAYISI KOTAYI ÖNCEDEN AŞMIŞ");
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

    public String toString () {
        String result = "";
        result += (this.name + " ") ;
        result += (this.section);
        return result;
    }

}