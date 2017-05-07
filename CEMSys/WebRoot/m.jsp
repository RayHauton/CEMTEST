<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!--include libraried -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<!--include summernote -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/summernote/dist2/summernote.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/view_set/head.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/view_set/footer.css">
<style type="text/css">
.wholepage {
	margin-left: auto;
	margin-right: auto;
	width: 1000px;
}

.input_span {
	width: 918px;
}
</style>
</head>

<body>
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
		<div class="navigation1">
			<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<a href="${pageContext.request.contextPath }/admin/adminIndex.jsp"
						class="navbar-brand">系统管理</a>
				</div>
				<div>
					<ul class="nav navbar-nav">
						<li><a
							href="${pageContext.request.contextPath }/mail/mailToAll.jsp">发给全体成员</a></li>
						<li><a
							href="${pageContext.request.contextPath }/mail/mailToGrade.jsp">发给指定年级</a></li>
						<li class="active"><a
							href="${pageContext.request.contextPath }/mail/mailToDept.jsp">发给指定系</a></li>
					</ul>
				</div>
			</div>
			</nav>
		</div>

		<div class="">
			<form id="form"
				action="${pageContext.request.contextPath }/mail/mailToAll"
				method="post" enctype="multipart/form-data">
				<div class="input-group">
					<span class="input-group-addon">收件人</span> <input type="text"
						id="toUsers" name="toUsers" class="form-control"
						placeholder="..@.." value="全体成员" readonly="readonly">
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon">主题</span> <input id="subject"
						name="subject" type="text" class="form-control">
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon">正文</span>
					<textarea id="summernote" name="content" rows="" cols=""></textarea>
				</div>
				<input type="button" id="button1" name="1"
					onclick="javascript:upload(this)" value="添加附件"> <input
					type="button" id="button2" name="2"
					onclick="javascript:upload(this)" value="继续添加"
					style="display: none;"> <input type="submit" value="发送" >

				<input type="file" id="file1" name="1" value="文件"
					style="display: none;" onchange="showOther(this)"> <input
					type="file" id="file2" name="2" value="文件" style="display: none;"
					onchange="showOther(this)">
			</form>

		</div>
	</div>
	<input type="hidden" value="${pageContext.request.contextPath }"
		id="basePath" />
	<jsp:include page="/baseView/footer.jsp"></jsp:include>

	<script
		src="${pageContext.request.contextPath }/js/mailController/mail.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/summernote/dist2/summernote.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/mailController/jquery-form.js"></script>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$('#summernote')
									.summernote(
											{
												height : 400,
												minHeight : 300,
												maxHeight : 500,
												focus : false,
												lang : 'zh-CN',
												toolbar : [
														[
																'style',
																[
																		'bold',
																		'italic',
																		'underline',
																		'clear' ] ],
														[ 'fontsize',
																[ 'fontsize' ] ],
														[ 'color', [ 'color' ] ],
														[
																'para',
																[ 'ul', 'ol',
																		'paragraph' ] ],
														[ 'height',
																[ 'height' ] ], ]
											});
						});
	</script>
</body>

</html>