public class Person {
    protected String name;
    protected String ID;
    protected Course[][] schedule2D;
    protected final int rowNum = 9;
    protected final int columnNum = 6; 
    protected Courses courses = new Courses();
    public Person(String name, String ID){
        this.name = name;
        this.ID = ID;
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < columnNum; j++){
                schedule2D[i][j] = null; //todo instantiate
            }
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
            System.out.println("The course spesified overlaps with another course.");
        }
    }
    private void addCourseToProgram(Course course) {
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < columnNum; j++){
                if(course.getProgram()[i][j]){
                    schedule2D[i][j]=course;
                }
            }
        } 
    }
    public boolean doesOverlap(Course course){
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < columnNum; j++){
                if(schedule2D[i][j]!=null){
                    if(course.getProgram()[i][j]){
                        return true;
                    }
                }
            }
        } 
        return false;
    }
}
