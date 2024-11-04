/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sen_projectmaven.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mycompany.sen_projectmaven.Presenter.DatabaseConnection;

/**
 *
 * @author mckyl
 */
public class Client {
    private int clientID;
    private String clientName;
    private String[] contracts;
    public String[] clientHistory;
    public String feedback;
    String query;
    public Client getClient(int ID) {
        Client client = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM public.clients WHERE clientID = ?")) {
            stmt.setInt(1, ID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            client = new Client();
            client.clientID = rs.getInt("clientID");
            client.clientName = rs.getString("clientName");
            client.contracts = (String[]) rs.getArray("contracts").getArray();
            client.clientHistory = (String[]) rs.getArray("clientHistory").getArray();
            client.feedback = rs.getString("feedback");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }
    public int getClientID() {
        return clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String[] getContracts() {
        return this.contracts;
    }

    public void setContracts(String[] contract) {
        this.contracts = contract;
    }

    public void updateProfile() {
        System.out.println("Updating profile...");
        //Add more logic here

    }

    public void submitFeedback(int id,String input) {
        query = "UPDATE clients SET feedback = ? WHERE clientID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, input);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Feedback submitted successfully");
    }
}

