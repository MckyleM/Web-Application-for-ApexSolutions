/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sen_projectmaven.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mckyl
 */
public class Job {
    private int JobID;
    private int TechnicianID;
    public String JobStatus;
    public String JobType;
    private int ContractID;
    
    public void CreateJob(int jobID,String jobStat, String jobtype, int contractID)
    {
        this.ContractID = contractID;
        
    }
    public void AssignJob(int techID,int jobID)
    {
        String query = "UPDATE public.jobs\n" +
                "SET \"TechnicianID\" = ?, \"JobStatus\" = ?, \"JobType\" = ?, \"ContractID\" = ?\n" +
                "WHERE \"JobID\" = ?;";
        try (Connection connection = DatabaseConnection.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(query)) {
             
             statement.setString(1, Integer.toString(TechnicianID));
             statement.setString(2, JobStatus);
             statement.setString(3, JobType);
             statement.setString(4,Integer.toString(ContractID));
             statement.setString(5, Integer.toString(jobID)); 
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }
    public boolean findTechnicianJob(int techID)
    {
        String query = "SELECT * FROM \"jobs\" WHERE TechnicianID = ?";
         
         try (Connection connection = DatabaseConnection.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(query)) {
             
             statement.setString(1, Integer.toString(techID));
             
             
             try (ResultSet resultSet = statement.executeQuery()){
                 return resultSet.next();
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return false;
    }
    
}
