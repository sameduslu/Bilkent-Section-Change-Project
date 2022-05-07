package tr.edu.bilkent.cs.cs102.registerplusplus.server.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("multipleRequest")
public class MultipleRequest extends Request {
    @DBRef
    private List<Course> wantedCourses = new ArrayList<>();

    public List<Course> getWantedCourses() {
        return wantedCourses;
    }

    public void setWantedCourses(List<Course> wantedCourses) {
        this.wantedCourses = wantedCourses;
    }
}
