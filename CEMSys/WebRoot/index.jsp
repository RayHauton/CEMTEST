<%--
  Created by IntelliJ IDEA.
  User: RayHauton
  Date: 2016/12/6
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1">
  <title>校友信息系统</title>
  <link rel="stylesheet" href="css/view_set/base.css">
  <link rel="stylesheet" href="css/view_set/style.css">
  <script src="js/loginController/loginAndLogout.js"></script>
</head>
  <body>
  <div class="box">
    <!--index head-->
    <div class="head">
      <div class="logo">
        <a href="${pageContext.request.contextPath}/index.jsp">
          <img src="img/cemLog.png" alt="南京航空航天大学">
        </a>
      </div>
      <div class="nav">
        <button id="nav-btn">菜单</button>
        <ul id="nav-list">
          <li>
            <a href="${pageContext.request.contextPath}/infoSys/open.action" target="iframe">信息系统</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/surveySys/open.action" target="iframe">调研系统</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/baseView/schoolmate.jsp" target="_blank">校友工作</a>
          </li>
          <li>
            <a href="javascript:void(0);">校友快讯</a>
          </li>
          <li>
            <a href="baseView/BBS.jsp" target="_blank">校友论坛</a>
          </li>
          <li>
            <a href="baseView/timeline.jsp" target="iframe">学院事件录</a>
          </li>
        </ul>
      </div>
      <div class="login">
        <c:choose>
          <c:when test="${sessionScope.user!=null}">
            <a onclick="logout('${pageContext.request.contextPath}','/logout.action','/index.jsp');"
               style="cursor: pointer;">注销</a>&nbsp;&nbsp;&nbsp;
            <a id="loginUp">欢迎您：${sessionScope.user.username}</a>
          </c:when>
          <c:otherwise>
            <a href="login/login.jsp" id="loginUp">请登录</a>
          </c:otherwise>
        </c:choose>
      </div>
    </div>
    <div class="container">
      <iframe src="baseView/start.html" id="iframe" name="iframe" frameborder="0"></iframe>
    </div>
    <!-- index foot -->
    <div class="foot">
      <div class="link">
        <span>友情链接：</span>
        <div class="link-a">
          <a href="javascript:void(0);">南航主页</a>
          <a href="javascript:void(0);">南航教务处</a>
          <a href="javascript:void(0);">南航经管院</a>
          <a href="javascript:void(0);">南航政教处</a>
          <a href="javascript:void(0);">南航信息中心</a>
        </div>
      </div>
      <div class="share">
        <span>联系我们：</span>
        <ul>
          <li>微信：<a href="javascript:void(0);">**********</a></li>
          <li>QQ：<a href="javascript:void(0);">**********</a></li>
          <li>微博：<a href="javascript:void(0);">**********</a></li>
        </ul>
      </div>
      <div class="information">
        <p>Copyright © 2004 Alumni information system of Nuaa Incorporated. All rights reserved.</p>
      </div>
    </div>
  </div>
  <script src="js/manu.js"></script>
  <script src="js/jquery-1.9.min.js"></script>
  <script>
    manu("nav-btn","bg-box");
  </script>
  </body>
</html>
