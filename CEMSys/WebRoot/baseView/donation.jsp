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
			<form action="">
				<div class="searchContent">
					<font style="letter-spacing: 1px;">捐&nbsp;赠&nbsp;人</font>：<input type="text" class="form-control"/>&nbsp;&nbsp;&nbsp;&nbsp;
					捐赠用途：<input type="text" class="form-control"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					捐赠物品类别：<select class="form-control" style="padding: 0;font-size: 12px;">&nbsp;&nbsp;&nbsp;&nbsp;
					<option>请选择</option>
					<option>基金</option>
					<option>其他</option>	
					</select><br>
					捐赠时间：<input type="date" class="form-control" style="font-size: 10px;"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font style="letter-spacing: 2px;">至</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="date" class="form-control" style="font-size: 12px;"/>&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;<font style="letter-spacing: 7px;">每页显示</font>:
					<select class="form-control" style="padding: 0px;">
						<c:forEach var="pageSize" items="${pageSizeList }">
							<option>${pageSize }</option>						
						</c:forEach>
					</select>
				</div>
				<div class="btnGroup">
					<button type="reset" class="searchBtn btn btn-info" style="">重置</button>
					<button type="button" class="searchBtn btn btn-success" style="">查询</button>
				</div>
			</form>
			
		</div>
		<table class="table table-bordered table-striped" cellpadding="0" cellspacing="0">
			<thead>
				<th>捐赠人</th>
				<th>入学年份</th>
				<th>所在专业</th>
				<th>捐赠的项目</th>
				<th>捐赠种类</th>
				<th>捐赠明细</th>
				<th>捐赠时间</th>
			</thead>
			<tbody>
				<tr>
					<td>林华栋</td>
					<td>2014</td>
					<td>信息管理与信息系统</td>
					<td>学院建设</td>
					<td>人民币</td>
					<td>1000元</td>
					<td>2017-02-24</td>
				</tr>
				<tr>
					<td>林华栋</td>
					<td>2014</td>
					<td>信息管理与信息系统</td>
					<td>学院建设</td>
					<td>人民币</td>
					<td>1000元</td>
					<td>2017-02-24</td>
				</tr>
				<tr>
					<td>林华栋</td>
					<td>2014</td>
					<td>信息管理与信息系统</td>
					<td>学院建设</td>
					<td>人民币</td>
					<td>1000元</td>
					<td>2017-02-24</td>
				</tr>
				<tr>
					<td>林华栋</td>
					<td>2014</td>
					<td>信息管理与信息系统</td>
					<td>学院建设</td>
					<td>人民币</td>
					<td>1000元</td>
					<td>2017-02-24</td>
				</tr>
				<tr>
					<td>林华栋</td>
					<td>2014</td>
					<td>信息管理与信息系统</td>
					<td>学院建设</td>
					<td>人民币</td>
					<td>1000元</td>
					<td>2017-02-24</td>
				</tr>
				<tr>
					<td>林华栋</td>
					<td>2014</td>
					<td>信息管理与信息系统</td>
					<td>学院建设</td>
					<td>人民币</td>
					<td>1000元</td>
					<td>2017-02-24</td>
				</tr>
				<tr>
					<td>林华栋</td>
					<td>2014</td>
					<td>信息管理与信息系统</td>
					<td>学院建设</td>
					<td>人民币</td>
					<td>1000元</td>
					<td>2017-02-24</td>
				</tr>
				<tr>
					<td>林华栋</td>
					<td>2014</td>
					<td>信息管理与信息系统</td>
					<td>学院建设</td>
					<td>人民币</td>
					<td>1000元</td>
					<td>2017-02-24</td>
				</tr>
				<tr>
					<td>林华栋</td>
					<td>2014</td>
					<td>信息管理与信息系统</td>
					<td>学院建设</td>
					<td>人民币</td>
					<td>1000元</td>
					<td>2017-02-24</td>
				</tr>
			</tbody>
		</table>
		<div class="dividePage">
			
		</div>
	</div>
</body>
</html>