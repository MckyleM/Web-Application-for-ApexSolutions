    <head>
        <title>Main Page</title>
        <link href="css/main2Style.css" rel="stylesheet" type="text/css"/>
    </head>
    
    <body>
       
       
        <%
            
            
            String username = (String) session.getAttribute("username");;
         
            
            if (username == "" || username == null) {
                   username = "Main"; 
                } 
        %>
        <header>
            <h1>ApexCares Solutions</h1>
            <nav>
                <a href="Main.jsp">Home</a>
                <a href="Clients.jsp">Client</a>
                <a href="Service.jsp">Service Desk</a>
                <a href="Contracts.jsp">Contracts</a>
                <a href="Contact.jsp">Contact Us</a>
            </nav>
        </header>
        <div>
            <h2>Welcome to ApexCare Solutions <%=username%></h2>
            <p>Your trusted partner in comprhensive care solutions. providing client management, real-time incident reporting, and seamless contract management services.</p>
        </div>

        <a href="index.jsp"><input type="submit" value="Log out" name="btnlogout" action="index.jsp"/></a>
        
    <footer><p>&copy; 2024 ApexCare Solutions - All rights reserved</p></footer>
    </body>