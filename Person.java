import java.util.Arrays;
public class Person {
    protected String name;
    protected String ID;
    protected Course[][] schedule2D = new Course[rowNum][columnNum];
    protected boolean[][] program = new boolean[rowNum][columnNum]; 
    protected static final int rowNum = 9;
    protected static final int columnNum = 6;
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
    public void addCourse(Course course){
        if(this.doesOverlap(course)==false){
            this.addCourseToProgram(course);
        }
        else{
            System.out.println("The course specified overlaps with another course.");
        }
    }
    private void addCourseToProgram(Course course) {
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < columnNum; j++){
                if(course.getProgram()[i][j]){
                    schedule2D[i][j]=course;
                    program[i][j] = true;
                }
            }
        } 
    }
    public boolean doesOverlap(Course course){
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < columnNum; j++){
                if(this.program[i][j] && course.getProgram()[i][j]){
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
