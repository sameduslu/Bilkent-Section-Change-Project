package main;
public class SingleRequest extends Request {

    private Course wantedCourse;

    public SingleRequest (Student owner, Course wanted) {
        super (owner);
        wantedCourse = wanted;
    }

    @Override
    public boolean isPossible() {
        return wantedCourse.isThereQuota();
    }

    @Override
    public boolean isStillValid() {
        if (this.getRequestOwner().doesOverlap(wantedCourse)) {
            return false;
        }
        return true;
    }
    
    public Course getWantedCourse() {
        return wantedCourse;
    }

    
}
