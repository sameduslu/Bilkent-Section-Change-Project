package main;
public abstract class Request {

    private Student requestOwner;

    private int id;

    public Request (Student owner) {
        requestOwner = owner;
    }

    public abstract boolean isPossible();

    public abstract boolean isStillValid();

    public Student getRequestOwner() {
        return requestOwner;
    }
}
