package client.main;

public class ForumRequest extends Request {

    private String id;

    private final Course wantedCourse;
    private final Course currentCourse;

    public ForumRequest(Student owner, Course wanted, Course current) {
        this.requestOwner = owner;
        wantedCourse = wanted;
        currentCourse = current;
    }

    public Course getWantedCourse() {
        return wantedCourse;
    }

    public Course getCurrentCourse() {
        return currentCourse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
