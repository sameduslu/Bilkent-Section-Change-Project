package client.main;

import java.util.List;

public class MultipleRequest extends Request {

    public MultipleRequest(Student owner, List<Course> wantedCourses) {
        this.requestOwner = owner;
        this.wantedCourses = wantedCourses;
    }

    private List<Course> wantedCourses;

    public List<Course> getWantedCourses() {
        return wantedCourses;
    }

    public void setWantedCourses(List<Course> wantedCourses) {
        this.wantedCourses = wantedCourses;
    }
}
