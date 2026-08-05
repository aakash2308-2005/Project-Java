import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        boolean noExit = true;

        Scanner sc = new Scanner(System.in);
        Handler handler = new Handler();
        
        while (noExit){
            System.out.println("====================================\n");
            System.out.println("STUDENT GRADE CALCULATOR\n");
            System.out.println("====================================\n\n\n");

            System.out.println(
                "1. Add Student\n" + 
                "2. Add Subject & Marks\n" + 
                "3. View Student Report\n" + 
                "4. View All Students\n" + 
                "5. Search Student\n" + 
                "6. View Class Statistics\n"+
                "7. Exit\n");
            System.out.println("Enter your choice:");
            int userChoice = sc.nextInt();

            switch(userChoice){
                case 1:
                    System.out.println("Student ID");
                    String addStudId = sc.next();
                    System.out.println("Name");
                    String addName = sc.next();
                    System.out.println("Age");
                    int age = sc.nextInt();
                    System.out.println("Department");
                    String dept = sc.next();
                    System.out.println("Year");
                    int year = sc.nextInt();
                    handler.addStudent(addStudId, addName, age, dept, year);
                    break;

                case 2:
                    System.out.println("Enter Student ID: ");
                    String id = sc.next();
                    System.out.println("Enter Subject Name: ");
                    String subName = sc.next();
                    System.out.println("Enter Marks Obtained: ");
                    float mark = sc.nextFloat();
                    System.out.println("Enter Maximum Marks: ");
                    float totalMark = sc.nextFloat();
                    handler.addSubjectAndMark(id, subName, mark, totalMark);
                    break;

                case 3:
                    System.out.println("View Student Report");
                    String studReportId = sc.next();
                    handler.viewStudentReport(studReportId);
                    break;

                case 4:
                    handler.viewAllStudents();
                    break;

                case 5:
                    System.out.println("Student ID: ");
                    String studId = sc.next();
                    handler.searchStudent(studId);
                    break;

                case 6:
                    handler.viewClassStatistics();
                    break;

                case 7:
                    noExit = false;
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
        sc.close();
    }
}