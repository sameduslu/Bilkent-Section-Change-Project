package tr.edu.bilkent.cs.cs102.registerplusplus.server.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public abstract class Request {
    @Id
    private String id;

    @DBRef
    private Student requestOwner;

    public Student getRequestOwner() {
        return requestOwner;
    }

    public void setRequestOwner(Student requestOwner) {
        this.requestOwner = requestOwner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
