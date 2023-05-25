package com.example.lotto.Services;

import java.sql.*;

public class DatabaseConn {
    public void connect() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:db/loteryData.db")) {
            System.out.println("Conexão realizada !!!!");

            Statement statement = connection.createStatement();

            // statement.execute("CREATE TABLE IF NOT EXISTS LOTERY( ID INTEGER, NOME
            // VARCHAR )");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
