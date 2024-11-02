/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sen_projectmaven.Model;

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
        return contracts;
    }

    public void setContracts(String[] contracts) {
        this.contracts = contracts;
    }

    public void updateProfile() {
        System.out.println("Updating profile...");
        // Add logic for updating the profile
    }

    public void submitFeedback() {
        System.out.println("Feedback submitted successfully");
    }
}

