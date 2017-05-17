<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/view_set/head.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/view_set/footer.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/view_set/forum.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/view_set/ihome.css">

<!-- 	ueditor编辑器 -->
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath }/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath }/ueditor/ueditor.all.min.js">
	
</script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath }/ueditor/lang/zh-cn/zh-cn.js"></script>


<style type="text/css">
h1 {
	font-family: "微软雅黑";
	font-weight: normal;
}

.btn {
	display: inline-block;
	*display: inline;
	padding: 4px 12px;
	margin-bottom: 0;
	*margin-left: .3em;
	font-size: 14px;
	line-height: 20px;
	color: #333333;
	text-align: center;
	text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75);
	vertical-align: middle;
	cursor: pointer;
	background-color: #f5f5f5;
	*background-color: #e6e6e6;
	background-image: -moz-linear-gradient(top, #ffffff, #e6e6e6);
	background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#ffffff),
		to(#e6e6e6));
	background-image: -webkit-linear-gradient(top, #ffffff, #e6e6e6);
	background-image: -o-linear-gradient(top, #ffffff, #e6e6e6);
	background-image: linear-gradient(to bottom, #ffffff, #e6e6e6);
	background-repeat: repeat-x;
	border: 1px solid #cccccc;
	*border: 0;
	border-color: #e6e6e6 #e6e6e6 #bfbfbf;
	border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
	border-bottom-color: #b3b3b3;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffffff',
		endColorstr='#ffe6e6e6', GradientType=0);
	filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
	*zoom: 1;
	-webkit-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px
		rgba(0, 0, 0, 0.05);
	-moz-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px
		rgba(0, 0, 0, 0.05);
	box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px
		rgba(0, 0, 0, 0.05);
}

.btn:hover, .btn:focus, .btn:active, .btn.active, .btn.disabled, .btn[disabled]
	{
	color: #333333;
	background-color: #e6e6e6;
	*background-color: #d9d9d9;
}

.btn:active, .btn.active {
	background-color: #cccccc \9;
}

.btn:first-child {
	*margin-left: 0;
}

.btn:hover, .btn:focus {
	color: #333333;
	text-decoration: none;
	background-position: 0 -15px;
	-webkit-transition: background-position 0.1s linear;
	-moz-transition: background-position 0.1s linear;
	-o-transition: background-position 0.1s linear;
	transition: background-position 0.1s linear;
}

.btn:focus {
	outline: thin dotted #333;
	outline: 5px auto -webkit-focus-ring-color;
	outline-offset: -2px;
}

.btn.active, .btn:active {
	background-image: none;
	outline: 0;
	-webkit-box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px
		rgba(0, 0, 0, 0.05);
	-moz-box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px
		rgba(0, 0, 0, 0.05);
	box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px
		rgba(0, 0, 0, 0.05);
}

.btn.disabled, .btn[disabled] {
	cursor: default;
	background-image: none;
	opacity: 0.65;
	filter: alpha(opacity = 65);
	-webkit-box-shadow: none;
	-moz-box-shadow: none;
	box-shadow: none;
}
}
</style>
</head>
<body class="ihome">
	<input type="hidden" value="${pageContext.request.contextPath }"
		id="basePath">

	<jsp:include page="/baseView/header.jsp"></jsp:include>
	<div class="wholepage">
		<div class="i_home">
			<div class="ihome-content">
				<div class="forum-content">
					<ul class="list-group">
						<c:forEach var="test" items="${forumList }">
							<li class="list-group-item forum"><span class="badge">精</span>
								<div class="forum-main">
									<div class="forum-title">
										<a
											href="${pageContext.request.contextPath }/forum/p/${test.forumId}">${test.forumTitle }</a>
									</div>
									<div class="forum-content">
										<span><img
											src="${pageContext.request.contextPath }/img/forum/user.png"
											alt="${test.username }" style="width: 9px; height: 8px;">${test.username }</span>
										<span>回复数${test.replyCount }</span> <span>查看量${test.viewCount }</span>
										<span title="最后回复时间">${test.updateTime }</</span>
									</div>
								</div></li>
						</c:forEach>
					</ul>
					<c:choose>
						<c:when test="${totalForumPage == 0 }">
							<div class="nonebbs11">还没有帖子 赶紧发一个吧</div>
						</c:when>
						<c:otherwise>
							<div class="container" style="text-align: center;">
								<ul class="pagination">
									<li><a href="#">共${totalForumPage }页</a></li>
									<li><a
										href="${pageContext.request.contextPath }/forum/f/${forumModule }?forumIndex=1">首页</a></li>

									<c:if test="${currentForumPage>1 }">
										<li><a
											href="${pageContext.request.contextPath }/forum/f/${forumModule }?forumIndex=${currentForumPage-1 }">上一页</a></li>
									</c:if>
									<c:choose>
										<c:when test="${totalForumPage<=10 }">
											<c:set var="begin" value="1"></c:set>
											<c:set var="end" value="${totalForumPage }"></c:set>
										</c:when>
										<c:otherwise>
											<c:set var="begin" value="${currentForumPage-5 }"></c:set>
											<c:set var="end" value="${currentForumPage+4 }"></c:set>
											<c:if test="${begin<1 }">
												<c:set var="begin" value="1"></c:set>
												<c:set var="end" value="10"></c:set>
											</c:if>
											<c:if test="${end>totalForumPage }">
												<c:set var="begin" value="${totalForumPage-9 }"></c:set>
												<c:set var="end" value="${totalForumPage }"></c:set>
											</c:if>
										</c:otherwise>
									</c:choose>
									<c:forEach var="i" begin="${begin }" end="${end }">
										<c:choose>
											<c:when test="${i==currentForumPage }">
												<li class="active"><a href="#">${i }</a></li>
											</c:when>
											<c:otherwise>
												<li><a
													href="${pageContext.request.contextPath }/forum/f/${forumModule }?forumIndex=${i }">${i }</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<c:if test="${currentForumPage<totalForumPage }">
										<li><a
											href="${pageContext.request.contextPath }/forum/f/${forumModule }?forumIndex=${currentForumPage+1 }">下一页</a></li>
									</c:if>
									<li><a
										href="${pageContext.request.contextPath }/forum/f/${forumModule }?forumIndex=${totalForumPage }">尾页</a></li>
								</ul>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
				<span>发表新帖 </span>
				<div class="inputBox"
					style="width: 819px; margin-left: auto; margin-right: auto;">
					<input type="text" id="forumTitle" placeholder="请填写标题"
						class="form-control" onkeydown="countChar('forumTitle','counter')"
						onkeyup="countChar('forumTitle','counter')" />
						已经输入<span id="counter">0</span>/25个字
					<div id="errormsg" style="display:none;">标题过长</div>
					<textarea rows="5" cols="5" id="editor" style="height: 300px"></textarea>
					<p>
						<input type="button" value="发送" onclick="javascript:postForum()"
							class="btn">
					</p>
				</div>
			</div>
			<div class="aside">
				<div class="my_info">
					<div class="my_info_title">
						<span class="my_info_title_setting">[设置]</span> <span
							class="my_info_title_title">个人信息</span>
					</div>
					<div class="my_info_content">
						<div class="my_info_content_img">头像</div>
						<div class="my_info_content_info">
							<p class="info_name">dadan</p>
							<p class="info_sex">男</p>
							<a href="${pageContext.request.contextPath }/forum/myMessage">
								<img alt=""
								src="${pageContext.request.contextPath }/img/forum/lingdang.png">
							</a> <span id="tongzhi" style="display: none;"><a
								href="${pageContext.request.contextPath }/forum/myMessage"><strong
									id="tongzhi-content">0</strong></a> </span>
						</div>
					</div>
				</div>
				<div class="somethingelse">
					<ul>
						<li class="somethingelse_home"><a
							href="${pageContext.request.contextPath }/forum/f/1">首页</a></li>
						<li class="somethingelse_mytie"><a
							href="${pageContext.request.contextPath }/forum/ihome_tie?uid=${sessionScope.user.userId }">个人中心</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/baseView/footer.jsp"></jsp:include>


	<script src="${pageContext.request.contextPath }/js/jquery.min.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath }/js/forumController/forum.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		function messagebox(test) {
			var floor = $(test).attr('name');
			$('#pp' + floor).toggle();
		}
	</script>
</body>
</html>