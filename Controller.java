
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        StudentDao dao = new StudentDaoImpl();

        while(true){
           try{
            System.out.println("\n===== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. View All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice =sc.nextInt();

            switch (choice) {
                case 1:                                           //for adding student records
                System.out.print("Enter student id: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("Enter student name: ");
                String name= sc.nextLine();
                System.out.print("Enter student marks: ");
                double marks= sc.nextDouble();
                dao.add(new StudentEntity(id, name, marks));                  //persisting new student records
                    break;

                    //for getting single student     

                case 2:                                                
                System.out.print("Enter Student id: ");
                int searchId=sc.nextInt();
                StudentEntity student = dao.getStudentById(searchId);
                if(student!=null){
                System.out.println(student);
                }else{
                    System.out.println("\nStudent not found with Id: "+searchId);
                }
                    break;

                    //for getting all student records

                case 3:                                          
                dao.viewAll();
                   break;

                //for Updating the student

                case 4:                                          
                System.out.print("Enter Id of Student to Update: ");
                int updatedId = sc.nextInt();
                StudentEntity updateStudent = dao.getStudentById(updatedId);
                if(updateStudent == null){
                     System.out.println("\nId :"+updatedId+" not found.Enter valid Id");
                    break;
                }
                System.out.print("you entered " +updateStudent.getName()+"'s Id. Enter his/her updated marks: ");
                double updateMarks = sc.nextDouble();
                dao.update(updatedId, updateMarks);
                    break;

                    //for Deleting student

                case 5:
                System.out.print("Enter ID of Student to Delete: ");
                    int deleteId = sc.nextInt();

                System.out.print("Are you sure you want to delete this student? (yes/no): ");
                String delConfirm = sc.next();
                if (delConfirm.equalsIgnoreCase("yes")) {
                    dao.delete(deleteId);
                }else{
                    System.out.println("Deltion cancelled");
                }
                   break;

                   //for exiting from the window
                case 6:
                 System.out.print("\nAre sure! you want to exit ? (Yes/No): ");
                 String confirm = sc.next();

                 if(confirm.equalsIgnoreCase("Yes")){
                    System.out.println("\nThank you. Exiting....\n");
                    sc.close();
                    return;
                 }
                 break;
            
                default:
                System.out.println("Invalid option. Please try again.");
                    break;
            }
               
                         //handling exceptions

        }catch(java.util.InputMismatchException e){                                            //exeption for handling text instead of number                            
            System.out.println("\nInvalid input! Please enter correct data types.");
            sc.nextLine();
        }
        catch(Exception e){                                                                    //for handling unknow exceptions 
            System.out.println("\nUnexpected Error occured "+e.getMessage());
        }

        }

        
    }
    
}
