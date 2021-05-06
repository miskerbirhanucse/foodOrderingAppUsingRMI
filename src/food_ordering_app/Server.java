/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food_ordering_app;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class Server {

    public static void main(String[] args) throws SQLException {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            System.out.println("\n\n ------------------ [ Server is running on port 1099 ::: Ready to receive requests! ] ------------------ ");

            LoginImplementation login = new LoginImplementation();
            registry.rebind("login", login);
//
//            RegisterService register = new RegisterService();
//            registry.rebind("register", register);
//
//            UserService user = new UserService();
//            registry.rebind("user", user);
//
            foodImplementation food = new foodImplementation();
            registry.rebind("food", food);
//            
            OrderImp order = new OrderImp();
            registry.rebind("order", order);
            
            OrderItemImp orderItem=new OrderItemImp();
            registry.rebind("orderItem", orderItem);
        }
        catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
