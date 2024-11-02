/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sen_projectmaven.Model;

/**
 *
 * @author mckyl
 */
public class Customer_Ratings extends Client {
    private int feedbackID;
    private int rating;

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void sendSurvey() {
        // Logic to send survey
    }

    public String assessFeedback(String feedback) {
        return "Feedback assessed successfully";
    }
}
