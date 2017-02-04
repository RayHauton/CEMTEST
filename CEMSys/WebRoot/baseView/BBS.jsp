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
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	<title>校友论坛</title>
	<link rel="stylesheet" href="../css/view_set/base.css">
	<link rel="stylesheet" href="../css/view_set/BBS.css">
	<script type="text/javascript" charset="utf-8" src="../plugin/textplugin/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="../plugin/textplugin/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="../plugin/textplugin/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
	<div class="head">
			<div class="logo">
				<a href="${pageContext.request.contextPath}/index.jsp">
					<img src="../img/cemLog.png" alt="南京航空航天大学">
				</a>
			</div>
			<div class="nav">
				<ul>
					<li>
						<a href="index.html">首页</a>
					</li>					
					<li>
						<a href="javascript:void(0);">个人中心</a>
					</li>
					<li>
						<a href="javascript:void(0);">我的好友</a>
					</li>
					<li>
						<a id="systemBtn" href="javascript:void(0);">其他系统</a>
						<div id="subnav">
							<a href="javascript:void(0);">校友招聘</a>
							<a href="javascript:void(0);">校友返校</a>
							<a href="javascript:void(0);">校友升迁</a>
							<a href="javascript:void(0);">校友活动</a>
						</div>
					</li>
					<script>
						window.onload = function(){
							var systemBtn = document.getElementById("systemBtn");
							var subNav = document.getElementById("subnav");
							var flag = 0;
							var box = document.getElementsByClassName("box")[0];
							systemBtn.onclick = function(){
								if (flag) {
									subNav.style.display = "none";
									flag = 0;
								}else{
									subNav.style.display = "block";
									flag = 1;
								};
							};
							box.onscroll = function(){
								subNav.style.display = "none";
								flag = 0;
							};
						};
					</script>
					<span>欢迎来到校友系统！</span>
				</ul>
			</div>
		</div>
	<div class="box">
		<div class="ul_list">
			<ul id="select">
				<li>所有帖子</li>
				<li>我的帖子</li>
				<li>我的回复<i>100</i></li>		
			</ul>
			<span id="release">发布信息</span>
		</div>
		<div id="content">
			<!-- <div class="inputBox">
				<textarea name="" id="textArea" placeholder="说点什么吧"></textarea>
				<a href="javascript:void(0);" class="file"><input type="file"></a>
				<p id="block">
					<a href="javascript:void(0);">表情</a>
					<a href="javascript:void(0);">艾特</a>
					<input id="sent" type="button" value="发送">
				</p>
			</div>-->
			<div class="allmessage">
				<div class="messageBox">
					<div class="massegeHead">
						<img src="##" alt="">
						<span>
							<a href="javascript:void(0);">昵称</a>
							<i class="time">13:12</i>
						</span>
					</div>
					<div class="massegeText">
						<p>文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文</p>
					</div>
					<div class="imgBox">
						<img src="../img/bg.jpg" onclick="open();"><img src="##" alt=""><img src="##" alt=""><span>100</span>
					</div>
					<div class="massegeFoot">
						<p>
							<i class="iconfont">评论</i>
							<i class="iconfont">赞</i>
						</p>
						<p><input type="text" placeholder="我也说一句"><input type="button" value="发送"></p>
						<div id="commentBox" class="commentBox"><span id="commentBtn" class="fr">展开</span>
							<div>
								<p>
									<a href="javascript:viod(0);">昵称：</a>我是评论内容<button>评论</button>
								</p>
								<p>
									<a href="javascript:viod(0);">昵称</a>回复<a href="javascript:viod(0);">昵称：</a>我是评论内容<button>评论</button>
								</p>
							</div>
							<script>
								var commentBtn = document.getElementById("commentBtn");
								var commentBox = document.getElementById("commentBox");var block = 1;
								commentBtn.onclick = function(){
									if (block) {
									commentBtn.innerHTML ="收起";
									block = 0;
									commentBox.style.height = "100%";
								}else{
									commentBtn.innerHTML ="展开";
									block = 1;
									commentBox.style.height = "16px";
								};
								};
							</script>
						</div>
					</div>
				</div>
				<div id="editorBox">
					<script id="editor" type="text/plain"></script>
				</div>
			</div>
			<div class="mymessage">
				<div class="messageBox">
					<div class="massegeHead">
						<img src="##" alt="">
						<span>
							<a href="javascript:void(0);">昵称</a>
							<i class="time">13:12</i>
						</span>
					</div>
					<div class="massegeText">
						<p>文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文</p>
					</div>
					<div class="imgBox">
						<img src="../img/bg.jpg" onclick="open();"><img src="##" alt=""><img src="##" alt=""><span>100</span>
					</div>
					<div class="massegeFoot">
						<p>
							<i class="iconfont">评论</i>
							<i class="iconfont">赞</i>
						</p>
						<p><input type="text" placeholder="我也说一句"><input type="button" value="发送"></p>
						<div id="mycommentBox" class="commentBox"><span id="mycommentBtn" class="fr">展开</span>
							<div>
								<p>
									<a href="javascript:viod(0);">昵称：</a>我是评论内容<button>评论</button>
								</p>
								<p>
									<a href="javascript:viod(0);">昵称</a>回复<a href="javascript:viod(0);">昵称：</a>我是评论内容<button>评论</button>
								</p>
							</div>
							<script>
								var mycommentBtn = document.getElementById("mycommentBtn");
								var mycommentBox = document.getElementById("mycommentBox");
								var myblock = 1;
								mycommentBtn.onclick = function(){
									if (myblock) {
									mycommentBtn.innerHTML ="收起";
									myblock = 0;
									mycommentBox.style.height = "100%";
								}else{
									mycommentBtn.innerHTML ="展开";
									myblock = 1;
									mycommentBox.style.height = "16px";
								};
								};
							</script>
						</div>
					</div>
				</div>
			</div>
			<div class="mycommentBox">
				<div>
					<p>
						<div class="massegeHead">
							<img src="##" alt="">
							<span>
								<a href="javascript:void(0);">昵称</a>
								<i class="time">13:12</i>
							</span>
						</div>
						<div class="massegeText">
							<p>文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文</p>
						</div>
						<div class="imgBox">
							<img src="../img/bg.jpg" onclick="open();"><img src="##" alt=""><img src="##" alt=""><span>100</span>
						</div>
					</p>
					<p>
						<a href="javascript:viod(0);">昵称</a>回复<a href="javascript:viod(0);">我：</a>我是评论内容<button>回复</button>
					</p>
				</div>
			</div>
		</div>		
	</div>
	<script src="../js/change.js"></script>
	<script type="text/javascript" src="../plugin/textplugin/controller.js"></script>
	<script>
		var	release = document.getElementById("release");
		var editor = document.getElementById("editorBox");
		release.onclick = function(){
			var parent = editor.parentNode;
			parent.style.display = "block";
			sibling(parent,function(){//divDom的兄弟节点的display状态为none
			this.style.display = "none";
			});
			document.getElementsByTagName('BODY')[0].scrollTop = parent.scrollHeight/2;
		};
	</script>
</body>
</html>