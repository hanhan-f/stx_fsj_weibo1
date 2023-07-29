<%@ page import="com.example.po.UserPo" %>

<%--
  Created by IntelliJ IDEA.
  User: 31749
  Date: 2023/6/26
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>微博</title>
    <style>

        /*清除所有系统缩进*/
        * {
            margin: 0;
            padding: 0;
        }

        /*设置主页面最小高度*/
        .app {
            min-height: 100%;
        }

        a {
            text-align: center;
            text-decoration: none;
            width: auto;
            height: auto;
        }

        .total-box {
            min-height: 100%;
            height: 100%;
            background-color: #e5e0e0;
        }

        /*设置顶部导航框*/
        .total-box-top {
            height: 300px;
            width: 100%;
            background-color: #fff;
        }

        .top-nav-main {
            width: auto;
            height: 100%;
        }

        .top-nav-main .video-log{
            position: absolute;
            top:20px;
            right: 20px;
        }
        .top-nav-main .search{
            position: absolute;
            top:125px;
            left: 25%;
            width: 50%;
            height: 50px;
            background-color: #fff;

        }

        /*顶部导航框子级盒子布局，flex固定位置布局，并为下一级盒子设置自动定位，默认不显示*/
        .top-nav-login {
            height: 50px;
            width: 100%;
            background-color: #fff;
            position: fixed;
            top: -50px;
            /*opacity: 0;!*是否显示*!*/
            display: flex;
            justify-content: space-between;
            align-items: center;
            transition: top 0.5s, left 0.5s;
        }

        .top-nav-login .child:nth-child(1) {
            margin-left: auto;
        }

        .top-nav-login .child:nth-child(2) {
            margin-left: auto;
        }

        .top-nav-login .child:nth-child(3) {
            margin-right: auto;
        }

        /*div盒子login三个子级盒子设置*/
        .login-left {
            height: 100%;
            width: 150px;
            background-color: transparent;
        }

        .login-center {
            height: 100%;
            width: 300px;
            background-color: transparent;
        }

        .login-right {
            height: 100%;
            width: 200px;
            display: flex;
            flex-direction: row;
            background-color: transparent;
        }

        .login-left .top-nav {
            height: 100%;
            display: flex;
            align-items: center;
        }

        /*对下部主盒子设置布局方式，水平居中*/
        .total-box-main-down {
            display: flex;
            justify-content: center;
        }

        /*顶部导航中心布局*/
        .login-item {
            height: 100%;
            display: flex;
            flex-direction: row;
            align-items: center;
        }

        .top-navi-tem {
            padding-top: 8px;
            padding-left: 10px;
            list-style: none;
            margin: auto;
            width: auto;
            height: 100%;
            justify-content: center;
        }

        .user {
            width: 70px;
        }

        /*登录注册按钮*/
        .user-login {

        }

        .user-new {

        }

        /*设置下端盒子内部布局方式，行内布局*/
        .total-box-down {
            display: flex;
            flex-direction: row;
            width: auto;
            height: auto;
        }

        .list-item {
            list-style: none;
        }

        .side {
            position: sticky;
            top: 60px
        }

        .total-box-down div {
            /*display: block;*/

        }

        .down-LeftPane {
            width: 182px;
            height: 1730px;
            background-color: #fff;
        }

        .down-RightPane {
            width: 842px;
            height: auto;
            display: flex;
            flex-direction: row;
        }

        .down-RightPane .RightPane-main {
            min-width: 600px;
            width: 100%;
            height: 100%;
            background-color: #fff;
        }

        .down-RightPane .RightPane-SideBox {
            width: 200px;
            height: auto;
        }

        .frame {
            width: 100%;
            height: 100%;
        }
        .overlay {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.5);
            display: flex;
            justify-content: center;
            align-items: center;
            display: none;
        }

        .modal {
            background: #fff;
            width: 500px;
            min-height: 300px;
            padding: 20px;
            border-radius: 5px;
        }
        .message{
            margin-left: 50px;
            width: 400px;
            height: 100px;
        }
        .image-box  {
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
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
%>
<div class="app">
    <div class="total-box">
        <div class="total-box-top">
            <div class="top-nav-login">
                <div class="login-left">
                    <ul class="top-nav">
                        <li><img src="images/favicon.ico" alt=""></li>
                        <li><input type="text"></li>
                    </ul>
                </div>
                <div class="login-center">
                    <ul class="login-item">
                        <li class="top-navi-tem"><a href="index"><img src="images/home.png" alt="首页"></a></li>
                        <li class="top-navi-tem"><a href="javascript:;"><img src="images/video.png" alt="视频"></a></li>
                        <li class="top-navi-tem"><a href="javascript:;"><img src="images/hot.png" alt="热点"></a></li>
                        <li class="top-navi-tem"><a href="javascript:;"><img src="images/message.png" alt="消息"></a>
                        </li>
                        <li class="top-navi-tem"><a href="userMessage" target="Right-main"><img src="images/personal.png"
                                                                             alt="个人主页"></a></li>
                    </ul>
                </div>
                <div class="login-right">
                    <%
                        if (user != null) {
                    %>
                    <ul class="login-item">
                        <li class="top-navi-tem"><a href="MyPage"><span class="user-login">个人主页</span></a></li>
                        <li class="top-navi-tem"><a href="logout"><span class="user-new">退出登录</span></a></li>
                        <li class="top-navi-tem"><button onclick="showModal()"><img src="images/write.png" alt="写微博"></button></li>
                    </ul>
                    <%
                    } else {
                    %>
                    <ul class="login-item">
                        <li class="top-navi-tem"><a href="login.jsp"><span class="user-login">登录</span></a></li>
                        <li class="top-navi-tem"><a href="CreatNewUser.jsp"><span class="user-new">注册</span></a></li>
                        <li class="top-navi-tem"><button onclick="showModal()"><img src="images/write.png" alt="写微博"></button></li>
                    </ul>
                    <%
                        }
                    %>
                </div>
            </div>
            <div class="top-nav-main">
                <video src="images/weibo_login.mp4" width="100%" height="100%" loop="loop" autoplay="autoplay" muted="muted"
                       class="video"></video>
                <div class="login-right video-log">
                    <%
                        if (user != null) {
                    %>
                    <ul class="login-item">
                        <li class="top-navi-tem user"><a href="MyPage"><span class="user-login">个人主页</span></a></li>
                        <li class="top-navi-tem user"><a href="logout"><span class="user-new">退出登录</span></a></li>
                    </ul>
                    <%
                    } else {
                    %>
                    <ul class="login-item">
                        <li class="top-navi-tem"><a href="login.jsp"><span class="user-login">登录</span></a></li>
                        <li class="top-navi-tem"><a href="CreatNewUser.jsp"><span class="user-new">注册</span></a></li>
                    </ul>
                    <%
                        }
                    %>
                </div>

                <div class="search">
                    <img src="" alt="">
                    <input type="text">

                </div>
            </div>
        </div>
        <div class="total-box-main-down">
            <div class="total-box-down">
                <div class="down-LeftPane">
                    <div class="LeftPane-side side">
                        <ul>
                            <li class="list-item"><a href="weiboList" target="Right-main">热门微博</a></li>
                            <li class="list-item"><a href="concernsWeibo" target="Right-main">关注</a></li>
                            <li class="list-item"><a href="findConcern" target="Right-main">发现更多</a></li>
                            <li class="list-item"><a href="noUserLogin.jsp:;" target="Right-main">热搜</a></li>
                            <li class="list-item"><a href="javascript:;" target="Right-main">文娱</a></li>
                            <li class="list-item"><a href="javascript:;" target="Right-main">要闻</a></li>
                        </ul>
                    </div>
                </div>
                <div class="down-RightPane">
                    <div class="RightPane-main">
                        <iframe name="Right-main" class="frame" src="weiboList"></iframe>
                    </div>
                    <div class="RightPane-SideBox"></div>
                </div>
            </div>
        </div>

    </div>

</div>
<div id="overlay" class="overlay">
    <div class="modal">
        <h2>表单</h2>
        <form action="save" enctype="multipart/form-data" method="post">
            <div>
                <textarea class="message" name="content"></textarea>
            </div>
            <div class="qq-upload">
                <input type="file" id="fileInput" name="file" multiple>
                <label for="fileInput">
                    <i class="fas fa-plus"></i> 添加图片
                </label>
            </div>
            <div class="image-box" id="img-box">
                <img src="images/home.png" alt="" class="view">
            </div>
            <div>
                <button type="submit">发布</button>
                <button type="button" onclick="hideModal()">取消</button>
            </div>
        </form>
    </div>
</div>

<script>
    (function () {
        const topNav = document.querySelector('.top-nav-login')
        const div = document.querySelector('.total-box-main-down')
        console.log(div.offsetTop)
        window.addEventListener('scroll', function () {
            const sc = document.documentElement.scrollTop
            if (sc >= div.offsetTop) {
                topNav.style.top = "0px"
            } else {
                topNav.style.top = "-50px"
            }
        })

    })();

    function showModal() {
        var overlay = document.getElementById("overlay");
        overlay.style.display = "flex";
    }

    function hideModal() {
        var overlay = document.getElementById("overlay");
        overlay.style.display = "none";
    }
    function showImage(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                var imgElement = document.querySelector(`.view`)
                imgElement.src = e.target.result;
                imgElement.style.maxWidth = "100px";
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
    let fileInput = document.getElementById("fileInput");
    let imgBox = document.getElementById("img-box");
    let selectedFiles = []; // 存储选定的文件

    fileInput.addEventListener("change", function() {
        let files = fileInput.files;

        for (let i = 0; i < files.length; i++) {
            let file = files[i];
            selectedFiles.push(file); // 将文件添加到选定的文件数组中
        }

        renderPreview(); // 渲染选定的图片预览
    });

    function renderPreview() {
        imgBox.innerHTML = ""; // 清空图片展示容器

        for (let i = 0; i < selectedFiles.length; i++) {
            let file = selectedFiles[i];
            let reader = new FileReader();

            reader.onload = function(e) {
                let imageUrl = e.target.result;
                let imageElement = document.createElement("img");
                imageElement.classList.add("img-item");
                imageElement.src = imageUrl;

                imgBox.appendChild(imageElement);
            };
            reader.readAsDataURL(file); // 读取文件内容，并将其转换为DataURL
        }
    }
</script>
</body>
</html>