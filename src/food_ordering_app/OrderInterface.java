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
public interface OrderInterface extends Remote {
    void addOrder(int custermer_id, String address,Food food_list) throws IOException,SQLException;
    List<Order> allOders() throws RemoteException;
    List<Order> allMyOders(int oID) throws RemoteException;
    void deleteOrder(String oID) throws IOException, SQLException;
    void edit(String oID,String address) throws IOException, SQLException;
}
