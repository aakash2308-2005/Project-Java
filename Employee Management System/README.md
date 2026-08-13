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
