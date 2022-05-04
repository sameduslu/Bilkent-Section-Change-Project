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

    public Course getWantedCourse() {
        return wantedCourse;
    }
}
