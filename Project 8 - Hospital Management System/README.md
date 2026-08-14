# 🏥 Hospital Patient Management System

A console-based **Hospital Patient Management System built in Java** using Object-Oriented Programming principles.

The application manages patients, doctors, appointments, admissions, discharges, doctor availability, and hospital statistics through a simple menu-driven interface.

This project was built to strengthen practical Java OOP concepts such as **classes, objects, encapsulation, enums, collections, object relationships, constructors, and service-oriented program structure**.

---

## 📌 Features

### 👤 Patient Management

- Register new patients
- Prevent duplicate patient IDs
- Store patient information:
  - Patient ID
  - Name
  - Age
  - Gender
  - Phone Number
  - Address
  - Blood Group
- View all registered patients
- Search patients by:
  - Patient name
  - Patient ID
- View detailed information about a specific patient
- Track patient status

### 👨‍⚕️ Doctor Management

- Register new doctors
- Prevent duplicate doctor IDs
- Store doctor information:
  - Doctor ID
  - Doctor name
  - Specialization
  - Phone number
  - Experience
  - Availability status
- View all registered doctors
- Search doctors by:
  - Specialization
  - Doctor ID
- Track doctor availability

### 🏥 Patient–Doctor Assignment

- Assign a patient to an available doctor
- Prevent assigning another doctor when a patient already has an assigned doctor
- Store the assigned doctor inside the patient object
- Store assignment information
- Update doctor availability when a doctor is assigned

### 📅 Appointment Management

- Book appointments for registered patients and doctors
- Generate appointments using a unique appointment ID
- Prevent duplicate appointment IDs
- Store:
  - Appointment ID
  - Patient
  - Doctor
  - Appointment date
  - Appointment time
  - Appointment status
- Accept appointment dates in:

```text
dd-MM-yyyy
