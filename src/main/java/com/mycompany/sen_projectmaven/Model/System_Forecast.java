/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sen_projectmaven.Model;

/**
 *
 * @author mckyl
 */
public class System_Forecast {
    private int systemID;
    private String maintenanceStatus;
    public String forecast;

    public int getSystemID() {
        return systemID;
    }

    public void setSystemID(int systemID) {
        this.systemID = systemID;
    }

    public String getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public void setMaintenanceStatus(String maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }

    public void notifyMaintenance() {
        SMSAPI api = new SMSAPI();
        api.SendMessage("System number " +Integer.toString(getSystemID()) + "needs maintenance", forecast);
        // Logic for notifying maintenance
    }

    public void forecast() {
        if ("Required".equals(maintenanceStatus)) {
            forecast = "Maintenance is required";
            notifyMaintenance();
        } else {
            forecast = "Maintenance is not required";
        }
    }
}
