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
<link rel="stylesheet" href="../css/adminPersonalAbility.css">
<title>调查</title>
</head>
<body>
	<div class="contentBody">
		<div class="searchDiv">
			<button type="button" class="btn btn-info"
				style="margin-left: 7%; margin-top: 7px;">根据个人信息查询</button>
			<button type="button" class="btn btn-info"
				style="margin-left: 15%; margin-top: 7px;">根据调研信息查询</button>
			<button type="button" class="btn btn-info"
				style="margin-left: 15%; margin-top: 7px;">调研信息导出成Excel</button>
			<div id="searchTermA">
				<hr id="hr" />
				<div class="searchLogo">
					<img alt="" src="../img/donation/search1.png">
				</div>
				<form action="../userManage/findUser">
					<div style="margin-bottom: 13px">
						<label>学号</label> <input class="form-control" placeholder="输入学号"
							name="studNumber"> <label>姓名</label> <input
							class="form-control" placeholder="输入姓名" name="trueName">
						<label>入学时间</label> <select class="form-control"
							name="entranceDate">
							<option value="volvo">Volvo</option>
							<option value="saab">Saab</option>
							<option value="opel">Opel</option>
							<option value="audi">Audi</option>
						</select> <label>每页显示</label> <select class="form-control" name="pageSize"
							id="pageSize" style="padding: 0px;">
							<c:forEach var="pageSize" items="${pageSizeList }">
								<option>${pageSize }</option>
							</c:forEach>
						</select>
					</div>
					<label><input type="radio" name="audit" value='0'
						onclick="setSelectUserNo(this);">包含未审核通过用户</label>
					<div style="margin-top: 15px; margin-left: 0px;">
						<button type="reset" class="btn btn-success form-control">&ensp;重置&ensp;</button>
						<button type="submit" class="btn btn-success form-control">&ensp;查询&ensp;</button>
						<button type="button" class="btn btn-success form-control" onclick="queryAll();">&ensp;查询全部&ensp;</button>
					</div>
				</form>
				<hr id="hr" />
			</div>
			<div id="tableDiv"
				style="width: 70%; margin-left: 15%; margin-top: 10px;">
				<label>共查询到<span style="color: red">${sum} </span>条记录
				</label>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>&emsp;&emsp;&emsp;姓名</th>
							<th>&emsp;&emsp;&emsp;学号</th>
							<th>&emsp;&emsp;&emsp;专业</th>
							<th>&emsp;&emsp;&emsp;电话</th>
							<th>&emsp;&emsp;&emsp;Email</th>
							<th>&emsp;&emsp;&emsp;入学时间</th>
							<th>&emsp;&emsp;&emsp;毕业时间</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="userList" var="users"></c:forEach>
						<tr>

							<td>users.trueName</td>
							<td>users.studNumber</td>
							<td></td>
							<td>users.mobile</td>
							<td>users.email</td>
							<td>users.entranceDate</td>
							<td>graduateDate</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script type="text/javascript">
	function getDatesSession() {

	}

	function setSelectUserNo(radioObj) {
		var radioCheck = $(radioObj).val();
		if ("1" == radioCheck) {
			$(radioObj).attr("checked", false);
			$(radioObj).val("0");
		} else {
			$(radioObj).val("1");

		}
	}
	
	function queryAll(){
		window.location.href = "../userManage/findUser";
	}
</script>
</html>