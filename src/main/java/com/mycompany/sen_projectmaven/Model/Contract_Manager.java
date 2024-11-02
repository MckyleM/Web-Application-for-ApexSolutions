/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sen_projectmaven.Model;

/**
 *
 * @author mckyl
 */
import java.util.Date;

public class Contract_Manager {
    private int contractID;
    private Date startDate;
    private Date endDate;

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public void renewContract() {
        // Logic to renew the contract
    }

    public String trackContract() {
        return "Contract is active";
    }
}
