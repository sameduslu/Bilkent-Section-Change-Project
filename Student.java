import java.util.ArrayList;
public class Student extends Person{

    private ArrayList <Student> friends = new ArrayList<>();
    private ArrayList <Request> requests = new ArrayList<>();

    public Student(String name, String ID){
        super(name,ID);
    }

    public ArrayList<Student> getFriends() {
        return friends;
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

    public boolean createSingleRequest (Course wanted) {
        if (this.doesOverlap(wanted)) {
            return false;
        }
        Request single = new SingleRequest(this, wanted);
        requests.add(single);
        wanted.addRequestToQueue(single);
        return true;
    }

    public boolean createMultipleRequest (Courses wanted) {
        if(this.doesOverlap(wanted)){
            return false;
        }
        Request multiple = new MultipleRequest(this, wanted);
        requests.add(multiple);
        for (int i = 0; i < wanted.getSize(); i++) {
            wanted.getCourse(i).addRequestToQueue(multiple); //TODO it is wrong for now it will change when database is implemented
        }
        return true;
    } 
}
