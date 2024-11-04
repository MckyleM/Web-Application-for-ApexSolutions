/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sen_projectmaven.Model;
//import import com.mycompany.sen_projectmaven.Presenter.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.sen_projectmaven.Presenter.DatabaseConnection;
/**
 *
 * @author mckyle
 */
public class Technician {
    private int technicianID;
    private String technicianName;
    private String task;
    private String[] skills;
    private boolean availability;
    private String number;

    
    public void notifyJobs(String number) {

        Job job = new Job();
        List<Integer> avJob = job.findOpenJob();
        
        try{
        //String phoneNumber = "+1234567890";
        String jobNumbers ="";
        for (int jobnum : avJob) {
            jobNumbers+= Integer.toString(jobnum)+", and ";
        }
        String message = "Job number "+jobNumbers+ " is available";
        Thread t = new Thread(new SMSAPI(message,number));
        t.start();
            System.out.println("SMS sent successfully");

            }
        catch(Exception e)
            {
               System.out.println("Failed to send SMS to ");
            }

    }
    public void notifySystem(String number,List<Integer> Sysin)
    {
        List<Integer> SysArr = Sysin;
        
        try{
        //String phoneNumber = "+1234567890";
        String systemNumbers ="";
        for (int SysNum : SysArr) {
            systemNumbers+= Integer.toString(SysNum)+", and ";
        }
        String message = "System number "+systemNumbers+ " needs maintenance";
        Thread t = new Thread(new SMSAPI(message,number));
        t.start();
            System.out.println("SMS sent successfully");

            }
        catch(Exception e)
            {
               System.out.println("Failed to send SMS to ");
            }
        
    }
    public List<String> getAvailableTechnicians() {
        List<String> availabletechnums = new ArrayList<>();

        String query = "SELECT public.technician FROM technicians WHERE availability = TRUE";
        try (Connection connection = DatabaseConnection.getConnection(); 
            PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            

            //places all mentions of that name and password and then returns whether the list has been populated(does the user exist).
            while(rs.next()) {
                availabletechnums.add(rs.getString("number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return availabletechnums;     
    }
    public void notifyAllTechniciansJobs() 
    {
        List<String> list = getAvailableTechnicians();
        for (String technicianNum : list) {
            notifyJobs(technicianNum);
        } 
    }
    public void notifyAllTechniciansSystems(List<Integer> SysArr){
        List<String> list = getAvailableTechnicians();
        for (String technicianNum : list) {
            notifySystem(technicianNum,SysArr);
        } 
    }
    public int getTechnicianID() {
        return technicianID;
    }

    public void setTechnicianID(int technicianID) {
        this.technicianID = technicianID;
    }

    public String getTechnicianName() {
        return technicianName;
    }

    public void setTechnicianName(String technicianName) {
        this.technicianName = technicianName;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
        assignTask();
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }
    public void setNumber(String Num)
    {
        this.number = Num;
    } 
    public String getNumber(){
        return this.number;
    }
    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
        updateAvailability();
    }

    public void updateAvailability() {
        System.out.println("Updating availability...");
        // Add logic to update availability
    }

    public void assignTask() {
        // Add logic for assigning tasks
    }
}
