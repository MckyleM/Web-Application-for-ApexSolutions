<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.mycompany.sen_projectmaven.Model.Customer_Ratings" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ratings Form</title>
</head>
<body>
    <h2>Submit Your Feedback</h2>
    <form action="processCustomerRatings.jsp" method="post">
        Feedback ID: <input type="number" name="feedbackID" required><br><br>
        Username: <input type="text" name="username" required><br><br>
        Rating (1-5): <input type="number" name="rating" min="1" max="5" required><br><br>
        <input type="submit" value="Submit Feedback">
    </form>
</body>
</html>
