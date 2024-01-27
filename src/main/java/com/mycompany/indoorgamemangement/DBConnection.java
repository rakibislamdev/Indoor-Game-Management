package com.mycompany.indoorgamemangement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Database connection class.
 */
public class DBConnection {
    private static String driverClassName = "com.mysql.cj.jdbc.Driver";
    private static String dbUrl = "jdbc:mysql://localhost:3306/indoor_game_management";
    private static String username = "root";
    private static String password = "";

    private static Connection connection;
    private static Statement statement;

    public static synchronized Statement getStatement() {
        if (statement == null) {
            try {
                Class.forName(driverClassName);

                // Establish the connection only if it's not already established
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(dbUrl, username, password);
                }

                statement = connection.createStatement();
                System.out.println("Database connection successful!");
            } catch (Exception e) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
                System.err.println("Database connection failed!");
            }
        } else {
            System.out.println("Statement not null");
        }

        return statement;
    }

    // Close the connection when done
    public static void closeConnection() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}