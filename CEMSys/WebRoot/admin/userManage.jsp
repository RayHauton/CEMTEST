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
<link rel="stylesheet" href="../css/userManage.css">
<link rel="stylesheet" href="../css/view_set/head.css">
<link rel="stylesheet" href="../css/view_set/footer.css">
<link rel="stylesheet"
	href="../css/view_set/adminViewSet/adminIndex.css">
<title>调查</title>
</head>
<body>
	<jsp:include page="header_admin.jsp"></jsp:include>
	<div class="contentBody">
		<div class="searchDiv">
			<!-- <button type="button" class="btn btn-info"
				style="margin-left: 7%; margin-top: 7px;">根据个人信息查询</button>
			<button type="button" class="btn btn-info"
				style="margin-left: 15%; margin-top: 7px;">根据调研信息查询</button> -->
			<button type="button" class="btn btn-info"
				style="margin-left: 7%; margin-top: 7px;">用户信息导出成Excel</button>
			<div id="searchTermA">
				<hr id="hr" />
				<div class="searchLogo">
					<img alt="" src="../img/donation/search1.png">
				</div>
				<form action="../userManage/findUser" method="get">
					<div style="margin-bottom: 13px">
						<label>学号</label> <input class="form-control" placeholder="输入学号"
							name="studNumber"> <label>姓名</label> <input
							class="form-control" placeholder="输入姓名" name="truename">
						<label>入学时间</label> <select class="form-control"
							name="entranceDate">
							<option value=""></option>
							<option value="volvo">Volvo</option>
							<option value="saab">Saab</option>
							<option value="opel">Opel</option>
							<option value="audi">Audi</option>

						</select> <br /> <label>学位</label><select name="degreeId"
							class="form-control">
							<option value="">-----</option>
							<option value="D01">专科</option>
							<option value="D02">本科</option>
							<option value="D03">硕士</option>
							<option value="D04">博士</option>
							<option value="D05">博士后</option>
						</select> <label>专业</label><select name="majorId" class="form-control">
							<option value="">-----</option>
							<option value="M01">工业工程</option>
							<option value="M02">信息管理与信息系统</option>
							<option value="M03">电子商务</option>
							<option value="M04">会计</option>
							<option value="M05">工商管理</option>
							<option value="M06">市场营销</option>
							<option value="M07">国际金融</option>
							<option value="M08">国际贸易</option>
						</select> <label>审核状态</label> <select class="form-control" name="audit"
							id="audit">
							<option value="0">未审核</option>
							<option value="1">已审核</option>
							<option value="3">全部</option>

						</select>
						<!--  <label>每页显示</label> <select class="form-control" name="pageSize"
							id="pageSize" style="padding: 0px;">
							<c:forEach var="pageSize" items="${pageSizeList }">
								<option value=${pageSize }>${pageSize }</option>
							</c:forEach>
						</select>-->
					</div>
					<div style="margin-top: 15px; margin-left: 0px;">
						<button type="reset" class="btn btn-success form-control">&ensp;重置&ensp;</button>
						<button type="submit" class="btn btn-success form-control">&ensp;查询&ensp;</button>
						<button type="button" class="btn btn-success form-control"
							onclick="queryAll();">&ensp;查询全部&ensp;</button>
					</div>
				</form>
				<hr id="hr" />
			</div>
			<div id="approved-table"
				style="width: 90%; margin-left: none; margin-top: 10px;">
				<label>共查询到<span style="color: red">${approvedsum} </span>条记录
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
							<th>&emsp;&emsp;&emsp;删除</th>
							<th>&emsp;&emsp;&emsp;详情</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="app_users" items="${approvedUserList}">
							<tr>

								<td>${app_users[0]}</td>
								<td>${ app_users[1]}</td>
								<td>${ app_users[2]}</td>
								<td>${ app_users[3]}</td>
								<td>${ app_users[4]}</td>
								<td>${app_users[5]}</td>
								<td>${app_users[6]}</td>
								<td><button onclick="deleteFun(${ app_users[1]});"
										class="btn btn-success form-control">删除</button></td>
								<td>详情</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div id="disapproved-table"
				style="width: 90%; margin-left: none; margin-top: 10px;">
				<label>共查询到<span style="color: red">${disapprovedsum}
				</span>条记录
				</label>
				<form id="disapproved">
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
								<th>&emsp;&emsp;&emsp;审核</th>
								<th>&emsp;&emsp;&emsp;详情</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="dis_users" items="${disapprovedUserList}">
								<tr>

									<td>${dis_users[0]}</td>
									<td><input type="text" name="studNumber"
										value="${ dis_users[1]}"></td>
									<td>${ dis_users[2]}</td>
									<td>${ dis_users[3]}</td>
									<td>${ dis_users[4]}</td>
									<td>${dis_users[5]}</td>
									<td>${dis_users[6]}</td>
									<td><select name="audit_states"><option
												value="1" id="select_audit">通过审核</option>
											<option value="2">不通过</option></select></td>
									<td>详情</td>
								</tr>
							</c:forEach>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td><button type="reset" class="form-control">重置</button></td>
								<td><button type="button" class="form-control"
										onclick="check();">提交</button></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="../baseView/footer.jsp"></jsp:include>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script type="text/javascript">
	function getDatesSession() {

	}

	function queryAll() {
		var pSize = 100;
		var status = document.getElementById("audit").value;
		var aim = "../userManage/findUserWithout?studNumber=&trueName=&entranceDate=&degreeId=&majorId=&audit="+status+"&pageSize="+pSize;
		window.location.assign(aim);
	}
	
	function deleteFun(studNumber) {
		var result =confirm('是否删除此用户');
		if(result){
			var params={};
			params.studNumber = studNumber;
			$.ajax({
				type:"POST",
				async:false,
				url:"../userManage/userDelete.action",
				data:params,
				error:function(){
					alert("失败");
				},
				success:function(date){
					if(date=="success"){
						alert("删除成功");
						queryAll();
					}					
					else{
						alert("用户不存在或用户已被删除");
					}
				}
				
			})
			}
		else
			alert("确认取消删除");
	}
	
	function check(){
		var params =  $('#disapproved').serializeArray();
		$.ajax({
			type:"post",
			async:false,
			url:"../userManage/check",
			data:params,
			error:function(){
				alert("失败");
			},
			success:function(data){
				alert("成功");
				queryAll();
			}
		})
	}
	
	window.onload=function selectStyle(){
		var app_table =document.getElementById("approved-table");
		var dis_table =document.getElementById("disapproved-table");
		if(${approvedsum}=="0"){
			app_table.style.display="none";
		}
		if(${disapprovedsum}=="0"){
			dis_table.style.display="none";
		}
	}
</script>
</html>