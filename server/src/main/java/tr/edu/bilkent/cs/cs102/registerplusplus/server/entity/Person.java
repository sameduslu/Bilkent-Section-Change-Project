package tr.edu.bilkent.cs.cs102.registerplusplus.server.entity;

import org.springframework.data.annotation.Id;

public abstract class Person {

    @Id
    protected String id;

    protected String name;

    public Person(String name, String id){
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
