public class Person {
    protected String name;
    protected String ID;
    protected course[][] schedule2D;
    protected final int rowNum = 9;
    protected final int columnNum = 6; 
    protected Courses courses = new Courses();
    public Person(String name, String ID){
        this.name = name;
        this.ID = ID;
        for(int i = 0; i < columnNum; i++){
            for(int j = 0; j < rowNum; j++){
                schedule2D[j][i] = null; 
            }
        } 
    }
    public String getName() {
        return name;
    }
    public int getID() {
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
        for(int i = 0; i < columnNum; i++){
            for(int j = 0; j < rowNum; j++){
                if(course.getBooleanMatrix()){
                    schedule2D[j][i]=course;
                }
            }
        } 
    }
    public boolean doesOverlap(Course course){
        for(int i = 0; i < columnNum; i++){
            for(int j = 0; j < rowNum; j++){
                if(schedule2D[j][i]!=null){
                    if(course.getBooleanMatrix()){
                        return true;
                    }
                }
            }
        } 
        return false;
    }
}
