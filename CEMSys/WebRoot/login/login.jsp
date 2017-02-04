<%--
  Created by IntelliJ IDEA.
  User: RayHauton
  Date: 2017/1/25
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <title>南航经管院专业学习交流平台</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/login/login.css">
    <script src="../js/loginController/loginAndLogout.js"></script>
</head>
<body>
    <div id="titleContent">
        <div class="nuaaImgDiv">
            <img alt="" src="../img/nuaa.jpg" class="img-circle">
        </div>
        <div class="title">
            <p class="h1 " style="color:#2CC42C;letter-spacing:3px;">经济与管理学院</p>
            <p class="h3" style="color:#000FFE;letter-spacing:2px;"><i>校友信息管理系统</i></p>
        </div>
    </div>
    <div id="loginFormDiv">
        <form action="" class="" id="loginInfo">
            <div class="input-group form_style_control">
                <div class="input-group-addon input-group-addon-cus label-style-control">用户名</div>
                <input type="text" id="loginMethod" name="loginMethod"
                       class="form-control input-lg" placeholder="选填用户名|手机号|邮箱|学号">
            </div>
            <div class="input-group form_style_control">
                <div class="input-group-addon input-group-addon-cus label-style-control">密&nbsp;&nbsp;&nbsp;码</div>
                <input type="password" name="password" id="password" class="form-control input-lg">
            </div>
            <div class="input-group form_style_control">
                <button type="submit" id="submitLoginInfo"
                        class="from-control btn btn-success btn-style-set"
                        onclick="login('${pageContext.request.contextPath}','/login.action','/index.jsp');return false;">确认登录</button>
            </div>
            <div class="input-group form_style_control">
                <button type="button" class="from-control btn btn-style-set btn-info" onclick="javascript:window.open('register.jsp');">注册账号</button>
            </div>
        </form>
    </div>
    <div class="end">
        <span>
            &copy;--2016南京航空航天大学经济与管理学院<br>
            信息管理与电子商务系<br>
            联系方式：2433983339@qq.com
        </span>
    </div>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script type="text/javascript">
//    $("#submitLoginInfo").click(function() {
//        $("#loginInfo").submit();
//    });
</script>
</html>
