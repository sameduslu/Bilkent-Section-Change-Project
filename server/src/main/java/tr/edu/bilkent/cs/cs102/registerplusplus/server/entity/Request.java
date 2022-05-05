package tr.edu.bilkent.cs.cs102.registerplusplus.server.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public abstract class Request {
    @Id
    private String id;

    @DBRef
    private Student requestOwner;

    protected long timeStamp = System.currentTimeMillis();

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

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
