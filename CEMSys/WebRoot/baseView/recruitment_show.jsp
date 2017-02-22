<!-- 
	create by linhd;
	2017/2/19
	招聘信息展示界面
 -->
<%@page import="com.cem.util.BaseDataUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setAttribute("pageSizeList", BaseDataUtil.getPageSizes());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/view_set/recruitment_show.css">
<title>招聘信息查看</title>
</head>
<body>
	<div class="outer">
		<div class="head">
			<div class="imgDiv">
				<img alt="" src="../img/discover.png">
			</div>
			<span>招聘信息一览</span>
		</div>
		<div class="searchDiv">
			<span class="divideSpan">每页显示</span>&nbsp;
			<select class="pgszSlkt">
				<option>请选择</option>
				<c:forEach var="pageSize" items="${pageSizeList }">
					<option>${pageSize }</option>
				</c:forEach>
			</select>&nbsp;条记录
			<button onclick="javascript:openSearchDialog();" id="searchBtn" class="searchBtn">我要查询</button>
		</div>
		<table class="table table-bordered table-striped" cellpadding="0" cellspacing="0">
			<thead>
				<th style="display: none;">发布人id</th>
				<th>发布人</th>
				<th>企事业单位名称</th>
				<th>信息概要(点击查看详情)</th>
				<th>联系方式</th>
				<th>附件</th>
				<th>发布日期</th>
			</thead>
			<tbody>
				<c:forEach var="recruitment" items="${recruitmentList }">
					<tr>
						<td style="display: none;">${recruitment.userId }</td>
						<td>${recruitment.truename }</td>
						<td>${recruitment.companyName }</td>
						<td>${recruitment.summary }</td>
						<td>${recruitment.connectWay }</td>
						<td><a href="${recruitment.attachmentPath }">附件下载</a></td>
						<td>${recruitment.publishDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 分页 -->
		<div style="float: left;margin-left: 290px;margin-right: auto;">
			<ul class="pagination dividePage">
				<li class="disabled"><span>&laquo;</span></li>
				<c:forEach begin="${queryVo.pageIndex-queryVo.pageIndex%5+1 }" end="${queryVo.pageIndex-queryVo.pageIndex%5+5 }" step="1" varStatus="status">
					<c:if test="${status.current<=queryVo.pageCount }">
						<li><a href="#">${status.current }</a></li>
					</c:if>
				</c:forEach>		
<!-- 				<li class="active"><a href="#">1</a></li> -->
				<li><a href="#">&raquo;</a></li>
			</ul>
		</div>
		<div class="record">
			<span>共<font>${queryVo.recordCount }</font>条记录，当前是第<font>${queryVo.pageIndex }</font>页，共<font>${queryVo.pageCount }</font>页</span>
		</div>
		<div class="modal dialog" id="searchDialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title" style="font-size: 20px;">查询条件输入</h1>
				</div>
				<div class="modal-body">
					<form action="">
						<div class="checkbox">
							<label for="viewAll">
								<input type="checkbox" name="viewAll" id="viewAll" value="" onclick="hideFormElementWhenChooseViewAll();"/>
							我要查看全部记录</label>
						</div>
						<div class="form-group" id="publishPersonDiv">
							<label for="publishPerson">发布人姓名：</label>
							<input type="text" class="form-control" id="publishPerson" placeholder="请输入发布人的真实姓名"/>
						</div>
						<div class="form-group" id="searchDateDiv">
							<label for="pubForedate">发布日期从：</label>
							<input type="date" class="form-control" id="pubForedate" placeholder="时间下限"/>
							<label for="pubAfterdate">到：</label>
							<input type="date" class="form-control" id="pubAfterdate" placeholder="时间上限"/>
						</div>
						<div class="form-group" id="companyNameDiv">
							<label for="pubCompany">企事业单位名称：</label>
							<input type="text" class="form-control" id="pubCompany" placeholder="请输入单位姓名"/>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn" style="background-color: #50E450;color: #FFFFFF;" onclick="closeSearchDialog();">关闭</button>
					<button type="button" class="btn" style="background-color: #1296db;color: #FFFFFF;">Go!-></button>
				</div>
			</div>
		</div>
	</div>
	
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/recruitmentControl/recruitment_show.js"></script>
<script type="text/javascript">
	function openSearchDialog() {
		$("#searchDialog").slideToggle(200);
	}
	function closeSearchDialog() {
		$("#searchBtn").click();
	}
</script>
</html>









