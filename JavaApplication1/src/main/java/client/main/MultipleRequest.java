package client.main;

import java.util.List;

public class MultipleRequest extends Request {

    private List<Course> wantedCourses;

    public List<Course> getWantedCourses() {
        return wantedCourses;
    }

    public void setWantedCourses(List<Course> wantedCourses) {
        this.wantedCourses = wantedCourses;
    }
}
