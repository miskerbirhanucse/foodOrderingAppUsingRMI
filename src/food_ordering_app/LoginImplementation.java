/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food_ordering_app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author admin
 */
public class LoginImplementation extends UnicastRemoteObject implements LoginInterface {

    //Constructor throws RemoteException
    public LoginImplementation() throws RemoteException {
    }

    private Integer role;
    private Integer userID;

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public Integer getUserID() throws RemoteException {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Override
    public Integer obtainLogin(String username, String password) throws SQLException {

        if (!(username.isEmpty()) && !(password.isEmpty())) {

            Connection connection = DatabaseConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSetOne = statement.executeQuery("select * from users where email='" + username + "' and u_password='" + password + "' and role=1");

            Connection connection1 = DatabaseConnection.getInstance().getConnection();
            Statement statement1 = connection1.createStatement();
            ResultSet resultSetTwo = statement1.executeQuery("select * from users where email='" + username + "' and u_password='" + password + "' and role=0");

            if (resultSetOne.next()) {
                System.out.println("\n\n ### -->  Valid username and password! .... Student is Authenticated !");
                userID = resultSetOne.getInt("id");
                role = 1;

            } else if (resultSetTwo.next()) {
                System.out.println("\n\n ### -->  Valid username and password! .... Admin is Authenticated !");
                userID = resultSetTwo.getInt("id");
                role = 0;

            } else {
                System.out.println("\n\n ### -->  Wrong username or password! .... Client is not recognized !");

                role = -1;

            }
        } else {
            System.out.println("\n\n ### --> Username and Password fields are required! Cannot have any of them blank!");
            role = -1;

        }
        return role;
    }
}
