public class MultipleRequest extends Request{

    Courses wantedCourses;
    
    public MultipleRequest (Student owner, Courses wanteds) {
        super (owner);
        wantedCourses = wanteds;
    }
    
    @Override
    public boolean isPossible() {
        for (int i = 0; i < wantedCourses.getSize(); i++) {
            if(!wantedCourses.getCourse(i).isThereQuota()) {
                return false;
            }
        }
        return true;
    }
}
