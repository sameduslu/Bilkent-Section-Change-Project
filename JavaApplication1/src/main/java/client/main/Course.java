package client.main;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Course
 */
public class Course {
    @SerializedName("name")
    private final String name;
    @SerializedName("section")
    private final String section;
    private final ArrayList<Student> students;
    @SerializedName("program")
    private final boolean[][] program;
    @SerializedName("instructor")
    private final Instructor instructor;

    private String id;

    public static final int QUOTA = 25;

    public Course(String name, String section, boolean[][] matrix, Instructor instructor) {
        this.name = name;
        this.section = section;
        this.program = matrix;
        this.instructor = instructor;
        students = new ArrayList<>();
        id = name + '-' + section;
    }

    public String getName() {
        return this.name;
    }

    public boolean[][] getProgram() {
        return this.program;
    }

    @Override
    public String toString() {
        String result = "";
        result += (this.name + " ");
        result += (this.section);
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}