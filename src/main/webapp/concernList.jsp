<%@ page import="java.util.List" %>
<%@ page import="com.example.po.UserPo" %>
<%@ page import="com.example.Dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: 31749
  Date: 2023/6/29
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .top-nav {
            height: 50px;
            width: auto;
            margin: 10px;
            background-color: darkblue;
        }

        .concern-item {
            width: auto;
            margin: 10px;
            height: 60px;
            display: flex;
            background-color: rosybrown;
        }

        .header-img {
            width: 40px;
            height: 40px;
            margin: 10px;
            background-color: cadetblue;
        }

        .head-img {
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>
<div class="main">
    <div class="top-nav"></div>
    <%
        UserPo user = (UserPo) session.getAttribute("user");
        List<UserPo> concernList = (List<UserPo>) session.getAttribute("userList");
        if (concernList != null) {
            for (UserPo concern : concernList) {
    %>
    <div class="concern-item">
        <div class="header-img">
            <img src="<%=UserDao.queryUserImg(concern.getUserId())%>" alt="" class="head-img">
        </div>
        <div class="text">
            <span class="user-name"><%=concern.getUserName()%></span><br>
            <span>介绍</span>
        </div>
        <div class="">
            <form action="#" method="post">
                <input name="user" value="<%=user.getUserId()%>" style="display: none">
                <input name="concern" value="<%=concern.getUserId()%>" style="display: none">
                <button onclick="this.form.action='deleteConcern';this.form.submit();">取消关注</button>
            </form>
        </div>
    </div>
    <%
        }
    } else {
    %>
    <div class="none-box">
        <span>暂无关注的人，去发现更多的人吧</span>
    </div>
    <%
        }
    %>
</div>


</body>
</html>
