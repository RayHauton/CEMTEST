<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="header1">
	<div class="logo">
		<img src="${pageContext.request.contextPath }/img/donation/logo3.png" />
	</div>
	<div class="comment">经济与管理学院校友信息管理系统</div>
	<div class="user">
		<c:choose>
			<c:when test="${sessionScope.user!= null }">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#" style="color: deeppink;"><img
							src="${pageContext.request.contextPath }/img/user.png"
							style="width: 20px; height: 20px;">
							${sessionScope.user.truename }<b class="caret"></b></a>
						<ul role="menu" class="dropdown-menu">
							<li><a href="#" data-toggle="modal"
								data-target="#alterPassword" style="cursor: pointer;">修改密码</a></li>
							<li><a href="javascript:void(0);" data-toggle="modal"
								data-target="#ability-bg"
								onclick="ability_detail('${sessionScope.user.username}');">查看资料</a></li>
							<li><a
								onclick="logout('${pageContext.request.contextPath}','/logout.action','/index.jsp');">注销</a></li>
						</ul></li>
				</ul>

			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath }/login.action"
					style="color: deeppink; margin-right: 10px;">请登录 <img
					src="${pageContext.request.contextPath }/img/mouse-pointer.png"
					style="width: 20px; height: 20px;"></a>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<div class="navBody">
	<nav role="navigation" class="navbar navbar-default">

		<div class="navbar-header">
			<button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
				<span class="sr-only">Toggle navigator</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a href="#" class="navbar-brand">功能导航</a>
		</div>
		<div id="navbarCollapse" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">数据管理<b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath }/alumiAssociation/open_adm.action">校友会信息</a></li>
						<li><a href="${pageContext.request.contextPath }/collegeEvent/show_adm.action">学院事件录</a></li>
						<li><a href="${pageContext.request.contextPath }/majorSet/open_adm.action">学历管理</a></li>
						<li><a href="${pageContext.request.contextPath }/adminSurveySys/open_adm.action">调研信息</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle fontColor1" href="#">公告管理<b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="#">新闻公告</a></li>
						<li><a href="${pageContext.request.contextPath }/donation/open_adm.action">捐款公告</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">系统管理<b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="#">论坛审核</a></li>
						<li><a href="#">祝福模板</a></li>
						<li><a href="${pageContext.request.contextPath }/userManage/open.action">用户管理</a></li>
						<li><a href="${pageContext.request.contextPath }/checkout/open_adm.action">用户审核</a></li>
					</ul>
				</li>
				<li><a href="${pageContext.request.contextPath }">返回普通系统</a></li>
			</ul>
		</div>

	</nav>
</div>
<!-- 修改密码弹出框 -->
<div class="modal fade" id="alterPassword" tabindex="-1" role="dialog"
	aria-labelledby="customModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="customModal">修改密码：</h4>
			</div>
			<form action="" method="post" id="alter_ff">
				<div class="modal-body">
					<input type="hidden" name="userId" id="userId" />
					<div class="form-group">
						<label for="oriPass">旧密码：</label> <input type="text"
							class="form-control" id="oriPass" name="oriPass" required />
					</div>
					<div class="form-group">
						<label for="newPass">新密码：</label> <input type="text"
							class="form-control" id="newPass" name="newPass" required />
					</div>
				</div>
			</form>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-success" onclick="submit();">
					提交</button>
			</div>
		</div>
	</div>
</div>

<!-- 模态框1（Modal） -->
<div class="modal fade" id="ability-bg" tabindex="-1" role="dialog"
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
							<td id=""><input id="ab-username"
								style="width: 100%; height: 100%; border: none; text-align: center;"></td>
						</tr>
						<tr>
							<td>真实姓名</td>
							<td id=""><input id="ab-trueName"
								style="width: 100%; height: 100%; border: none; text-align: center;"></td>
						</tr>
						<tr>
							<td>性别</td>
							<td id=""><input id="ab-sex"
								style="width: 100%; height: 100%; border: none; text-align: center;"></td>
						</tr>
						<tr>
							<td>学号</td>
							<td><input id="ab-studnumber"
								style="width: 100%; height: 100%; border: none; text-align: center;"
								readonly unselectable="on"></td>
						</tr>
						<tr>
							<td>生日</td>
							<td id=""><input id="ab-birth"
								style="width: 100%; height: 100%; border: none; text-align: center;"></td>
						</tr>
						<tr>
							<td>手机号</td>
							<td id=""><input id="ab-mobile"
								style="width: 100%; height: 100%; border: none; text-align: center;"></td>
						</tr>
						<tr>
							<td>Email</td>
							<td id=""><input id="ab-email"
								style="width: 100%; height: 100%; border: none; text-align: center;"></td>
						</tr>
						<tr>
							<td>地址</td>
							<td id=""><input id="ab-address"
								style="width: 100%; height: 100%; border: none; text-align: center;"></td>
						</tr>
						<tr>
							<td>入学日期</td>
							<td id=""><input id="ab-entrancedate"
								style="width: 100%; height: 100%; border: none; text-align: center;"></td>
						</tr>
						<tr>
							<td>毕业日期</td>
							<td id=""><input id="ab-graduateDate"
								style="width: 100%; height: 100%; border: none; text-align: center;"></td>
						</tr>
						<tr>
							<td>学历</td>
							<td id=""><select
								style="width: 60%; height: 100%; border: none; text-align: center; margin-left: 20%"
								id="ab-degree" disabled="true">
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
								style="width: 60%; height: 1000%; border: none; text-align: center; margin-left: 20%"
								disabled="true" id="ab-major">
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
					onclick="update_ability();">修改</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal"
					id="de_close">关闭</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->
</div>


<script type="text/javascript">
	/**
	 * 修改密码控制
	 */
	function submit() {
		if (document.getElementById("oriPass").value == '') {
			window.alert("请填写原始密码");
			return;
		}
		var newPass = document.getElementById("newPass").value;
		if (newPass == '') {
			window.alert("请填写新密码");
			return;
		}
		if (newPass.length<8 || newPass.length>20) {
			window.alert("密码长度在8-20字符之间！");
			return;
		}
		document.getElementById("userId").value = '${sessionScope.user.userId}';
		$
				.ajax({
					type : 'POST',
					url : "/CEMSys/userManage/alterPassword.action",
					data : $("#alter_ff").serialize(),
					async : true,
					error : function() {
						window.alert("出现未知错误！");
					},
					success : function(data) {
						if (data == "succ") {
							window.alert("修改密码成功！");
							window
									.open(
											"${pageContext.request.contextPath}/login/login.jsp",
											"_self");
						}
						if (data == "passSame") {
							window.alert("新旧密码不能相同!");
						}
						if (data == "passError") {
							window.alert("原密码错误！");
						}
					}
				});
	}
</script>
<script src="../js/loginController/loginAndLogout.js"></script>
<script type="text/javascript">
	function ability_detail(username) {
		var params = {};
		params.username = username;
		$
				.ajax({
					type : "post",
					async : false,
					url : "${pageContext.request.contextPath}/userManage/findUser_adm",
					data : params,
					error : function() {
						alert("失败");
					},
					success : function(data) {
						var de = new Array();
						de = data.split("/")
						for (i = 0; i < de.length; i++) {
							switch (i) {
							case 0:
								document.getElementById("ab-username").value = de[i];
								break;
							case 1:
								document.getElementById("ab-trueName").value = de[i];
								break;
							case 2:
								document.getElementById("ab-sex").value = de[i];
								break;
							case 3:
								document.getElementById("ab-studnumber").value = de[i];
								break;
							case 4:
								document.getElementById("ab-birth").value = de[i];
								break;
							case 5:
								document.getElementById("ab-mobile").value = de[i];
								break;
							case 6:
								document.getElementById("ab-email").value = de[i];
								break;
							case 7:
								document.getElementById("ab-address").value = de[i];
								break;
							case 8:
								document.getElementById("ab-entrancedate").value = de[i];
								break;
							case 9:
								document.getElementById("ab-graduateDate").value = de[i];
								break;

							}
						}
						var option1 = document.getElementById("ab-degree").options;
						var size1 = option1.length;
						for (var m = 0; m < size1; m++) {
							if (option1[m].value == de[10]) {
								option1[m].selected = true;
							}
						}
						;

						var option2 = document.getElementById("ab-major").options;
						var size2 = option2.length;
						for (var q = 0; q < size2; q++) {
							if (option2[q].value == de[11]) {
								option2[q].selected = true;
							}
						}
						;

					}
				})
	};

	function update_ability() {
		var params = {};
		params.username = document.getElementById('ab-username').value;
		params.truename = document.getElementById('ab-trueName').value;
		params.sex = document.getElementById('ab-sex').value;
		params.studNumber = document.getElementById('ab-studnumber').value;
		params.birth = document.getElementById('ab-birth').value;
		params.email = document.getElementById('ab-email').value;
		params.mobile = document.getElementById('ab-mobile').value;
		params.address = document.getElementById('ab-address').value;
		params.entranceDate = document.getElementById('ab-entrancedate').value;
		params.graduateDate = document.getElementById('ab-graduateDate').value;
		var degreeIndex = document.getElementById('ab-degree').selectedIndex;
		params.degreeId = document.getElementById('ab-degree').options[degreeIndex].value;
		var majorIndex = document.getElementById('ab-major').selectedIndex;
		/* alert(degreeIndex)		;
		alert(majorIndex)		; */
		params.majorId = document.getElementById('ab-major').options[majorIndex].value;
		/* 	alert(params.degreeId)		;
			alert(params.majorId)		; */

		$
				.ajax({
					type : "post",
					async : false,
					url : "${pageContext.request.contextPath}/userManage/update_ability",
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

						}

					}
				});
	};
</script>

