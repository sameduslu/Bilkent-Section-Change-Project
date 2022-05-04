import java.util.ArrayList;
public class Student extends Person{

    private ArrayList <Request> requests = new ArrayList<>();

    public Student (String name, String ID){
        super(name,ID);
    }

    public void removeCourse (Course course){
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < columnNum; j++){
                if(course.getProgram()[i][j]){
                    schedule2D[i][j]=null;
                    program[i][j] = false;
                }
            }
        } 
        courses.removeCourse(course);
    }

    public boolean createSingleRequest (Course wanted) {
        if (this.doesOverlap(wanted)) {
            System.out.println ("Invalid request, check your schedule!");
            return false;
        }
        Request single = new SingleRequest(this, wanted);
        requests.add(single);
        Register.addRequestToQueue(single);
        return true;
    }

    public boolean createMultipleRequest (Courses wanted) {
        if(this.doesOverlap(wanted)){
            System.out.println ("Invalid request, check your schedule!");
            return false;
        }
        Request multiple = new MultipleRequest(this, wanted);
        requests.add(multiple);
        Register.addRequestToQueue(multiple);
        return true;
    } 

    public ArrayList <Request> getRequests() {
        return requests;
    }
}
