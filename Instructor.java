public class Instructor extends Person{
    private Student favorite;
    public Instructor(String name, String ID){
        super(name, ID);
    }
    public String getName() {
        return name;
    }
    public String getID() {
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
