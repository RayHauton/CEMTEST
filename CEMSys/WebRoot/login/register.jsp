<%--
  Created by IntelliJ IDEA.
  User: RayHauton
  Date: 2017/1/26
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>校友信息系统用户注册</title>
    <link rel="stylesheet" href="../css/login/register.css"/>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
</head>
<body>
<div class="topSection">
    <div class="log">
        <img src="../img/cemLog.png"/>
    </div>
    <div class="title">
        <span class="school">南航经济与管理学院</span>
        <span class="system">校友信息系统</span>
    </div>
</div>
<div class="registerHead">
    <span>欢迎注册南航经济与管理学院校友信息系统！&nbsp;</span>
    <span><strong>《请根据提示正确且完整地填写以下信息，以便于通过审核。》</strong></span>
</div>
<div class="registerBody">
    <form class="form-horizontal" id="regisForm">
        <div class="formSection1">
            <div class="input-group" style="margin-top: 10px;">
                <div class="input-group-addon">用户名</div>
                <input type="text" name="userId" class="form-control ">
            </div>
            <div class="warning">

            </div>
            <div class="input-group">
                <div class="input-group-addon">姓&nbsp;&nbsp;&nbsp;&nbsp;名</div>
                <input type="text" name="truename" class="form-control ">
            </div>
            <div class="warning">

            </div>
            <div class="input-group">
                <div class="input-group-addon">密&nbsp;&nbsp;&nbsp;&nbsp;码</div>
                <input type="text" name="password" class="form-control">
            </div>
            <div class="warning">

            </div>
            <div class="input-group">
                <div class="input-group-addon">确认密码</div>
                <input type="text" name="confirmPassword" class="form-control" style="width: 236px;">
            </div>
            <div class="warning">

            </div>
            <div class="input-group">
                <div class="input-group-addon">手&nbsp;&nbsp;&nbsp;&nbsp;机</div>
                <input type="text" name="mobile" class="form-control">
            </div>
            <div class="warning">

            </div>
            <div class="input-group">
                <div class="input-group-addon">邮&nbsp;&nbsp;&nbsp;&nbsp;箱</div>
                <input type="text" name="email" class="form-control ">
            </div>
            <div class="warning">

            </div>
            <%--<div class="validationInfo">--%>
                <%--<div class="comment">--%>
                   <%--<span style="margin-top: 10px;display: block;">--%>
                       <%--&nbsp;&nbsp;注册错误<br>--%>
                        <%--&nbsp;&nbsp;信息提示--%>
                   <%--</span>--%>
                <%--</div>--%>
                <%--<div class="errorInfo">--%>
                    <%--傻逼，有错误 你赶紧检查检查--%>
                <%--</div>--%>
            <%--</div>--%>
        </div>

        <div class="formSection2">
            <div class="input-group" style="margin-top: 10px;">
                <div class="input-group-addon">入学年份</div>
                <input type="month" name="admit" class="form-control" style="width: 236px;">
            </div>
            <div class="warning">

            </div>
            <div class="input-group">
                <div class="input-group-addon">学&nbsp;&nbsp;&nbsp;&nbsp;号</div>
                <input type="text" name="studNumber" class="form-control" placeholder="选填">
            </div>
            <div class="warning">

            </div>
            <div class="input-group">
                <div class="input-group-addon">学&nbsp;&nbsp;&nbsp;&nbsp;历</div>
                <select class="form-control" style="width: 250px;">
                    <option value="1">本科</option>
                    <option value="2">硕士</option>
                    <option value="3">博士</option>
                </select>
            </div>
            <div class="warning">

            </div>
            <div class="input-group">
                <div class="input-group-addon">专&nbsp;&nbsp;&nbsp;&nbsp;业</div>
                <select class="form-control" style="width: 250px;">
                    <optgroup>
                        <option value="1">工商</option>
                        <option value="2">会计</option>
                        <option value="3">金融</option>
                    </optgroup>
                    <optgroup>
                        <option value="1">工商</option>
                        <option value="2">会计</option>
                        <option value="3">金融</option>
                    </optgroup>
                    <optgroup>
                        <option value="1">工商</option>
                        <option value="2">会计</option>
                        <option value="3">金融</option>
                    </optgroup>
                </select>
            </div>
            <div class="warning">

            </div>
            <div class="input-group">
                <button type="button" value="" class="btn btn-success btn-set">提交</button>
            </div>
            <div class="warning">

            </div>
            <div class="input-group">
                <button type="reset" value="" class="btn btn-info btn-set">重置</button>
            </div>
        </div>
    </form>
</div>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</html>
