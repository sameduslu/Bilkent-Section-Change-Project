public class SingleRequest extends Request {

    Course wantedCourse;

    public SingleRequest (Student owner, Course wanted) {
        super (owner);
        wantedCourse = wanted;
    }

    @Override
    public boolean isPossible() {
        return wantedCourse.isThereQuota();
    }
}
