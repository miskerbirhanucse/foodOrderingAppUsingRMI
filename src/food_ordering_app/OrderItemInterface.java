/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food_ordering_app;

/**
 *
 * @author admin
 */
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public interface OrderItemInterface extends Remote {
	void handleDelivered(String oID) throws IOException,SQLException;
    List<OrderItem> orderItems(Integer oID) throws RemoteException;
}
