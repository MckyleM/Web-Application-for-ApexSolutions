/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sen_projectmaven.Model;

/**
 *
 * @author mckyl
 */
public class Self_Service extends Contract_Manager {
    private Client client = new Client();

    public int getClientID() {
        return client.getClientID();
    }

    @Override
    public int getContractID() {
        return super.getContractID();
    }

    public void viewContract() {
        // Logic to view contract
    }

    public void requestService() {
        // Logic to request service
    }
}
