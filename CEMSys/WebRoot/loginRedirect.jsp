<%--
  Created by IntelliJ IDEA.
  User: RayHauton
  Date: 2017/1/29
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <!-- 登录拦截器中使用response会有问题，只能使用request进行转发，只能新建一个页面作为中转； -->
    <script type="text/javascript">
//         window.onload=function(){
//             if('${requestScope.toLogin}'=='toLogin'){
//                 if (window.confirm("您尚未登录本系统，是否现在登录？")) {
//                     window.open("${pageContext.request.contextPath}/login/login.jsp","_blank");
//                 }
//             }
//         }
    </script>
</head>
<body>
	<h2>您尚未登录本系统，<a href="${pageContext.request.contextPath }/login/login.jsp" target="_blank">点击此处</a>可以进行登录</h2>
	<h2>如果您还没有注册账号，<a href="${pageContext.request.contextPath }/login/register.jsp" target="_blank">点击此处</a>可以进行注册</h2>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</html>
