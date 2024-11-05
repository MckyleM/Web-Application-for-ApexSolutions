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
    <title>Contracts Management</title>
    <link href="css/main2Style.css" rel="stylesheet" type="text/css"/>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<%--    <style>--%>
<%--        body {--%>
<%--            font-family: Arial, sans-serif;--%>
<%--            margin: 0;--%>
<%--            padding: 0;--%>
<%--            overflow-x: hidden; /* Prevent horizontal overflow */--%>
<%--        }--%>

<%--        .header {--%>
<%--            background-color: #091057;--%>
<%--            color: white;--%>
<%--            padding: 10px 0;--%>
<%--            text-align: center;--%>
<%--        }--%>

<%--        .navbar {--%>
<%--            background-color: #EC8305;--%>
<%--            overflow: hidden;--%>
<%--            padding: 10px;--%>
<%--        }--%>

<%--        .navbar a {--%>
<%--            float: left;--%>
<%--            display: block;--%>
<%--            color: white;--%>
<%--            text-align: center;--%>
<%--            padding: 10px 16px;--%>
<%--            text-decoration: none;--%>
<%--        }--%>

<%--        .contract-container {--%>
<%--            display: flex;--%>
<%--            flex-wrap: wrap; /* Allow wrapping to fit in smaller screens */--%>
<%--            justify-content: space-between;--%>
<%--            padding: 20px;--%>
<%--            gap: 20px;--%>
<%--            max-width: 1200px;--%>
<%--            margin: auto;--%>
<%--        }--%>

<%--        .summary-section, .performance-section {--%>
<%--            background-color: #DBD3D3;--%>
<%--            padding: 10px;--%>
<%--            border-radius: 8px;--%>
<%--            flex: 1 1 45%; /* Allow sections to take up to 45% of the container */--%>
<%--            box-shadow: 0px 0px 10px #DBD3D3;--%>
<%--            max-width: 600px; /* Set a max width for better fitting */--%>
<%--        }--%>

<%--        .performance-section h2, .summary-section h2 {--%>
<%--            margin-top: 0;--%>
<%--            font-size: 1.2em; /* Smaller header size */--%>
<%--        }--%>

<%--        .summary-section table, .performance-section table {--%>
<%--            width: 100%;--%>
<%--            border-collapse: collapse;--%>
<%--            margin-top: 10px;--%>
<%--            font-size: 14px; /* Smaller font size */--%>
<%--        }--%>

<%--        table, th, td {--%>
<%--            border: 1px solid #091057;--%>
<%--        }--%>

<%--        th {--%>
<%--            background-color: #091057;--%>
<%--            color: white;--%>
<%--            padding: 8px;--%>
<%--            text-align: left;--%>
<%--        }--%>

<%--        td {--%>
<%--            padding: 6px; /* Reduced padding */--%>
<%--            color: #333;--%>
<%--        }--%>

<%--        tr:nth-child(even) {--%>
<%--            background-color: #F2F2F2;--%>
<%--        }--%>

<%--        tr:hover {--%>
<%--            background-color: white;--%>
<%--            cursor: pointer;--%>
<%--        }--%>

<%--        .button {--%>
<%--            background-color: #EC8305;--%>
<%--            color: white;--%>
<%--            border: none;--%>
<%--            padding: 6px 12px; /* Reduced button padding */--%>
<%--            cursor: pointer;--%>
<%--            border-radius: 8px;--%>
<%--            font-size: 14px; /* Smaller font size */--%>
<%--        }--%>

<%--        .button:hover {--%>
<%--            background-color: #024CAA;--%>
<%--        }--%>

<%--        .action-buttons {--%>
<%--            display: flex;--%>
<%--            gap: 5px; /* Reduced gap */--%>
<%--        }--%>

<%--        .charts-container {--%>
<%--            display: flex;--%>
<%--            gap: 10px; /* Reduced gap between charts */--%>
<%--            flex-direction: row;--%>
<%--            margin-top: 10px; /* Reduced margin */--%>
<%--        }--%>

<%--        .chart {--%>
<%--            width: 45%; /* Adjusted width for smaller charts */--%>
<%--            height: 150px; /* Adjusted height */--%>
<%--        }--%>

<%--        .footer {--%>
<%--            text-align: center;--%>
<%--            padding: 10px;--%>
<%--            background-color: #091057;--%>
<%--            color: white;--%>
<%--            position: relative; /* Allow footer to sit below content */--%>
<%--            bottom: 0;--%>
<%--            width: 100%;--%>
<%--        }--%>
<%--    </style>--%>
</head>
<body>
<div class="header">
    <h1>Welcome to ApexCare Solutions - Contracts</h1>
</div>

<div class="navbar">
    <a href="Main.jsp">Home</a>
    <a href="Clients.jsp">Clients</a>
    <a href="Service.jsp">Field Services</a>
    <a href="Contracts.jsp">Contracts</a>
    <a href="Ratings.jsp">Ratings</a>
</div>

<div class="contract-container">
    <!-- Summary Section -->
    <div class="summary-section">
        <h2>Contracts in Progress (Most Urgent)</h2>
        <table id="contractsTable">
            <thead>
            <tr>
                <th>Contract ID</th>
                <th>Client Name</th>
                <th>Deadline</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <tr onclick="viewContractDetails('C123')">
                <td>C123</td>
                <td>John Doe</td>
                <td>2024-11-10</td>
                <td>In Progress</td>
            </tr>
            <tr onclick="viewContractDetails('C124')">
                <td>C124</td>
                <td>Jane Smith</td>
                <td>2024-11-15</td>
                <td>In Progress</td>
            </tr>
            <tr onclick="viewContractDetails('C125')">
                <td>C125</td>
                <td>Michael Johnson</td>
                <td>2024-11-20</td>
                <td>In Progress</td>
            </tr>
            <tr onclick="viewContractDetails('C126')">
                <td>C126</td>
                <td>Emily Davis</td>
                <td>2024-11-25</td>
                <td>In Progress</td>
            </tr>
            <!-- Additional rows can be dynamically added here -->
            </tbody>
        </table>
    </div>

    <!-- Performance Section -->
    <div class="performance-section">
        <h2>Contract Performance</h2>
        <table id="performanceContractsTable">
            <thead>
            <tr>
                <th>Contract ID</th>
                <th>Client Name</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>C123</td>
                <td>John Doe</td>
                <td>Active</td>
                <td class="action-buttons">
                    <button class="button" onclick="renewContract('C123')">Renew</button>
                    <button class="button" onclick="terminateContract('C123')">Terminate</button>
                    <button class="button" onclick="updateContract('C123')">Update</button>
                </td>
            </tr>
            <tr>
                <td>C124</td>
                <td>Jane Smith</td>
                <td>Active</td>
                <td class="action-buttons">
                    <button class="button" onclick="renewContract('C124')">Renew</button>
                    <button class="button" onclick="terminateContract('C124')">Terminate</button>
                    <button class="button" onclick="updateContract('C124')">Update</button>
                </td>
            </tr>
            <!-- Additional rows can be dynamically added here -->
            </tbody>
        </table>
        <button class="button" onclick="generatePerformanceReport()">Generate Report</button>

        <!-- Charts for Performance Metrics -->
        <div class="charts-container">
            <canvas id="serviceLevelChart" class="chart"></canvas>
            <canvas id="financeMetricsChart" class="chart"></canvas>
        </div>
    </div>
</div>

<div class="footer">
    <p>&copy; 2024 ApexCare Solutions - All rights reserved</p>
</div>

<script>
    // JavaScript functions for viewing contract details and managing contracts
    function viewContractDetails(contractId) {
        alert("Viewing details for contract: " + contractId); // Placeholder for detail view logic
    }

    function renewContract(contractId) {
        alert("Renewing contract: " + contractId); // Placeholder for renew logic
    }

    function terminateContract(contractId) {
        alert("Terminating contract: " + contractId); // Placeholder for terminate logic
    }

    function updateContract(contractId) {
        alert("Updating contract: " + contractId); // Placeholder for update logic
    }

    function generatePerformanceReport() {
        alert("Generating performance report based on contract performance."); // Placeholder for report generation logic
    }

    // Function to render the charts
    function renderCharts() {
        // Pie chart for Service Level Metrics
        const ctx1 = document.getElementById('serviceLevelChart').getContext('2d');
        const serviceLevelChart = new Chart(ctx1, {
            type: 'pie',
            data: {
                labels: ['Service Level 1', 'Service Level 2', 'Service Level 3'],
                datasets: [{
                    label: 'Service Levels',
                    data: [30, 50, 20], // Sample data
                    backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56'],
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'top',
                    },
                    title: {
                        display: true,
                        text: 'Service Level Metrics'
                    }
                }
            }
        });

        // Line graph for Finance Metrics
        const ctx2 = document.getElementById('financeMetricsChart').getContext('2d');
        const financeMetricsChart = new Chart(ctx2, {
            type: 'line',
            data: {
                labels: ['January', 'February', 'March', 'April', 'May', 'June'],
                datasets: [{
                    label: 'Monthly Revenue',
                    data: [3000, 4000, 3500, 4500, 5000, 5500], // Sample data
                    fill: false,
                    borderColor: 'rgba(75, 192, 192, 1)',
                    tension: 0.1
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'top',
                    },
                    title: {
                        display: true,
                        text: 'Finance Metrics'
                    }
                }
            }
        });
    }

    // Call the renderCharts function when the window loads
    window.onload = renderCharts;
</script>
</body>
</html>
