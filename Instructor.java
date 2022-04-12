public class Instructor extends Person{
    private String name;
    private String ID;
    private Student favorite;
    public Instructor(String name, String ID, Student favorite){
        super(name, ID);
        this.favorite = favorite;
    }
    public String getName() {
        return name;
    }
    public int getID() {
        return ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setID(String iD) {
        ID = iD;
    }
    public Student getFavorite() {
        return favorite;
    }
    public void setFavorite(Student favorite) {
        this.favorite = favorite;
    }
    
}
