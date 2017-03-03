<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="header1">
	<div class="logo">
		<img src="../img/donation/logo3.png"/>
	</div>
	<div class="comment">
		经济与管理学院校友信息管理系统
	</div>
	<div class="user">
		<ul class="nav navbar-nav">
			<li class="dropdown"><a data-toggle="dropdown"
				class="dropdown-toggle" href="#" style="color:deeppink;"><img src="../img/user.png" style="width:20px;height:20px;">
				不知道栋不知道栋<b class="caret"></b></a>
				<ul role="menu" class="dropdown-menu">
					<li><a href="#">修改密码</a></li>
					<li><a href="#">查看资料</a></li>
					<li><a href="#">注销</a></li>
				</ul>
			</li>
		</ul>
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
			<a href="#" class="navbar-brand">系统导航</a>
		</div>
		<div id="navbarCollapse" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">个人信息<b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="#">基础信息</a></li>
						<li><a href="#">职业信息</a></li>
						<li><a href="#">工作待遇</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle fontColor1" href="#">调研问卷<b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="#">个人能力品质</a></li>
						<li><a href="#">专业能力培养</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">返校服务<b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="#">返校指南</a></li>
						<li><a href="#">周边住宿</a></li>
						<li><a href="#">办理成绩单</a></li>
						<li><a href="#">参观预约</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">校友快讯<b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="#">招聘信息</a></li>
						<li><a href="#">校友风采</a></li>
						<li><a href="#">新闻公告</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">校友联络<b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="#">校友会</a></li>
						<li><a href="#">校友联络</a></li>
						<li><a href="#">校友发声</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">校友捐赠<b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="#">捐赠指南</a></li>
						<li><a href="${pageContext.request.contextPath }/donation/open.action">捐赠公示</a></li>
					</ul>
				</li>
				<li><a href="#">学院事件录</a></li>
			</ul>
		</div>
	</nav>
</div>
