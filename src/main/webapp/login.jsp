<%--
  Created by IntelliJ IDEA.
  User: 31749
  Date: 2023/6/26
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <style>

    .box {
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
    .log-box{
      width: 300px;
      height: 300px;
      padding-top: 20px;
      background-color: #c7beba;
    }
    .log-way{
      height: 40px;
      width: 270px;
      margin:0 0 -10px 15px;
      display: flex;
      flex-direction: row;
    }
    .log-check{
      color: red;
    }
    .log-item{
      width: 135px;
      height: 40px;
      padding-top: 10px;
      text-align: center;
      background-color: #b1a9a9;
    }
    .main {
      display: flex;
      justify-content: center;
      flex-wrap: wrap;
      flex-direction: row;
    }
    .input{
      width: 270px;
      height: 40px;
      margin: 10px 10px 10px 0;
      background-color: #fff;
    }
    .input input{
      width: 100%;
      height: 100%;
    }
    .agree{
      margin: 10px 10px 0 0;
      font-size: 10px;
    }
    .submit{
      margin: 10px 10px 0 0;
      height: 30px;
      width: 270px;
    }
    .submit button{
      height: 100%;
      width: 100%;
      border: none;
      background-color: #45d8f3;
    }
  </style>
</head>
<body>
<%
  Object obj = request.getAttribute("message");
  String msg = "";
  if (obj != null) {
    msg = (String) obj;
  }
%>
<div class="box">
  <div class="log-box">
    <div class="log-way">
      <div class="log-item log-check" id="0">账号登录</div>
      <div class="log-item" id="1">邮箱登录</div>
    </div>
    <form action="logById" class="form">
      <div class="main">
        <div class="input" id="input-1">
          <input  name="userid" required type="text" placeholder="请输账号/邮箱">
          <span id="mes" style="font-size: 10px;color: red;"></span>
        </div>
        <div class="input">
          <input  name="pwd" required type="password" placeholder="请输入密码">
        </div>
        <div class="agree">
          <label for="my-checkbox">
            <input type="checkbox" value="1" id="my-checkbox" class="check" name="agree">
            <span class="iconfont "></span>
          </label>
          我已同意 <a href="javascript:;">《服务条款》</a> 和 <a href="javascript:;">《服务条款》</a>
        </div>
        <div class="submit">
          <button>登录</button>
        </div>
        <h2><%=msg%></h2>
      </div>

    </form>
  </div>
</div>
<script>
  let logWay=document.querySelector(".log-way")
  let form=document.querySelector('.form')
  let agree=document.querySelector('.check')
  let userKey=document.querySelector('[name=userid]')
  let mes=document.getElementById('mes')
  let a;
  let canSubmit=true;

  logWay.addEventListener("click",function(e){
    if(document.querySelector('.log-check')!=null)
      document.querySelector('.log-check').classList.remove('log-check')
    e.target.classList.add("log-check")
    a=e.target.id
    if(e.target.id==0){
      form.action="logById"
    }else if(e.target.id==1)
      form.action='logByEmile'
    console.log(e.target.id)
  })
  form.addEventListener('submit',function(e){
    if(!agree.checked){
      e.preventDefault();
      alert('请勾选用户协议')
    }else if(!canSubmit){
      e.preventDefault();
    }
  })

  userKey.addEventListener('change',function (){
    if(a==0){
      const reg=/\D+/
      if(reg.test(userKey.value)){
        mes.innerHTML='id输入不合法'
        canSubmit=false
      }else {
        mes.innerHTML=''
        canSubmit=true
      }
    }
  })

</script>
</body>
</html>
