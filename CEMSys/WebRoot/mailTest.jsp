<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/mail/mail.css">
<title>Insert title here</title>

<!-- 	ueditor编辑器 -->
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath }/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath }/ueditor/ueditor.all.min.js"></script>
</head>
<body>
	<p>本邮件系统仅支持发送 接收请到相应邮箱进行查看</p>
	<p>987612820@qq.com;</p>
	
	<div style="padding: 100px 100px 10px;">
		<form id="form"
			action="${pageContext.request.contextPath }/mail/uploadMail"
			method="post" enctype="multipart/form-data">
			<div class="input-group">
				<span class="input-group-addon">收件人</span> <input type="text"
					id="toUsers" name="toUsers" class="form-control" placeholder="..@..">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">主题</span> <input id="subject" name="subject"
					type="text" class="form-control">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">正文</span>
				<textarea name="content" rows="5" cols="5" id="editor" style="height: 300px"></textarea>
			</div>
			<input type="button" id="button1" name="1"
				onclick="javascript:upload(this)" value="添加附件"> <input
				type="button" id="button2" name="2"
				onclick="javascript:upload(this)" value="继续添加"
				style="display: none;"> <input type="submit" value="发送">
			
			<input type="file" id="file1" name="1" value="文件"
			style="display: none;" onchange="showOther(this)"> <input
			type="file" id="file2" name="2" value="文件" style="display: none;"
			onchange="showOther(this)">
		</form>
		
	</div>


	<script src="${pageContext.request.contextPath }/js/jquery.min.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath }/js/mailController/mail.js"
		type="text/javascript"></script>
</body>
</html>