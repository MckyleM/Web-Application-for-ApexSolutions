
<%-- 
    Document   : index
    Created on : 23 Oct 2024, 05:15:38
    Author     : ntuli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/indexStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1 id="header">Hello Apex Solutions!</h1>
        <hr>
       
        <form name="formlogin" action="LoginServlet" method="POST">
            <table border="0" cellpadding="5">
               
                <tbody>
                   
                    <tr>
                        <td></td>
                        <td><input type="text" name="txtusername"  size="15" placeholder="Username" required/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="password" name="txtpassword"  size="15" placeholder="Password" required/></td>
                    </tr>
                    <tr>
                        <td width="15px"></td>
                        <td> <input type="submit" value="Login" name="btnsubmit" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>

            
            
            
           
            
        </form>
        
        <table border="0" cellpadding="5">
            <tbody>
               <tr>
                    <td></td>
                    <td> <a href="SignUp.jsp" class="button"><input type="submit" value="sign up" name="btnsignup" /></a>
                        </td>
                </tr> 
            </tbody>
            
           
        </table>
        
        
    </body>
</html>