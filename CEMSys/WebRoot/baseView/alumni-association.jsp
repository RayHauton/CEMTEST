<!-- 
	校友会信息页面
 -->
<%@page import="com.cem.util.BeanUtil"%>
<%@page import="com.cem.serviceImpl.SystemInfoGetterService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
if(session.getAttribute("systemDomain")==null){
	session.setAttribute("systemDomain", ((SystemInfoGetterService)BeanUtil.getBean(SystemInfoGetterService.class)).getSystemDomain());
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>校友系统-校友会</title>
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/bootstrap.css">
	<link rel="stylesheet" href="../css/view_set/alumni-association.css">
	<link rel="stylesheet" href="../css/view_set/head.css">
	<link rel="stylesheet" href="../css/view_set/footer.css">
	<script src="../js/alumniAssociationController/alumniAssociationControl.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="content">
		<c:forEach var="pojo" items="${alumniAssoList }">
			<div class="association">
				<h2>${pojo.alumniAssociationName }</h2>
				<p>联系人：${pojo.contactPerson }&nbsp&nbsp&nbsp&nbsp联系方式：${pojo.contactWay }</p>
				<div id="picture">
					<img src="http://${sessionScope.systemDomain }/fileUpload/alumniAssociationImg/${pojo.img }" alt="${pojo.alumniAssociationName }" onload="resize(this,'${pojo.width}','${pojo.height }');">
				</div>
			</div>
		</c:forEach>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/loginController/loginAndLogout.js" ></script>
</html>