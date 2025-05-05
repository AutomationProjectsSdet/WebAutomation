package com.parabank.controlls;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseControl {


    private static String CONNECTION_URL = "";
    private static String USERNAME = "";
    private static String PASSWORD = "";

    private Connection con; // Declare connection as a class member

    //create connection
public Connection openConnection(Connection con) {
    try {
        String dbClass = "oracle.jdbc.driver.OracleDriver";
        Class.forName(dbClass).newInstance();
        // Get connection to DB
        con = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    } catch (InstantiationException e) {
        throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
    }
    return con;
}




    public  void deleteUser(String user) {
        con=openConnection(con);
        String query = "delete from tablename where username='" + user + "'";
        try (Statement statement = con.createStatement()) {
            int rowsAffected = statement.executeUpdate(query);
            System.out.println(rowsAffected + " row(s) deleted.");
            closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void closeConnection() {
        try {
            if (con != null) {
                con.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

