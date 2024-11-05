<head>
    <title>ApexCare Solutions</title>
    <link href="css/main2Style.css" rel="stylesheet" type="text/css"/>
</head>

<body>


<%


    String username = (String) session.getAttribute("username");;


    if (username == "" || username == null) {
        username = "Main";
    }
%>
<div class="header">
    <h1> Welcome to ApexCare Solutions</h1>
</div>
<div class="navbar">
    <a href="Main.jsp">Home</a>
    <a href="Technicians.jsp">Technicians</a>
    <a href="Service.jsp">Field Services</a>
    <a href="Contracts.jsp">Contracts</a>
    <a href=".jsp">Ratings</a>
</div>
<div class="container">
    <h2>Welcome to ApexCare Solutions <%=username%></h2>
    <p>Your trusted partner in comprhensive care solutions. providing client management, real-time incident reporting, and seamless contract management services.</p>
</div>

<a href="index.jsp"><input type="submit" value="Log out" name="btnlogout" action="index.jsp"/></a>
<div class="footer">
    <p>&copy; 2024 ApexCare Solutions - All rights reserved</p>
</div>
</body>
</html>
