#!/usr/bin/env bash
# One-time database setup for the Bank Management System.
# Run it with:   ./setup-db.sh
set -e
cd "$(dirname "$0")"

APP_USER="bankapp"
APP_PASS="BankApp@123"

echo "==> Creating database, tables and demo account..."
sudo mysql < schema.sql

echo "==> Creating the '$APP_USER' MySQL user for the application..."
# Ubuntu's MySQL root account uses socket authentication, which a Java/JDBC
# connection over TCP cannot use. So the app gets its own password-based user.
sudo mysql <<SQL
CREATE USER IF NOT EXISTS '${APP_USER}'@'localhost' IDENTIFIED BY '${APP_PASS}';
ALTER USER '${APP_USER}'@'localhost' IDENTIFIED BY '${APP_PASS}';
GRANT ALL PRIVILEGES ON Bank_System.* TO '${APP_USER}'@'localhost';
FLUSH PRIVILEGES;
SQL

echo "==> Saving credentials to db.env (this file is git-ignored)..."
cat > db.env <<ENV
# Credentials used by run.sh. Not committed to git.
export DB_URL="jdbc:mysql://localhost:3306/Bank_System"
export DB_USER="${APP_USER}"
export DB_PASS="${APP_PASS}"
ENV
chmod 600 db.env

echo ""
echo "Done. Now start the application with:   ./run.sh"
echo "Log in with card number 1111-2222-3333-4444 and PIN 1234"
