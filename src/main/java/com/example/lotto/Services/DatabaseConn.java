package com.example.lotto.Services;

import java.sql.*;

public class DatabaseConn {
    Connection conn = null;
    Statement setupStatement = null;
    Statement readStatement = null;
    ResultSet resultSet = null;
    String results = "";
    int numresults = 0;
    String statement = null;

    String dbName = "lotto";
    String userName = "lagado";
    String password = "Carlos10";
    String hostname = "lotto-database-1.c8ad9ewm0gfl.us-east-1.rds.amazonaws.com";
    String port = "3306";
    String jdbcUrl = "jdbc:mysql://" + hostname + ":" +
            port + "/" + dbName + "?user=" + userName + "&password=" + password;

    public DatabaseConn() {
        try {
            System.out.println("Loading driver...");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find the driver in the classpath!", e);
        }
    }

    public void test() {
        try {
            conn = DriverManager.getConnection(jdbcUrl);

            readStatement = conn.createStatement();
            resultSet = readStatement.executeQuery("SELECT lotto_name FROM lotto_code;");

            resultSet.first();
            results = resultSet.getString("lotto_name");
            resultSet.next();
            results += ", " + resultSet.getString("lotto_name");

            System.out.println(results);

            resultSet.close();
            readStatement.close();
            conn.close();

        } catch (SQLException ex) {
            // Handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            System.out.println("Closing the connection.");
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException ignore) {
                }
        }
    }
}
