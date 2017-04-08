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
<div class="navBody" id="navBody">
	<nav role="navigation" class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
				<span class="sr-only">Toggle navigator</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a href="#" class="navbar-brand">系统导航</a>
		</div>
		<div id="navbarCollapse" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">个人信息<b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu" id="select">
						<li><a href="${pageContext.request.contextPath }/infoSys/open.action">基础信息</a></li>
						<li><a href="${pageContext.request.contextPath }/infoSys/open.action">职业信息</a></li>
						<li><a href="${pageContext.request.contextPath }/infoSys/open.action">工作待遇</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle fontColor1" href="#">调研问卷<b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu" id="survey"> 
						<li><a href="${pageContext.request.contextPath }/surveySys/open?SelfabilityqualityHref" id="SelfabilityqualityHref">个人能力品质</a></li>
						<li><a href="${pageContext.request.contextPath }/surveySys/open?MajorabilitycultivationqualityHref" id="MajorabilitycultivationqualityHref">专业能力培养</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">返校服务<b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="http://cem.nuaa.edu.cn/show11769449.htm">返校指南</a></li>
						<li><a href="${pageContext.request.contextPath }/baseView/accommodation.jsp">周边住宿</a></li>
						<li><a href="http://alumni.nuaa.edu.cn/a/bszn/183.html">办理成绩单</a></li>
						<li><a href="${pageContext.request.contextPath }/baseView/appointment.jsp">参观预约</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">校友快讯<b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="#">招聘信息</a></li>
						<li><a href="http://cem.nuaa.edu.cn/list11710910.htm">校友风采</a></li>
						<li><a href="http://cem.nuaa.edu.cn/list11710909.htm">新闻公告</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">校友联络<b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="#">校友会</a></li>
						<li><a href="#">校友联络</a></li>
						<li><a href="${pageContext.request.contextPath }/forum/f/1">校友发声</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">校友捐赠<b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="http://edf.nuaa.edu.cn/a/way/">捐赠指南</a></li>
						<li><a href="${pageContext.request.contextPath }/donation/open.action">捐赠公示</a></li>
					</ul>
				</li>
				<li><a href="${pageContext.request.contextPath }/collegeEvent/show.action">学院事件录</a></li>
				<li><a href="${pageContext.request.contextPath }/userManage/openClassmatesView.action">查找我的同学</a></li>
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