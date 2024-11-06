<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mycompany.sen_projectmaven.Model.Technician" %>
<%@ page import="com.mycompany.sen_projectmaven.Model.Client" %>
<%@ page import="com.mycompany.sen_projectmaven.Model.Contract_Manager" %><%--
  Created by IntelliJ IDEA.
  User: ntuli
  Date: 2024/11/04
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

%>
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
    <a href="Client Management.jsp">Client Management</a>
    <a href="Service.jsp">Field Services</a>
    <a href="Contracts.jsp">Contracts</a>
    <a href="ServiceDesk.jsp">Service Desk</a>
</div>

<div class="container">
    <div class="left-section">
        <div class="tech-info" >
            <h2>Client Information</h2>
            <table>
                <thead>
                <tr>
                    <th>ID #</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>

                <%


                    Client client = new Client();
                    List<Client> clients = new ArrayList<Client>();

                    clients = client.getAllCLients();

                    for(Client c : clients ){

                        int ID = c.getClientID();
                        String Name = c.getClientName();
                        String email = c.getEmail();


                %>
                <tr>
                    <td><%= ID %></td>
                    <td><%= Name %></td>
                    <td><%= email %></td>
                    <td>
                        <button class="button" onclick="updateClient()">Update</button>
                        <button class="button" onclick="deleteClient()">Delete</button>
                    </td>
                </tr>
                <%
                    }
                %>
                <!-- add new rows here -->

                </tbody>
            </table>
            <button class="button" onclick="addClient()">Add New Client</button>
        </div>

        <div class="contracts-section">
            <h2>Active Contracts</h2>
            <table>
                <thead>
                <tr>
                    <th>Contract ID</th>
                    <th>Service</th>
                    <th>level</th>
                    <th>Status</th>
                </tr>
                </thead>
                <tbody>
                <%

                    Contract_Manager contract = new Contract_Manager();
                    List<Contract_Manager> ContractList = new ArrayList<Contract_Manager>();

                    //ContractList = contract.getAllContracts();

                    for(Contract_Manager cm : ContractList ){

                        int ID = cm.getContractID();
                        int ClientID = cm.getCLientID();
                        String service = cm.getService();
                        String level = cm.getLevel();
                        String status = cm.getStatus();

                %>
                <tr>
                    <td><%= ID %></td>
                    <td><%= service %></td>
                    <td><%= level %></td>
                    <td><%= status %></td>
                </tr>
                <%
                    }
                %>
                <!-- to be added -->
                </tbody>
            </table>
        </div>
    </div>

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


    function populateTable(dataArray) {
        const tableBody = document.querySelector("#TechInfo tbody");

        tableBody.innerHTML = "";

        dataArray.forEach((item) => {
            const row = document.createElement("tr");

            for (const key in item) {
                const cell = document.createElement("td");
                cell.textContent = item[key];
                row.appendChild(cell);
            }

            tableBody.appendChild(row);
        });
    }

    window.onload = function (){

    populateTable()
    };

    document.getElementById().addEventListener("input", function(){

        fetch("processI")
    });

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
