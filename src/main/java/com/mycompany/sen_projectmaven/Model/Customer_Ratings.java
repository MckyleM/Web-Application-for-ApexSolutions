/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sen_projectmaven.Model;

import com.mycompany.sen_projectmaven.Model.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author mckyl
 */
public class Customer_Ratings extends Client {
    private int feedbackID;
    public String Username;
    private int rating;
    Client client = new Client();

    public Customer_Ratings(){};
    public Customer_Ratings(int feedbackID, String username, int rating){
        this.feedbackID = feedbackID;
        this.Username = client.username;
        this.rating = rating;

    }


    public void sendSurvey() {
        // Logic to send survey
    }

    public String assessFeedback(String feedback) {
        return "Feedback assessed successfully";
    }

    public void submitFeedback(int id) {
        query = "UPDATE client_ratings SET rating = ? WHERE username = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, rating);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Feedback submitted successfully");
    }

}
