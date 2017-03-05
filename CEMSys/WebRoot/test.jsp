<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="css/view_set/base.css"> -->
<!-- <link rel="stylesheet" href="css/view_set/BBS.css"> -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/view_set/head.css">
<link rel="stylesheet" href="css/view_set/footer.css">
</head>
<body>
	<c:choose>
		<c:when test="">
			<a href="${pageContext.request.contextPath }/test.action">testException</a>
		</c:when>
		<c:otherwise>

		</c:otherwise>
	</c:choose>

	<jsp:include page="/baseView/header.jsp"></jsp:include>
	<div style="text-align:center;">
	<p><a href="${pageContext.request.contextPath }/forum/f/1">随便你说</a></p>
	<p><a href="${pageContext.request.contextPath }/forum/f/2">学术论坛</a></p>
	</div>
	<jsp:include page="/baseView/footer.jsp"></jsp:include>
</body>
</html>