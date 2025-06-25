
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{

    List<StudentEntity> students = new ArrayList<>();              //Takinng arrayList for storing student records


                     //For adding the new Student Records
    @Override
    public void add(StudentEntity student) {
         boolean exist=false;
        for(StudentEntity stud:students){
            if(stud.getId()==student.getId()){                               //Checking the Student id in the list before adding to avoid the duplicate id's
                exist=true;
                break;                                                       //if true brak the loop
            }   
        }
        if(exist){                                                          //if id exist print message
            System.out.println("\nStudent with ID :"+student.getId()+" already exists. Please enter a different ID.");
        }else{
            students.add(student);                                           ///if not exist then add the record into the list
             System.out.println("\nStudent added successfully.");
        }
        
        
    }
                             //Getting All Student Records
    @Override
    public void viewAll() {

        if(students.isEmpty()){
            System.out.println("\nNo student records found");
        }else{
            for(StudentEntity student : students){
             System.out.println(student);
            }
        }
    }
  
                             //Updating student Marks based on id
    @Override
    public void update(int id, double marks) {
        boolean found = false;
       for(StudentEntity stud:students){
            if(stud.getId()==id){
                stud.setMarks(marks);                                   //updating student marks 
                System.out.println("\nStudent records updated successfully");
                found=true;
                break;                                                  //stops the further iteration in the students if student with id found
        }    
       
       }
       if(!found){
        System.out.println("\nStudent not found with Id: "+id);
       }
    }

                               //Deleting Student record by Id
    @Override
    public void delete(int id) {
        boolean removed = students.removeIf(student -> student.getId() == id);
    if (removed) {
        System.out.println("\nStudent record deleted successfully.");
    } else {
        System.out.println("\nStudent not found with ID: " + id);
    }
}

                             //Single Student record By id
    @Override
    public StudentEntity getStudentById(int id) {
        for(StudentEntity stud:students){
            if(stud.getId()==id){
                return stud;
            }
        }
        return null;
    }
}