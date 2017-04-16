<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="header1">
	<div class="logo">
		<img src="${pageContext.request.contextPath }/img/donation/logo3.png"/>
	</div>
	<div class="comment">
		经济与管理学院校友信息管理系统
	</div>
	<div class="user">
		<c:choose>
			<c:when test="${sessionScope.user!= null }">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#" style="color:deeppink;"><img src="${pageContext.request.contextPath }/img/user.png" style="width:20px;height:20px;">
						${sessionScope.user.truename }<b class="caret"></b></a>
						<ul role="menu" class="dropdown-menu">
							<li><a href="#" data-toggle="modal" data-target="#alterPassword" style="cursor:pointer;">修改密码</a></li>
							<li><a href="#">查看资料</a></li>
							<li><a onclick="logout('${pageContext.request.contextPath}','/logout.action','/index.jsp');">注销</a></li>
						</ul>
					</li>
				</ul>
				
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath }/login.action"
				 style="color:deeppink;margin-right: 10px;">请登录
				 <img src="${pageContext.request.contextPath }/img/mouse-pointer.png" style="width:20px;height:20px;"></a>
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
<div class="modal fade" id="alterPassword" tabindex="-1" role="dialog" aria-labelledby="customModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="customModal">
					修改密码：
				</h4>
			</div>
			<form action="" method="post" id="alter_ff">
				<div class="modal-body">
					<input type="hidden" name="userId" id="userId"/>
					<div class="form-group">
						<label for="oriPass">旧密码：</label>
						<input type="text" class="form-control" id="oriPass" name="oriPass" required/>
					</div>
					<div class="form-group">
						<label for="newPass">新密码：</label>
						<input type="text" class="form-control" id="newPass" name="newPass" required/>
					</div>
				</div>
			</form>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-success" onclick="submit();">
					提交
				</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
/**
 * 修改密码控制
 */
	function submit(){
		if(document.getElementById("oriPass").value==''){
			window.alert("请填写原始密码");
			return;
		}
		var newPass = document.getElementById("newPass").value;
		if(newPass==''){
			window.alert("请填写新密码");
			return;
		}
		if(newPass.length<8 || newPass.length>20){
			window.alert("密码长度在8-20字符之间！");
			return;
		}
		document.getElementById("userId").value='${sessionScope.user.userId}';
		$.ajax({
			type:'POST',
			url:"/CEMSys/userManage/alterPassword.action",
			data:$("#alter_ff").serialize(),
			async:true,
			error:function(){
				window.alert("出现未知错误！");
			},
			success:function(data){
				if(data=="succ"){
					window.alert("修改密码成功！");
					window.open("${pageContext.request.contextPath}/login/login.jsp","_self");
				}
				if(data=="passSame"){
					window.alert("新旧密码不能相同!");
				}
				if(data=="passError"){
					window.alert("原密码错误！");
				}
			}
		});
}
</script>
<script src="../js/loginController/loginAndLogout.js"></script>