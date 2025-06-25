public class StudentEntity {
    private int id;
    private String name;
    private double marks;

    public StudentEntity(){}

    public StudentEntity(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }


    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getMarks() {
        return marks;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMarks(double marks) {
        this.marks = marks;
    }
    @Override
    public String toString() {
        return "\n[id=" + id + ", name=" + name + ", marks=" + marks + "]";
    }
    
    
    
}
