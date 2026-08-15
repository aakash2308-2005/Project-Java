import java.util.Scanner;
import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Handler{

    private Scanner sc;
    private List<Employee> employees = new ArrayList<>();
    private Set<String> employeeIds = new HashSet<>();

    public Handler(Scanner sc)
    {
        this.sc = sc;
    }

    public void addEmployee()
    {
        System.out.println("Enter employee Id: ");
        String employeeId = sc.next();
        sc.nextLine();

        if (employeeIds.contains(employeeId))
        {
            System.out.println("Employee Id already exists!");
            return;
        }  
        System.out.println("Enter employee Name: ");
        String name = sc.nextLine();

        System.out.println("Enter employee age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter employee email: ");
        String email = sc.next();
        sc.nextLine();
        
        System.out.println("Enter employee department: ");
        String dept = sc.next();
        sc.nextLine();
        
        Departments department;
        if (dept.equalsIgnoreCase("engineering"))
        {
            department = Departments.ENGINEERING;
        }

        else if (dept.equalsIgnoreCase("hr"))
        {
            department = Departments.HR;
        }

        else if (dept.equalsIgnoreCase("finance"))
        {
            department = Departments.FINANCE;
        }

        else if (dept.equalsIgnoreCase("marketing"))
        {
            department = Departments.MARKETING;
        }

        else if (dept.equalsIgnoreCase("operations"))
        {
            department = Departments.OPERATIONS;
        }

        else
        {
            System.out.println("Invalid department!");
            return;
        }

        System.out.println("Enter employee department(FullTimeEmployee/PartTimeEmployee/Intern): ");
        String employeeType = sc.next();
        sc.nextLine();

        Employee employee;

        if (employeeType.equalsIgnoreCase("fulltimeemployee"))
        {
            System.out.println("Enter BasicSalary: ");
            BigDecimal basicSalary = new BigDecimal(sc.next());
            sc.nextLine();
            System.out.println("Enter allowance/benefits: ");
            BigDecimal allowance = new BigDecimal(sc.next());
            sc.nextLine();
            employee = new FullTimeEmployee(employeeId, name, age, email, department, basicSalary, allowance);
        }

        else if (employeeType.equalsIgnoreCase("parttimeemployee"))
        {
            System.out.println("Enter Hourly Rate: ");
            BigDecimal hourlyRate = new BigDecimal(sc.next());
            sc.nextLine();
            System.out.println("Enter number of hours: ");
            int numberOfHours = sc.nextInt();
            sc.nextLine();
            employee = new PartTimeEmployee(employeeId, name, age, email, department, hourlyRate, numberOfHours);
        }

        else if (employeeType.equalsIgnoreCase("intern"))
        {
            System.out.println("Enter stipend: ");
            BigDecimal stipend = new BigDecimal(sc.next());
            sc.nextLine();
            System.out.println("Enter duration: ");
            int duration = sc.nextInt();
            sc.nextLine();
            employee = new Intern(employeeId, name, age, email, department, stipend, duration);
        }

        else{
            return;
        }
        employee.calculateSalary();
        employees.add(employee);
        employeeIds.add(employeeId);
    }

    public void viewAllEmployees()
    {
        System.out.println("ID | Name | Department | Type | Compensation");

        if (employees.isEmpty())
        {
            System.out.println("No employees are present");
            return;
        }
        for (Employee employee : employees)
        {
            System.out.println(
                employee.getEmployeeId() + " | " +
                employee.getName() + " | " +
                employee.getDepartment() + " | " +
                employee.getEmployeeType() + " | " +
                employee.getSalary()
            );
        }
    }

    public void searchEmployee()
    {
        System.out.println("1.Employee Id search\n2.Employee Name Search.");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1)
        {
            System.out.println("Enter employee Id: ");
            String employeeId = sc.next();
            sc.nextLine();
            boolean found = false;
            for (Employee employee : employees)
            {
                if (employee.getEmployeeId().equals(employeeId))
                {
                    found = true;
                    System.out.println(
                        employee.getEmployeeId() + " | " +
                        employee.getName() + " | " +
                        employee.getDepartment() + " | " +
                        employee.getEmployeeType() + " | " +
                        employee.getSalary()
                    );
                    break;
                }
            }

            if (!found)
            {
                System.out.println("No employee found.");
            }
        }

        else if (choice == 2)
        {
            System.out.println("Enter employee Name: ");
            String employeeName = sc.nextLine();
            boolean found = false;
            for (Employee employee : employees)
            {
                if (employee.getName().equals(employeeName))
                {
                    found = true;
                    System.out.println(
                        employee.getEmployeeId() + " | " +
                        employee.getName() + " | " +
                        employee.getDepartment() + " | " +
                        employee.getEmployeeType() + " | " +
                        employee.getSalary()
                    );
                }
            }

            if (!found)
            {
                System.out.println("No employee found.");
            }
        }

        else
        {
            System.out.println("Invalid choice.");
            return;
        }

    }

    public void updateEmployee()
    {
        System.out.println("Enter employee id: ");
        String employeeId = sc.next();
        sc.nextLine();

        boolean found = false;
        for (Employee employee : employees)
        {
            if (employee.getEmployeeId().equals(employeeId))
            {
                found = true;
                System.out.println("Update\n1.Name\n2.Age\n3.Email\n4.Department");
                int choice = sc.nextInt();
                sc.nextLine();

                switch(choice)
                {
                    case 1:
                        System.out.println("Enter employee name: ");
                        String name = sc.nextLine();
                        employee.setName(name);
                        break;

                    case 2:
                        System.out.println("Enter employee age: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        employee.setAge(age);
                        break;

                    case 3:
                        System.out.println("Enter employee email: ");
                        String email = sc.next();
                        sc.nextLine();
                        employee.setEmail(email);
                        break;

                    case 4:
                        System.out.println("Enter employee department: ");
                        String dept = sc.next();
                        sc.nextLine();

                        Departments department;

                        if (dept.equalsIgnoreCase("engineering"))
                        {
                            department = Departments.ENGINEERING;
                        }

                        else if (dept.equalsIgnoreCase("hr"))
                        {
                            department = Departments.HR;
                        }

                        else if (dept.equalsIgnoreCase("finance"))
                        {
                            department = Departments.FINANCE;
                        }

                        else if (dept.equalsIgnoreCase("marketing"))
                        {
                            department = Departments.MARKETING;
                        }

                        else if (dept.equalsIgnoreCase("operations"))
                        {
                            department = Departments.OPERATIONS;
                        }

                        else
                        {
                            System.out.println("Invalid department!");
                            return;
                        }

                        employee.setDepartment(department);
                }
                break;
            }
        }

        if (!found)
        {
            System.out.println("Employee Not found");
            return;
        }
    }

    public void removeEmployee()
    {
        System.out.println("Enter employee id: ");
        String employeeId = sc.next();
        sc.nextLine();

        int index = -1;

        for (int i = 0; i< employees.size(); i++)
        {
            if (employees.get(i).getEmployeeId().equals(employeeId))
            {
                index = i;
                break;
            }
        }

        if (index == -1)
        {
            System.out.println("Employee does not Exist!");
            return;
        }
        else
        {
            employeeIds.remove(employees.get(index).getEmployeeId());
            employees.remove(index);
        }
    }

    public void checkDepartment(Departments department)
    {
        boolean found = false;
        for (Employee employee : employees)
        {
            if(employee.getDepartment().equals(department))
            {
                found = true;
                System.out.println(employee.getEmployeeId() + "-" + employee.getName());
            }
        }

        if (!found)
        {
            System.out.println("No employees are present in this department");
        }
    }

    public void viewDepartmentEmployees()
    {
        System.out.println("Engineering Employees\n\n---------------------");
        checkDepartment(Departments.ENGINEERING);
        System.out.println("HR Employees\n\n---------------------");
        checkDepartment(Departments.HR);
        System.out.println("Finance Employees\n\n---------------------");
        checkDepartment(Departments.FINANCE);
        System.out.println("Marketing Employees\n\n---------------------");
        checkDepartment(Departments.MARKETING);
        System.out.println("Operations Employees\n\n---------------------");
        checkDepartment(Departments.OPERATIONS);
    }

    public void viewEmployeeStatistics()
    {
        if (employees.isEmpty())
        {
            System.out.println("No employee available!");
            return;
        }
        int numberOfFullTimeEmployees = 0;
        int numberOfPartTimeEmployees = 0;
        int numberOfInterns = 0;

        BigDecimal totalPayRoll = new BigDecimal("0.0");
        BigDecimal fullTimeTotalPayRoll = new BigDecimal("0.0");
        BigDecimal partTimeTotalPayRoll = new BigDecimal("0.0");
        BigDecimal internTotalPayRoll = new BigDecimal("0.0");

        for (Employee employee : employees)
        {
            if (employee.getEmployeeType() == EmployeeType.FULLTIMEEMPLOYEE)
            {
                numberOfFullTimeEmployees += 1;
                fullTimeTotalPayRoll = fullTimeTotalPayRoll.add(employee.getSalary());
            }

            else if (employee.getEmployeeType() == EmployeeType.PARTTIMEEMPLOYEE)
            {
                numberOfPartTimeEmployees += 1;
                partTimeTotalPayRoll = partTimeTotalPayRoll.add(employee.getSalary());
            }

            else if (employee.getEmployeeType() == EmployeeType.INTERN)
            {
                numberOfInterns += 1;
                internTotalPayRoll = internTotalPayRoll.add(employee.getSalary());
            }

            totalPayRoll = totalPayRoll.add(employee.getSalary());
        }

        System.out.println("Number of Full Time Employees: " + numberOfFullTimeEmployees);
        System.out.println("Number of Part Time Employees: " + numberOfPartTimeEmployees);
        System.out.println("Number of Intern: "+ numberOfInterns);
        System.out.println("Total Payroll: " + totalPayRoll);
        System.out.println("Full Time Payroll: " + fullTimeTotalPayRoll);
        System.out.println("Part Time Payroll: " + partTimeTotalPayRoll);
        System.out.println("Intern Payroll: " + internTotalPayRoll);

        if (numberOfFullTimeEmployees > 0)
        {
            System.out.println("Average Full Time Payroll: " + fullTimeTotalPayRoll.divide(new BigDecimal(numberOfFullTimeEmployees)));
        }
        
        if (numberOfPartTimeEmployees > 0)
        {
            System.out.println("Average Part Time Payroll: " + partTimeTotalPayRoll.divide(new BigDecimal(numberOfPartTimeEmployees)));
        }
        
        if (numberOfInterns > 0)
        {
            System.out.println("Average Intern Payroll: " + internTotalPayRoll.divide(new BigDecimal(numberOfInterns)));
        }

    }
}