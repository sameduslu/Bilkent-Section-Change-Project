package client.main;

public class ForumRequest extends Request {

    private final Course wantedCourse;
    private final Course currentCourse;

    private Student acceptor;

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

    public Student getAcceptor() {
        return acceptor;
    }
}
