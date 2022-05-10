package client.main;

import java.util.ArrayList;
/**
 * set of Course objects
 * 
 * Last Update: 7.04.22
 */
public class Courses {
    ArrayList<Course> courses;
    // default constructor
    public Courses(){
        courses = new ArrayList<Course>(); 
    }
    /*************************************************************************************** */
    /**************************** METHODS ************************************************** */
    /*************************************************************************************** */
    public void addCourse (Course newCourse)
    {
        courses.add(newCourse);
    }

    public void removeCourse (Course removedCourse) {
        courses.remove(removedCourse);
    }
    
    //Get methods
    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public int getSize() {
        return courses.size();
    }

    public Course getCourse (int index) {
        return courses.get(index);
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}
