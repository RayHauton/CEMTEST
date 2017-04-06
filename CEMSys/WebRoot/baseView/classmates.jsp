<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>同班同学查询</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/view_set/head.css">
<link rel="stylesheet" href="../css/view_set/footer.css">
<link rel="stylesheet" href="../css/view_set/classmate.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="outer">
	<!-- 查询条件输入 -->
	<form action="${pageContext.request.contextPath }/userManage/findClassmatesByClassNo.action" method="post">
		<table cellpadding="0" cellspacing="0" class="queryTable">
			<tr>
			<td width="50px">&nbsp;&nbsp;姓名：</td>
			<td width="140px"><input type="text" name="truename" id="truename" class="inputSet" placeholder="选填"/></td>
			<td width="55px">&nbsp;&nbsp;&nbsp;班号：</td>
			<td width="150px"><input type="text" name="classNo" id="classNo" class="inputSet" placeholder="必填" required/></td>
			<td align="center"><input type="submit" name="submit" value="查询" class="inputBtn"style="background-color: #5caae9;"/></td>
			<td align="center"><input type="reset" name="reset" value="重置" class="inputBtn" style="background-color: #1db81d;"/></td>
			</tr>
		</table>
	</form>
	<hr style="padding: 0;margin: 0;">
	<table class="table table-striped table-bordered">
		<caption><b>查询结果：</b></caption>
		<thead>
			<th>姓名</th>
			<th>班号</th>
			<th>联系电话</th>
			<th>邮箱</th>
			<th>所在公司</th>
		</thead>
		<tbody>
			<c:forEach var="item" items="${classmatesList }">
			<tr>
				<td>${item.truename }</td>
				<td>${item.classNo }</td>
				<td>${item.mobile }</td>
				<td>${item.email }</td>
				<td>${item.companyName }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/loginController/loginAndLogout.js" ></script>
<script type="text/javascript">
	window.onload=function(){
		document.getElementById("truename").value='${truename}'
		document.getElementById("classNo").value='${classNo}'
	}
</script>
</html>