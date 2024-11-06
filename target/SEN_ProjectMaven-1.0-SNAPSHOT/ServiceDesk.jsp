<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mycompany.sen_projectmaven.Model.Technician" %>
<%-- Created by IntelliJ IDEA. User: ntuli Date: 2024/11/06 Time: 00:19 --%>
<html>
<head>
    <title>Service Desk</title>
    <link href="css/main2Style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="header">
    <h1>ApexCare Solutions - Service Desk</h1>
</div>

<div class="navbar">
    <a href="Main.jsp">Home</a>
    <a href="Clients.jsp">Clients</a>
    <a href="Service.jsp">Field Services</a>
    <a href="Contracts.jsp">Contracts</a>
    <a href="ServiceDesk.jsp">Service Desk</a>
</div>

<div class="container">
    <!-- Call History and Log Call Form -->
    <div class="left-section">
        <!-- Form to Log a New Call -->
        <div class="tech-info">
            <h2>Make a Call</h2>
            <form action="LogCallServlet" method="post">
                <label for="clientName">Client Name:</label>
                <input type="text" id="clientName" name="clientName" placeholder="Enter client name" required/><br>

                <label for="issue">Issue:</label>
                <textarea id="issue" name="issue" placeholder="Describe the client's issue..." required></textarea>

                <button class="button" type="submit">Start Call</button>
            </form>
        </div>

        <!-- Section to Display Previous Call History -->
        <div class="contracts-section">
            <h2>Previous Call History</h2>
            <table>
                <thead>
                <tr>
                    <th>Date</th>
                    <th>Client</th>
                    <th>Details</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>2024-10-01</td>
                    <td>Jane Doe</td>
                    <td>Discussed account status and recent issues.</td>
                    <td>
                        <button class="button" onclick="viewCallDetails()">View Details</button>
                    </td>
                </tr>
                <!-- Additional rows populated dynamically -->
                </tbody>
            </table>
        </div>
    </div>

    <!-- Right Section for Managing Work Requests -->
    <div class="notes-section">
        <h2>Manage Work Requests</h2>

        <!-- Form to add a new work request -->
        <form action="AddWorkRequestServlet" method="post">
            <label for="workReqDetails">Work Request Details:</label><br>
            <textarea id="workReqDetails" name="workReqDetails" placeholder="Enter new work request details..." required></textarea>
            <button class="button" type="submit">Add Work Request</button>
        </form>

        <!-- Display active work requests in a table with options for actions -->
        <h3>Active Work Requests</h3>
        <table>
            <thead>
            <tr>
                <th>Request ID</th>
                <th>Client Name</th>
                <th>Details</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>WR123</td>
                <td>John Doe</td>
                <td>Network connectivity issue</td>
                <td>Pending</td>
                <td>
                    <button class="button update-btn" onclick="updateWorkRequest('WR123')">Update</button>
                    <button class="button delete-btn" onclick="acceptWorkRequest('WR123')">Accept</button>
                    <button class="button delete-btn" onclick="declineWorkRequest('WR123')">Decline</button>
                </td>
            </tr>
            <!-- Additional rows will be populated dynamically -->
            </tbody>
        </table>
    </div>
</div>

<div class="footer">
    <p>&copy; 2024 ApexCare Solutions - All rights reserved</p>
</div>

<script>
    function viewCallDetails() {
        alert("Displaying call details.");
        // Further code to display details can be added here.
    }

    function updateWorkRequest(requestId) {
        alert("Update functionality for Request ID: " + requestId);
    }

    function acceptWorkRequest(requestId) {
        alert("Accept functionality for Request ID: " + requestId);
    }

    function declineWorkRequest(requestId) {
        alert("Decline functionality for Request ID: " + requestId);
    }
</script>
</body>
</html>
