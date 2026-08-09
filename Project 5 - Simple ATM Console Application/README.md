# Simple ATM Console Application

A console-based ATM application built using Java. The project simulates basic ATM operations such as user authentication, balance enquiry, deposits, withdrawals, money transfers, and transaction history.

## Features

* Account login using account number and PIN
* Maximum 3 failed login attempts
* ATM account lock after 3 failed attempts
* Check account balance
* Deposit money
* Withdraw money
* Insufficient balance handling
* Transfer money between accounts
* Prevent transfers to the same account
* Handle transfers to nonexistent accounts
* Maintain transaction history
* Record incoming and outgoing transfers
* Logout functionality
* Menu-driven console interface

## Technologies Used

* Java
* `ArrayList`
* `List`
* `BigDecimal`
* `Scanner`

## Project Structure

```text
Simple ATM Console Application/
│
├── Main.java
├── Handler.java
├── Account.java
├── Accounts.java
└── README.md
```

### Main.java

Responsible for starting the application and initiating the ATM login process.

### Account.java

Represents an individual bank account.

Stores:

* Account number
* Account holder name
* PIN
* Account type
* Account balance
* Transaction history

### Accounts.java

Stores the available accounts using an `ArrayList`.

The project uses predefined accounts for simulation.

### Handler.java

Contains the main ATM application logic:

* Login
* Authentication
* ATM menu
* Balance enquiry
* Deposit
* Withdrawal
* Transfer
* Transaction history
* Logout

## ATM Menu

```text
===== ATM MENU =====

1. Check Balance
2. Deposit Money
3. Withdraw Money
4. Transfer Money
5. Transaction History
6. Logout
```

## Transaction Handling

The application uses `BigDecimal` for monetary calculations instead of floating-point types.

### Deposit

* Accepts a positive amount
* Adds the amount to the account balance
* Records the transaction

Example:

```text
DEPOSIT +₹500
```

### Withdrawal

* Accepts a positive amount
* Checks whether sufficient balance is available
* Deducts the amount from the account
* Records the transaction

Example:

```text
WITHDRAW -₹568
```

### Transfer

The application supports transferring money between two existing accounts.

The system:

1. Accepts the recipient account number
2. Prevents transferring to the same account
3. Checks whether the recipient exists
4. Validates the transfer amount
5. Checks sufficient balance
6. Updates both account balances
7. Records the transaction for both accounts

Example:

Sender:

```text
TRANSFER TO102-₹10000
```

Receiver:

```text
TRANSFER FROM101+₹10000
```

## Authentication

Users must provide:

```text
Account Number
PIN
```

The ATM allows a maximum of **3 failed login attempts**.

After the third failed attempt:

```text
Too many failed attempts.
ATM locked.
```

## Sample Flow

```text
===== ATM =====
Enter Account Number:
101
Enter PIN:
2308

Login successful.

===== ATM MENU =====

1. Check Balance
2. Deposit Money
3. Withdraw Money
4. Transfer Money
5. Transaction History
6. Logout
```

## Concepts Practiced

This project was built to strengthen Java fundamentals through a practical application.

Key concepts practiced:

* Classes and objects
* Constructors
* Encapsulation basics
* `ArrayList`
* Generics
* Enhanced `for` loops
* `while` loops
* `switch` statements
* Conditional statements
* `Scanner` input handling
* `BigDecimal`
* Object references
* List-based data management
* Basic authentication logic
* Transaction tracking

## How to Run

Compile all Java files:

```bash
javac *.java
```

Run the application:

```bash
java Main
```

## Project Scope

This is a **console-based learning project** and does not use a database or persistent storage.

Account data exists only while the application is running.

The project intentionally focuses on Java fundamentals rather than advanced architecture.

## Future Improvements

Possible improvements for a future version include:

* Database integration
* Persistent account storage
* PIN change functionality
* Account creation
* Better exception handling
* Service-layer separation
* REST API using Spring Boot
* Authentication and authorization
* Database transactions
* Unit testing

These features are intentionally outside the scope of this project.

## Learning Goal

The goal of this project was to practice Java fundamentals by building a small but realistic banking workflow while working with objects, collections, user input, monetary calculations, and transaction state.

