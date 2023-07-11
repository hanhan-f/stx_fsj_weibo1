<%@ page import="com.example.po.UserPo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: 31749
  Date: 2023/7/9
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .app {
            min-height: 100%;
            width: 100%;
        }

        .main {
            min-height: 100%;
            width: auto;
            margin-left: 10px;
            margin-right: 10px;
            margin-top: 10px;
        }

        .nav {
            width: auto;
            height: 50px;
            background-color: bisque;
        }

        .weibo .concern-item {
            display: block;
            margin: 20px;
            background-color: bisque;
            min-height: 100px;
            width: auto;
        }

        .head {
            width: 100%;
            height: 40px;
            display: flex;
            align-items: center;
            padding-top: 10px;
        }

        .head form {
            width: 100%;
            height: 100%;
            display: flex;
            flex-direction: row;
            align-items: center;
            justify-content: space-between;
            padding-right: 20px;
        }


        .body {
            margin-bottom: 20px;
        }

        .img-box {
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
        }

        .head-img {
            width: 40px;
            height: 40px;
            margin-left: 10px;

        }

        .header-img {
            display: flex;
            flex-direction: row;
        }

        .userName {
            margin-top: 10px;
            margin-left: 10px;
        }

    </style>
</head>
<body>
<%
    UserPo user = (UserPo) session.getAttribute("user");
    List<UserPo> findConcernList = (List<UserPo>) session.getAttribute("findConcernList");

%>
<div class="app">
    <div class="main">
        <div class="nav"></div>
        <div class="weibo">
            <%
                if (findConcernList != null) {
                    for (UserPo concern : findConcernList) {
            %>
            <div class="concern-item">
                <div class="head">
                    <form action="#" method="post">
                        <div class="header-img">
                            <%--点击打开用户主页--%>
                            <%
                                if (user != null) {
                            %>
                            <input name="user" value="<%=user.getUserId()%>" style="display: none">
                            <%}%>
                            <input name="concern" value="<%=concern.getUserId()%>" style="display: none">
                            <button onclick="this.form.action='otherUserPage'; this.form.submit();"
                                    style="background-color:transparent; border: none">
                                <img src="<%=UserDao.queryUserImg(concern.getUserId())%>" class="head-img"
                                >
                            </button>
                            <span
                                    class="userName"><%=concern.getUserName()%></span>
                        </div>
                        <div class="add-concern">
                            <button onclick="this.form.action='addConcern'; this.form.submit();"><span>添加关注</span>
                            </button>
                        </div>
                    </form>

                </div>
                <div class="body">
                    <span style="margin: 10px">介绍</span>


                </div>
            </div>
            <%
                    }
                }
            %>
        </div>
    </div>
</div>
</body>
</html>
