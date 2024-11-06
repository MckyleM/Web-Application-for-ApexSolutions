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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.annotation.Contract;

import com.mycompany.sen_projectmaven.Model.DatabaseConnection;

public class Contract_Manager {

    private int contractID;
    private int clientID;
    private String service;
    private String level;
    private String Status;

    public Contract_Manager(){};
    public Contract_Manager(int ContractID,int ClientID, String Service, String Level, String Status)
    {
        this.contractID = ContractID;
        this.clientID = ClientID;
        this.service = Service;
        this.level = Level;
        this.Status = Status;
    }
    String query;

    public List<Contract_Manager> getAllContracts(int clientID){
        List<Contract_Manager> Contracts = new ArrayList<Contract_Manager>();

        String query = "SELECT * FROM contract_manager WHERE \"clientID\"";

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setInt(1, clientID);
            ResultSet rs = statement.executeQuery();


            while (rs.next()) {

                Contract_Manager cm = new Contract_Manager();

                clientID = rs.getInt("clientID");
                String service = rs.getString("service");
                String level = rs.getString("level");
                String Status = rs.getString("Status");
                Contracts.add(cm);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return Contracts;
    }

    public Contract_Manager getContract(int ID) {
        Contract_Manager contract = null;
        query = "SELECT \"contractID\" FROM contract_manager WHERE \"clientID\" = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, ID);
            ResultSet rs = stmt.executeQuery();
            //Finds first instance of ID
            while (rs.next()) {
                contract = new Contract_Manager(contractID, clientID, service, level, Status);
                contract.contractID =rs.getInt("contractID");
                contract.service = rs.getString("service");
                contract.level = rs.getString("level");
                contract.Status = rs.getString("status");

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
        query = "SELECT * FROM contract_manager WHERE \"clientID\" = ?";
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

    public int getCLientID() {
        return clientID;
    }

    public String getService() {
        return service;
    }

    public String getLevel() {
        return level;
    }

    public String getStatus() {
        return Status;
    }



}
