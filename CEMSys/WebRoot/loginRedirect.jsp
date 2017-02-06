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
    <!-- 登录拦截器中使用response会有问题，只能使用request进行转发，只能新建一个页面作为中转； -->
    <script type="text/javascript">
        window.onload=function(){
            if('${requestScope.toLogin}'=='toLogin'){
                if (window.confirm("您尚未登录本系统，是否现在登录？")) {
                    window.open("${pageContext.request.contextPath}/login/login.jsp","_blank");
                }
            }
        }
    </script>
</head>
<body>
</body>
</html>
