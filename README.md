# Bank Management System

A desktop ATM simulator built with **Java Swing** and a **MySQL** database, connected over **JDBC**.
A customer can open an account through a 3-page signup form, log in with a card number and PIN,
and then deposit, withdraw, check their balance, view a mini statement, or change their PIN.

---

## Quick start

### Step 1 - Install MySQL (only needed once)

```bash
sudo apt update
sudo apt install -y mysql-server
sudo systemctl enable --now mysql
```

### Step 2 - Set up the database

```bash
cd ~/Documents/Project/Bank_Management_System
./setup-db.sh
```

This creates the `Bank_System` database, all 5 tables, a demo account, and a MySQL
user for the application. It saves the credentials to `db.env`, which `run.sh` reads
automatically.

### Step 3 - Run it

```bash
./run.sh
```

That one command compiles the project and opens the login window.

### Optional - a GUI to browse the database

Useful for showing the tables during an interview:

```bash
sudo snap install dbeaver-ce          # recommended, officially published
# or
sudo snap install mysql-workbench-community
```

Connect with host `localhost`, port `3306`, database `Bank_System`,
user `bankapp`, password `BankApp@123`.

---

## Demo account

The `schema.sql` file creates a ready-to-use account so you never have to sign up during a demo:

| Field | Value |
|---|---|
| Card number | `1111-2222-3333-4444` |
| PIN | `1234` |
| Opening balance | Rs 5000 |

---

## Suggested demo walkthrough

A 2-minute path that shows every feature:

1. **Log in** with the demo card number and PIN above.
2. **Balance Enquiry** - shows Rs 5000.
3. **Deposit** Rs 2000 -> go back to Balance Enquiry, now Rs 7000.
4. **Cash Withdrawal** of Rs 1000 -> balance becomes Rs 6000.
5. Try withdrawing **Rs 50000** - it is rejected ("Maximum withdrawal limit is Rs. 10,000").
6. Try withdrawing more than the balance - it is rejected ("Insufficient Balance").
7. **Fast Cash** -> Rs 500, for the preset-amount shortcut.
8. **Mini Statement** - lists every transaction with the running total.
9. **Pin Change** - change the PIN, then log out and log back in with the new one.
10. Optionally show **Sign Up** to walk through the 3-page form and the auto-generated card number.

Steps 5 and 6 are worth doing on purpose - they show the validation logic, not just the happy path.

---

## Tech stack

- Java 17 or newer (Swing for the GUI)
- MySQL 8
- JDBC via `mysql-connector-java-8.0.28.jar`
- `jcalendar-tz-1.3.3-4.jar` for the date-of-birth picker

---

## Database - 5 tables

| Table | Columns | What it stores |
|---|---|---|
| `signup` | 11 | Name, father's name, DOB, gender, email, address, city, state |
| `signup2` | 10 | Religion, category, income, education, occupation, PAN, Aadhaar |
| `signup3` | 5 | Account type, card number, PIN, services opted for |
| `login` | 3 | Form no, card number, PIN - checked by the login screen |
| `bank` | 4 | PIN, date, type (`Deposit`/`Withdraw`), amount - the transaction ledger |

**How they link together:**

```
signup ──┐
signup2 ─┼── joined on  Form_no   (one customer, filled across the 3 signup pages)
signup3 ─┘
                 │
                 ▼
login  ── card number + PIN are copied here when the account is created
                 │
                 ▼
bank   ── every transaction row is linked by  pin
```

---

## Key design decision: the balance is calculated, not stored

There is **no balance column anywhere** in the database. The `bank` table is a transaction
ledger, and the balance is worked out by replaying it:

```java
// Balance.java
while (rs.next()) {
    if (rs.getString("type").equals("Deposit")) balance += amount;
    else                                        balance -= amount;
}
```

This is the *event sourcing* pattern.

- **Advantage:** there is a complete audit trail, and the balance can never disagree with the
  list of transactions.
- **Trade-off:** reading a balance is O(n) in the number of transactions. A real banking system
  would store a running balance alongside the ledger and reconcile the two.

---

## Known limitations and what I would improve

These are deliberate talking points rather than hidden problems:

1. **SQL injection.** Queries are built with string concatenation and `Statement`. They should use
   `PreparedStatement` with bound parameters.
2. **PINs are stored in plaintext.** They should be salted and hashed (BCrypt or Argon2).
3. **No transactions.** A withdrawal reads the balance and then inserts a row without a
   transaction, so two simultaneous withdrawals could both pass the balance check. This needs
   `setAutoCommit(false)` plus `SELECT ... FOR UPDATE`.
4. **The PIN is used as the join key** to the `bank` table. A PIN is a credential, not an
   identity - it is changeable and not unique. That is why changing a PIN has to update three
   tables at once. An immutable account number would be the correct key.
5. **Amounts and dates are stored as `VARCHAR`.** They should be `DECIMAL(12,2)` and `DATETIME`.
6. **Connections are never closed.** Each button handler creates a new `Con` and leaks it.
   Try-with-resources and a connection pool (HikariCP) would fix this.
7. **No separation of concerns.** SQL lives directly inside the Swing classes. A DAO/service
   layer would separate the database code from the UI.
8. **Absolute positioning.** `setLayout(null)` with fixed pixel coordinates means the UI does not
   adapt to different screen sizes.

---

## Project structure

```
Bank_Management_System/
├── run.sh                      # compile + run in one command
├── setup-db.sh                 # one-time database setup
├── schema.sql                  # creates the database, 5 tables and a demo account
├── mysql-connector-java-8.0.28.jar
├── jcalendar-tz-1.3.3-4.jar
├── Images/                     # background images used by the screens
└── Bank_Management_System/
    ├── Con.java                # JDBC connection (reads DB_USER / DB_PASS)
    ├── Login.java              # entry point
    ├── SignUp.java             # signup page 1 - personal details
    ├── SignUp2.java            # signup page 2 - KYC details
    ├── SignUp3.java            # signup page 3 - account type, generates card no + PIN
    ├── main_class.java         # the ATM menu
    ├── Deposit.java
    ├── Withdraw.java           # enforces the Rs 10,000 limit and balance check
    ├── FastCash.java           # preset amounts
    ├── Balance.java
    ├── MiniStatement.java
    └── ChangePin.java
```

---

## Troubleshooting

**"Could not connect to the database"**
MySQL is not running, or `setup-db.sh` has not been run yet.
Check with `systemctl status mysql` and start it with `sudo systemctl start mysql`.

**Images do not appear**
Always start the app with `./run.sh`. The images are loaded from the classpath, so the app has to
be run from the project root.

**`javac: command not found`**
Install a JDK: `sudo apt install default-jdk`

---

This project was built for learning purposes.
