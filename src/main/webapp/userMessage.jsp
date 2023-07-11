<%@ page import="com.example.po.UserPo" %>
<%@ page import="com.example.Dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: 31749
  Date: 2023/7/5
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>选择本地图片</title>
    <script type="text/javascript">
        function showImage(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    var imgElement = document.querySelector(".view")
                    imgElement.src = e.target.result;
                    imgElement.style.maxWidth = "100px";
                }

                reader.readAsDataURL(input.files[0]);
            }
        }
    </script>
    <style>
        .view{
            width: 100px;
        }
    </style>
</head>

<body>
<%
    UserPo user = (UserPo) session.getAttribute("user");
%>
<h2>个人信息：</h2>
<form action="changeUser" enctype="multipart/form-data" method="post">
    <div>
        <div id="preview">
            <img src="<%=UserDao.queryUserImg(user.getUserId())%>" alt="" class="view">
        </div>
        <input type="file" onchange="showImage(this)" accept="image/*" name="img">
    </div>
    <div>
        <input type="text" value="<%=user.getUserId()%>" name="userId" style="display: none">
        <input type="text" value="<%=user.getUserName()%>" name="userName">
    </div>
    <div><input type="text" value="<%=user.getEmile()%>" name="emile"></div>
    <div><input type="text" value="<%=user.getPhone()%>" name="phone"></div>
    <div><input type="password" value="<%=user.getPwd()%>" name="pwd"></div>
    <div><input type="submit" value="修改"></div>
</form>


</body>
</html>
