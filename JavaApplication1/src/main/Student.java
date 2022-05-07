package main;
import java.util.ArrayList;

/**
 *
 * @author Pc
 */
public class Student extends Person{
    private ArrayList<Student>students = new ArrayList<Student>();
    public Student(String name, String ID){
        super(name,ID);
        students.add(this);
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void removeCourse(Course course){
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < columnNum; j++){
                if(schedule2D[i][j]!=null){
                    removeCourseFromProgram(course);
                }
                else{
                    System.out.println("There is no course in the spesified location");
                }
            }
        } 
    }
    public void removeCourseFromProgram(Course course){
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < columnNum; j++){
                if(course.getProgram()[i][j]&&schedule2D[i][j]!=null){
                    schedule2D[i][j]=null;
                }
            }
        } 
    }
}
