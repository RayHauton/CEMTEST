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
			<div id="searchTermA">
				<hr id="hr" />
				<div class="searchLogo">
					<img alt="" src="../img/donation/search1.png">
				</div>
				<form action="../userManage/findUsers_adm" method="post">
					<div style="margin-bottom: 13px">
						<label>学号</label> <input class="form-control" placeholder="输入学号"
							name="studNumber" id="studNumber"> <label>姓名</label> <input
							class="form-control" placeholder="输入姓名" name="truename"
							id="truename"> <label>入学时间</label> <input type="text"
							class="form-control" placeholder="输入入学时间" name="entranceDate" id="entranceDate">

						<br /> <label>学位</label><select name="degreeId"
							class="form-control" id="degreeId">
							<option value="">-----</option>
							<option value="D01">专科</option>
							<option value="D02">本科</option>
							<option value="D03">硕士</option>
							<option value="D04">博士</option>
							<option value="D05">博士后</option>
						</select> <label>专业</label><select name="majorId" class="form-control"
							id="majorId">
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
							<!-- <option value="3">全部</option> -->
							<option value="1">已审核</option>
							<!-- <option value="0">未审核</option> -->

						</select>
					</div>
					<div style="margin-top: 15px; margin-left: 0px;">
						<table style="margin-left: 112px;">
							<tbody>
								<tr>
									<td>
										<button type="reset" class="btn btn-success form-control">&ensp;重置&ensp;</button>
									</td>
									<td>
										<button id="SimpleQueryButton" type="submit"
											class="btn btn-success form-control">&ensp;查询&ensp;</button>
									</td>
									<td>
										<button id="AllQueryButton" type="button"
											class="btn btn-success form-control" onclick="queryAll();">&ensp;查询全部&ensp;</button>
									</td>
									<td>
										<button type="button" class="btn btn-success form-control"
											style="background-color: #2894FF; border: none;"
											onclick="downloadUsers();">导出全部用户信息</button>
									</td>
									<td style="margin: 30px;">
										<p style="margin-top: 16px; margin-left: 13px;">每页显示
										<p>
									</td>
									<td><select class="btn btn-success form-control"
										name="pageSize" id="pageSize"
										style="padding: 0px; width: 77px;">
											<c:forEach var="pageSize" items="${pageSizeList }">
												<option value=${pageSize }>${pageSize }</option>
											</c:forEach>

									</select></td>
								</tr>
							</tbody>
						</table>
					</div>
				</form>
				<hr id="hr" />
			</div>
			<div id="approved-table"
				style="width: 98%; margin-left: 1%; margin-top: 10px;">
				<span>共<font id="approvedsum" style="color: red;">${approvedsum}
				</font>条记录
				</span>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>&emsp;姓名</th>
							<th>&emsp;&emsp;&emsp;学号</th>
							<th>&emsp;专业</th>
							<!-- <th>&emsp;&emsp;&emsp;电话</th>
							<th>&emsp;&emsp;&emsp;&emsp;&emsp;Email</th> -->
							<th>&emsp;&emsp;入学时间</th>
							<th>&emsp;&emsp;毕业时间</th>
							<th>&emsp;&emsp;&emsp;&emsp;详情</th>
							<th>&emsp;&emsp;&emsp;&emsp;删除</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="app_users" items="${approvedUserList}">
							<tr>

								<td>${app_users[1]}</td>
								<td>${ app_users[2]}</td>
								<td>${ app_users[3]}</td>
								<%-- <td>${ app_users[3]}</td>
								<td>${ app_users[4]}</td> --%>
								<td>${app_users[6]}</td>
								<td>${app_users[7]}</td>
								<td><button class="btn btn-success form-control"
										data-toggle="modal" data-target="#detail-bg"
										onclick="detail('${ app_users[0]}');"
										style="margin: 0px; border: none; width: 77px; background-color: #2894FF;">详情</button></td>
								<td><button onclick="deleteFun('${ app_users[0]}');"
										class="btn btn-success form-control"
										style="margin: 0px; width: 77px; background-color: #FF2D2D; border: none;">删除</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="record">
					<span><a id="lastPage1" onclick="lastpage();"
						href="javascript:void(0);">上一页</a> 当前是第<font>${userManageVo.pageIndex }</font>页<a
						id="nextPage1" onclick="nextpage();" href="javascript:void(0);">下一页</a>共<font>${userManageVo.pageCount }</font>页
					</span>
				</div>

			</div>
			<%-- <div id="disapproved-table"
				style="width: 98%; margin-left: 1%; margin-top: 10px;">
				<span>共<font id="disapprovedsum" style="color: red;">${disapprovedsum}
				</font>条记录
				</span>
				<form id="disapproved">
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>&emsp;姓名</th>
								<th>&emsp;&emsp;&emsp;学号</th>
								<th>&emsp;专业</th>
								<!-- <th>&emsp;&emsp;&emsp;电话</th>
								<th>&emsp;&emsp;&emsp;&emsp;Email</th> -->
								<th>&emsp;&emsp;&emsp;入学时间</th>
								<th>&emsp;&emsp;&emsp;毕业时间</th>
								<th>&emsp;&emsp;&emsp;审核</th>
								<th>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;详情</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="dis_users" items="${disapprovedUserList}">
								<tr>

									<td>${dis_users[0]}</td>
									<td><input type="text" name="studNumber"
										value="${ dis_users[1]}" style="width: 90px;"></td>
									<td>${ dis_users[2]}</td>
									<td>${ dis_users[3]}</td>
									<td>${ dis_users[4]}</td>
									<td>${dis_users[5]}</td>
									<td>${dis_users[6]}</td>
									<td><select name="audit_states"><option value="1"
												id="select_audit">通过审核</option>
											<option value="2">不通过</option></select></td>
									<td><button class="btn btn-success form-control"
											data-toggle="modal" data-target="#detail-bg" type="button"
											onclick="detail(${ dis_users[1]});">详情</button></td>
								</tr>
							</c:forEach>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td><button type="reset" class="form-control"
										style="width: 90px;">重置</button></td>
								<td><button type="button" class="form-control"
										onclick="check();" style="width: 90px;">提交</button></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</form>
				<div class="record">
					<span><a id="lastPage2" onclick="lastpage();"
						href="javascript:void(0);">上一页</a> 当前是第<font>${userManageVo.pageIndex }</font>页<a
						id="nextPage2" onclick="nextpage" href="javascript:void(0);">下一页</a>共<font>${userManageVo.pageCount }</font>页
				</div>
			</div> --%>
		</div>
	</div>
	<!-- 模态框1（Modal） -->
	<div class="modal fade" id="detail-bg" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 500px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<%-- <h4 class="modal-title" id="myModalLabel">${app_users[0]}</h4> --%>
				</div>
				<div class="modal-body" style="margin-left: 50px; padding: 0px;">
					<form action="" id="update_detail">
						<table class="table table-bordered table-striped"
							style="width: 400px;">
							<tr>
								<td>用户名</td>
								<td id=""><input id="de-username"
									style="width: 100%; height: 100%; border: none; text-align: center;"
									readonly unselectable="on"></td>
							</tr>
							<tr>
								<td>真实姓名</td>
								<td id=""><input id="de-trueName"
									style="width: 100%; height: 100%; border: none; text-align: center;"></td>
							</tr>
							<tr>
								<td>性别</td>
								<td id=""><input id="de-sex"
									style="width: 100%; height: 100%; border: none; text-align: center;"></td>
							</tr>
							<tr>
								<td>学号</td>
								<td><input id="de-studnumber"
									style="width: 100%; height: 100%; border: none; text-align: center;"></td>
							</tr>
							<tr>
								<td>生日</td>
								<td id=""><input id="de-birth"
									style="width: 100%; height: 100%; border: none; text-align: center;"></td>
							</tr>
							<tr>
								<td>手机号</td>
								<td id=""><input id="de-mobile"
									style="width: 100%; height: 100%; border: none; text-align: center;"></td>
							</tr>
							<tr>
								<td>Email</td>
								<td id=""><input id="de-email"
									style="width: 100%; height: 100%; border: none; text-align: center;"></td>
							</tr>
							<tr>
								<td>地址</td>
								<td id=""><input id="de-address"
									style="width: 100%; height: 100%; border: none; text-align: center;"></td>
							</tr>
							<tr>
								<td>入学日期</td>
								<td id=""><input id="de-entrancedate"
									style="width: 100%; height: 100%; border: none; text-align: center;"></td>
							</tr>
							<tr>
								<td>毕业日期</td>
								<td id=""><input id="de-graduateDate"
									style="width: 100%; height: 100%; border: none; text-align: center;"></td>
							</tr>
							<tr>
								<td>学历</td>
								<td id=""><select
									style="width: 60%; height: 100%; border: none; text-align: center;"
									 id="de-degree">
										<option value="">-----</option>
										<option value="D01">专科</option>
										<option value="D02">本科</option>
										<option value="D03">硕士</option>
										<option value="D04">博士</option>
										<option value="D05">博士后</option>
								</select></td>
							</tr>
							<tr>
								<td>专业</td>
								<td id=""><select 
									style="width: 60%; height: 1000%; border: none; text-align: center;"
									id="de-major">
										<option value="">-----</option>
										<option value="M01">工业工程</option>
										<option value="M02">信息管理与信息系统</option>
										<option value="M03">电子商务</option>
										<option value="M04">会计</option>
										<option value="M05">工商管理</option>
										<option value="M06">市场营销</option>
										<option value="M07">国际金融</option>
										<option value="M08">国际贸易</option>
								</select></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary"
						style="background-color: #ee7700; border: none;"
						onclick="update_detail();">修改</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal"
						id="de_close">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<jsp:include page="../baseView/footer.jsp"></jsp:include>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/userManage.js"></script>
<script src="../js/loginController/loginAndLogout.js"></script>
<script type="text/javascript">
	function update_detail() {
		var params = {};
		params.username = document.getElementById('de-username').value;
		params.truename = document.getElementById('de-trueName').value;
		params.sex = document.getElementById('de-sex').value;
		params.studNumber = document.getElementById('de-studnumber').value;
		params.birth = document.getElementById('de-birth').value;
		params.email = document.getElementById('de-email').value;
		params.mobile = document.getElementById('de-mobile').value;
		params.address = document.getElementById('de-address').value;
		params.entranceDate = document.getElementById('de-entrancedate').value;
		params.graduateDate = document.getElementById('de-graduateDate').value;
		var degreeIndex = document.getElementById('de-degree').selectedIndex; 
		params.degreeId = document.getElementById('de-degree').options[degreeIndex].value; 
		var majorIndex = document.getElementById('de-major').selectedIndex; 
		/* alert(degreeIndex)		;
		alert(majorIndex)		; */
		params.majorId = document.getElementById('de-major').options[majorIndex].value;
	/* 	alert(params.degreeId)		;
		alert(params.majorId)		; */
		
		$.ajax({
			type : "post",
			async : false,
			url : "../userManage/update_adm",
			data : params,
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
			},
			success : function(data) {
				if (data == "fail") {
					alert("修改失败");
				} else {
					document.getElementById('de_close').click();
					var accessMo = '${userManageVo.accessMode }';
					if (accessMo == "findUsers") {
						document.getElementById('SimpleQueryButton').click();
					} else {
						document.getElementById('AllQueryButton').click();
					}

				}

			}
		}); 
	};
	function deleteFun(username) {
		var result = confirm('是否删除此用户');
		if (result) {
			var params = {};
			params.username = username;
			$.ajax({
				type : "POST",
				async : false,
				url : "../userManage/userDelete_adm.action",
				data : params,
				error : function() {
					alert("失败");
				},
				success : function(date) {
					if (date == "success") {
						alert("删除成功");
						var accessMo = '${userManageVo.accessMode }';
						if (accessMo == "findUsers") {
							document.getElementById('SimpleQueryButton').click();
						} else {
							document.getElementById('AllQueryButton').click();
						}
					} else {
						alert("用户不存在或用户已被删除");
					}
				}

			})
		}
	};
	

	function queryAll() {
		var pSize = document.getElementById("pageSize").value;
		var status = document.getElementById("audit").value;
		var aim = "../userManage/findUserWithout_adm?studNumber=&trueName=&entranceDate=&degreeId=&majorId=&audit="
				+ status + "&pageSize=" + pSize;
		window.location.assign(aim);
	};

	function lastpage() {
		var last = parseInt('${userManageVo.pageIndex}') - 1;
		var aim = "../userManage/${userManageVo.accessMode }_adm?studNumber=${userManageVo.studNumber}&truename=${userManageVo.truename}&entranceDate=${userManageVo.entranceDate}&majorId=${userManageVo.majorId}&degreeId=${userManageVo.degreeId}&audit=${userManageVo.audit}&pageSize=${userManageVo.pageSize}&pageIndex="
				+ last;
		window.location.assign(aim);
	};

	function nextpage() {
		var next = parseInt('${userManageVo.pageIndex}') + 1;
		var aim = "../userManage/${userManageVo.accessMode }_adm?studNumber=${userManageVo.studNumber}&truename=${userManageVo.truename}&entranceDate=${userManageVo.entranceDate}&majorId=${userManageVo.majorId}&degreeId=${userManageVo.degreeId}&audit=${userManageVo.audit}&pageSize=${userManageVo.pageSize}&pageIndex="
				+ next;
		window.location.assign(aim);
	};

	var options = document.getElementById("pageSize").options;
	var size = options.length;
	for (var i = 0; i < size; i++) {
		if (options[i].value == '${userManageVo.pageSize}') {
			options[i].selected = true;
		}
	};

	var options = document.getElementById("majorId").options;
	var size = options.length;
	for (var i = 0; i < size; i++) {
		if (options[i].value == '${userManageVo.majorId}') {
			options[i].selected = true;
		}
	};

	var options = document.getElementById("degreeId").options;
	var size = options.length;
	for (var i = 0; i < size; i++) {
		if (options[i].value == '${userManageVo.degreeId}') {
			options[i].selected = true;
		}
	};

	var options = document.getElementById("audit").options;
	var size = options.length;
	for (var i = 0; i < size; i++) {
		if (options[i].value == '${userManageVo.audit}') {
			options[i].selected = true;
		}
	};

	var studNumber = document.getElementById("studNumber");
	if ('${userManageVo.studNumber}' != null)
		studNumber.value = '${userManageVo.studNumber}';

	var truename = document.getElementById("truename");
	if ('${userManageVo.truename}' != null)
		truename.value = '${userManageVo.truename}';
		
	var truename = document.getElementById("entranceDate");
	if ('${userManageVo.entranceDate}' != null)
		truename.value = '${userManageVo.entranceDate}';

	window.onload = function selectStyle() {
		var app_table = document.getElementById("approved-table");
		/* var dis_table =document.getElementById("disapproved-table"); */
		var lastpage1 = document.getElementById("lastPage1");
		var nextpage1 = document.getElementById("nextPage1");
		/* var lastpage2  = document.getElementById("lastPage2");
		var nextpage2 = document.getElementById("nextPage2"); */
		if ('${approvedsum}' == "0") {
			app_table.style.display = "none";
		}
		/* if('${disapprovedsum}'=="0"){
			dis_table.style.display="none";
		} */
		if ('${userManageVo.pageIndex}' == 1) {
			lastpage1.style.display = "none";
			/* lastpage2.style.display = "none"; */

		}
		if ('${userManageVo.pageIndex}' == '${userManageVo.pageCount}') {
			nextpage1.style.display = "none";
			/* nextpage2.style.display = "none"; */

		}
	};
</script>
</html>