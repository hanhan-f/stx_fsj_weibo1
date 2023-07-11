<%@ page import="com.example.Dao.UserDao" %>
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
    <title>Title</title>
    <style>
        .app {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.5);
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .new-user-box {
            width: 300px;
            height: 500px;
            padding-top: 20px;
            padding-left: 20px;
            background-color: #E26237;
        }

        .input {
            width: 280px;
            height: 70px;
        }

        .input input {
            width: 100%;
            height: 40px;
        }

        .input span {
            margin-top: 0;
            height: 20px;
            font-size: 8px;
        }

        .submit {
            margin-top: 20px;
        }

        .input button {
            width: 100%;
            height: 40px;
        }

        .agree {
            font-size: 10px;
        }

    </style>
</head>
<body>
<%
    Object name_error = request.getAttribute("name_error");
    Object phone_error = request.getAttribute("phone_error");
    Object emile_error = request.getAttribute("emile_error");
    String name="";
    String phone="";
    String emile="";
    if(name_error!=null){
        name=(String) name_error;
    }
    if(phone_error!=null){
        phone=(String) phone_error;
    }
    if(emile_error!=null){
        emile=(String) emile_error;
    }
%>
<div class="app">
    <div class="new-user-box">
        <form action="newUser" name="form">
            <div class="main">
                <div class="userName input">
                    <input required type="text" placeholder="请输入用户名" name="userName">
                    <span><%=name%></span>
                </div>
                <div class="phone input">
                    <input required type="text" placeholder="请输入手机号" name="phone">
                    <span><%=phone%></span>
                </div>
                <div class="password input">
                    <input required type="password" placeholder="请输入密码(设置6至20位字母、数字和符号组合)"
                           name="password">
                    <span></span>
                </div>
                <div class="repassword input">
                    <input required type="password" placeholder="请再次输入密码" name="rpassword">
                    <span></span>
                </div>
                <div class="emile input">
                    <input required type="text" placeholder="请输入你的邮箱" name="emile">
                    <span><%=emile%></span>
                </div>
                <div class="agree">
                    <label for="my-checkbox">
                        <input type="checkbox" value="1" id="my-checkbox" class="check" name="agree">
                        <span class="iconfont "></span>
                    </label>
                    我已同意 <a href="javascript:;">《服务条款》</a> 和 <a href="javascript:;">《服务条款》</a>
                </div>
                <div class="submit input">
                    <button name="submit">注册</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    let userName = document.querySelector('[name=userName]')
    let phone = document.querySelector('[name=phone]')
    let password = document.querySelector('[name=password]')
    let rpassword = document.querySelector('[name=rpassword]')
    let emile = document.querySelector('[name=emile]')
    let agree = document.querySelector('[name=agree]')
    let submit = document.querySelector('[name=submit]')
    let form = document.querySelector('[name=form]')

    userName.addEventListener('change', function () {

    })

    function checkName() {
    }

    phone.addEventListener('change', checkPhone)

    function checkPhone() {
        const span = phone.nextElementSibling
        const reg = /\d{3}\d{8}|\d{4}\{7,8}/   //电话号码
        console.log(reg.test(phone.value))
        if (!reg.test(phone.value)) {
            span.innerHTML = '电话号码输入不合法'
            return false
        } else {
            span.innerHTML = ''
            return true
        }
    }

    password.addEventListener('change', checkPassword)

    function checkPassword() {
        const span = password.nextElementSibling
        const reg = /^[\w\W]{6,20}$/   //6至20位字母、数字和符号组合
        console.log(reg.test(password.value))
        if (!reg.test(password.value)) {
            span.innerHTML = '设置6至20位字母、数字和符号组合'
            return false
        } else {
            span.innerHTML = ''
            return true
        }
    }

    rpassword.addEventListener('change', checkRpassword)

    function checkRpassword() {
        const span = rpassword.nextElementSibling
        if (password.value != rpassword.value) {
            span.innerHTML = '两次密码输入不一致'
            return false
        } else {
            span.innerHTML = ''
            return true
        }
    }

    emile.addEventListener('change', checkEmile)

    function checkEmile() {
        const span = emile.nextElementSibling
        const reg = /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/
        if (!reg.test(emile.value)) {
            span.innerHTML = '邮箱输入不合法'
            return false
        } else {
            span.innerHTML = ''
            return true
        }
    }

    form.addEventListener('submit', function (e) {
        if (!agree.checked) {
            e.preventDefault();
            alert('请勾选用户协议')
        } else if (!checkPhone() || !checkRpassword() || !checkRpassword() || !checkEmile()) {
            e.preventDefault();
        }
    })
</script>
</body>
</html>