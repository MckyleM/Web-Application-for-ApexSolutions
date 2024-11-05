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

import com.mycompany.sen_projectmaven.Model.DatabaseConnection;

public class Contract_Manager {

    private int contractID;
    private int clientID;
    private Date startDate;
    private Date endDate;

    public Contract_Manager(){};
    public Contract_Manager(int ContractID,int ClientID, Date StartDate, Date EndDate)
    {
        this.contractID = ContractID;
        this.clientID = ClientID;
        this.startDate = StartDate;
        this.endDate = EndDate;
    }
    String query;

    public Contract_Manager getContract(int ID) {
        Contract_Manager contract = null;
        query = "SELECT contractID FROM contract_manager WHERE clientID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, ID);
            ResultSet rs = stmt.executeQuery();
            //Finds first instance of ID
            while (rs.next()) {
                contract = new Contract_Manager(contractID, clientID, startDate, endDate);
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

    public String getContractString(int ID) {
        String ContractInfoString = null;
        query = "SELECT * FROM public.contract_manager WHERE clientID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, Integer.toString(ID));
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                ContractInfoString += rs.getString("username, clientname, email, clientHistory") + ("\n");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ContractInfoString;
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
