<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/view_set/base.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/view_set/BBS.css">
</head>
<body>
	<input type="hidden" value="${pageContext.request.contextPath }"
		id="basehref">
	<div class="inputBox">
		<input type="text" id="forumTitle" placeholder="标题" /> <span>共可以输入25个字</span>
		<textarea name="forumContent" id="textArea" placeholder="说点什么吧"
			cols="" rows=""></textarea>
		<a href="javascript:document.getElementById('file1').click();"
			class="file"></a> <input type="file" id="file1"
			accept=".jpg,bmp,.gig,.png,.tif,.rgb,.dib,.eps,.jpe,.pcx,.bmp,.gif"
			style="display: none;">
		<p>
			<a href="javascript:void(0);" class="expression" onclick="file();"></a>
			<a href="javascript:void(0);">艾特</a> <input type="button" value="发送"
				onclick="javascript:postForum()">
		</p>
	</div>
	<c:forEach var="test" items="${forumList }">
		<div>
			<a href="${pageContext.request.contextPath }/forum/p/${test.forumId}">${test.forumTitle }</a>
			<p>查看量:${test.viewCount }</p>
			<p>回复量：${test.replyCount }</p>
		</div>
	</c:forEach>
</body>
</html>