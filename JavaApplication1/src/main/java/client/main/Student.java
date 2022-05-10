package client.main;
import java.util.ArrayList;

public class Student extends Person{

    private ArrayList <Request> requests = new ArrayList<>();

    private ArrayList <Request> forumRequests = new ArrayList<>();

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

    public boolean createForumRequest (Course wanted) {
        if (this.doesOverlap(wanted)) {
            System.out.println ("Invalid request, check your schedule!");
            return false;
        }
        Course current = null;
        for (int i = 0; i < courses.getSize(); i++) {
            if (courses.getCourse(i).getName().equals(wanted.getName())) {
                current = courses.getCourse(i);
            }
        }
        Request forum = new ForumRequest(this, wanted, current);
        forumRequests.add(forum);
        Register.addRequestToForum(forum);
        return true;
    }

    public ArrayList <Request> getRequests() {
        return requests;
    }

    public ArrayList <Request> getForumRequests() {
        return forumRequests;
    }

    public void acceptForumRequest (Request r) {
        Course cc = ((ForumRequest) r).getWantedCourse();
        Course cc2 = ((ForumRequest) r).getCurrentCourse();
        boolean control = false;
        for (int i = 0; i < courses.getSize(); i++) {
            if (courses.getCourse(i).equals(cc) && !this.doesOverlap(cc2)) {
                control = true;
                Register.processForumRequest ((ForumRequest) r, this);
                break;
            }
        }
        if (!control) {
            System.out.println("You can't accept this request !");
        }
    }

    public void removeRequest (Request r) {
        requests.remove(r);
        Register.removeRequestFromQueue(r);
    }

    public void removeForumRequest (Request r) {
        forumRequests.remove(r);
        Register.removeRequestFromForum(r);
    }
}
