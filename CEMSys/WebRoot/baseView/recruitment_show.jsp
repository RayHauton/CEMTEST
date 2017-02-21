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
			<span class="divideSpan">每页显示</span>
			<div class="btn-group" style="margin-left: 1px;margin-top: 3px;float: left;">
				<button id="pgsz" class="btn btn-nav">请选择</button>
				<button data-toggle="dropdown" class="dropdown-toggle btn-drop" id="btn_drop_divide">
					<img alt="" src="../img/drop.png" style="width: 15px;height: 15px;">
				</button>
				<ul class="dropdown-menu" style="height: 152px;">
					<c:forEach var="pageSize" items="${pageSizeList }">
						<li onclick="changeSearch(this,'pgsz');">${pageSize }</li>
					</c:forEach>
				</ul>
			</div>
			<span class="divideSpan">条记录</span>
			<div style="float: right; width: 380px;">
				<div class="btn-group" style="margin-left: 1px;margin-top: 3px;float: left;">
					<button id="searchMethod" class="btn btn-nav">搜索方式</button>
					<button data-toggle="dropdown" class="dropdown-toggle btn-drop" id="btn_drop">
						<img alt="" src="../img/drop.png" style="width: 15px;height: 15px;">
					</button>
					<ul class="dropdown-menu">
						<li onclick="changeSearch(this,'searchMethod');">全部记录</li>
<!-- 						<li class="divider"></li> -->
						<li onclick="changeSearch(this,'searchMethod');">发&nbsp;&nbsp;布&nbsp;&nbsp;人</li>
<!-- 						<li class="divider"></li> -->
						<li onclick="changeSearch(this,'searchMethod');">发布日期</li>
<!-- 						<li class="divider"></li> -->
						<li onclick="changeSearch(this,'searchMethod');">发布单位</li>
					</ul>
				</div>
				<form action="" role="form" style="margin-right: 0px;">
					<div class="form-group searchForm">
						<input type="text" class="form-control" name="" id="searchContent" placeholder="输入查询内容"/>
					</div>
					<div class="searchImgDiv">
						<button class="searchBtn">
							<img alt="" src="../img/search.png">
						</button>
					</div>
				</form>
			</div>
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
	</div>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script type="text/javascript">
	function changeSearch(obj,id) {
		document.getElementById(id).innerHTML=obj.innerHTML;
	}
</script>
</html>









