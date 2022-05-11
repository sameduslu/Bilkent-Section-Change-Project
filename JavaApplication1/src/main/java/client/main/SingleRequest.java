package client.main;

public class SingleRequest extends Request {

    private Course wantedCourse;

    public SingleRequest(Student owner, Course wanted) {
        this.requestOwner = owner;
        wantedCourse = wanted;
    }

    public Course getWantedCourse() {
        return wantedCourse;
    }


}
