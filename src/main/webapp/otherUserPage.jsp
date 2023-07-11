<%@ page import="java.util.List" %>
<%@ page import="com.example.po.weiboPo" %>
<%@ page import="com.example.po.UserPo" %><%--
  Created by IntelliJ IDEA.
  User: 31749
  Date: 2023/7/3
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
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

        .weibo .weibo-item {
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

        .img-item {
            width: 100px;
            height: 100px;
            object-fit: cover;
            border: 1px solid #999;
        }
    </style>
</head>
<body>
<%
    UserPo user = (UserPo) session.getAttribute("user");
    List<weiboPo> weiboList = (List<weiboPo>) session.getAttribute("weiboList");
%>
<div class="app">
    <div class="main">
        <div class="nav">
            <h2><%=weiboList.get(0).getUsername()%>的空间</h2>
        </div>
        <div class="weibo">
            <%
                for (weiboPo weibo : weiboList) {
            %>
            <div class="weibo-item">
                <div class="head">
                    <form action="#" method="post">
                        <div class="header-img">
                            <img src="<%=weibo.getUserImage()%>" alt="" class="head-img"><span
                                class="userName"><%=weibo.getUsername()%></span>
                        </div>
                        <div class="add-concern">
                            <button onclick="this.form.action='addConcern'; this.form.submit();"><span>添加关注</span>
                            </button>
                        </div>
                    </form>

                </div>
                <div class="body">
                    <span style="margin: 10px"><%=weibo.getContent()%></span>

                    <%
                        if (weibo.getImages().size() != 0) {
                    %>
                    <div class="img-box">
                        <% for (String url : weibo.getImages()) {
                        %>

                        <img src="<%=url%>" alt="" class="img-item">

                        <%
                            }
                        %></div>
                    <%
                        }
                    %>

                </div>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>
</body>
</html>