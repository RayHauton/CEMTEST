<%--
Created by IntelliJ IDEA.
User: RayHauton
Date: 2016/12/6
Time: 21:22
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>校友论坛</title>
	<link rel="stylesheet" href="../css/view_set/base.css">
	<link rel="stylesheet" href="../css/view_set/BBS.css">
</head>
<body>
	<div class="box">
		<div class="head">
			<div class="logo">
				<a href="javascipt:void(0);">
					<img src="" alt="个人头像">
				</a>
			</div>
			<div class="nav">
				<ul>
					<li>
						<a href="index.html">系统首页</a>
						<div class="subNav">
							<a href="javascript:void(0);">校友快讯</a>
							<a href="javascript:void(0);">返校预约</a>
							<a href="javascript:void(0);">经管历程</a>
							<a href="javascript:void(0);">南航主页</a>
						</div>
					</li>					
					<li>
						<a href="javascript:void(0);">个人中心</a>
						<div class="subNav">
							<a href="javascript:void(0);">我的主页</a>
							<a href="javascript:void(0);">我的回复</a>
							<a href="javascript:void(0);">修改资料</a>
							<a href="${pageContext.request.contextPath }/recruitment/publish.action">发布信息</a>
						</div>
					</li>
					<li>
						<a href="javascript:void(0);">我的帖子</a>
					</li>
				</ul>
				<span>欢迎来到校友系统！</span>
			</div>
		</div>
		<div class="container">
			<div class="fileBox">
				<div class="file">
					<input type="file" multiple>
				</div>
				<div class="imgShow"></div>
				<hr>
				<div class="imgSubmit">
					<button>取消</button>
					<button>确认</button>
				</div>
			</div>
			<div class="inputBox">
				<textarea name="" id="textArea" placeholder="说点什么吧"></textarea>
				<a href="javascript:void(0);" class="file"></a>
				<p>
					<a href="javascript:void(0);" class="expression" onclick="file();"></a>
					<a href="javascript:void(0);">艾特</a>
					<input type="button" value="发送">
				</p>
			</div>
			<div class="message">
				<div class="messageBox">
					<div class="head">
						<img alt="个人头像" />
						<div class="nameBox">
							<span class="name">昵称</span>
							<span class="time">时间</span>
						</div>
					</div>
					<div class="text">
						<p>I am back after few months or so of not blogging. Have you heard something called “Emoji”?I am back after few months or so of not blogging. Have you heard something called “Emoji”?I am back after few months or so of not blogging. Have you heard something called “Emoji”?I am back after few months or so of not blogging. Have you heard something called “Emoji”?</p>
					</div>
					<div class="img">
						<img src="" alt="图片">
						<img src="" alt="图片">
						<img src="" alt="图片">
						<span>100</span>
					</div>
					<div class="content">
						<input type="text" placeholder="说点什么吧">
						<span class="c-epsion"></span>
						<button calss="content-btn">评论</button>
					</div>
					<div class="contentBox">
						<p>
							<i>展开</i>
						</p>	
						<p>
							<b>昵称1</b>评论<b>昵称2</b>：<span>评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容</span>
							<a href="javascript:void(0);">回复</a>
						</p>
						<p>
							<b>昵称2</b>评论<b>昵称3</b>：<span>评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容</span>
							<a href="javascript:void(0);">回复</a>
						</p>
					</div>
				</div>
			</div>
		</div>	
	</div>
</body>
</html>