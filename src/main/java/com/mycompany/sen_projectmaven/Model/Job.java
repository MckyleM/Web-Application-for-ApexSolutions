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
public class Job {
    private int JobID;
    private int TechnicianID;
    public String JobStatus;
    public String JobType;
    private int ContractID;
    public Job(){}
    public Job(int jobID, int TechnicianID, String JobStatus, String JobType, int ContractID)
    {
        this.JobID = jobID;
        this.TechnicianID = TechnicianID;
        this.JobStatus = JobStatus;
        this.JobType = JobType;
        this.ContractID = ContractID;
    }
    public void AssignJob(int techID,int jobID)
    {
        String query = "UPDATE jobs\n" +
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
        String query = "SELECT * FROM \"jobs\" WHERE \"TechnicianID\" = ?";

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
    public List<Integer> findOpenJob()
    {
        //List<String> availabletechnums = new ArrayList<>();
        List<Integer> jobs = new ArrayList<>();
        String query = "SELECT \"JobID\" FROM jobs WHERE \"JobStatus\" = 'Open' ";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();


            //places all mentions of that name and password and then returns whether the list has been populated(does the user exist).
            while(rs.next()) {
                jobs.add(rs.getInt("jobID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }

}
