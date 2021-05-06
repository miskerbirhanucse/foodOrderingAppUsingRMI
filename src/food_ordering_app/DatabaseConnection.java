/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food_ordering_app;
import java.sql.*;
/**
 *
 * @author admin
 */
public class DatabaseConnection {

    private DatabaseConnection() {

    }

    public static DatabaseConnection getInstance() {
        //Creating an instance
        return new DatabaseConnection();
    }

    public Connection getConnection() throws SQLException {
        //Connect to the database: host 127.0.0.1 & port 3306 & database dcoms_db
        String url = "jdbc:mysql://127.0.0.1:3306/food";
        String user = "root";
        String password = "";


        Connection databaseConnection = DriverManager.getConnection(url,user,password);

        return databaseConnection;
    }
}

