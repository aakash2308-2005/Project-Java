# Employee Management System

A console-based Employee Management System built with **Core Java** to demonstrate practical Object-Oriented Programming, inheritance, polymorphism, enums, collections, and financial calculations using `BigDecimal`.

The project simulates a basic employee management platform where employees can be created, searched, updated, removed, grouped by department, and analyzed through payroll statistics.

---

## 🚀 Features

### Employee Management
- Add new employees
- View all employees
- Search employees by:
  - Employee ID
  - Employee name
- Update employee information
- Remove employees
- Prevent duplicate employee IDs

### Department Management
Employees can be assigned to:

- Engineering
- HR
- Finance
- Marketing
- Operations

The system can display employees grouped by department.

### Employee Types

The system supports three different employee categories:

#### Full-Time Employee
- Basic salary
- Allowances / benefits
- Total compensation calculation

#### Part-Time Employee
- Hourly rate
- Number of working hours
- Total compensation calculation

#### Intern
- Stipend
- Internship duration
- Total compensation calculation

### Payroll Statistics

The application calculates:

- Total number of employees by type
- Total payroll
- Full-time payroll
- Part-time payroll
- Intern payroll
- Average payroll for each employee type

---

## 🏗️ Project Structure

```text
Employee Management System
│
├── Main.java
│
├── Handler.java
│
├── Employee.java
├── FullTimeEmployee.java
├── PartTimeEmployee.java
├── Intern.java
│
├── EmployeeType.java
└── Departments.java
🧠 Object-Oriented Design

The project is designed around the core principles of OOP.

Encapsulation

Employee data is kept private and accessed through getters and setters.

private String name;
private int age;
private String email;

This protects the internal state of an employee object.

Inheritance

Different employee types inherit common properties from the base Employee class.

                 Employee
                    │
        ┌───────────┼───────────┐
        │           │           │
 FullTimeEmployee  PartTimeEmployee  Intern

Common employee information is maintained in the parent class, while salary-specific information is implemented in subclasses.

Polymorphism

Employees are stored using the parent type:

List<Employee> employees;

This allows the system to work with different employee types through a common Employee reference.

Each employee type can provide its own salary calculation.

Abstraction

Common employee behavior is defined at the Employee level, while specific compensation logic is implemented by the individual employee subclasses.

Enums

Enums are used to represent fixed categories:

EmployeeType
Departments

For example:

EmployeeType.FULLTIMEEMPLOYEE
EmployeeType.PARTTIMEEMPLOYEE
EmployeeType.INTERN

This is safer and cleaner than representing employee types using arbitrary strings.

🗂️ Data Structures
ArrayList

Employees are stored using:

List<Employee> employees = new ArrayList<>();

This provides dynamic storage for employee objects and allows iteration, searching, and removal.

HashSet

Employee IDs are maintained using:

Set<String> employeeIds = new HashSet<>();

The set is used to ensure that duplicate employee IDs cannot be registered.

💰 Financial Calculations

The project uses Java's BigDecimal instead of double for monetary calculations.

Example:

BigDecimal totalPayroll = new BigDecimal("0.0");

This avoids the floating-point precision issues that can occur when using double for financial values.

For example, instead of relying on:

double salary;

the application performs calculations using:

BigDecimal

which is more appropriate for monetary values.

🔄 Application Flow
Start
  │
  ▼
Main Menu
  │
  ├── Add Employee
  │      │
  │      ├── Collect employee details
  │      ├── Validate employee ID
  │      ├── Select department
  │      ├── Select employee type
  │      ├── Create appropriate employee object
  │      └── Calculate salary
  │
  ├── View Employees
  │
  ├── Search Employee
  │      ├── By ID
  │      └── By Name
  │
  ├── Update Employee
  │      ├── Name
  │      ├── Age
  │      ├── Email
  │      └── Department
  │
  ├── Remove Employee
  │
  ├── View Department Employees
  │
  ├── View Employee Statistics
  │
  └── Exit
🔍 Employee Search

The system supports two search strategies:

Search by ID

Employee IDs are unique, allowing the system to identify a specific employee.

Search by Name

The system can also search through employees using their name and display matching employees.

✏️ Employee Updates

The following employee information can be updated:

Name
Age
Email
Department

The employee ID and employee type remain unchanged because they identify the employee and determine the employee's underlying object type.

🗑️ Employee Removal

Employees can be removed using their employee ID.

When an employee is removed:

The employee is removed from the ArrayList.
The employee ID is removed from the HashSet.

This keeps both data structures synchronized.

📊 Example Statistics
Number of Full Time Employees: 1
Number of Part Time Employees: 1
Number of Intern: 1

Total Payroll: 1000000100000000019000.0

Full Time Payroll: 1000000100000000000000.0
Part Time Payroll: 4000.0
Intern Payroll: 15000.0

Average Full Time Payroll: 1000000100000000000000.0
Average Part Time Payroll: 4000.0
Average Intern Payroll: 15000.0
🛠️ Technologies Used
Java
Java Collections Framework
ArrayList
HashSet
BigDecimal
Scanner
Object-Oriented Programming
Enums

No external libraries or frameworks are required.

▶️ How to Run
1. Clone the repository
git clone <repository-url>
2. Navigate into the project
cd "Employee Management System"
3. Compile the project
javac *.java
4. Run the application
java Main
📋 Example Menu
================================
EMPLOYEE MANAGEMENT SYSTEM
================================
1. Add Employee
2. View All Employees
3. Search Employee
4. Update Employee
5. Remove Employee
6. View Department Employees
7. View Employee Statistics
8. Exit
🎯 Key Learning Outcomes

Through this project, I practiced:

Designing classes using OOP principles
Modeling real-world entities using Java classes
Using inheritance for specialized employee types
Applying runtime polymorphism
Using enums for fixed categories
Managing objects with Java collections
Maintaining unique identifiers with HashSet
Implementing CRUD-style operations
Performing monetary calculations using BigDecimal
Separating application logic into a handler class
Working with a menu-driven console application
Managing Scanner input correctly
Designing basic business logic and validations
🔮 Future Improvements

The current application is intentionally built using Core Java.

Possible future versions could introduce:

Stronger input validation and exception handling
File-based persistence
MySQL/PostgreSQL database integration
JDBC
Repository and Service layers
Unit testing with JUnit
REST APIs
Spring Boot
Spring Data JPA
Authentication and authorization
Global exception handling
DTOs and validation
Logging
API documentation using Swagger/OpenAPI

This would allow the project to evolve from a console application into a production-style backend service.

📌 Project Status

Completed — Core Java / OOP Version

This project is part of my Java backend development journey and serves as a foundation for building more advanced backend applications using Spring Boot, databases, REST APIs, and distributed systems.
