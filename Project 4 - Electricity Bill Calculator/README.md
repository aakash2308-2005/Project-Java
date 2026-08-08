# ⚡ Electric Bill Calculator

A console-based Java application that calculates electricity bills based on customer type and units consumed using a progressive slab-based billing system.

## 📌 Features

* Create and calculate electricity bills for customers
* Supports **Residential** and **Commercial** customers
* Progressive electricity slab calculation
* Fixed charges based on customer type
* Surcharge calculation based on bill subtotal
* Calculates final bill amount
* Stores multiple bills during the application session
* Displays previously generated customer bills
* Menu-driven console interface

## 🏗️ Project Structure

```text
Electric Bill Calculator/
│
├── Main.java
├── Handler.java
├── Customer.java
├── Bill.java
└── BillingService.java
```

### `Main.java`

Responsible for:

* Starting the application
* Displaying the main menu
* Handling menu selection
* Controlling the application loop

### `Handler.java`

Responsible for:

* Reading customer information
* Creating `Customer` and `Bill` objects
* Calling `BillingService`
* Displaying generated bills
* Maintaining the list of bills

### `Customer.java`

Represents a customer and stores:

* Customer ID
* Customer name
* Meter number
* Customer type
* Units consumed

### `Bill.java`

Represents a generated electricity bill and stores:

* Customer information
* Energy charge
* Fixed charge
* Surcharge
* Total bill

### `BillingService.java`

Contains the business logic for:

* Progressive slab calculation
* Fixed charge calculation
* Surcharge calculation
* Final bill calculation

## 💰 Billing Rules

### Residential Customers

| Units Consumed |       Rate |
| -------------: | ---------: |
|          0–100 | ₹2.50/unit |
|        101–200 | ₹4.00/unit |
|        201–500 | ₹5.50/unit |
|      Above 500 | ₹7.00/unit |

**Fixed Charge:** ₹50

**Surcharge:**

* Subtotal ≤ ₹2,000 → No surcharge
* Subtotal > ₹2,000 → 5%

### Commercial Customers

| Units Consumed |       Rate |
| -------------: | ---------: |
|          0–100 | ₹4.00/unit |
|        101–200 | ₹6.00/unit |
|        201–500 | ₹7.50/unit |
|      Above 500 | ₹9.00/unit |

**Fixed Charge:** ₹150

**Surcharge:**

* Subtotal ≤ ₹5,000 → No surcharge
* Subtotal > ₹5,000 → 8%

## 🧮 Example

For a residential customer consuming **800 units**:

```text
First 100 units     = 100 × ₹2.50 = ₹250
Next 100 units      = 100 × ₹4.00 = ₹400
Next 300 units      = 300 × ₹5.50 = ₹1650
Remaining 300 units = 300 × ₹7.00 = ₹2100

Energy Charge = ₹4400
Fixed Charge  = ₹50

Subtotal      = ₹4450
Surcharge     = 5% of ₹4450
              = ₹222.50

Final Bill    = ₹4672.50
```

## ▶️ How to Run

Compile the Java files:

```bash
javac *.java
```

Run the application:

```bash
java Main
```

## 🖥️ Application Menu

```text
===== ELECTRIC BILL CALCULATOR =====

1. Calculate Electricity Bill
2. Display Customer Bills
3. Exit
```

## 🧪 Testing

The application was tested with different consumption levels including:

* 100 units
* 200 units
* 500 units
* 800 units
* Residential customers
* Commercial customers
* Multiple customers and bills
* Surcharge and non-surcharge cases

## 🛠️ Technologies Used

* Java
* Object-Oriented Programming
* `BigDecimal`
* `ArrayList`
* `Scanner`

## 📚 Concepts Practiced

This project helped practice:

* Classes and objects
* Encapsulation
* Getters and setters
* `toString()`
* Object composition
* `ArrayList`
* Loops and switch statements
* Conditional logic
* Method decomposition
* `BigDecimal`
* Separation of business logic from input handling
* Basic debugging and testing

## 🚀 Future Improvements

Possible improvements for a future version:

* Input validation
* Persistent storage
* Database integration
* Better bill formatting
* Customer search
* Bill deletion
* Monthly billing history
* REST API using Spring Boot

## 👨‍💻 Author

**Aakash Karuppasamy**

This project is part of my Java Backend Development learning journey.

