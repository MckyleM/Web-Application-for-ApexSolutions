<%--
  Created by IntelliJ IDEA.
  User: ntuli
  Date: 2024/11/04
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Field Services Management</title>
    <link href="css/main2Style.css" rel="stylesheet" type="text/css"/>
    <style>
        /* Additional styles for drag-and-drop cards */
        .job-cards {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }

        .column {
            background-color: #DBD3D3;
            border-radius: 8px;
            padding: 10px;
            width: 30%;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        .column h3 {
            text-align: center;
        }

        .card {
            background-color: white;
            border: 1px solid #091057;
            border-radius: 8px;
            padding: 10px;
            margin: 10px 0;
            cursor: move; /* Change cursor on hover */
            transition: background-color 0.2s;
        }

        .card:hover {
            background-color: #f0f0f0;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>Welcome to ApexCare Solutions</h1>
</div>

<div class="navbar">
    <a href="Main.jsp">Home</a>
    <a href="Clients.jsp">Clients</a>
    <a href="Service.jsp">Field Services</a>
    <a href="Contracts.jsp">Contracts</a>
    <a href="Ratings.jsp">Ratings</a>
</div>

<div class="container">
    <!-- Job Requests Section -->
    <div class="left-section">
        <div class="job-requests">
            <h2>Job Requests</h2>
            <table>
                <thead>
                <tr>
                    <th>Job ID</th>
                    <th>Client Name</th>
                    <th>Urgency</th>
                    <th>Required Skill Set</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <tr class="job-row" onmouseover="showSummary('job1Summary', event)" onmouseout="hideSummary('job1Summary')">
                    <td>J001</td>
                    <td>John Doe</td>
                    <td>High</td>
                    <td>Electrical</td>
                    <td>
                        <button class="button" onclick="acceptJob('J001')">Accept</button>
                        <button class="button" onclick="declineJob('J001')">Decline</button>
                    </td>
                    <div id="job1Summary" class="summary">
                        <strong>Summary:</strong>
                        <p>Fix electrical issues at 123 Main St, Springfield.</p>
                    </div>
                </tr>
                <tr class="job-row" onmouseover="showSummary('job2Summary', event)" onmouseout="hideSummary('job2Summary')">
                    <td>J002</td>
                    <td>Jane Smith</td>
                    <td>Medium</td>
                    <td>Plumbing</td>
                    <td>
                        <button class="button" onclick="acceptJob('J002')">Accept</button>
                        <button class="button" onclick="declineJob('J002')">Decline</button>
                    </td>
                    <div id="job2Summary" class="summary">
                        <strong>Summary:</strong>
                        <p>Repair leaky faucet at 456 Elm St, Springfield.</p>
                    </div>
                </tr>
                </tbody>
            </table>
        </div>

        <!-- Available Technicians Section -->
        <div class="available-technicians">
            <h2>Available Technicians</h2>
            <table>
                <thead>
                <tr>
                    <th>Technician Name</th>
                    <th>Status</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Mike Johnson</td>
                    <td>Available</td>
                </tr>
                <tr>
                    <td>Sarah Connor</td>
                    <td>Busy</td>
                </tr>
                <tr>
                    <td>John Smith</td>
                    <td>Available</td>
                </tr>
                <tr>
                    <td>Jane Doe</td>
                    <td>On Leave</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Active Jobs Schedule Section -->
    <div class="active-jobs">
        <h2>Active Jobs</h2>
        <div class="job-cards">
            <!-- Pending Jobs Column -->
            <div class="column" ondrop="drop(event)" ondragover="allowDrop(event)">
                <h3>Pending Jobs</h3>
                <div class="card" draggable="true" ondragstart="drag(event)" id="job1">
                    <strong>Job ID: J001</strong><br>
                    Client: John Doe<br>
                    Urgency: High
                </div>
                <div class="card" draggable="true" ondragstart="drag(event)" id="job2">
                    <strong>Job ID: J002</strong><br>
                    Client: Jane Smith<br>
                    Urgency: Medium
                </div>
            </div>

            <!-- In Progress Jobs Column -->
            <div class="column" ondrop="drop(event)" ondragover="allowDrop(event)">
                <h3>In Progress Jobs</h3>
                <div class="card" draggable="true" ondragstart="drag(event)" id="job3">
                    <strong>Job ID: J003</strong><br>
                    Client: Tom Brown<br>
                    Urgency: Low
                </div>
            </div>

            <!-- Completed Jobs Column -->
            <div class="column" ondrop="drop(event)" ondragover="allowDrop(event)">
                <h3>Completed Jobs</h3>
                <div class="card" draggable="true" ondragstart="drag(event)" id="job4">
                    <strong>Job ID: J004</strong><br>
                    Client: Alice Green<br>
                    Urgency: None
                </div>
            </div>
        </div>
    </div>
</div>

<div class="footer">
    <p>&copy; 2024 ApexCare Solutions - All rights reserved</p>
</div>

<script>
    // Drag and drop functions
    function allowDrop(event) {
        event.preventDefault(); // Prevent default behavior (e.g., opening as link)
    }

    function drag(event) {
        event.dataTransfer.setData("text", event.target.id); // Store the ID of the dragged element
    }

    function drop(event) {
        event.preventDefault(); // Prevent default behavior
        var data = event.dataTransfer.getData("text"); // Get the ID of the dragged element
        event.target.appendChild(document.getElementById(data)); // Append the dragged element to the drop target
    }

    function showSummary(summaryId, event) {
        var summaryDiv = document.getElementById(summaryId);
        summaryDiv.style.left = event.pageX + 'px'; // Position summary near cursor
        summaryDiv.style.top = event.pageY + 'px';
        summaryDiv.style.display = 'block'; // Show the summary
    }

    function hideSummary(summaryId) {
        var summaryDiv = document.getElementById(summaryId);
        summaryDiv.style.display = 'none'; // Hide the summary
    }

    function acceptJob(jobId) {
        alert("Job " + jobId + " accepted.");
    }

    function declineJob(jobId) {
        alert("Job " + jobId + " declined.");
    }
</script>
</body>
</html>
