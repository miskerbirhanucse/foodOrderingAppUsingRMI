/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food_ordering_app;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class foodImplementation extends UnicastRemoteObject implements FoodInterface {
    boolean valid = false;

    Connection connection = DatabaseConnection.getInstance().getConnection();
    Statement statement = connection.createStatement();


    public foodImplementation() throws RemoteException, SQLException {
    }

    @Override
    public boolean addFood(String food, String price, String category) throws IOException, SQLException {

        if(!(food.isEmpty()) && !(price.isEmpty()) && !(category.isEmpty())) {

            statement.executeUpdate("insert into food(fname,price,category) " +
                    "values('"+food+"','"+price+"','"+category+"')");

            System.out.println("\n\n ###------------------------ Food Added Successfully! -------------------------");
            valid = true;
        }
        else {
            System.out.println("\n\n ### --> All fields are required!");
            valid = false;
        }

        return valid;
    }

    @Override
    public List<Food> allFood() throws RemoteException {
        List<Food> list = new ArrayList<Food>();
        try{
            ResultSet resultSet = statement.executeQuery("select * from food");

            

            while(resultSet.next()) {
                Food food = new Food();
                food.setId(resultSet.getInt("id"));
                food.setFname(resultSet.getString("fname"));
                food.setPrice(resultSet.getString("price"));
                food.setCategory(resultSet.getString("category"));
                list.add(food);
            }
           

        } catch (Exception ex) {
            ex.printStackTrace();

            return null;
        }
         return list;
    }
    @Override
    public Food getFood(String fname)throws RemoteException{
        Food f=new Food();
        try{
            PreparedStatement ps=connection.prepareStatement("select id,fname,price,category from food where fname=?");
            ps.setString(1, fname);
           ResultSet resultSet=ps.executeQuery();
           while(resultSet.next()){
               f.setId(resultSet.getInt("id"));
               f.setFname(resultSet.getString("fname"));
               f.setPrice(resultSet.getString("price"));
               f.setCategory(resultSet.getString("category"));
           }
        }catch (Exception ex) {
            ex.printStackTrace();

        }
        return f;
    }

}
