/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sen_projectmaven.Presenter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ntuli
 */
public class DatabaseConnection {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/ApexDB";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Kaykaykay1_";
    
    

    public static Connection getConnection() throws SQLException {
        
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
}
