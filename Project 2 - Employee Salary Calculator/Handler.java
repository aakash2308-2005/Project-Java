import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

class Handler{

    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(String employeeId, String employeeName, String department, String designation, BigDecimal basicSalary)
    {

        for (Employee emp : employees)
        {
            if (emp.getEmployeeId().equals(employeeId))
            {
                System.out.println("Employee Id already exists.");
                return;
            }
        }
        Employee emp = new Employee();
        emp.setEmployeeId(employeeId);
        emp.setEmployeeName(employeeName);
        emp.setDepartment(department);
        emp.setDesignation(designation);
        emp.setBasicSalary(basicSalary);
        employees.add(emp);
    }

    public void calculateSalary(String employeeId)
    {

        boolean found = false;
        for (Employee emp : employees)
        {
            if (employeeId.equals(emp.getEmployeeId()))
            {
                found = true;
                Salary sal = new Salary(emp.getBasicSalary());
                System.out.println(
                    "========================================\n" + 
                    "EMPLOYEE PAYSLIP\n" + 
                    "========================================\n\n" +
                    "Employee ID     : " + emp.getEmployeeId() + "\n" +
                    "Employee Name   : " + emp.getEmployeeName() + "\n" +
                    "Department      : " + emp.getDepartment() + "\n" +
                    "Designation     : " + emp.getDesignation() + "\n\n"
                );
                System.out.println(sal);
                break;
                
            }
        }

        if (!found)
        {
            System.out.println("Employee not found.");
        }
    }
    
    public void displayEmployeeDetails(String empId)
    {
        boolean found = false;
        for (Employee emp : employees)
        {
            if (empId.equals(emp.getEmployeeId()))
            {
                found = true;
                System.out.println(emp);
                break;
                
            }
        }

        if (!found)
        {
            System.out.println("Employee not found.");
        }
    }
}