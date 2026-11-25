#!/usr/bin/env bash
# Compile and launch the Bank Management System.
set -e
cd "$(dirname "$0")"

# Load database credentials if setup-db.sh has been run.
if [ -f db.env ]; then
    source db.env
fi

JARS="mysql-connector-java-8.0.28.jar:jcalendar-tz-1.3.3-4.jar"

echo "Compiling..."
mkdir -p build
javac -nowarn -cp "$JARS" -d build Bank_Management_System/*.java

echo "Starting application..."
java -cp "build:.:$JARS" Bank_Management_System.Login
