package tr.edu.bilkent.cs.cs102.registerplusplus.server.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("forumRequest")
public class ForumRequest extends Request {

    @DBRef
    private Course wantedCourse;

    @DBRef
    private Course currentCourse;

    public Course getWantedCourse() {
        return wantedCourse;
    }

    public void setWantedCourse(Course wantedCourse) {
        this.wantedCourse = wantedCourse;
    }

    public Course getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(Course currentCourse) {
        this.currentCourse = currentCourse;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof ForumRequest)){
            return false;
        }
        return this.getRequestOwner().equals(((ForumRequest) o).getRequestOwner()) && this.wantedCourse.equals(((ForumRequest) o).wantedCourse);
    }
}
