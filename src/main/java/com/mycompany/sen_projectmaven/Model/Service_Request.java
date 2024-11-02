/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sen_projectmaven.Model;

/**
 *
 * @author mckyl
 */
public class Service_Request extends Technician {
    public String requestID;
    public String requestType;
    private String serviceStatus;
    public String servicePriority;

    public int getLinkedTechnician() {
        return getTechnicianID();
    }

    public void setLinkedTechnician(int technicianID) {
        setTechnicianID(technicianID);
    }
}
