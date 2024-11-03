/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sen_projectmaven.Model;

/**
 *
 * @author mckyl
 */
public class Technician {
    private int technicianID;
    private String technicianName;
    private String task;
    private String[] skills;
    private boolean availability;
    private String number;

    public void initilize(int id)
    {
        //connect to database and execute
        String query = "SELECT * FROM \"technician\" WHERE technicianID = ?";
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
