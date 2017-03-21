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
			<img src="${pageContext.request.contextPath }/img/donation/logo3.png" />
		</div>
		<div class="comment">经济与管理学院校友信息管理系统</div>
		<div class="user">
			<c:choose>
				<c:when test="${sessionScope.user!= null }">
					<ul class="nav navbar-nav">
						<li class="dropdown"><a data-toggle="dropdown"
							class="dropdown-toggle" href="#" style="color: deeppink;"><img
								src="${pageContext.request.contextPath }/img/user.png"
								style="width: 20px; height: 20px;">
								${sessionScope.user.truename }<b class="caret"></b></a>
							<ul role="menu" class="dropdown-menu">
								<li><a href="#">修改密码</a></li>
								<li><a href="#">查看资料</a></li>
								<li><a
									onclick="logout('${pageContext.request.contextPath}','/logout.action','/index.jsp');">注销</a></li>
							</ul></li>
					</ul>

				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath }/login.action"
						style="color: deeppink; margin-right: 10px;">请登录 <img
						src="${pageContext.request.contextPath }/img/mouse-pointer.png"
						style="width: 20px; height: 20px;"></a>
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
							<a href="${pageContext.request.contextPath }/forum/f/1"
								class="navbar-brand">论坛主页</a>
						</div>
						<div>
							<ul class="nav navbar-nav">
								<li class="active"><a
									href="${pageContext.request.contextPath }/forum/myMessage?uid=${sessionScope.user.userId }">回复我的</a></li>
								<li><a
									href="${pageContext.request.contextPath }/forum/ihome_tie?uid=${sessionScope.user.userId }">我的帖子</a></li>
								<li><a
									href="${pageContext.request.contextPath }/forum/ihome_reply?uid=${sessionScope.user.userId }">我的回复</a></li>
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
											<a
												href="${pageContext.request.contextPath }/forum/ihome_tie?uid=${test.personId }"
												target="_blank">${test.personName }&nbsp;:&nbsp;</a>
										</div>
									</div>
									<div class="feed_from">
										回复我的主题：“<a
											href="${pageContext.request.contextPath }/forum/p/${test.forumId }"
											class="feed_forum" title="" target="_blank">${test.forumTitle }</a>”
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
				<div class="button_next">
					<c:if test="${currentPageNum >1 }">
						<a
							href="${pageContext.request.contextPath }/forum/myMessage?messagePageIndex=1">首页</a>
						<a
							href="${pageContext.request.contextPath }/forum/myMessage?messagePageIndex=${currentPageNum-1}"><上一页</a>
					</c:if>
					<c:if test="${currentPageNum<totalPage }">
						<a
							href="${pageContext.request.contextPath }/forum/myMessage?messagePageIndex=${currentPageNum+1}"
							class="button_next_next">下一页></a>
					</c:if>
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