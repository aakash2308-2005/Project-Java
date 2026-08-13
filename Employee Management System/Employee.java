import java.math.BigDecimal;

abstract class Employee{
    private String employeeId;
    private String name;
    private int age;
    private String email;
    private Departments department;
    private BigDecimal salary;
    private EmployeeType employeeType;

    public Employee(String employeeId, String name, int age, String email, Departments department)
    {
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Departments getDepartment()
    {
        return department;
    }

    public void setDepartment(Departments department)
    {
        this.department = department;
    }

    public BigDecimal getSalary() {
        return salary;
    }
    protected void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }
    protected void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    abstract void calculateSalary();

}

class FullTimeEmployee extends Employee{

    private BigDecimal basicSalary;
    private BigDecimal allowance;
    public FullTimeEmployee(String employeeId, String name, int age, String email, Departments department, BigDecimal basicSalary, BigDecimal allowance)
    {
        super(employeeId, name, age, email, department);
        this.basicSalary = basicSalary;
        this.allowance = allowance;
        super.setEmployeeType(EmployeeType.FULLTIMEEMPLOYEE);
    }

    public BigDecimal getBasicSalary() {
        return basicSalary;
    }
    public void setBasicSalary(BigDecimal basicSalary) {
        this.basicSalary = basicSalary;
    }

    public BigDecimal getAllowance() {
        return allowance;
    }
    public void setAllowance(BigDecimal allowance) {
        this.allowance = allowance;
    }

    public void calculateSalary()
    {
        super.setSalary(basicSalary.add(allowance));
    }

}

class PartTimeEmployee extends Employee{

    private BigDecimal hourlyRate;
    private int numberOfWorkingHours;
    public PartTimeEmployee(String employeeId, String name, int age, String email, Departments department, BigDecimal hourlyRate, int numberOfWorkingHours)
    {
        super(employeeId, name, age, email, department);
        this.hourlyRate = hourlyRate;
        this.numberOfWorkingHours = numberOfWorkingHours;
        super.setEmployeeType(EmployeeType.PARTTIMEEMPLOYEE);
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }
    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public int getNumberOfWorkingHours() {
        return numberOfWorkingHours;
    }
    public void setNumberOfWorkingHours(int numberOfWorkingHours) {
        this.numberOfWorkingHours = numberOfWorkingHours;
    }

     public void calculateSalary()
    {
        super.setSalary(hourlyRate.multiply(new BigDecimal(String.valueOf(numberOfWorkingHours))));
    }


}

class Intern extends Employee{

    private BigDecimal stipend;
    private int duration;
    public Intern(String employeeId, String name, int age, String email, Departments department, BigDecimal stipend, int duration)
    {
        super(employeeId, name, age, email, department);
        this.stipend = stipend;
        this.duration = duration;
        super.setEmployeeType(EmployeeType.INTERN);
    }

    public BigDecimal getStipend() {
        return stipend;
    }
    public void setStipend(BigDecimal stipend) {
        this.stipend = stipend;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void calculateSalary()
    {
        super.setSalary(stipend);
    }

}