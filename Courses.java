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
    public void addCourse(Course newCourse)
    {
        courses.add(newCourse);
    }

    public void removeCourse(Course removedCourse)
    {
        int index = this.findCourseIndex(removedCourse);
        if(index>=0)
        {
            courses.remove(index);
        }else{
            System.out.println("The removal desired course can not found");
        }
    }
    public void changeCourse(Course oldCourse, Course newCourse)
    {
        int index = this.findCourseIndex(oldCourse);
        if(index>=0)
        {
            courses.set(index, newCourse);
        }else{
            System.out.println("Can not found the Old Course");
        }
    }
    // helper method 
    public int findCourseIndex(Course removedCourse)// returns the matching indec of the removed course
    {
        int index = -1;
        for(int i =0;i<courses.size();i++)
        {
            if(courses.get(i).equals(removedCourse))
            {
                index = i;
            }
        }
        return index;
    }
    //                  Get methods
    public ArrayList<Course> getCourses()
    {
        return this.courses;
    }
    public int getSize()
    {
        return courses.size();
    }   
}
