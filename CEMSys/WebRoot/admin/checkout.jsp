<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.cem.util.BaseDataUtil"%>
<%
	request.setAttribute("pageSizeList", BaseDataUtil.getPageSizes());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/checkout/adminCheckout.css">
<link rel="stylesheet" href="../css/view_set/head.css">
<link rel="stylesheet" href="../css/view_set/footer.css">
<link rel="stylesheet"
	href="../css/view_set/adminViewSet/adminIndex.css">
<title>用户审核界面</title>
</head>
<body>
	<jsp:include page="header_admin.jsp"></jsp:include>
	<div class="contentBody">
		<br />
		<h3
			style="margin: 0; padding: 0; margin-bottom: 15px; margin-top: 5px;">以下为尚未审核用户</h3>
		<div id="tableDiv"
			style="width: 70%; margin-left: 15%; margin-top: 10px;">
			<form action="${pageContext.request.contextPath }/checkout/auditSelected_adm.action">
				<table class="table table-bordered table-striped" style="width: 100%;" >
					<thead style="font-size: 15px;">
						<tr>
							<th>序号</th>
							<th>多选</th>
							<th>用户名</th>
							<th>真实姓名</th>
							<th>学号</th>
							<th>入学时间</th>
							<th>是否通过审核</th>
						</tr>
					</thead>
					<tbody>
						<% int i=1; %>
						<% int j=1; %>
						<% int k=0; %>
						<input id="tempInput" name="tempInput" style=" display:none">
						<c:forEach var="result" items="${sessionScope.result}">
							<tr>
								<td><%=k+1 %></td>
								<td><div class="check-box"><i><input type="checkbox" name="check-box" value="<%=k++%>" /></i></div></td>
								<td>${ result[0]}</td>
								<td>${ result[1]}&emsp;<img src="../images/${ result[2]}.png" style="width:13px;height:auto;" id="img<%=i++%>"/></td>
								<td>${ result[3]}&emsp;<img src="../images/${ result[4]}.png" style="width:13px;height:auto;" id="img<%=i++%>"/></td>
								<td>${ result[5]}&emsp;<img src="../images/${ result[6]}.png" style="width:13px;height:auto;" id="img<%=i++%>"/></td>
								<td><a class="btn form-control btn-success" href="${pageContext.request.contextPath }/checkout/audit_adm.action?username=${ result[0]}&flag=1">是</a>&emsp;
								<a class="btn form-control btn-danger" href="${pageContext.request.contextPath }/checkout/audit_adm.action?username=${ result[0]}&flag=-">否</a></td>
								<div class="notice" id="notice<%=j++%>">
									<span style="color:white;">注册：${ result[1]}</span><br/>
									<span style="color:white;">数据库：${ result[7]}</span>
								</div>	
								<div class="notice" id="notice<%=j++%>">
									<span style="color:white;">注册：${ result[3]}</span><br/>
									<span style="color:white;">数据库：<a style="color:#fff;text-decoration:none;" class="StuID">${ result[8]}</a></span>
								</div>	
								<div class="notice" id="notice<%=j++%>">
									<span style="color:white;">注册：${ result[5]}</span><br/>
									<span style="color:white;">数据库：<a style="color:#fff;text-decoration:none;" class="EntranceDate">${ result[9]}</a></span>
								</div>	
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td><%=k+1 %></td>	
							<td><div class="check-box" id="selectAll"><i><input type="checkbox" name="check-box" id="temp"></i></div><span style="display:inline-block;vertical-align:super;">全选</span></td>
							<td><button class="btn form-control btn-success" style="width:120px;" id="pass">批量通过审核</button></td>
							<td><button class="btn form-control btn-danger" style="width:120px;" id="refuse">批量不通过审核</button></td>
						</tr>
					</tfoot>
				</table>
			</form>
		</div>
	<br/>
	<br/>
	</div>
	<jsp:include page="../baseView/footer.jsp"></jsp:include>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/adminCheckout.js"></script>
<script src="../js/prefixfree.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/loginController/loginAndLogout.js"></script>
</html>