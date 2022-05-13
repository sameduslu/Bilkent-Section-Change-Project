package client.main;

public class Instructor extends Person {

    public Instructor(String name, String ID) {
        super(name, ID);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(String iD) {
        id = iD;
    }

}
