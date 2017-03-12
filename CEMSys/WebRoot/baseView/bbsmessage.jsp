<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/view_set/head.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/view_set/footer.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/view_set/ihome.css">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/view_set/forum.css">
</head>
<body>
	<input type="hidden" value="${pageContext.request.contextPath }"
		id="basePath" />
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
	<div class="wholepage">
	<div class="i_home">
		<div class="i_left">
			<div class="navigation1">
				<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid">
					<div class="navbar-header">
						<a href="www.baidu.com" class="navbar-brand">论坛主页</a>
					</div>
					<div>
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">我的消息</a></li>
							<li><a href="#">我的帖子</a></li>
							<li><a href="#">我的回复</a></li>
						</ul>
					</div>
				</div>
				</nav>
			</div>
			<div class="feed">
				<ul>
				<c:forEach items="${messageList }" var="test">
					<li class="feed_item">
						<div class="feed_left">
							<div class="replyme">
								<div class="replyme_user">
									<a href="#" target="_blank">${test.personName }&nbsp;:&nbsp;</a>
								</div>
								<div class="replyme_content">
									<a href="#">我ye喜欢你</a>
								</div>
							</div>
							<div class="feed_from">
								回复我的主题：“<a href="#" class="feed_forum" title="" target="_blank">${test.forumTitle }</a>”
							</div>
						</div>
						<div class="feed_right">
							<div class="feed_time">${test.time }</div>
							<div class="reply1">
								<img src="" alt=""><a href="#" target="_blank">回复</a>
							</div>
						</div>
					</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="i_right">侧边栏</div>
	</div>
	</div>
	<jsp:include page="/baseView/footer.jsp"></jsp:include>
	<script src="${pageContext.request.contextPath }/js/jquery-1.9.min.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"
		type="text/javascript"></script>
</body>
</html>