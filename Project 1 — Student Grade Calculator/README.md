# Student Grade Calculator

A console-based Java application for managing student information, recording subject marks, generating student grade reports, and calculating class statistics.

This is **Project 1** in my Java Backend learning journey. The primary goal of this project is to strengthen Java fundamentals and object-oriented programming concepts before moving into advanced backend development with Spring Boot.

## Features

* Add students with:

  * Student ID
  * Name
  * Age
  * Department
  * Year of Study
* Prevent duplicate Student IDs
* Add subjects and marks for students
* Validate marks
* View an individual student's complete grade report
* View all registered students
* Search for a student by Student ID
* Calculate:

  * Total marks
  * Percentage
  * Grade
  * Pass/Fail result
* View class statistics:

  * Total students
  * Passed students
  * Failed students
  * Class average
  * Top-performing student

## Application Menu

```text
====================================

STUDENT GRADE CALCULATOR

====================================

1. Add Student
2. Add Subject & Marks
3. View Student Report
4. View All Students
5. Search Student
6. View Class Statistics
7. Exit
```

## Grading System

|    Percentage | Grade |
| ------------: | :---: |
| 90% and above |   A+  |
|  80% – 89.99% |   A   |
|  70% – 79.99% |   B   |
|  60% – 69.99% |   C   |
|  50% – 59.99% |   D   |
|  40% – 49.99% |   E   |
|     Below 40% |   F   |

A student passes when they have at least one subject and score **40% or above in every subject**.

## Technologies

* **Java**
* `ArrayList`
* `List`
* `Scanner`
* Object-Oriented Programming
* Console-based application

## Project Structure

```text
Project 1 — Student Grade Calculator/
│
├── Main.java
├── Handler.java
├── Student.java
├── Subject.java
├── README.md
└── REQUIREMENTS.md
```

### `Main.java`

Responsible for:

* Starting the application
* Displaying the main menu
* Reading user input
* Handling the main application loop
* Calling the appropriate operations in `Handler`

### `Handler.java`

Responsible for the application's main operations:

* Adding students
* Adding subjects and marks
* Searching students
* Displaying student reports
* Displaying all students
* Calculating class statistics

### `Student.java`

Represents a student and contains:

* Student information
* List of subjects
* Total marks calculation
* Percentage calculation
* Grade calculation
* Pass/Fail calculation
* Student report generation

### `Subject.java`

Represents a subject and stores:

* Subject name
* Marks obtained
* Maximum marks

## How to Run

### Prerequisites

Install the Java Development Kit (JDK).

Verify the installation:

```bash
java -version
javac -version
```

### Compile

Navigate to the project directory and run:

```bash
javac *.java
```

### Run

```bash
java Main
```

## Example Student Report

```text
========================================

STUDENT GRADE REPORT

========================================

Student ID   : S101
Name         : Rahul
Age          : 21
Department   : CSE
Year         : 3

----------------------------------------
Subject       Marks
----------------------------------------
Java         85/100
DBMS         90/100
DSA          80/100


----------------------------------------
Total         : 255/300
Percentage    : 85.0%
Grade         : A
Result        : PASS

========================================
```

## Validation

The application handles basic validation including:

* Duplicate Student IDs
* Non-existent Student IDs
* Marks below 0
* Marks greater than maximum marks
* Reports for non-existent students
* Class statistics when no students are registered

## Concepts Practiced

This project was built to practice the following Java fundamentals:

* Variables and data types
* `if-else`
* `switch`
* `for` loops
* Enhanced `for` loops
* Methods
* Constructors
* Classes and objects
* Encapsulation concepts
* `ArrayList`
* `List`
* String handling
* `Scanner`
* Boolean logic
* Object relationships
* Method overriding with `toString()`
* Basic input validation

## Data Storage

The application currently stores all data **in memory using Java collections**.

Data is lost when the application terminates.

No database or external storage is used in this version.

## Future Improvements

As part of the backend learning journey, future versions/projects will introduce more advanced concepts such as:

* Improved input validation
* Exception handling
* Unit testing
* File-based persistence
* MySQL/PostgreSQL
* Spring Boot
* REST APIs
* Layered architecture
* Authentication and authorization
* Docker
* Cloud deployment
* System design concepts

These are **future learning goals and are not implemented in the current project**.

## Project Goal

The purpose of this project is not to build a production-grade application. It is to establish a strong foundation in Java programming and object-oriented programming through a complete working application.

This project is the first step in my progression toward:

```text
Java Fundamentals
       ↓
Object-Oriented Programming
       ↓
Advanced Java
       ↓
Spring Boot
       ↓
Backend Development
       ↓
Databases & REST APIs
       ↓
System Design
       ↓
Production-Ready Backend Systems
```

## Status

**Completed — Project 1**

The application compiles and runs as a standalone Java console application.
