# Bank Management System

A Java Swing–based Bank Management System with MySQL backend.

## Features
- User signup (multi‑page)
- Login with card number and PIN
- Deposit, Withdraw, Fast Cash
- Balance Enquiry
- Mini Statement
- PIN Change

## Tech Stack
- **Java 17**
- **Swing (GUI)**
- **MySQL**
- **JDBC**

## Project Structure
```
Bank_Management_System/
├── Images/
├── Bank_Management_System/
│   ├── SignUp.java
│   ├── SignUp2.java
│   ├── SignUp3.java
│   ├── Login.java
│   ├── main_class.java
│   ├── Deposit.java
│   ├── Withdraw.java
│   ├── FastCash.java
│   ├── Balance.java
│   ├── MiniStatement.java
│   └── ChangePin.java
```

## Database Setup
Create the database and tables (example):

```sql
CREATE DATABASE bank;
USE bank;

CREATE TABLE signup (
  Form_no VARCHAR(20),
  name VARCHAR(50),
  fathername VARCHAR(50),
  dob VARCHAR(20),
  gender VARCHAR(10),
  email VARCHAR(50),
  marital VARCHAR(20),
  address VARCHAR(100),
  city VARCHAR(30),
  pincode VARCHAR(10),
  state VARCHAR(30)
);

CREATE TABLE signup2 (
  Form_no VARCHAR(20),
  Religion VARCHAR(20),
  category VARCHAR(20),
  income VARCHAR(20),
  education VARCHAR(20),
  Occupation VARCHAR(50),
  PAN VARCHAR(10),
  Adhar_No VARCHAR(20),
  Senior_citizen VARCHAR(20),
  existingaccount VARCHAR(20)
);

CREATE TABLE signup3 (
  Form_no VARCHAR(20),
  Account_type VARCHAR(50),
  Card_number VARCHAR(25),
  Pin VARCHAR(10),
  Services VARCHAR(200)
);

CREATE TABLE login (
  formno VARCHAR(20),
  cardno VARCHAR(25),
  pin VARCHAR(10)
);

CREATE TABLE bank (
  pin VARCHAR(10),
  date VARCHAR(50),
  type VARCHAR(20),
  amount VARCHAR(20)
);
```

## How to Run
1. Configure MySQL credentials in your `Con` class.
2. Ensure `Images/` contains required image files.
3. Run the app:
   ```bash
   javac -d . Bank_Management_System/*.java
   java Bank_Management_System.Login
   ```

## Notes
- Make sure MySQL server is running.
- Use correct image paths (case‑sensitive on Linux).

## License
This project is for educational use.