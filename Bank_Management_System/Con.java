package Bank_Management_System;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Single place where the MySQL connection is opened.
 *
 * Credentials are read from environment variables so that no password is
 * stored in the source code. If a variable is not set, the default is used:
 *
 *   DB_URL   jdbc:mysql://localhost:3306/Bank_System
 *   DB_USER  root
 *   DB_PASS  (empty)
 */
public class Con {

    private static final String URL  = env("DB_URL",  "jdbc:mysql://localhost:3306/Bank_System");
    private static final String USER = env("DB_USER", "root");
    private static final String PASS = env("DB_PASS", "");

    Connection connection;
    Statement statement;

    Con() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement  = connection.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Could not connect to the database.\n\n" + e.getMessage() +
                "\n\nCheck that MySQL is running and that DB_USER and DB_PASS are set correctly.");
            e.printStackTrace();
        }
    }

    private static String env(String key, String fallback) {
        String value = System.getenv(key);
        return (value == null || value.isEmpty()) ? fallback : value;
    }
}
