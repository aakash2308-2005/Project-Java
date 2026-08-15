import java.util.Scanner;

public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Handler handler = new Handler(sc);
        boolean stop = false;

        while (!stop)
        {
            System.out.println(
                "\n\n================================\n" + 
                "EMPLOYEE MANAGEMENT SYSTEM\n" +
                "================================\n" + 
                "1. Add Employee\n" +
                "2. View All Employees\n" +
                "3. Search Employee\n" + 
                "4. Update Employee\n" +
                "5. Remove Employee\n" +
                "6. View Department Employees\n" + 
                "7. View Employee Statistics\n" + 
                "8. Exit\n");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice)
            {
                case 1:
                    handler.addEmployee();
                    break;

                case 2:
                    handler.viewAllEmployees();
                    break;

                case 3:
                    handler.searchEmployee();
                    break;

                case 4:
                    handler.updateEmployee();
                    break;

                case 5:
                    handler.removeEmployee();
                    break;

                case 6:
                    handler.viewDepartmentEmployees();
                    break;

                case 7:
                    handler.viewEmployeeStatistics();
                    break;

                case 8:
                    stop = true;
                    System.out.println("Good Bye!");
                    break;

                default:
                    System.out.println("Enter valid choice!");
                    break;
            }
        }
    }
}