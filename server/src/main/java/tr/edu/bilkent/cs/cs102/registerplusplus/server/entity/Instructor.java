package tr.edu.bilkent.cs.cs102.registerplusplus.server.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("instructor")
public class Instructor extends Person{
    public Instructor(String name, String id){
        super(name,id);
    }
}
