package tr.edu.bilkent.cs.cs102.registerplusplus.server.entity;

import org.springframework.data.annotation.Id;

public abstract class Person {
    public static final int rowNum = 9;
    public static final int columnNum = 6;
    @Id
    protected String id;

    protected String name;

    protected boolean[][] program = new boolean[rowNum][columnNum];

    //private Course[][] schedule2D = new Course[rowNum][columnNum];

    public Person(String name, String id) {
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

    public boolean[][] getProgram() {
        return program;
    }

    public void setProgram(boolean[][] program) {
        this.program = program;
    }

//    public void setSchedule(Course[][] sch) {
//        this.schedule2D = sch;
//    }
}
