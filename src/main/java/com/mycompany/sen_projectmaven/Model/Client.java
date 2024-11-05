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
    private String[] contracts;
    public String[] clientHistory;


    public Client(){};
    public Client(int clientID, String username, String clientName, String[] contracts, String[] clientHistory)
    {
        this.clientID = clientID;
        this.username = username;
        this.clientName = clientName;
        this.contracts = contracts;
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
                client = new Client(clientID,username, clientName,contracts,clientHistory);
                client.clientID = rs.getInt("clientID");
                client.username = rs.getString("username");
                client.clientName = rs.getString("clientName");
                client.contracts = (String[]) rs.getArray("contracts").getArray();
                client.clientHistory = (String[]) rs.getArray("clientHistory").getArray();

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

    public void updateProfile() {
        System.out.println("Updating profile...");
        //Add more logic here

    }


}

