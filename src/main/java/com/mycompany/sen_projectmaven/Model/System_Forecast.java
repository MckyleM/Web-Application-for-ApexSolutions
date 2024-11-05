/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sen_projectmaven.Model;
import java.util.List;
import java.util.ArrayList;
import com.mycompany.sen_projectmaven.Model.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author mckyl
 */
public class System_Forecast {
    private int systemID;
    private String maintenanceStatus;
    public String forecast;
    String query;

    public System_Forecast(){};
    public System_Forecast(int systemID, String maintenanceStatus, String forecast)
    {
        this.systemID = systemID;
        this.maintenanceStatus = maintenanceStatus;
        this.forecast = forecast;
    }

    public List<Integer> getMaintananceNeeded()
    {
        query = "SELECT 'MaintenanceStatas' FROM public.system_forecast WHERE MaintenanceStatus = Required";
        List<Integer> sys = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();


            //places all mentions of that name and password and then returns whether the list has been populated(does the user exist).
            while(rs.next()) {
                sys.add(rs.getInt("MaintanaceStatus"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sys;
    }

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
}
