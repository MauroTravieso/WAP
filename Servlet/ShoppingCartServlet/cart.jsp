<%--
  Created by IntelliJ IDEA.
  User: mauro
  Date: 6/16/2019
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="checkout" method="get">
    <h1>Shopping Cart!</h1>
    <div>
        <span>Product 1</span> <input type="hidden" name="p1name" /><br/>
        <span>Price:</span><input type="text" name="p1price" value="12.5" readonly /><br/>
        <span>Quantity</span><input type="text" name="p1qty" value="0"><br/>
    </div>
    <div>
        <span>Product 2</span><input type="hidden" name="p2name" /><br/>
        <span>Price:</span><input type="text" name="p2price" value="15.3" readonly /><br/>
        <span>Quantity</span><input type="text" name="p2qty" value="0"><br/>
    </div>
    <div>
        <span>Product 3</span><input type="hidden" name="p3name" /><br/>
        <span>Price:</span><input type="text" name="p3price" value="10" readonly /><br/>
        <span>Quantity</span><input type="text" name="p3qty" value="0"><br/>
    </div>

    <input type="submit" value="Checkout" name="act"/>
    <!--
    UserName: <input type="text" name="uname"/><br/>
    Password: <input type="password" name="upassword"><br/>
    Remember me <input type="checkbox" name="uremember"><br/>
    <input type="submit" value="Login" name="act"/>
    <input type="submit" value="Guest" name="act"/>
    -->
</form>



</body>
</html>
