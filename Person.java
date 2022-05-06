import java.util.Arrays;
public abstract class Person {

    protected String name, ID;
    protected Course[][] schedule2D = new Course[rowNum][columnNum];
    protected boolean[][] program = new boolean[rowNum][columnNum]; 
    protected static final int rowNum = 9, columnNum = 6;
    protected Courses courses = new Courses();

    public Person(String name, String ID){
        this.name = name;
        this.ID = ID;
        for(int i = 0; i < rowNum; i++){
            Arrays.fill(schedule2D[i], null);
            Arrays.fill(program[i],false);
        } 
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public Courses getCourses () {
        return courses;
    }

    public void addCourse (Course course){
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < columnNum; j++){
                if(course.getProgram()[i][j]){
                    schedule2D[i][j]=course;
                    program[i][j] = true;
                }
            }
        } 
        courses.addCourse(course);
    }

    public boolean doesOverlap (Course course){
        for (int i = 0; i < courses.getSize(); i++) {
            if (course.equals(courses.getCourse(i))) {
                return true;
            }
        }
        for (int i = 0; i < rowNum; i++){
            for(int j = 0; j < columnNum; j++){
                if (this.program[i][j] && this.schedule2D[i][j].getName().equals(course.getName())) {
                    continue;
                }
                if (this.program[i][j] && course.getProgram()[i][j]){
                    return true;
                }
            }
        } 
        return false;
    }

    public boolean doesOverlap (Courses requestingCourses){
        Courses noIncluded = new Courses();
        //finding the courses which is not in the requesting courses and adding them to noIncluded 
        for (int i = 0; i < courses.getSize(); i++) {
            boolean ctr = true;
            for (int j = 0; j < requestingCourses.getSize(); j++) {
                if (requestingCourses.getCourse(j).getName().equals(courses.getCourse(i).getName())) {
                    ctr = false;
                }
            }
            if (ctr) {
                noIncluded.addCourse(courses.getCourse(i));
            }
        }
        
        //checking the compatibility of requesting courses and no included courses
        for (int i = 0; i < requestingCourses.getSize(); i++) {
            for (int j = 0; j < noIncluded.getSize(); j++) {
                if(requestingCourses.getCourse(i).doesOverlap(noIncluded.getCourse(j))){
                    return true;
                }
            } 
        }
        //checking the compatibility of requesting courses with each other
        for (int i = 0; i < requestingCourses.getSize(); i++) {
            for (int j = i+1; j < requestingCourses.getSize(); j++) {
                if(requestingCourses.getCourse(i).doesOverlap(requestingCourses.getCourse(j))){
                    return true;
                }
            } 
        }

        return false;
    }
    

    public void printSchedule() {
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < columnNum; j++) {
                if (schedule2D[i][j] == null) {
                    System.out.print ("----- ");
                }
                else {
                    System.out.print (schedule2D[i][j].getName() + " ");
                }
            }
            System.out.println();
        }
    }
}
