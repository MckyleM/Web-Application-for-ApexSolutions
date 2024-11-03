<%-- 
    Document   : SignUp
    Created on : 31 Oct 2024, 13:06:53
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
        <form name="formSignup" action="SignupServlet">
            <table border="0" cellpadding="5">
                
                <tbody>
                    <tr>
                        <td></td>
                        <td><input type="email" name="txtemail"  size="15" placeholder="user@email.com"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="text" name="txtusername"  size="15" placeholder="Username"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="password" name="txtpassword"  size="15" placeholder="Password"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="password" name="txtpassword2"  size="15" placeholder="Retype Password"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="sign up" name="btnsignup" /></td>
                    </tr>
                </tbody>
            </table>


        </form>
    </body>
</html>
