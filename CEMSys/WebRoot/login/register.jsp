<%--
  Created by IntelliJ IDEA.
  User: RayHauton
  Date: 2017/1/26
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.cem.util.BeanUtil"%>
<%@page import="com.cem.util.BaseDataUtil"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setAttribute("degreeList", new BaseDataUtil().getDegrees());
request.setAttribute("majorList", new BaseDataUtil().getMajors());
%>
<html>
<head>
    <title>校友信息系统用户注册</title>
    <link rel="stylesheet" href="../css/login/register.css"/>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
</head>
<body>
<!-- 保存url前缀 -->
<input type="hidden" value="${pageContext.request.contextPath }" id="urlPrefix"/>
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
                <input type="text" name="userId" class="form-control " id="username"
                 onblur="checkUnique('username','username','checkUsername');"/>
            </div>
            <div class="warning" id="checkUsername">

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
                <input type="text" name="mobile" class="form-control" id="mobile"
                onblur="checkUnique('mobile','mobile','checkMobile');"/>
            </div>
            <div class="warning" id="checkMobile">

            </div>
            <div class="input-group">
                <div class="input-group-addon">邮&nbsp;&nbsp;&nbsp;&nbsp;箱</div>
                <input type="text" name="email" class="form-control " id="email"
                onblur="checkUnique('email','email','checkEmail');">
            </div>
            <div class="warning" id="checkEmail">

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
                <input type="text" name="studNumber" class="form-control" placeholder="选填" id="studNum"
                 onblur="checkUnique('studNum','studNum','checkStudNum');"/>
            </div>
            <div class="warning" id="checkStudNum">

            </div>
            <div class="input-group">
                <div class="input-group-addon">学&nbsp;&nbsp;&nbsp;&nbsp;历</div>
                <select class="form-control" style="width: 250px;"  id="degreeSelect"
                 onchange="getMajorsAccordingDegree('${pageContext.request.contextPath }/chooseMajor.action');">
                	<c:forEach var="degree" items="${degreeList }">
                		<option value="${degree.degreeId }">${degree.degreeName }</option>
                	</c:forEach>
                </select>
            </div>
            <div class="warning">

            </div>
            <div class="input-group">
                <div class="input-group-addon">专&nbsp;&nbsp;&nbsp;&nbsp;业</div>
                <select class="form-control" style="width: 250px;" id="majorSection">
                	<option value="default">请选择专业</option>
                	<c:forEach var="major" items="${majorList }">
                		<option value="${major.majorId }">${major.majorName }</option>
                	</c:forEach>
                </select>
            </div>
            <div class="warning">

            </div>
            <div class="input-group">
                <button type="button" value="" class="btn btn-success btn-set" onclick="checkFormIfCouldSubmit();">提交</button>
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
<script src="../js/registerController/registerCheck.js"></script>
<script type="text/javascript">
	function test() {
		alert("succ");
	}
</script>
</html>
