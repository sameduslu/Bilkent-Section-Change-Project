package tr.edu.bilkent.cs.cs102.registerplusplus.server.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("forumRequest")
public class ForumRequest extends Request {

    @DBRef
    private Course wantedCourse;

    @DBRef
    private Course currentCourse;

    @DBRef
    private Student acceptor;

    public Course getWantedCourse() {
        return wantedCourse;
    }

    public void setWantedCourse(Course wantedCourse) {
        this.wantedCourse = wantedCourse;
    }

    public Student getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(Student acceptor) {
        this.acceptor = acceptor;
    }

    public Course getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(Course currentCourse) {
        this.currentCourse = currentCourse;
    }
}
