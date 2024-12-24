package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A class to provide a database connection
 */
public class ConnectionProvider {
    // Database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/cafems?useSSL=false"; // Update with your database name
    private static final String USER = "root"; // Update with your MySQL username
    private static final String PASSWORD = ""; // Update with your MySQL password
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; // Updated MySQL JDBC Driver

    /**
     * Establish and return a database connection
     * 
     * @return Connection object
     * @throws RuntimeException if connection fails
     */
    public static Connection getCon() {
        try {
            // Load the JDBC driver
            Class.forName(DRIVER_CLASS);

            // Establish and return the connection
            Connection con=DriverManager.getConnection(URL, USER, PASSWORD);
            return con;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection failed: " + e.getMessage());
        }
    }

 
}
