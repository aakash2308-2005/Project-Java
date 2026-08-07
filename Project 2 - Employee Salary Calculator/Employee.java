import java.math.BigDecimal;

class Employee{
    private String employeeId;
    private String employeeName;
    private String department;
    private String designation;
    private BigDecimal basicSalary;

    public String getEmployeeName()
    {
        return employeeName;
    }

    public String getEmployeeId()
    {
        return employeeId;
    }

    public String getDepartment()
    {
        return department;
    }

    public String getDesignation()
    {
        return designation;
    }

    public BigDecimal getBasicSalary()
    {
        return basicSalary;
    }
   
    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    public void setEmployeeId(String employeeId)
    {
        this.employeeId = employeeId;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public void setDesignation(String designation)
    {
        this.designation = designation;
    }

    public void setBasicSalary(BigDecimal basicSalary)
    {
        this.basicSalary = basicSalary;
    }

    @Override
    public String toString()
    {
        String output = "========================================\n" + 
                    "EMPLOYEE DETAILS\n" + 
                    "========================================\n\n" +
                    "Employee ID     : " + getEmployeeId() + "\n" +
                    "Employee Name   : " + getEmployeeName() + "\n" +
                    "Department      : " + getDepartment() + "\n" +
                    "Designation     : " + getDesignation() + "\n\n";

        return output;
    }


}