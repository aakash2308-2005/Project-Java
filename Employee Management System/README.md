# Employee Management System

A console-based Employee Management System built using Java to practice Object-Oriented Programming, inheritance, polymorphism, enums, collections, and `BigDecimal`-based salary calculations.

## Features

1. Add Employee
2. View All Employees
3. Search Employee
   - Search by Employee ID
   - Search by Employee Name
4. Update Employee
   - Name
   - Age
   - Email
   - Department
5. Remove Employee
6. View Employees by Department
7. View Employee Statistics
8. Exit

## Employee Types

The system supports three types of employees:

- Full-Time Employee
  - Basic Salary
  - Allowances/Benefits
- Part-Time Employee
  - Hourly Rate
  - Number of Hours
- Intern
  - Stipend
  - Duration

Each employee type has its own salary calculation.

## Departments

Employees can belong to:

- Engineering
- HR
- Finance
- Marketing
- Operations

Departments are represented using Java `enum`.

## Concepts Practiced

- Classes and Objects
- Encapsulation
- Inheritance
- Polymorphism
- Method Overriding
- Constructors
- Getters and Setters
- Enums
- Interfaces / Abstract Classes
- `ArrayList`
- `HashSet`
- `Scanner`
- `BigDecimal`
- Loops and Conditional Statements
- Switch Statements
- Searching and Removing from Collections
- Basic CRUD Operations

## Data Structures Used

### ArrayList

An `ArrayList<Employee>` is used to store all employees.

### HashSet

A `HashSet<String>` is used to maintain unique employee IDs and prevent duplicate employees from being added.

## Salary Handling

`BigDecimal` is used for salary and monetary calculations instead of `double` to avoid floating-point precision problems.

The system calculates:

- Individual employee compensation
- Total payroll
- Full-time payroll
- Part-time payroll
- Intern payroll
- Average payroll for each employee type

## Project Structure

Employee Management System
│
├── Main.java
├── Handler.java
├── Employee.java
├── FullTimeEmployee.java
├── PartTimeEmployee.java
├── Intern.java
├── EmployeeType.java
└── Departments.java
How to Run

Compile all Java files:

javac *.java

Run the application:

java Main
Example
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
Validation Implemented
Prevents duplicate employee IDs
Validates employee departments
Validates employee types
Prevents operations on non-existent employees
Handles empty employee collections
Maintains employee IDs after removal
Learning Outcome

This project demonstrates the fundamentals of designing a small Java application using OOP principles and collection frameworks. It also provides practical experience with polymorphic employee types, enum-based classification, CRUD operations, and financial calculations using BigDecimal.

Future Improvements

Possible improvements for a larger version:

Stronger input validation
Exception handling for invalid numeric input
File/database persistence
Authentication and authorization
Separate service and repository layers
REST API using Spring Boot
Database integration using JPA/Hibernate
Unit testing with JUnit
Status

Completed

This project serves as a foundation for progressing from core Java and OOP concepts toward backend development with Spring Boot.
