# 🍽️ Restaurant Order Management System


A Java-based console application that simulates a restaurant's menu, customer, and order management workflow.  
The project was built to strengthen **Object-Oriented Programming (OOP)**, Java Collections, enums, `BigDecimal`, and menu-driven application design.


## 🚀 Features


### 1. Menu Management
- Add new menu items with unique Item IDs.
- Store item name, category, price, and availability status.
- Prevent duplicate Item IDs using a `HashSet`.
- View all available menu items.
- Search menu items by Item ID.
- Search menu items by Item Name.
- Support categories such as Starter, Main Course, Dessert, and Beverage.
- Track item availability using an enum.


### 2. Customer Management
- Register new customers.
- Store Customer ID, name, and phone number.
- Prevent duplicate Customer IDs.
- View all registered customers.
- Validate customers before creating orders.


### 3. Order Management
- Create orders for registered customers.
- Assign unique Order IDs.
- Maintain order status using an enum.
- Supported statuses include:
  - `PENDING`
  - `PREPARING`
  - `READY`
  - `COMPLETED`
  - `CANCELLED`


### 4. Order Items
- Add multiple menu items to an order.
- Specify quantity for each item.
- Add additional quantities of an existing item.
- Prevent adding unavailable menu items.
- Validate that quantity is greater than zero.
- Remove items from an order.
- Prevent modification of completed or cancelled orders.


### 5. Billing
- Calculate the total bill using `BigDecimal`.
- Calculate item-wise cost using:
  `Item Price × Quantity`
- Display individual item costs.
- Display the final order total.
- Store the calculated total inside the Order object.
- Recalculate the bill after modifying order items.


### 6. Order Status Management
- Update the status of an existing order.
- Prevent changes to completed orders.
- Prevent changes to cancelled orders.
- Display the current status when viewing orders.


### 7. Order Searching & Viewing
- View complete details of a specific order.
- Display customer information associated with an order.
- Display ordered items and quantities.
- View all orders in the system.
- View all orders belonging to a particular customer.
- Inform the user when no orders are found.


## 🧱 Project Structure


```text
Restaurant Order Management System/
│
├── Main.java
├── Handler.java
├── Customer.java
├── MenuItem.java
├── Order.java
├── MenuCategory.java
├── OrderStatus.java
└── AvailabilityStatus.java
🛠️ Java Concepts Used
Classes and Objects
Encapsulation
Constructors
Getters and Setters
Enums
ArrayList
HashSet
HashMap
Map
Enhanced For Loop
Scanner
BigDecimal
Method-based program structure
Object relationships
Basic validation
Menu-driven console application
📦 Collections Used
List<MenuItem> for storing menu items.
List<Customer> for storing registered customers.
List<Order> for storing restaurant orders.
Set<String> for maintaining unique Item IDs.
Set<String> for maintaining unique Customer IDs.
Set<String> for maintaining unique Order IDs.
Map<MenuItem, Integer> for storing ordered items and their quantities.
💰 Why BigDecimal?

BigDecimal is used for monetary calculations instead of double to avoid floating-point precision problems when calculating prices and bills.

🔄 Order Workflow
Register Customer
       ↓
Create Order
       ↓
Add Menu Items
       ↓
Specify Quantities
       ↓
Calculate Bill
       ↓
Update Order Status
       ↓
Complete / Cancel Order
▶️ How to Run

Compile all Java files:

javac *.java

Run the application:

java Main
🎯 Learning Objective

This project was developed as part of my Java backend learning journey to practice real-world object-oriented programming concepts before moving towards Spring Boot and backend development.

The project focuses on writing structured Java code, managing relationships between objects, using collections effectively, handling user input, and implementing business logic in a console-based application.
