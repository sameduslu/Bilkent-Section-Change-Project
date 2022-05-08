package tr.edu.bilkent.cs.cs102.registerplusplus.server.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("student")
public class Student extends Person {

    public Student(String name, String id) {
        super(name, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) return false;
        return ((Student) obj).id.equals(this.id);
    }
}
