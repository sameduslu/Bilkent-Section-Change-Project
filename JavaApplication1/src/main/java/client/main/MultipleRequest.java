package client.main;

import java.util.List;

public class MultipleRequest extends Request{

    private List<Course> wantedCourses;
    
    public MultipleRequest (Student owner, List<Course> wantedCourses) {
        super (owner);
        this.wantedCourses = wantedCourses;
    }

    public MultipleRequest(Student owner, Courses wanteds){
        super(owner);
        this.wantedCourses = wanteds.getCourses();
    }
    
    @Override
    public boolean isPossible() {
        for (int i = 0; i < wantedCourses.size(); i++) {
            if(!wantedCourses.get(i).isThereQuota()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isStillValid() {
        if (this.getRequestOwner().doesOverlap(getWantedCourses())) {
            return false;
        }
        return true;
    }

    public Courses getWantedCourses() {
        Courses result = new Courses();
        result.setCourses(wantedCourses);
        return result;
    }
}
