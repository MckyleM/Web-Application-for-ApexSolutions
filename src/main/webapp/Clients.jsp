<%--
  Created by IntelliJ IDEA.
  User: ntuli
  Date: 2024/11/04
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clients Management</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="header">
    <h1>Client Management</h1>
</div>

<div class="navbar">
    <a href="Main.jsp">Home</a>
    <a href="Clients.jsp">Clients</a>
    <a href="Service.jsp">Field Services</a>
    <a href="Contracts.jsp">Contracts</a>
    <a href="Ratings.jsp">Ratings</a>
</div>

<div class="container">
    <!-- Search bar -->
    <div class="search-bar">
        <input type="text" placeholder="Search clients..." id="searchInput">
        <button class="button" onclick="searchClients()">Search</button>
    </div>

    <!-- Client information section -->
    <div class="client-info">
        <h2>Client Information</h2>
        <button class="button" onclick="showClientHistory()">View Client History</button>
        <div id="clientHistory" style="display:none;">
            <!-- Client history details will be loaded here -->
            <p>Client history details displayed here...</p>
        </div>
    </div>

    <!-- Active contracts section -->
    <div class="contracts-section">
        <h2>Active Contracts</h2>
        <p>Details of active contracts, including deadlines, expiration dates, and renewal options, will be shown here.</p>
    </div>

    <!-- Notes section -->
    <div class="notes-section">
        <h2>Important Notes</h2>
        <textarea placeholder="Add notes for important clients..."></textarea>
    </div>
</div>

<div class="footer">
    <p>&copy; 2024 Client Management System</p>
</div>

<script>
    function showClientHistory() {
        var historyDiv = document.getElementById("clientHistory");
        if (historyDiv.style.display === "none") {
            historyDiv.style.display = "block";
        } else {
            historyDiv.style.display = "none";
        }
    }

    function searchClients() {
        // Placeholder for search functionality
        alert("Searching clients...");
    }
</script>
</body>
</html>