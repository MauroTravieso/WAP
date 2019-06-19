<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: mauro
  Date: 6/17/2019
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>

<%--<%@ page import="com.mysql.cj.protocol.Resultset" %>--%>
<%--<%@ page import="java.sql.ResultSet" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="entity.Feed" %>--%>
<%--<%@ page import="java.util.Iterator" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Feeds</title>
    <link href="https://fonts.googleapis.com/css?family=Slabo+27px&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/feeds.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

<div class="topnav">
    <span id="title"><img src="images/logo.png" alt="logo"></span>
    <!--<span id="title">JustAsk!</span>-->
    <a href="logout">Logout</a>
    <a class="active" href="profile">Profile</a>
    <a href="feed">Feed</a>

</div>

<div id="category">
    <h4> Categories </h4>
    <ul id="categoryList">
        <c:forEach items="${requestScope.get('tags')}" var="tag">
            <li>
                <a href="${requestScope.getContextPath}feed?tag=${tag.getTag()}">${tag.getTag()}</a>
            </li>
        </c:forEach>
    </ul>
</div>


<div id="feedDisplayArea">
    <form action="" method="post">
        Id: <input type="text" disabled id="tbId" value="   <%= request.getAttribute("userId") %>" /> <br/>
        Name: <input type="text" id="tbName" value="    <%= request.getAttribute("userName") %>" disabled /> <br/>
        Email: <input type="text" id="tbEmail" value="  <%= request.getAttribute("userEmail") %>" disabled/> <br/>
        <br/>
        <div>
            <input type="button" value="Statistics" id="bttStats"/>&nbsp;&nbsp;&nbsp;&nbsp;
            <span id="resultStats"></span>
        </div>

        <!--<input type="hidden" id="quest" value="--><!--(((ArrayList<Question>) request.getAttribute("questions")).size()) %>" />-->
    </form>

    <br/>
    <h1 style="margin-left: 15px;">Questions posted by <%= request.getAttribute("userName") %></h1>

<%--
    <ol style="font-size: 20px;">
        <% ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions");
            for(Question q : questions){ %>
          <li>  <%= q.getTitle() %><br/> </li>
          <li>  <%= q.getCreatedAt() %><br/> </li>
          <li>  <%= q.getUpdatedAt() %><br/> </li>
        <%}%>

&lt;%&ndash;
        <c:forEach items="${questions}" var="qs">
            <li>
                <c:out value = "${qs.title}"/>
            </li>
        </c:forEach>
&ndash;%&gt;
    </ol>
--%>

    <%-- Requested --%>
    <c:if test="${requestScope.get('feeds') != null}">
        <%--<c:forEach items="${requestScope.get('feeds')}" var="feed">
        <c:forEach items="${questions}" var="qs">--%>
        <% ArrayList<Question> questionss = (ArrayList<Question>) request.getAttribute("questions");
        for(Question q : questionss){ %>
            <div class="questionAnswerDisplayArea">
                <div class="feed-content">
                    <div class="image">
                        <img src="https://api.adorable.io/avatars/48/abott@adorable" class="img img-responsive avatar"/>
                    </div>
                    <div class="q-title">
                        <h3 class="title">
                            <%--<a href="answer?id=${feed.getId()}">${feed.getTitle()}</a>
                            <a href="answer?id=${q.getId()}">${q.getTitle()}</a>
                                    <%= q.getTitle() %>--%>
                                <a href="answer?id=${q.getId()}"><%= q.getTitle() %></a>
                        </h3>
                        <ul class="list-inline">
                            <li class="list-inline-item">
                                <strong class="texteffect">Posted on:</strong> <%= q.getCreatedAt() %> <%--{q.getCreatedAt()}--%>
                            </li>
                            <%--<li class="list-inline-item">
                                <strong class="texteffect">By:</strong> <%= q.getUpdatedAt() %> &lt;%&ndash;${q.getQuestionUser()}&ndash;%&gt;
                            </li>
                            <li class="list-inline-item">
                                <strong class="texteffect">Tags:</strong> &lt;%&ndash;${q.getTags()}&ndash;%&gt;
                            </li>--%>
                        </ul>
                    </div>
                </div>
                <%--<div class="clearfix"></div>
                <div class="feed-answer">
                    <div class="image">
                        <img src="https://api.adorable.io/avatars/48/abott@adorable.png"
                             class="img img-responsive avatar"/>
                    </div>
                    <div class="q-title">
                        <h3 class="title">
                                ${q.getAnswerUser()}
                        </h3>
                        <ul class="list-inline">
                            <li class="list-inline-item">
                                <strong class="texteffect">Posted on:</strong> ${q.getCreatedAt()}
                            </li>
                        </ul>
                    </div>
                    <h3 class="answer-content">${q.getAnswer()}</h3>
                </div>
                <div class="feed-action">
                    <ul class="list-inline">
                        <li class="list-inline-item">
                            <a href="#" class="upvoteQuestion" data-id="${q.getId()}">
                                <img class="vote" src="images/upvote.png" alt="upvotebutton"></a>
                            <span class="count-upvotes">${q.getUpVotes()}</span>
                        </li>
                        <li class="list-inline-item">
                            <a href="#" class="downvoteQuestion" data-id="${q.getId()}">
                                <img class="vote" src="images/downvote.png" alt="downvotebutton">
                            </a>
                            <span class="count-downvotes">${q.getDownVotes()}</span>
                        </li>
                    </ul>
                </div>--%>
            </div>
        <%--</c:forEach>--%>
        <%}%>
    </c:if>
    <%-- Requested --%>



    <%--<form action="question" method="POST">
        <!--<textarea name="questiontitle" id="questiontitle" cols="100" rows="8" placeholder="Post your query"></textarea>-->
        <input type="text" name="questiontitle" id="questiontitle" placeholder="    Post your query">
        <input type="text" name="tags" id="tag" placeholder="   Insert tags">
        <button id="justaskbtn" type="submit">JustAsk</button>
    </form>--%>
</div>


<%--
<c:if test="${requestScope.get('feeds') != null}">
    <c:forEach items="${requestScope.get('feeds')}" var="feed">
        <div id="questionAnswerDisplayArea">
            <a href="answer?id=${feed.getId()}">
                <h3 class="title">${feed.getTitle()}</h3>
            </a>
            <!-- upvote Question -->
            <a href="#" class="upvoteQuestion" data-id = "${feed.getId()}">
                <img class="vote" src="images/upvote.png"></a>
            <span>0</span>

            <!-- downvote Question -->
            <a href="#" class="downvoteQuestion">
                <img class="vote" src="images/downvote.png"></a>
            <span>0</span>

            <h6>Posted on: ${feed.getCreatedAt()}</h6>

        </div>
    </c:forEach>
</c:if>
--%>
<%--<h1>List of feeds</h1>
<c:forEach items="${requestScope.get('feeds')}" var="feed">
<<<<<<< HEAD
<div class="row card">
    <div class="col-md-12">
        <a href="/feeds/${feed.getId()}">
            <h3>${feed.getTitle()}</h3>
        </a>
=======
    <div id="questionAnswerDisplayArea">
        <a href="${requestScope.getContextPath}/feed/${feed.getId()}">
            <h3 class="title">${feed.getTitle()}</h3>
        </a>

        <!-- upvote Question -->
        <a href="questionUpvote">
        <img class="vote" src="images/upvote.png"></a>
        <span>0</span>

        <!-- downvote Question -->
        <a href="questionDownvote">
        <img class="vote" src="images/downvote.png"></a>
        <span>0</span>

        <h6>Posted on: ${feed.getCreatedAt()}</h6>

    </div>
</c:forEach>
<%--<h1>List of feeds</h1>
<c:forEach items="${requestScope.get('feeds')}" var="feed">
<div class="row card">
    <div class="col-md-12">
        <a href="/feeds/${feed.getId()}">
            <h3>${feed.getTitle()}</h3>
        </a>
>>>>>>> 26bfb33dc5b5bbd95589e36d516be9accd5e0b0c
    </div>
</div>
</c:forEach>--%>
<%--
<script>
    window.onload = function () {

        const upvotes = document.getElementsByClassName("upvoteQuestion");

        for (let i = 0; i< upvotes.length; i++){
            upvotes[i].addEventListener("click",function (evt) {
                evt.preventDefault();
                const id = this.attributes['data-id'].value;
                fetch('upvote-question',{
                    method: 'post',
                    body: JSON.stringify({"id": id})
                }).then(function (res) {
                    console.log(res);
                })
            },false);
        }
    }
</script>
--%>

<script>
    $(document).ready(function(){
        $('#bttStats').click(function(){
            //var stats = $('#quest').val();//questions.size();
            $.ajax({
                type: 'POST',
                //data: {stats: stats},
                url: 'profile',
                success: function(result) {
                    console.log("result ", result);
                    $('#resultStats').html("Number of questions posted by the user: " + result);
                }
            });//$('.classname')
        });
    });
</script>

</body>
</html>
