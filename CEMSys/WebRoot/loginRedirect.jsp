<%--
  Created by IntelliJ IDEA.
  User: RayHauton
  Date: 2017/1/29
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Title</title>
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<style type="text/css">
.content {
	width: 500px;
	height: 300px;
	border: 1px solid #1296DB;
	border-radius: 10px;
	margin: 60px auto;
	font-family: 微软雅黑;
}
a{
	color: #1296DB;
}
a:HOVER {
	color: lightgreen;
}
a:VISITED {
	color: #1296DB;
}
</style>
</head>
<body>
	<div class="content">
		<div style="float: left;margin-top: 100px;width: 50px;height: 50px;margin-left: 20px;">
			<img alt="" src="${pageContext.request.contextPath }/img/info1.png" style="width: 50px;height: 50px;">
		</div>
		<div style="float: left;">
			<h4 style="margin-top: 100px;margin-left: 10px;">
				您尚未登录本系统，<a
					href="${pageContext.request.contextPath }/login/login.jsp"
					target="_blank">点击此处</a>可以进行登录
			</h4>
			<h4 style="margin-left: 10px;">
				如果您还没有注册账号，<a
					href="${pageContext.request.contextPath }/login/register.jsp"
					target="_blank">点击此处</a>可以进行注册
			</h4>
		</div>
	</div>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</html>
