/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sen_projectmaven.Model;

import com.mycompany.sen_projectmaven.Model.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author mckyl
 */
public class CRM {
    Client client = new Client();
    Contract_Manager contractmanager = new Contract_Manager();


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

    public List<String> getClientInfo(int ID) {
        List<String> Info = new ArrayList<>();
        try
        {
            Info.add(client.getClientString(ID));
            Info.add(contractmanager.getContractString(ID));

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return Info;
    }

}
