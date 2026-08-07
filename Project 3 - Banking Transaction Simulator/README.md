# 🏦 Banking Transaction Simulator

A console-based Java application that simulates basic banking operations such as account creation, deposits, withdrawals, money transfers, balance checking, and transaction history.

This project is part of my **Java Backend Development learning journey**, focused on strengthening Java fundamentals, object-oriented programming, collections, exception handling, and input validation.

---

## 📌 Features

* Create a new bank account
* Prevent duplicate account numbers
* Validate account holder name
* Support **Savings** and **Current** account types
* Set an initial account balance
* Deposit money into an account
* Withdraw money from an account
* Prevent withdrawals exceeding the available balance
* Transfer money between two accounts
* Prevent transferring money to the same account
* Check account balance
* Display complete account details
* Maintain transaction history for each account
* Handle invalid menu input
* Handle invalid monetary input without crashing

---

## 🛠️ Technologies Used

* **Java**
* **Java Collections Framework**
* **ArrayList**
* **BigDecimal**
* **Exception Handling**
* **Scanner**
* Object-Oriented Programming concepts

---

## 📂 Project Structure

```text
Banking Transaction Simulator/
│
├── Main.java
├── Handler.java
├── Account.java
└── README.md
```

### `Main.java`

Responsible for:

* Displaying the main menu
* Accepting the user's choice
* Calling the appropriate banking operation
* Handling invalid menu choices
* Exiting the application

### `Account.java`

Represents a bank account and stores:

* Account number
* Account holder name
* Account type
* Account balance
* Transaction history

### `Handler.java`

Contains the main banking operations:

* Account creation
* Deposit
* Withdrawal
* Transfer
* Balance checking
* Account details
* Transaction history

---

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone <your-repository-url>
```

### 2. Navigate to the project directory

```bash
cd "Banking Transaction Simulator"
```

### 3. Compile the Java files

```bash
javac *.java
```

### 4. Run the application

```bash
java Main
```

---

## 🖥️ Main Menu

```text
===== BANKING TRANSACTION SIMULATOR =====

1. Create Account
2. Deposit Money
3. Withdraw Money
4. Check Balance
5. Transfer Money
6. Display Account Details
7. Transaction History
8. Exit

Enter choice:
```

---

## 💰 Example Operations

### Create Account

```text
Account number: 1001
Account holder name: Aakash
Account type: Savings
Initial Balance: 10000
```

### Deposit

```text
Account number: 1001
Deposit Amount: 5000

Deposit successful.
Current Balance: 15000
```

### Withdrawal

```text
Account number: 1001
Withdraw Amount: 3000

Withdrawal successful.
Current Balance: 12000
```

### Transfer

```text
Sender Account: 1001
Receiver Account: 1002
Amount: 2000

Transfer successful.
```

---

## 🔐 Validation

The application validates important banking operations.

* Account numbers must be unique
* Account holder name cannot be empty
* Account type must be `Savings` or `Current`
* Initial balance cannot be negative
* Deposit amount must be greater than zero
* Withdrawal amount must be greater than zero
* Withdrawal cannot exceed available balance
* Transfer amount must be greater than zero
* Transfer cannot exceed available balance
* Sender and receiver cannot be the same account
* Invalid monetary input is handled without terminating the application
* Invalid menu choices are rejected

---

## 🧪 Testing

The application was tested for:

* Valid account creation
* Duplicate account numbers
* Invalid account types
* Empty account holder names
* Negative initial balances
* Valid deposits
* Invalid deposits
* Valid withdrawals
* Insufficient balance withdrawals
* Valid transfers
* Invalid receiver accounts
* Same-account transfers
* Insufficient transfer balance
* Transaction history
* Invalid menu choices
* Invalid monetary input

---

## 🎯 Learning Objectives

This project was built to practice:

* Java classes and objects
* Encapsulation
* Getters and setters
* `ArrayList`
* Loops and conditional statements
* `Scanner` input handling
* `BigDecimal` for monetary values
* Exception handling
* Searching objects inside collections
* Method-based program organization
* Basic application testing and debugging

---

## 🚀 Future Improvements

Possible improvements for a future version:

* Persistent storage using a database
* Spring Boot REST API
* Authentication and authorization
* Transaction IDs
* Date and time for transactions
* Database-backed transaction history
* Unit testing with JUnit
* REST API integration with a frontend

---

## 👨‍💻 Project Status

**Status:** Completed ✅

**Project:** 3 of Java Backend Development Learning Plan

**Type:** Console-based Java application

**Development Time:** Approximately 2–3 hours

