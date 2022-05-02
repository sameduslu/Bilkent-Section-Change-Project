package tr.edu.bilkent.cs.cs102.registerplusplus.server.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("course")
public class Course {

    @Id
    private String id;
    private String name;
    private String section;

    @DBRef
    private List<Student> students = new ArrayList<>();
    private boolean[][] program;
    @DBRef
    private Instructor instructor;

    public static final int QUOTA = 5;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public boolean[][] getProgram() {
        return program;
    }

    public void setProgram(boolean[][] program) {
        this.program = program;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Course)) return false;
        return this.id.equals(((Course) o).id);
    }
}
