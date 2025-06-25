
public interface StudentDao {
    void add(StudentEntity student);
    void viewAll();
    void update(int id, double marks);
    void delete(int id);
    StudentEntity getStudentById(int id);
    
}
