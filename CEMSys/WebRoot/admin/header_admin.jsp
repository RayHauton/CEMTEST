<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="header1">
	<div class="logo">
		<img src="${pageContext.request.contextPath }/img/donation/logo3.png"/>
	</div>
	<div class="comment">
		经济与管理学院校友信息管理系统
	</div>
	<div class="user">
		<c:choose>
			<c:when test="${sessionScope.user!= null }">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#" style="color:deeppink;"><img src="${pageContext.request.contextPath }/img/user.png" style="width:20px;height:20px;">
						${sessionScope.user.truename }<b class="caret"></b></a>
						<ul role="menu" class="dropdown-menu">
							<li><a href="#">修改密码</a></li>
							<li><a href="#">查看资料</a></li>
							<li><a onclick="logout('${pageContext.request.contextPath}','/logout.action','/index.jsp');">注销</a></li>
						</ul>
					</li>
				</ul>
				
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath }/login.action"
				 style="color:deeppink;margin-right: 10px;">请登录
				 <img src="${pageContext.request.contextPath }/img/mouse-pointer.png" style="width:20px;height:20px;"></a>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<div class="navBody">
	<nav role="navigation" class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
				<span class="sr-only">Toggle navigator</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a href="#" class="navbar-brand">功能导航</a>
		</div>
		<div id="navbarCollapse" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">数据管理<b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="#">校友会信息</a></li>
						<li><a href="${pageContext.request.contextPath }/collegeEvent/show_adm.action">学院事件录</a></li>
						<li><a href="#">学历管理</a></li>
						<li><a href="#">调研信息</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle fontColor1" href="#">公告管理<b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="#">新闻公告</a></li>
						<li><a href="${pageContext.request.contextPath }/donation/open_adm.action">捐款公告</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">系统管理<b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="#">论坛审核</a></li>
						<li><a href="#">祝福模板</a></li>
						<li><a href="#">用户管理</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
</div>
