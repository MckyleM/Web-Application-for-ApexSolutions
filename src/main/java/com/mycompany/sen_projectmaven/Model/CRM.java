/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sen_projectmaven.Model;

/**
 *
 * @author mckyl
 */
public class CRM {
    private Client client = new Client();
    private Contract_Manager contractManager = new Contract_Manager();

    public int getClientID() {
        return client.getClientID();
    }

    public int getContractID() {
        return contractManager.getContractID();
    }

    public String[] getClientHistory() {
        return client.clientHistory;
    }

    public void getClientInfo() {
        // Logic to get client info
    }

    public void syncClientInfo() {
        // Logic to sync client info
    }
}
