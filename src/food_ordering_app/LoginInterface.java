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

/**
 *
 * @author admin
 */
public interface LoginInterface extends Remote {
	
	Integer getUserID() throws RemoteException;
    // The login method that is going to be invoked by the remote client
    Integer obtainLogin(String username, String password) throws IOException, SQLException;
}
