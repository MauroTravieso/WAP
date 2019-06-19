<%--
  Created by IntelliJ IDEA.
  User: mauro
  Date: 6/19/2019
  Time: 6:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Ajax JSP</title>
    <script src="js/jquery-3.4.1.js" type="text/javascript"></script>

    <script>
      $(document).ready(function(){
        $('#bttHello').click(function(){
          var fullname = $('#fullname').val();
          $.ajax({
            type: 'POST',
            data: {fullname: fullname},
            url: 'AjaxController',
            success: function(result) {
              $('#result1').html(result);

            }
          });
        });
      });


    </script>

  </head>
  <body>
    <form>
      Name <input type="text" id="fullname"/>
      <input type="button" value="Hello" id="bttHello"/>
      <br/>
      <span id="result1"></span>
    </form>
  </body>
</html>
