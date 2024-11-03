    package com.mycompany.sen_projectmaven.Model;

import com.mycompany.sen_projectmaven.Presenter.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



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
}
