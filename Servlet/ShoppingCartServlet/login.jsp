<%--
  Created by IntelliJ IDEA.
  model.User: mauro
  Date: 6/14/2019
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart Login Page</title>
    </head>
<body>
<form action="login" method="get">
    <h1>Shopping Cart Login</h1>
    model.User: <input type="text" name="uname"/><br/>
    Password: <input type="password" name="upassword"><br/>
    Remember me <input type="checkbox"><br/>
    <input type="submit" value="Login"/>
</form>
</body>
</html>
