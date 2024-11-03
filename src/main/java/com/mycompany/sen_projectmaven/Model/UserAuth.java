    package com.mycompany.sen_projectmaven.Model;

import com.mycompany.sen_projectmaven.Presenter.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.PrintWriter;



/**
 *
 * @author ntuli
 */
public class UserAuth {
    
      
    public static boolean authenticate(String username, String password) {
       //check if user is real, if their credentials exist in the database
        String query = "SELECT * FROM \"Users\" WHERE username = ? AND password = ?";

        try (Connection connection = DatabaseConnection.getConnection(); 
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, password);

            //places all mentions of that name and password and then returns whether the list has been populated(does the user exist).
            try (ResultSet resultSet = statement.executeQuery()){
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;     
    }
    
    public static boolean authenticate(String email){
        String query = "SELECT * FROM \"Users\" WHERE email = ?";

        try (Connection connection = DatabaseConnection.getConnection(); 
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, email);
            

            //places all mentions of that name and password and then returns whether the list has been populated(does the user exist).
            try (ResultSet resultSet = statement.executeQuery()){
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;   
    }
     
    public static void insert(String username, String password, String email){

        String query = "INSERT INTO \"Users\" (username,password,email) VALUES (?,?,?)";

        try (Connection connection = DatabaseConnection.getConnection(); 
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);

           int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {

                System.out.println("Added");
            } else{
                System.out.println("insert ran - not added");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
