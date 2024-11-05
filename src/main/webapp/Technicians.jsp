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
    <title>Technician Management</title>
    <link href="css/main2Style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="header">
    <h1>Welcome to ApexCare Solutions</h1>
</div>

<div class="navbar">
    <a href="Main.jsp">Home</a>
    <a href="Technicians.jsp">Technicians</a>
    <a href="Service.jsp">Field Services</a>
    <a href="Contracts.jsp">Contracts</a>
    <a href="Ratings.jsp">Ratings</a>
</div>

<div class="container">
    <!-- Left section with Client Information and Active Contracts -->
    <div class="left-section">
        <!-- Client information section with a table and action buttons -->
        <div class="client-info">
            <h2>Technician Information</h2>
            <table>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>John Doe</td>
                    <td>john@example.com</td>
                    <td>123-456-7890</td>
                    <td>
                        <button class="button" onclick="updateClient()">Update</button>
                        <button class="button" onclick="deleteClient()">Delete</button>
                    </td>
                </tr>
                <!-- More rows can be added dynamically -->
                </tbody>
            </table>
            <button class="button" onclick="addClient()">Add New Client</button>
        </div>

        <!-- Active contracts section with a table -->
        <div class="contracts-section">
            <h2>Active Contracts</h2>
            <table>
                <thead>
                <tr>
                    <th>Contract ID</th>
                    <th>Client Name</th>
                    <th>Expiration Date</th>
                    <th>Status</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>C123</td>
                    <td>John Doe</td>
                    <td>2024-12-31</td>
                    <td>Active</td>
                </tr>
                <!-- More rows can be added dynamically -->
                </tbody>
            </table>
        </div>
    </div>

    <!-- Right section for To-Do List -->
    <div class="notes-section">
        <h2>To-Do List</h2>
        <ul id="toDoList">
            <li>
                <input type="text" placeholder="Enter new task..." id="newTaskInput">
                <button class="add-btn" onclick="addTask()">+</button>
            </li>
        </ul>
    </div>
</div>

<div class="footer">
    <p>&copy; 2024 ApexCare Solutions - All rights reserved</p>
</div>

<script>

    document.getElementById().addEventListener()

    function addClient() {
        alert("Add new client functionality");
    }

    function updateClient() {
        alert("Update client functionality");
    }

    function deleteClient() {
        alert("Delete client functionality");
    }

    function addTask() {
        var taskInput = document.getElementById("newTaskInput");
        var taskText = taskInput.value.trim();
        if (taskText) {
            var listItem = document.createElement("li");
            listItem.innerHTML = taskText + '<button class="remove-btn" onclick="removeTask(this)">-</button>';
            document.getElementById("toDoList").appendChild(listItem);
            taskInput.value = ""; // Clear input after adding
        }
    }

    function removeTask(element) {
        element.parentElement.remove();
    }
</script>
</body>
</html>
