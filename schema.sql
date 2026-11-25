-- Bank Management System - database setup
-- Run once with:  mysql -u root -p < schema.sql

DROP DATABASE IF EXISTS Bank_System;
CREATE DATABASE Bank_System;
USE Bank_System;

-- 1. Personal details (signup page 1)
CREATE TABLE signup (
  Form_no     VARCHAR(20) PRIMARY KEY,
  name        VARCHAR(50),
  fathername  VARCHAR(50),
  dob         VARCHAR(20),
  gender      VARCHAR(10),
  email       VARCHAR(50),
  marital     VARCHAR(20),
  address     VARCHAR(100),
  city        VARCHAR(30),
  pincode     VARCHAR(10),
  state       VARCHAR(30)
);

-- 2. KYC / additional details (signup page 2)
CREATE TABLE signup2 (
  Form_no         VARCHAR(20) PRIMARY KEY,
  Religion        VARCHAR(20),
  category        VARCHAR(20),
  income          VARCHAR(20),
  education       VARCHAR(20),
  Occupation      VARCHAR(50),
  PAN             VARCHAR(10),
  Adhar_No        VARCHAR(20),
  Senior_citizen  VARCHAR(20),
  existingaccount VARCHAR(20)
);

-- 3. Account details (signup page 3)
CREATE TABLE signup3 (
  Form_no      VARCHAR(20) PRIMARY KEY,
  Account_type VARCHAR(50),
  Card_number  VARCHAR(25),
  Pin          VARCHAR(10),
  Services     VARCHAR(200)
);

-- 4. Credentials used by the login screen
CREATE TABLE login (
  formno VARCHAR(20),
  cardno VARCHAR(25),
  pin    VARCHAR(10)
);

-- 5. Transaction ledger. There is no balance column by design -
--    the balance is calculated from these rows (see README).
CREATE TABLE bank (
  pin    VARCHAR(10),
  date   VARCHAR(50),
  type   VARCHAR(20),
  amount VARCHAR(20),
  INDEX (pin)
);

-- Optional demo account so you can log in immediately.
-- Card number 1111-2222-3333-4444, PIN 1234, opening balance Rs 5000.
INSERT INTO signup  VALUES ('1001','Demo User','Demo Father','01/01/2000','Male',
                            'demo@example.com','Unmarried','1 Demo Street','Ahmedabad','380001','Gujarat');
INSERT INTO signup2 VALUES ('1001','NA','General','Upto 2,50,000','Graduate',
                            'Student','ABCDE1234F','123412341234','No','No');
INSERT INTO signup3 VALUES ('1001','Saving Account','1111-2222-3333-4444','1234','ATM Card, Internet Banking');
INSERT INTO login   VALUES ('1001','1111-2222-3333-4444','1234');
INSERT INTO bank    VALUES ('1234','Mon Jan 01 10:00:00 IST 2024','Deposit','5000');
