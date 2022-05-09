package main;

public class ForumRequest extends Request {
    
    private Course wantedCourse, currentCourse;
    private Student acceptor;

    public ForumRequest (Student owner, Course wanted, Course current) {
        super (owner);
        wantedCourse = wanted;
        currentCourse = current;
    }

    @Override
    public boolean isPossible() {
        if (!acceptor.equals(null)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isStillValid() {
        boolean ctr = false;
        for (int i = 0; i < this.getRequestOwner().getCourses().getSize(); i++) {
            if (this.getRequestOwner().getCourses().getCourse(i).equals(currentCourse)) {
                ctr = true;
            }
        }
        if (!ctr) {
            return false;
        }
        return true;
    }

    public Course getWantedCourse() {
        return wantedCourse;
    }

    public Course getCurrentCourse() {
        return currentCourse;
    }

    public void setAcceptor (Student ss) {
        acceptor = ss;
    }

}
