package client.main;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    public static final int ROW_NUM = 9;
    public static final int COLUMN_NUM = 6;

    protected String name;

    @SerializedName("id")
    protected String id;

    @SerializedName("schedule")
    protected Course[][] courseSchedule = new Course[ROW_NUM][COLUMN_NUM];
    protected boolean[][] program = new boolean[ROW_NUM][COLUMN_NUM];

    protected List<Course> courses = new ArrayList<>();

    public Person(String name, String ID) {
        this.name = name;
        this.id = ID;
    }

    public String getCourseAt(int row, int column) {
        if (courseSchedule[row][column] == null) {
            return "-----";
        } else {
            return courseSchedule[row][column].getName() + "";
        }
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setCourseSchedule(Course[][] courseSchedule) {
        this.courseSchedule = courseSchedule;
    }
}
