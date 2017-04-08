<!-- 
	校友会信息页面
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>校友系统-校友会</title>
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/view_set/alumni-association.css">
	<link rel="stylesheet" href="../css/view_set/head.css">
	<link rel="stylesheet" href="../css/view_set/footer.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="content">
		<div class="association">
			<h2>校友会名称</h2>
			<p>联系人：某某人&nbsp&nbsp&nbsp&nbsp联系电话：025-52765388</p>
			<div id="picture">
				这是一张校友会图片
				<img src="" alt="">
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/loginController/loginAndLogout.js" ></script>
</html>