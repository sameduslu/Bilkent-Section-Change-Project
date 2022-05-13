package client.main;

public abstract class Request {

    protected Student requestOwner;

    public Student getRequestOwner() {
        return requestOwner;
    }

    public void setRequestOwner(Student requestOwner) {
        this.requestOwner = requestOwner;
    }
}
