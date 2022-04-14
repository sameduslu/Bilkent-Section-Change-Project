import java.util.ArrayList;
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
        for(int i = 0; i < columnNum; i++){
            for(int j = 0; j < rowNum; j++){
                if(schedule2D[j][i]!=null){
                    removeCourseFromProgram(course);
                }
                else{
                    System.out.println("There is no course in the spesified location");
                }
            }
        } 
    }
    public void removeCourseFromProgram(Course course){
        for(int i = 0; i < columnNum; i++){
            for(int j = 0; j < rowNum; j++){
                if(course.getProgram()[j][i]&&schedule2D[j][i]!=null){
                    schedule2D[j][i]=null;
                }
            }
        } 
    }
}
