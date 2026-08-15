# Hospital Patient Management System

A Java console-based Hospital Patient Management System designed to practice **Object-Oriented Programming, Collections, Enums, Date/Time API, and basic entity management**.

## Features

1. **Patient Registration**
   - Register patients with ID, name, age, gender, phone, address, and blood group.
   - Prevent duplicate patient IDs.

2. **Doctor Registration**
   - Register doctors with ID, name, specialization, phone number, and experience.
   - Supports multiple medical specializations.
   - Prevent duplicate doctor IDs.

3. **View Records**
   - View all registered patients.
   - View all registered doctors.
   - Display complete patient and doctor information.

4. **Search**
   - Search patients by name or ID.
   - Search doctors by specialization or ID.

5. **Patient–Doctor Assignment**
   - Assign an available doctor to a patient.
   - Prevent assigning a second doctor to the same patient.
   - Doctor status changes to `BUSY` after assignment.

6. **Appointment Management**
   - Book appointments using patient ID, doctor ID, appointment ID, date, and time.
   - Prevent duplicate appointment IDs.
   - Only available doctors can be booked.
   - Appointment date uses `dd-MM-yyyy`.
   - Appointment time uses `HH:mm`.
   - Appointment statuses: `SCHEDULED`, `COMPLETED`, `CANCELLED`.

7. **Patient Admission**
   - Admit registered patients.
   - Prevent admitting an already admitted patient.
   - Discharge patients only after admission.
   - Track patient status as `OUTPATIENT`, `ADMITTED`, or `DISCHARGED`.

8. **Appointment Completion / Cancellation**
   - Complete scheduled appointments.
   - Cancel scheduled appointments.
   - Prevent modifying completed or cancelled appointments.
   - Doctor becomes `AVAILABLE` after appointment completion or cancellation.

9. **Patient Details**
   - View complete details of an individual patient.
   - Displays assigned doctor and admission information.

10. **Hospital Statistics**
    - Displays total patients.
    - Displays admitted, discharged, and outpatient counts.
    - Displays total, available, busy, and off-duty doctors.
    - Displays total, scheduled, completed, and cancelled appointments.

## OOP Concepts Used

- Classes and Objects
- Encapsulation
- Constructors
- Getters and Setters
- Enums
- Object Relationships
- Composition / Association
- Method-based service organization

## Java Concepts Used

- `ArrayList`
- `HashSet`
- `Scanner`
- `LocalDate`
- `LocalTime`
- `DateTimeFormatter`
- Enhanced `for` loops
- Conditional logic
- Collections for ID tracking

## Main Entities

- `Patient`
- `Doctor`
- `Appointment`
- `Handler`
- `Main`

## Enums

- `PatientStatus`
- `DoctorStatus`
- `AppointmentStatus`
- `Specialization`

## Data Management

`ArrayList` is used to maintain patients, doctors, and appointments, while `HashSet` is used to efficiently track unique patient, doctor, and appointment IDs.

## Running the Project

Compile all Java files:

```bash
javac *.java
