<!-- 
	create by linhd;
	2017/2/19
	招聘信息展示界面
 -->
<%@page import="com.cem.util.BaseDataUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	request.setAttribute("pageSizeList", BaseDataUtil.getPageSizes());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/view_set/recruitment_show.css">
<link rel="stylesheet" href="../css/view_set/head.css">
<link rel="stylesheet" href="../css/view_set/footer.css">
<link rel="stylesheet" href="../css/person_detail.css">
<title>招聘信息查看</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<input type="hidden" value="${queryVo.viewAll }" id="checkViewAll">
	<div class="outer">
		<div class="head">
<!-- 			<div class="imgDiv"> -->
<!-- 				<img alt="" src="../img/discover.png"> -->
<!-- 			</div> -->
			<span>招聘信息一览</span>
		</div>
		<div class="searchDiv">
			<span class="divideSpan">每页显示</span>&nbsp;
			<select class="pgszSlkt" id="pageSizeSelection">
				<option>请选择</option>
				<c:forEach var="pageSize" items="${pageSizeList }">
					<option>${pageSize }</option>
				</c:forEach>
			</select>&nbsp;条记录
			<script type="text/javascript">
			/*
			设置选择页面显示几条记录
		     */
				var options = document.getElementById("pageSizeSelection").options;
				var optionsCount = options.length;
				for(var i=0;i<optionsCount;i++){
					if(options[i].innerText=='${queryVo.pageSize}'){
						options[i].selected="selected";
					}
				}
			</script>
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
						<td onclick="showSummary(this);" 
						style="cursor:pointer;">
						<span style="width: 150px;display:block;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">${recruitment.summary }</span>
						</td>
						<td>${recruitment.connectWay }</td>
						<td>
							<c:choose>
								<c:when test="${recruitment.attachmentPath!=null }">
									<a href="${pageContext.request.contextPath }/recruitment/download.action?filename=${recruitment.attachmentPath }">附件下载</a>
								</c:when>
									<c:otherwise>
									<a>无附件</a>
								</c:otherwise>
							</c:choose>
						</td>
<%-- 						<td>${recruitment.publishDate }</td> --%>
						<td>${recruitment.publishDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 分页 -->
		<div style="float: left;margin-left: 290px;margin-right: auto;">
			<ul class="pagination dividePage">
				<c:choose>
					<c:when test="${queryVo.pageIndex>=2 }">
						<li>
						<a onclick="submitSearchForm('divPg','${queryVo.pageIndex-1}');" style="cursor: pointer;">
							<span>&laquo;</span>
						</a>
						</li>
					</c:when>
					<c:otherwise>
						<li	 class="disabled"><span>&laquo;</span></li>
					</c:otherwise>
				</c:choose>
				<c:forEach begin="${queryVo.pageIndex-queryVo.pageIndex%5+1 }" end="${queryVo.pageIndex-queryVo.pageIndex%5+5 }" step="1" varStatus="status">
					<c:if test="${(status.current-1)!=0 and (status.current-1)%5 eq 0 }">
						<li>
							<a  name="pageTag" onclick="submitSearchForm('divPg',this.innerText);" style="cursor: pointer;">${status.current-1 }</a>
						</li>
					</c:if>
					<c:if test="${status.current<=queryVo.pageCount }">
						<li>
							<a name="pageTag" onclick="submitSearchForm('divPg',this.innerText);" style="cursor: pointer;">${status.current }</a>
						</li>
					</c:if>
				</c:forEach>		
<!-- 				<li class="active"><a href="#">1</a></li> -->
				
				<c:choose>
					<c:when test="${queryVo.pageIndex<queryVo.pageCount }">
						<li>
						<a onclick="submitSearchForm('divPg','${queryVo.pageIndex+1}');" style="cursor: pointer;">
							<span>&raquo;</span>
						</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="disabled"><span>&laquo;</span></li>
					</c:otherwise>
				</c:choose>
			</ul>
			<script type="text/javascript">
				var aTags = document.getElementsByName("pageTag");
				var aTagCount = aTags.length;
				for(var i=0;i<aTagCount;i++){
					if(aTags[i].innerText=='${queryVo.pageIndex}'){
						aTags[i].style.backgroundColor="#DDDDDD";
					}
				}
			</script>
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
					<form action="${pageContext.request.contextPath }/recruitment/show.action" id="searchForm" method="post">
						<input type="hidden" name="pageIndex" id="pageIndex_hdn" value=""/>
						<input type="hidden" name="pageSize" id="pageSize_hdn" value=""/>
						<div class="checkbox">
							<label for="viewAll">
								<input type="checkbox" name="viewAll" id="viewAll" value="" onclick="hideFormElementWhenChooseViewAll();"/>
							我要查看全部记录</label>
						</div>
						<div class="form-group" id="publishPersonDiv">
							<label for="publishPerson">发布人姓名：</label>
							<input type="text" class="form-control" value="${queryVo.publishPerson }" id="publishPerson" name="publishPerson" placeholder="请输入发布人的真实姓名"/>
						</div>
						<div class="form-group" id="searchDateDiv">
							<label for="pubForedate">发布日期从：</label>
							<input type="date" class="form-control" value="${queryVo.pubForedate }" id="pubForedate" name="pubForedate" placeholder="时间下限"/>
							<label for="pubAfterdate">到：</label>
							<input type="date" class="form-control" value="${queryVo.pubAfterdate }" id="pubAfterdate" name="pubAfterdate" placeholder="时间上限"/>
						</div>
						<div class="form-group" id="companyNameDiv">
							<label for="pubCompany">企事业单位名称：</label>
							<input type="text" class="form-control" value="${queryVo.pubCompany }" id="pubCompany" name="pubCompany" placeholder="请输入单位姓名"/>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn" style="background-color: #50E450;color: #FFFFFF;" onclick="closeSearchDialog();">关闭</button>
					<button type="button" class="btn" style="background-color: #1296db;color: #FFFFFF;" onclick="submitSearchForm();">Go!-></button>
				</div>
			</div>
		</div>
		<div class="modal dialog" id="summaryDialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title" style="font-size: 20px;">招聘信息概要详细内容查看</h1>
				</div>
				<div class="modal-body">
					<p id="summaryDetail"></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn" style="background-color: #50E450;color: #FFFFFF;" onclick="closeSummaryDialog();">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/recruitmentControl/recruitment_show.js"></script>
<script src="../js/loginController/loginAndLogout.js" ></script>
<script type="text/javascript">
	function openSearchDialog() {
		$("#searchDialog").slideToggle(200);
// 		checkViewAll
		if(document.getElementById("checkViewAll").value==''){
			document.getElementById("viewAll").checked=false;
		}else{
			document.getElementById("viewAll").checked=true;
		}
	}
	function closeSearchDialog() {
// 		$("#searchBtn").click();
		$("#searchDialog").slideToggle(200);
	}
	function showSummary(obj){
		$("#summaryDialog").slideToggle(200);
		document.getElementById("summaryDetail").innerHTML=obj.innerHTML;
	}
	function closeSummaryDialog(){
		$("#summaryDialog").slideToggle(200);
	}
</script>
</html>









