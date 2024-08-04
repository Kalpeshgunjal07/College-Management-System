package Clg;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CollegeDAO collegeDAO = new CollegeDAO();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Add College");
            System.out.println("2. View All Colleges");
            System.out.println("3. Update College");
            System.out.println("4. Delete College");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add College
                    College college = new College();
                    System.out.print("Enter College Name: ");
                    college.setName(scanner.nextLine());
                    System.out.print("Enter College Address: ");
                    college.setAddress(scanner.nextLine());
                    System.out.print("Enter College Contact: ");
                    college.setContact(scanner.nextLine());
                    System.out.print("Enter Number of Departments: ");
                    college.setDepartmentsCount(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Department Name: ");
                    college.setDepartmentName(scanner.nextLine());
                    collegeDAO.addCollege(college);
                    break;
                case 2:
                    // View All Colleges
                    List<College> colleges = collegeDAO.getAllColleges();
                    for (College c : colleges) {
                        System.out.println("College ID: " + c.getId());
                        System.out.println("College Name: " + c.getName());
                        System.out.println("College Address: " + c.getAddress());
                        System.out.println("College Contact: " + c.getContact());
                        System.out.println("Number of Departments: " + c.getDepartmentsCount());
                        System.out.println("Department Name: " + c.getDepartmentName());
                        System.out.println();
                    }
                    break;
                case 3:
                    // Update College
                    College collegeToUpdate = new College();
                    System.out.print("Enter College ID to Update: ");
                    collegeToUpdate.setId(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New College Name: ");
                    collegeToUpdate.setName(scanner.nextLine());
                    System.out.print("Enter New College Address: ");
                    collegeToUpdate.setAddress(scanner.nextLine());
                    System.out.print("Enter New College Contact: ");
                    collegeToUpdate.setContact(scanner.nextLine());
                    System.out.print("Enter New Number of Departments: ");
                    collegeToUpdate.setDepartmentsCount(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Department Name: ");
                    collegeToUpdate.setDepartmentName(scanner.nextLine());
                    collegeDAO.updateCollege(collegeToUpdate);
                    break;
                case 4:
                    // Delete College
                    System.out.print("Enter College ID to Delete: ");
                    int idToDelete = scanner.nextInt();
                    collegeDAO.deleteCollege(idToDelete);
                    break;
                case 5:
                    // Exit
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
