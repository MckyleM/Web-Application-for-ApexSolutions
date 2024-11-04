<%--
  Created by IntelliJ IDEA.
  User: ntuli
  Date: 2024/11/04
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*, java.util.*, your.package.name.Contract_Manager" %> <!-- Replace 'your.package.name' with the actual package name -->
<!DOCTYPE html>
<html>
<head>
    <title>Contract Manager Information</title>
</head>
<body>
    <h1>Contract Information</h1>

    <%
        // Get client ID from request parameter or use a default
        int clientId = request.getParameter("clientId") != null ? Integer.parseInt(request.getParameter("clientId")) : 1;

        // Create an instance of Contract_Manager and retrieve contract information
        Contract_Manager contractManager = new Contract_Manager();
        Contract_Manager contract = contractManager.getContract(clientId);

        if (contract != null) {
    %>
            <table border="1">
                <tr>
                    <th>Contract ID</th>
                    <td><%= contract.getContractID() %></td>
                </tr>
                <tr>
                    <th>Client ID</th>
                    <td><%= clientId %></td>
                </tr>
                <tr>
                    <th>Start Date</th>
                    <td><%= contract.startDate %></td>
                </tr>
                <tr>
                    <th>End Date</th>
                    <td><%= contract.endDate %></td>
                </tr>
                <tr>
                    <th>Status</th>
                    <td><%= contract.trackContract() %></td>
                </tr>
            </table>
    <%
        } else {
    %>
            <p>No contract information available for the provided client ID.</p>
    <%
        }
    %>
</body>
</html>
