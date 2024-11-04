    package com.mycompany.sen_projectmaven.Presenter;

import java.sql.*;

import static javax.swing.JOptionPane.showMessageDialog;


    /**
 *
0 * @author ntuli
 */
public class UserAuth {
    
      
    public boolean authenticate(String username, String password) {
       //check if user is real, if their credentials exist in the database
        String query = "SELECT * FROM login WHERE username = ? AND password = ?";

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
    
    public boolean authenticate(String email){
        String query = "SELECT * FROM client WHERE email = ?";

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
     //add new clients to the database
    public void insert(String username, String password, String clientName, String email){

        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);

            try {
                intoLogin(username,password, connection);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            try {
                intoClient(username, clientName, email,connection);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


            connection.commit();
            showMessageDialog(null,"User added!");
            System.out.println("Transaction committed successfully.");

        } catch (SQLException e) {


            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Transaction rolled back due to error: " + e.getMessage());
                } catch (SQLException rollbackEx) {
                    System.err.println("Failed to rollback transaction: " + rollbackEx.getMessage());
                }
            }

        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.setAutoCommit(true); // Reset auto-commit mode to default
                    connection.close();
                } catch (SQLException closeEx) {
                    System.err.println("Failed to close connection: " + closeEx.getMessage());
                }
            }
        }





    }

    public void intoClient(String username, String clientName, String email, Connection connection){

        ;
        String query = "INSERT INTO client (username,clientName,email) VALUES (?,?,?)";


        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, clientName);
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

    public void intoLogin(String username, String password, Connection connection){

        String query = "INSERT INTO login (username,password) VALUES (?,?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, password);


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
