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
	<link rel="stylesheet" href="../css/view_set/base.css">
	<link rel="stylesheet" href="../css/view_set/timeline.css">
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/view_set/head.css">
	<link rel="stylesheet" href="../css/view_set/footer.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
<div class="box">
	<div class="check">
	<form action="${pageContext.request.contextPath }/collegeEvent/show.action" method="post" class="">
		<!-- 设置页面显示记录数量（定值：6） -->
		<input type="hidden" name="pageSize" value="6"/>
		<table class="">
			<tr>
				<td>从：<input type="month" class="inputSet" id="foredate" name="foredate" value="${queryVo.foredate }"/></td>
				<td>至：<input type="month" class="inputSet" id="afterdate" name="afterdate" value="${queryVo.afterdate }"/></td>
				<td><button class="btn-custom">查询</button></td>
			</tr>
		</table>
	</form>
	</div>
	<!-- 单个事件 resultList-->
	<c:forEach var="pojo" items="${resultList }">
		<div class="each">
			<div class="time">
				${pojo.eventDate }
			</div>
			<div class="linebox">
				<div class="line"></div>
			</div>
			<div class="content">
				<span class="title">${pojo.eventTitle }</span>
				<div class="detail">
					${pojo.eventDetail }
				</div>
			</div>
			<div class="imgDiv">
				<img alt="" src="/fileUpload/collegeEventImgs/${pojo.eventImg}">
			</div>
		</div>
	</c:forEach>
</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/loginController/loginAndLogout.js"></script>
</html>














