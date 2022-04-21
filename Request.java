public abstract class Request {

    Student requestOwner;

    public static int requestNumber = 0;

    private int id;

    public Request (Student owner) {
        requestOwner = owner;
        id = requestNumber++;
    }

    public abstract boolean isPossible();

    public Student getRequestOwner() {
        return requestOwner;
    }

    public int getID() {
        return id;
    }
}
