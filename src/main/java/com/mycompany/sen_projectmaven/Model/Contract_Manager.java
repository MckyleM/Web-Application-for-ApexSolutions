/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sen_projectmaven.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author mckyl
 */
import java.util.Date;

import org.apache.http.annotation.Contract;

import com.mycompany.sen_projectmaven.Presenter.DatabaseConnection;

public class Contract_Manager {
    
    private int contractID;
    private Date startDate;
    private Date endDate;
    String query;

    public Contract_Manager getContract(int ID) {
        Contract_Manager contract = null;
        query = "SELECT contractID FROM contract_manager WHERE contractID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, ID); 
            ResultSet rs = stmt.executeQuery();
            //Finds first instance of ID
            if (rs.next()) {
                contract = new Contract_Manager();
                contract.contractID =rs.getInt("contractID");
                contract.startDate = rs.getDate("startDate");
                contract.endDate = rs.getDate("endDate");   

                // Add additional fields here as needed
            }

        } catch (SQLException e) {
            //logger.error("Error getting contract", e);
            e.printStackTrace();
        }

        return contract;
    }

    public int getContractID() {
        return contractID;
        
        
    }

    public void renewContract(Date newEndDate) {
        endDate = newEndDate;
    }

    public String trackContract() {
        if(endDate.before(new Date())) {
            return "Contract has expired";
        }
        else if (startDate.after(new Date())) {
            return "Contract has not started yet";  
        }
        else{
            return "Contract is active";
        }
        
    }
}
