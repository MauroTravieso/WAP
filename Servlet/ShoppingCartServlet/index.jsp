<%--
  Created by IntelliJ IDEA.
  model.User: mauro
  Date: 6/14/2019
  Time: 9:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Shopping Cart</title>
  </head>
  <body>
    <form action="login" method="get">
      <h1>Shopping Cart</h1>
      UserName: <input type="text" name="uname"/><br/>
      Password: <input type="password" name="upassword"><br/>
      Remember me <input type="checkbox" name="uremember"><br/>
      <input type="submit" value="Login" name="act"/>
      <input type="submit" value="Guest" name="act"/>
    </form>

    <!--
    <form action="login" method="get">
      <input type="submit" value="Guest"/>
    </form>
    -->

  </body>
</html>