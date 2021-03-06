﻿<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: mauro
  Date: 6/17/2019
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Feeds</title>
    <link rel="stylesheet" href="css/feeds.css">
</head>
<body>

<div class="topnav">
    <span id="title">JustAsk!</span>
    <a href="logout">Logout</a>
    <a href="profile">Profile</a>
    <a class="active" href="feed">Home</a>

</div>

<div id="category">
    Categories
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
        Id: <input type="text" disabled id="tbId" value="<%= request.getAttribute("userId") %>" /> <br/>
        Name: <input type="text" id="tbName" value="<%= request.getAttribute("userName") %>" /> <br/>
        Email: <input type="text" id="tbEmail" value="<%= request.getAttribute("userEmail") %>" /> <br/>
        <input type="submit" value="Submit"/>
    </form>

    <ul>
        <% ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions");
            for(Question q : questions){ %>
            <%= q.getTitle() %>
        <%}%>

        <c:forEach items="${questions}" var="qs">
            <li>
                <c:out value = "${qs.title}"/>
            </li>
        </c:forEach>
    </ul>

    <form action="question" method="POST">
        <!--<textarea name="questiontitle" id="questiontitle" cols="100" rows="8" placeholder="Post your query"></textarea>-->
        <input type="text" name="questiontitle" id="questiontitle" placeholder="    Post your query">
        <input type="text" name="tags" id="tag" placeholder="   Insert tags">
        <button id="justaskbtn" type="submit">JustAsk</button>
    </form>
</div>
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

</body>
</html>
