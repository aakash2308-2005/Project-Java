# Vehicle Rental System

A console-based Vehicle Rental System built using **Java** to practice Object-Oriented Programming, collections, inheritance, polymorphism, and basic business logic.

## Features

1. Add vehicles
2. Register customers
3. View available vehicles
4. View all vehicles
5. Rent a vehicle
6. Return a vehicle
7. View all rental records
8. View customer details
9. View vehicle details
10. Exit the application

## Vehicle Types

The system supports three vehicle types:

- **Car** – stores number of seats
- **Bike** – stores engine capacity
- **Truck** – stores load capacity

All vehicle types inherit common properties from the `Vehicle` class.

## Main Classes

- `Main` – Handles the application menu and program execution.
- `Handler` – Contains the main application operations and manages collections.
- `Vehicle` – Base class containing common vehicle information.
- `Car` – Extends `Vehicle` with seat information.
- `Bike` – Extends `Vehicle` with engine capacity.
- `Truck` – Extends `Vehicle` with load capacity.
- `Customer` – Stores customer information.
- `Rental` – Represents a vehicle rental transaction.

## Enums

- `VehicleStatus`
  - `AVAILABLE`
  - `RENTED`

- `RentalStatus`
  - `ACTIVE`
  - `COMPLETED`

## Concepts Practiced

- Classes and Objects
- Encapsulation
- Constructors
- Getters and Setters
- Inheritance
- Polymorphism
- Method Overriding
- `ArrayList`
- `HashSet`
- `Scanner`
- `BigDecimal`
- Enums
- Object Relationships
- Basic CRUD-style operations

## Rental Logic

When a vehicle is rented:

1. Customer ID is verified.
2. Vehicle ID is verified.
3. Vehicle availability is checked.
4. Rental duration is entered.
5. Total rental price is calculated.
6. Vehicle status changes to `RENTED`.
7. A rental record is created with `ACTIVE` status.

When a vehicle is returned:

1. Rental ID is searched.
2. Rental status is checked.
3. Rental status changes to `COMPLETED`.
4. Vehicle status changes back to `AVAILABLE`.

## Price Calculation

Rental price is calculated using:

`Base Rental Price Per Day × Number Of Rental Days`

`BigDecimal` is used for monetary calculations.

## Data Management

The application currently stores data in memory using:

- `List<Vehicle>`
- `List<Customer>`
- `List<Rental>`
- `Set<String>` for unique IDs

Data is lost when the application terminates.

## How to Run

Compile all Java files:

```bash
javac *.java
