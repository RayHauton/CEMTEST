<!-- 
	返校住宿静态页面
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>校友系统-返校住宿</title>
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/bootstrap.css">
	<link rel="stylesheet" href="../css/view_set/accommodation.css">
	<link rel="stylesheet" href="../css/view_set/head.css">
	<link rel="stylesheet" href="../css/view_set/footer.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="content">
		<div id="hotel1" class="hotel">
			<h2>锦江之星</h2>
			<p>地址：南京江宁经济开发区胜太西路162号（南航江宁校区北门对面）&nbsp&nbsp&nbsp&nbsp联系电话：025-52765388</p>
			<img src="${pageContext.request.contextPath }/img/hotel/hotel1-jj.jpg" alt="锦江之星">
		</div>
		<div id="hotel2" class="hotel">
			<h2>南京湖滨金陵饭店</h2>
			<p>地址：南京江宁经济技术开发区佳湖东路8号&nbsp&nbsp&nbsp&nbsp联系电话：400-636-6636</p>
			<img src="${pageContext.request.contextPath }/img/hotel/hotel2-hb.jpg" alt="南京湖滨金陵饭店">
		</div>
		<div id="hotel3" class="hotel">
			<h2>江苏翠屏山宾馆</h2>
			<p>地址：江苏省南京市江宁开发区天元西路168号&nbsp&nbsp&nbsp&nbsp联系电话：025-52427896</p>
			<img src="${pageContext.request.contextPath }/img/hotel/hotel3-cp.jpg" alt="江苏翠屏山宾馆">
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/loginController/loginAndLogout.js" ></script>
</html>