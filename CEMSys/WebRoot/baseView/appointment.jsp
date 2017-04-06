<!-- 
	预约参观静态页面
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>校友系统-参观预约</title>
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/bootstrap.css">
	<link rel="stylesheet" href="../css/view_set/appointment.css">
	<link rel="stylesheet" href="../css/view_set/head.css">
	<link rel="stylesheet" href="../css/view_set/footer.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="content">
		<div class="title">
			<h2>学院预约参观</h2>
			<span id="contact">预约联系人：任慈&nbsp&nbsp&nbsp联系方式：025-52119019</span>
		</div>
		<div id="box">
			<a id="a1" class="num">1</a>
			<a id="a2" class="num">2</a>
			<a id="a3" class="num">3</a>
			<a id="a4" class="num">4</a>
			<a id="a5" class="num">5</a>
			<a id="a6" class="num">6</a>
			<a id="a7" class="num">7</a>
			<div id="picture" class="play">
				<img src="${pageContext.request.contextPath }/img/visit/h-museum1.jpg" >  
				<img src="${pageContext.request.contextPath }/img/visit/h-museum2.jpg">
				<img src="${pageContext.request.contextPath }/img/visit/library.jpg">
				<img src="${pageContext.request.contextPath }/img/visit/library1.jpg">
				<img src="${pageContext.request.contextPath }/img/visit/library2.jpg">
				<img src="${pageContext.request.contextPath }/img/visit/cafe.jpg">
				<img src="${pageContext.request.contextPath }/img/visit/cafe1.jpg">
				<ul id="abstract">
					<li>学院院史馆</li>
					<li>学院院史馆</li>
					<li>512图书馆</li>
					<li>512图书馆</li>
					<li>512图书馆</li>
					<li>W&M咖啡厅</li>
					<li>W&M咖啡厅</li>
				</ul>
			</div>
		</div>		
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/loginController/loginAndLogout.js" ></script>
</html>