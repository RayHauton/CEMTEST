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
			<div id="searchTermA">
				<hr id="hr" />
				<div class="searchLogo">
					<img alt="" src="../img/donation/search1.png">
				</div>
				<form action="../userManage/findUsers" method="get">
					<div style="margin-bottom: 13px">
						<label>学号</label> <input class="form-control" placeholder="输入学号"
							name="studNumber" id="studNumber"> <label>姓名</label> <input
							class="form-control" placeholder="输入姓名" name="truename"
							id="truename"> <label>入学时间</label> <select
							class="form-control" name="entranceDate" id="entranceDate">
							<option value=""></option>
							<option value="volvo">Volvo</option>
							<option value="saab">Saab</option>
							<option value="opel">Opel</option>
							<option value="audi">Audi</option>

						</select> <br /> <label>学位</label><select name="degreeId"
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
							<option value="0">未审核</option>

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
										<button type="submit" class="btn btn-success form-control">&ensp;查询&ensp;</button>
									</td>
									<td>
										<button type="button" class="btn btn-success form-control"
											onclick="queryAll();">&ensp;查询全部&ensp;</button>
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
							<th>&emsp;入学时间</th>
							<th>&emsp;毕业时间</th>
							<th>&emsp;&emsp;&emsp;&emsp;删除</th>
							<th>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;详情</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="app_users" items="${approvedUserList}">
							<tr>

								<td>${app_users[0]}</td>
								<td>${ app_users[1]}</td>
								<td>${ app_users[2]}</td>
								<%-- <td>${ app_users[3]}</td>
								<td>${ app_users[4]}</td> --%>
								<td>${app_users[5]}</td>
								<td>${app_users[6]}</td>
								<td><button onclick="deleteFun(${ app_users[1]});"
										class="btn btn-success form-control"
										style="width: 77px; background-color: #FF2D2D;">删除</button></td>
								<td><button class="btn btn-success form-control"
										data-toggle="modal" data-target="#detail-bg"
										onclick="detail(${ app_users[1]});">详情</button></td>
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
			<div id="disapproved-table"
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
									<%-- <td>${ dis_users[3]}</td>
									<td>${ dis_users[4]}</td> --%>
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
			</div>
		</div>
	</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="detail-bg" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">${app_users[0]}</h4>
				</div>
				<div class="modal-body">
					<table class="table table-bordered table-striped">
						<tr>
							<td>用户名</td>
							<td id="username"></td>
						</tr>
						<tr>
							<td>真实姓名</td>
							<td id="trueName"></td>
						</tr>
						<tr>
							<td>性别</td>
							<td id="sex"></td>
						</tr>
						<tr>
							<td>学号</td>
							<td id="studnumber"></td>
						</tr>
						<tr>
							<td>生日</td>
							<td id="birth"></td>
						</tr>
						<tr>
							<td>手机号</td>
							<td id="mobile"></td>
						</tr>
						<tr>
							<td>Email</td>
							<td id="email"></td>
						</tr>
						<tr>
							<td>地址</td>
							<td id="address"></td>
						</tr>
						<tr>
							<td>入学日期</td>
							<td id="entrancedate"></td>
						</tr>
						<tr>
							<td>毕业日期</td>
							<td id="graduateDate"></td>
						</tr>
						<<%-- tr> <td>学历</td> <td id="degree">${userDetail.degree}</td>
						</tr> <tr> <td>专业</td> <td id="major">${userDetail.major}</td>
						</tr> --%>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
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
<script type="text/javascript">
function queryAll() {
	var pSize = document.getElementById("pageSize").value;
	var status = document.getElementById("audit").value;
	var aim = "../userManage/findUserWithout?studNumber=&trueName=&entranceDate=&degreeId=&majorId=&audit="+status+"&pageSize="+pSize;
	window.location.assign(aim);
};

function lastpage(){
	var last = parseInt('${userManageVo.pageIndex}')-1;
	var aim  = "../userManage/${userManageVo.accessMode }?studNumber=${userManageVo.studNumber}&truename=${userManageVo.truename}&entranceDate=${userManageVo.entranceDate}&majorId=${userManageVo.majorId}&degreeId=${userManageVo.degreeId}&audit=${userManageVo.audit}&pageSize=${userManageVo.pageSize}&pageIndex="+last;
	window.location.assign(aim);
};

function nextpage(){
	var next = parseInt('${userManageVo.pageIndex}')+1;
	var aim  = "../userManage/${userManageVo.accessMode }?studNumber=${userManageVo.studNumber}&truename=${userManageVo.truename}&entranceDate=${userManageVo.entranceDate}&majorId=${userManageVo.majorId}&degreeId=${userManageVo.degreeId}&audit=${userManageVo.audit}&pageSize=${userManageVo.pageSize}&pageIndex="+next;
	window.location.assign(aim);
};

var options = document.getElementById("pageSize").options;
var size = options.length;
for(var i=0;i<size;i++){
	if(options[i].value=='${userManageVo.pageSize}'){
		options[i].selected=true;
	}
};

var options = document.getElementById("majorId").options;
var size = options.length;
for(var i=0;i<size;i++){
	if(options[i].value=='${userManageVo.majorId}'){
		options[i].selected=true;
	}
};

var options = document.getElementById("degreeId").options;
var size = options.length;
for(var i=0;i<size;i++){
	if(options[i].value=='${userManageVo.degreeId}'){
		options[i].selected=true;
	}
};

var options = document.getElementById("audit").options;
var size = options.length;
for(var i=0;i<size;i++){
	if(options[i].value=='${userManageVo.audit}'){
		options[i].selected=true;
	}
};

var studNumber = document.getElementById("studNumber");
if('${userManageVo.studNumber}'!=null )
	studNumber.value = '${userManageVo.studNumber}';
	
var truename = document.getElementById("truename");
if('${userManageVo.truename}'!=null )
	truename.value = '${userManageVo.truename}';

	
window.onload=function selectStyle(){
	var app_table =document.getElementById("approved-table");
	var dis_table =document.getElementById("disapproved-table");
	var lastpage1  = document.getElementById("lastPage1");
	var lastpage2  = document.getElementById("lastPage2");
	var nextpage1 = document.getElementById("nextPage1");
	var nextpage2 = document.getElementById("nextPage2");
	if('${approvedsum}'=="0"){
		app_table.style.display="none";
	}
	if('${disapprovedsum}'=="0"){
		dis_table.style.display="none";
	}
	if('${userManageVo.pageIndex}'==1){
		lastpage1.style.display = "none";
		lastpage2.style.display = "none";
		
	}
	if('${userManageVo.pageIndex}'=='${userManageVo.pageCount}'){
		nextpage1.style.display = "none";
		nextpage2.style.display = "none";
		
	}
};
</script>
</html>