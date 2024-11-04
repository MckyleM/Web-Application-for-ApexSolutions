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
import com.mycompany.sen_projectmaven.Presenter.DatabaseConnection;
/**
 *
 * @author mckyl
 */
public abstract class CRM {
    private Client client = new Client();
    private Contract_Manager contractManager = new Contract_Manager();

    public int getClientID() {
        return client.getClientID();
    }

    public List<String> getClientHistory(int ID) {
        List<String> ClientHistoryList = new ArrayList<>();
        String query = "SELECT \"clientHistory\" FROM \"public.client\" WHERE \"clientID\" =?";
        try (Connection connection = DatabaseConnection.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(query)) {
             statement.setString(1, Integer.toString(ID));
             ResultSet rs = statement.executeQuery();

             while(rs.next()){
                 ClientHistoryList.add(rs.getString("clientHistory"));
             }

         } catch (SQLException e) {
             e.printStackTrace();
         }
        return ClientHistoryList;

    }

    public void getClientInfo() {
        
        // Logic to get client info
    }

    public void syncClientInfo() {
        // Logic to sync client info
    }
}
