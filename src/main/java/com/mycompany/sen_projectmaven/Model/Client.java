/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sen_projectmaven.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.sen_projectmaven.Model.DatabaseConnection;

/**
 *
 * @author mckyl
 */
public class Client {
    private int clientID;
    public String username;
    private String clientName;
    private String email;
    public String[] clientHistory;


    public Client(){};
    public Client(int clientID, String username, String clientName, String email, String[] clientHistory)
    {
        this.clientID = clientID;
        this.username = username;
        this.clientName = clientName;
        this.email = email;
        this.clientHistory = clientHistory;

    }
    String query;
    public Client getClient(int ID) {
        Client client = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM client WHERE \"clientID\" = ?")) {
            stmt.setInt(1, ID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                client = new Client(clientID,username, clientName,email,clientHistory);
                client.clientID = rs.getInt("clientID");
                client.username = rs.getString("username");
                client.clientName = rs.getString("clientName");
                client.email = rs.getString("email");
                client.clientHistory = (String[]) rs.getArray("clientHistory").getArray();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public String getClientName() {
        return clientName;
    }

    public int getClientID() {
        return clientID;
    }



    public String getEmail() { return email; }

    public List<Client> getAllCLients() {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT \"clientID\", \"clientName\", username, email, \"clientHistory\" FROM client";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int clientID = rs.getInt("clientID");
                String clientName = rs.getString("clientName");

                if (clientHistory != null) {
                    String[] clientHistory = rs.getString("clientHistory").split(",");
                }
                 // Assuming skills are stored as a comma-separated string
                String username = rs.getString("username");
                String email = rs.getString("email");

                Client client = new Client(clientID,username,clientName,email,clientHistory);
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }
//    public String getClientContracts(Client client) {
//        return client.contracts;
//    }

    public Client getClient(String username) {
        Client client = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM client WHERE username = ?")) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();






            if (rs.next()) {
                client = new Client(clientID,username, clientName,email,clientHistory);
                client.clientID = rs.getInt("clientID");
                client.username = rs.getString("username");
                client.clientName = rs.getString("clientName");
                client.email = rs.getString("email");




                try{
                    client.clientHistory = (String[]) rs.getArray("clientHistory").getArray();
                } catch (SQLException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (RuntimeException e) {
                    System.out.println("Error: " + e.getMessage());
                }

                if (client != null) {
                    if (client.username == null || client.username.isEmpty()) {
                        //where username is null or empty, if needed
                        System.out.println("Username is empty or null");
                    }
                    else{
                        client.username = rs.getString("username");
                    }
                } else {
                    // Handle the case where the client was not found in the database
                    System.out.println("Client not found.");
                }



            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public String getClientString(int ID) {
        String ClientInfoString = null;
        query = "SELECT * FROM client WHERE \"clientID\" = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, Integer.toString(ID));
            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                ClientInfoString = rs.getString("username, clientname, email, clientHistory");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ClientInfoString;
    }

    public String getClientString(String username) {
        String ClientInfoString = null;
        query = "SELECT * FROM client WHERE username = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                ClientInfoString = rs.getString("username, clientname, email, clientHistory");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ClientInfoString;
    }

    public void updateProfile() {
        System.out.println("Updating profile...");
        //Add more logic here

    }


}

