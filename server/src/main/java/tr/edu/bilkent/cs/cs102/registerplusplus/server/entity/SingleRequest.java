package tr.edu.bilkent.cs.cs102.registerplusplus.server.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("singleRequest")
public class SingleRequest extends Request {

    @DBRef
    private Course wantedCourse;

    public Course getWantedCourse() {
        return wantedCourse;
    }

    public void setWantedCourse(Course wantedCourse) {
        this.wantedCourse = wantedCourse;
    }
}
