<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.cem.util.BaseDataUtil"%>
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
		<button type="button" class="btn btn-info" style="margin-left:7%;margin-top:7px;">根据个人信息查询</button>
		<button type="button" class="btn btn-info" style="margin-left:15%;margin-top:7px;">根据调研信息查询</button>
		<button type="button" class="btn btn-info" style="margin-left:15%;margin-top:7px;">调研信息导出成Excel</button>
		<div id="searchTermA">
			<hr id="hr"/>
			<div class="searchLogo"style="z-index:1px;position:absolute;">
				<img alt="" src="../img/donation/search1.png">
			</div>
			<form>
				<div style="margin-bottom:13px">
					<div id="test"></div>
					<div id="addDiv">
						<div id="addDiv0">
							<label>第</label>
							<input class="form-control" placeholder="输入1-39内的整数">
							<label>&emsp;题&emsp;选择</label>
							<input class="form-control" placeholder="输入1-5内的整数">
							<label>&emsp;分&emsp;</label>
							<img alt="" src="../images/add.png" height=20px; id="addImg">
							<br/>
						</div>
					</div>
				</div>
				<div style="margin-top:15px;margin-left:0px;">
				    <button type="reset" class="btn btn-success form-control">&ensp;重置&ensp;</button>
				    <button type="submit" class="btn btn-success form-control">&ensp;查询&ensp;</button>
				</div>
			</form>
			<hr id="hr"/>
		</div>
		<div id="tableDiv" style="width:70%;margin-left:15%;margin-top:10px;">
			<label>共查询到<span style="color:red">5</span>条记录</label>
			<table class="table table-bordered table-striped" >
				<thead>
					<tr>
						<th>&emsp;&emsp;&emsp;diyige</th>
						<th>&emsp;&emsp;&emsp;diyige</th>
						<th>&emsp;&emsp;&emsp;diyige</th>
						<th>&emsp;&emsp;&emsp;diyige</th>
						<th>&emsp;&emsp;&emsp;diyige</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>这是内容</td>
						<td>这是内容</td>
						<td>这是内容</td>
						<td>这是内容</td>
						<td>这是内容</td>
					</tr>
					<tr>
						<td>这是内容</td>
						<td>这是内容</td>
						<td>这是内容</td>
						<td>这是内容</td>
						<td>这是内容</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/personalabilityControl/adminSurvey.js"></script>
<script src="../js/loginController/loginAndLogout.js"></script>
<script type="text/javascript">
	
</script>
</html>