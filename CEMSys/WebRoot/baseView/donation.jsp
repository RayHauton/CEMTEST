<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.cem.util.BaseDataUtil" %>
<%
	request.setAttribute("pageSizeList", BaseDataUtil.getPageSizes());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/view_set/donation.css">
<title>捐赠实时公告系统</title>
</head>
<body>
	<div class="header">
		<div class="logo">
			<img alt="" src="../img/donation/logo3.png">
		</div>
		<div class="title">
			经管院校友捐赠实时公告系统
		</div>
		<div class="head_right">
			<div class="head_right_top">
				<img alt="" src="../img/donation/return.png">
				<span style="font-size:12px;">返回主页</span>
			</div>
			<div class="head_right_bottom">
				<span>林华栋林华栋</span>
				<img alt="" src="../img/donation/user.png">
			</div>
		</div>
	</div>
	<div class="contentBody">
		<div class="searchDiv">
			<div class="searchLogo">
				<img alt="" src="../img/donation/search1.png">
			</div>
			<form action="${pageContext.request.contextPath }/donation/show.action" method="post">
				<div class="searchContent">
					<font style="letter-spacing: 1px;">
					捐&nbsp;赠&nbsp;人</font>：
					<input type="text" class="form-control" name="truename" id="truename" value="${queryVo.truename }"/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					捐赠用途：
					<input type="text" class="form-control" name="donationProject" id="donationProject" value="${queryVo.truename }"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					捐赠物品类别：
					<select class="form-control" name="donationType" id="donationType"
					 style="padding: 0;font-size: 12px;">&nbsp;&nbsp;&nbsp;&nbsp;
						<option value="">请选择</option>
						<option value="0">基金</option>
						<option value="1">其他</option>	
					</select><br>
					<!-- 这里写上js效果会好一些，不会看出下拉框被选的值有很明显的跳动 -->
					<script type="text/javascript">
						var options = document.getElementById("donationType").options;
						var size = options.length;
						for(var i=0;i<size;i++){
							if(options[i].value=='${queryVo.donationType}'){
								options[i].selected=true;
							}
						}
					</script>
					捐赠时间：
					<input type="date" class="form-control" name="foredate" id="foredate" value="${queryVo.foredate }"
					style="font-size: 12px;padding: 0;"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font style="letter-spacing: 2px;">
					至</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="date" class="form-control" name="afterdate" id="afterdate" value="${queryVo.afterdate }"
					 style="font-size: 12px;padding: 0;"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font style="letter-spacing: 8px;">每页显示</font>:
					<select class="form-control" name="pageSize" id="pageSize" style="padding: 0px;">
						<c:forEach var="pageSize" items="${pageSizeList }">
							<option>${pageSize }</option>						
						</c:forEach>
					</select>
				</div>
				<script type="text/javascript">
					var options = document.getElementById("pageSize").options;
					var size = options.length;
					for(var i=0;i<size;i++){
						if(options[i].value=='${queryVo.pageSize}'){
							options[i].selected=true;
						}
					}
				</script>
				<div class="btnGroup">
					<button type="reset" class="searchBtn btn btn-info" style="">重置</button>
					<button type="submit" class="searchBtn btn btn-success" style="">查询</button>
				</div>
			</form>
			
		</div>
		<table class="table table-bordered table-striped" cellpadding="0" cellspacing="0">
			<thead>
				<th>捐赠人</th>
				<th>捐赠的项目</th>
				<th>捐赠种类</th>
				<th>捐赠明细</th>
				<th>捐赠时间</th>
			</thead>
			<tbody>
				<c:forEach var="donation" items="${donationList }" >
					<tr>
						<td>${donation.truename }</td>
						<td>${donation.donationProject }</td>
						<td>${donation.donationType }</td>
						<td>${donation.donationItem }</td>
						<td>${donation.donationDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="dividePage">
			
		</div>
	</div>
</body>
</html>