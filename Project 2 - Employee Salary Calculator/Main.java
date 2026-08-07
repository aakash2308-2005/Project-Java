import java.util.Scanner;
import java.math.BigDecimal;

class Main{
    public static void main(String args[]){
        boolean notStop = true;
        Scanner sc = new Scanner(System.in);
        Handler handler = new Handler();

        while (notStop)
        {
            System.out.println("===== Employee Salary Calculator =====\n\n");
            System.out.println(
                "1. Add Employee\n" + 
                "2. Calculate Salary\n" +
                "3. Display Employee Details\n" + 
                "4. Exit\n\n");

            System.out.print("Enter your choice:");
            int choice = sc.nextInt();

            switch(choice)
            {
                case 1:

                    int count = 1;
                    boolean proceed = true;

                    while (proceed)
                    {
                        System.out.println("Add Employee " + count);
                        System.out.println("Employee ID: ");
                        String empId = sc.next();

                        if (empId.equals(""))
                        {
                            proceed = false;
                            break;
                        }
                        sc.nextLine();
                        System.out.println("Employee name: ");
                        String empName = sc.nextLine();

                        if (empName.equals(""))
                        {
                            proceed = false;
                            break;
                        }

                        System.out.println("Deaprtment: ");
                        String dept = sc.next();

                        if (dept.equals(""))
                        {
                            proceed = false;
                            break;
                        }
                        System.out.println("Designation: ");
                        String desg = sc.next();

                        if (desg.equals(""))
                        {
                            proceed = false;
                            break;
                        }
                        
                        BigDecimal basicSal;
                        while (true)
                        {
                            System.out.println("Basic Salary: ");

                            try {
                                basicSal = new BigDecimal(sc.next());

                                if (basicSal.compareTo(new BigDecimal("1.0")) > 0)
                                {
                                    break;
                                }

                                System.out.println("Salary must be greater than 0.");
                            }

                            catch(NumberFormatException e)
                            {
                                System.out.println("Invalid Salary.PLease enter a valid number.");
                            }
                        }
                        
                        handler.addEmployee(empId, empName, dept, desg, basicSal);
                        count += 1;

                        System.out.println("Do you want to add another employee? (Y/N)");
                        String ch = sc.next();

                        if (ch.equals("N") || ch.equals("n"))
                        {
                            proceed = false;
                        }

                    }
                    
                    break;

                case 2:
                    System.out.println("Enter Employee Id: ");
                    String eId = sc.next();
                    handler.calculateSalary(eId);
                    break;

                case 3:
                    System.out.println("Enter Employee Id: ");
                    String id = sc.next();
                    handler.displayEmployeeDetails(id);
                    break;

                case 4:
                    notStop = false;
                    break;

                default:
                    System.out.println("Choose correct option.");
                    break;
            }
        }
    }
}