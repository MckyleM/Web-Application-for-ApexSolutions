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

</head>
<body>
<div class="header">
    <h1>Welcome to ApexCare Solutions - Contracts</h1>
</div>

<div class="navbar">
    <a href="Main.jsp">Home</a>
    <a href="Client Management.jsp">Client Management</a>
    <a href="Service.jsp">Field Services</a>
    <a href="Contracts.jsp">Contracts</a>
    <a href="ServiceDesk.jsp">Ratings</a>
</div>

<div class="contract-container">
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
            </tbody>
        </table>
    </div>

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
            </tbody>
        </table>
        <button class="button" onclick="generatePerformanceReport()">Generate Report</button>

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
    function viewContractDetails(contractId) {
        alert("Viewing details for contract: " + contractId);
    }

    function renewContract(contractId) {
        alert("Renewing contract: " + contractId);
    }

    function terminateContract(contractId) {
        alert("Terminating contract: " + contractId);
    }

    function updateContract(contractId) {
        alert("Updating contract: " + contractId);
    }

    function generatePerformanceReport() {
        alert("Generating performance report based on contract performance.");
    }

    // Function to render the charts
    function renderCharts() {

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


    window.onload = renderCharts;
</script>
</body>
</html>
