/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food_ordering_app;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 */
public interface FoodInterface extends Remote {
    boolean addFood(String fname, String price, String category) throws IOException,SQLException;

    List<Food> allFood() throws RemoteException;
    Food getFood(String fname) throws RemoteException;
}