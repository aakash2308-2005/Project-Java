# 💼 Project 2 — Employee Salary Calculator

A Java console-based application that manages employee information and calculates salaries based on predefined business rules. This project demonstrates Object-Oriented Programming (OOP), collections, encapsulation, and financial calculations using `BigDecimal`.

---

## 📌 Features

- Add multiple employees
- Prevent duplicate Employee IDs
- Search employee by Employee ID
- Display employee details
- Generate detailed salary payslip
- Calculate:
  - House Rent Allowance (HRA)
  - Dearness Allowance (DA)
  - Special Allowance
  - Gross Salary
  - Provident Fund (PF)
  - Professional Tax
  - Income Tax
  - Total Deductions
  - Net Salary
  - Salary Grade
- Input validation for salary
- Menu-driven console application

---

## 🛠️ Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- BigDecimal
- Exception Handling

---

## 📂 Project Structure

```
Employee Salary Calculator/
│
├── Main.java
├── Handler.java
├── Employee.java
├── Salary.java
└── README.md
```

---

## 🧮 Salary Calculation Rules

### HRA

| Basic Salary | HRA |
|--------------|-----|
| < ₹30,000 | 10% |
| ₹30,000 – ₹59,999 | 15% |
| ≥ ₹60,000 | 20% |

### DA

| Basic Salary | DA |
|--------------|----|
| < ₹30,000 | 8% |
| ₹30,000 – ₹59,999 | 10% |
| ≥ ₹60,000 | 12% |

### Special Allowance

- 5% of Basic Salary

### Gross Salary

```
Gross Salary = Basic Salary + HRA + DA + Special Allowance
```

### Provident Fund

```
PF = 12% of Basic Salary
```

### Professional Tax

| Gross Salary | Tax |
|--------------|-----|
| ≤ ₹25,000 | ₹0 |
| ₹25,001 – ₹50,000 | ₹200 |
| > ₹50,000 | ₹300 |

### Income Tax

| Annual Gross Salary | Tax |
|---------------------|-----|
| ≤ ₹3,00,000 | 0% |
| ₹3,00,001 – ₹6,00,000 | 5% |
| ₹6,00,001 – ₹10,00,000 | 10% |
| > ₹10,00,000 | 20% |

### Net Salary

```
Net Salary = Gross Salary − Total Deductions
```

---

## 📋 Menu

```
===== Employee Salary Calculator =====

1. Add Employee
2. Calculate Salary
3. Display Employee Details
4. Exit
```

---

## 📄 Sample Payslip

```
========================================
EMPLOYEE PAYSLIP
========================================

Employee ID     : EMP001
Employee Name   : Aakash
Department      : Engineering
Designation     : Software Engineer

----------------------------------------
EARNINGS
----------------------------------------

Basic Salary        : 50000
HRA                 : 7500
DA                  : 5000
Special Allowance   : 2500
Gross Salary        : 65000

----------------------------------------
DEDUCTIONS
----------------------------------------

Provident Fund      : 6000
Professional Tax    : 300
Income Tax          : XXXX

Total Deductions    : XXXX

----------------------------------------
NET SALARY          : XXXXX
SALARY GRADE        : A
========================================
```

---

## ▶️ How to Run

### Compile

```bash
javac *.java
```

### Run

```bash
java Main
```

---

## 🧪 Test Cases

The application has been tested for:

- Low salary
- Medium salary
- High salary
- Salary boundary values
- Duplicate Employee ID
- Employee search
- Multiple employees
- Invalid salary input
- Employee not found

---

## 📚 Java Concepts Practiced

- Classes and Objects
- Encapsulation
- Getters and Setters
- Method Decomposition
- Object Composition
- ArrayList
- Loops
- Conditional Statements
- Exception Handling
- BigDecimal for Financial Calculations
- Method Overriding (`toString()`)

---

## 🎯 Learning Outcome

This project was built to strengthen Java fundamentals by implementing a real-world salary management system using clean object-oriented design and accurate financial calculations.

---

**Author:** Aakash Karuppasamy
