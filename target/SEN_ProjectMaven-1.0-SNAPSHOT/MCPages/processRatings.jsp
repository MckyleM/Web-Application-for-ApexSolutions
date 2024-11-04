<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.mycompany.sen_projectmaven.Model.Customer_Ratings" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
    <title>Feedback Submission Result</title>
    <script>
        function goBack() {
            window.history.back();
        }

        function goForward() {
            window.history.forward();
        }
    </script>
</head>
<body>
    <%
        String feedbackIDStr = request.getParameter("feedbackID");
        String username = request.getParameter("username");
        String ratingStr = request.getParameter("rating");

        if (feedbackIDStr != null && username != null && ratingStr != null) {
            int feedbackID = Integer.parseInt(feedbackIDStr);
            int rating = Integer.parseInt(ratingStr);

            Customer_Ratings customerRatings = new Customer_Ratings(feedbackID, username, rating);

            // Simulate submitting the feedback (replace with real logic as needed)
            customerRatings.submitFeedback(feedbackID);

            out.println("<h3>Feedback Submitted Successfully</h3>");
            out.println("<p>Feedback ID: " + feedbackID + "</p>");
            out.println("<p>Username: " + username + "</p>");
            out.println("<p>Rating: " + rating + "</p>");
        } else {
            out.println("<h3>Invalid input. Please go back and try again.</h3>");
        }
    %>
    <br>
    <button onclick="goBack()">Back</button>
    <button onclick="goForward()">Forward</button>
</body>
</html>
