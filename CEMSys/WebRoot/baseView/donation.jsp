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
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/view_set/donation.css">
<link rel="stylesheet" href="../css/view_set/head.css">
<link rel="stylesheet" href="../css/view_set/footer.css">
<title>捐赠实时公告系统</title>
</head>
<body>
<!-- 	<div class="header"> -->
<!-- 		<div class="logo"> -->
<!-- 			<img alt="" src="../img/donation/logo3.png"> -->
<!-- 		</div> -->
<!-- 		<div class="title"> -->
<!-- 			经管院校友捐赠实时公告系统 -->
<!-- 		</div> -->
<!-- 		<div class="head_right"> -->
<!-- 			<div class="head_right_top"> -->
<!-- 				<img alt="" src="../img/donation/return.png"> -->
<!-- 				<span style="font-size:12px;" class="returnIndex"> -->
<%-- 					<a href="${pageContext.request.contextPath }/index.jsp">返回主页</a> --%>
<!-- 				</span> -->
<!-- 			</div> -->
<!-- 			<div class="head_right_bottom"> -->
<%-- 				<span>${sessionScope.user.truename }</span> --%>
<!-- 				<img alt="" src="../img/donation/user.png">&nbsp; -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
	<jsp:include page="header.jsp"></jsp:include>
	<div class="contentBody">
		<div class="searchDiv">
			<div class="searchLogo">
				<img alt="" src="../img/donation/search1.png">
			</div>
			<form action="${pageContext.request.contextPath }/donation/show.action" method="post" id="searchForm">
				<div class="searchContent">
					<font style="letter-spacing: 1px;">
					捐&nbsp;赠&nbsp;人</font>：
					<input type="text" class="form-control" name="truename" id="truename" value="${queryVo.truename }"/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					捐赠用途：
					<input type="text" class="form-control" name="donationProject" id="donationProject" value="${queryVo.donationProject }"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					捐赠物品类别：
					<select class="form-control" name="donationType" id="donationType"
					 style="padding: 0;font-size: 12px;">&nbsp;&nbsp;&nbsp;&nbsp;
						<option value="">全部</option>
						<option value="0">基金</option>
						<option value="1">其他</option>	
					</select>
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
					style="font-size: 10px;padding: 0;"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font style="letter-spacing: 2px;">
					至：</font>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="date" class="form-control" name="afterdate" id="afterdate" value="${queryVo.afterdate }"
					 style="font-size: 10px;padding: 0;"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font style="letter-spacing: 6px;">每页显示</font>：
					<select class="form-control" name="pageSize" id="pageSize" style="padding: 0px;">
						<c:forEach var="pageSize" items="${pageSizeList }">
							<option>${pageSize }</option>						
						</c:forEach>
					</select>
					<input type="hidden" name="pageIndex" id="pageIndex"/>
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
					<button type="button" class="searchBtn btn btn-info" onclick="resetForm();" style="">重置</button>
					<button type="submit" class="searchBtn btn btn-success" style="">查询</button>
				</div>
			</form>
			
		</div>
		<table class="table table-bordered table-striped" cellpadding="0" cellspacing="0">
			<thead>
				<th style="width: 180px;">捐赠人(点击查看捐赠人详情)</th>
				<th>捐赠的项目</th>
				<th>捐赠种类</th>
				<th>捐赠明细</th>
				<th>捐赠时间</th>
			</thead>
			<tbody>
				<c:forEach var="donation" items="${donationList }" >
					<tr>
						<td class="prevTd" style="display: none;" id="${donation.userId }">${donation.userId }</td>
						<td><a class="a-set" onclick="showInfoDialog(this,'${pageContext.request.contextPath}/donation/getDonorInfo.action');" title="点击查看捐赠人信息">${donation.truename }</a></td>
						<td>${donation.donationProject }</td>
						<td>
							<c:choose>
								<c:when test="${donation.donationType eq 0 }">
									基金
								</c:when>
								<c:otherwise>
									其他
								</c:otherwise>
							</c:choose>
						</td>
						<td>${donation.donationItem }</td>
						<td>${donation.donationDate }</td>
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
						<a onclick="submitForm('${queryVo.pageIndex-1 }');" style="cursor: pointer;">
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
							<a  name="pageTag" onclick="submitForm('${status.current-1 }');" style="cursor: pointer;">${status.current-1 }</a>
						</li>
					</c:if>
					<c:if test="${status.current<=queryVo.pageCount }">
						<li>
							<a name="pageTag" onclick="submitForm('${status.current }')" style="cursor: pointer;">${status.current }</a>
						</li>
					</c:if>
				</c:forEach>		
<!-- 				<li class="active"><a href="#">1</a></li> -->
				
				<c:choose>
					<c:when test="${queryVo.pageIndex<queryVo.pageCount }">
						<li>
						<a onclick="submitForm('${queryVo.pageIndex+1 }')" style="cursor: pointer;">
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
		<div class="modal dialog" id="infoDialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title" style="font-size: 18px;font-weight: normal;">捐赠人信息查看</h1>
				</div>
				<div class="modal-body">
					<table id="infoTable" class="table table-bordered border-striped" cellpadding="0" cellspacing="0" style="display:none;">
						<tbody>
							<tr>
								<td>姓名</td>
								<td id="truename_json"></td>
							</tr>
							<tr>
								<td>入学年份</td>
								<td id="entranceDate"></td>
							</tr>
							<tr>
								<td>攻读专业</td>
								<td id="majorName"></td>
							</tr>
							<tr>
								<td>学位</td>
								<td id="degreeName"></td>
							</tr>
						</tbody>
					</table>
					<div id="loading" style="display: block;margin-left:auto;margin-right:auto;width:30px;height:30px;">
						<img src="../img/donation/loading.gif"
						 style="margin-left:auto;margin-right:auto;width:30px;height:30px;">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" style="width: 70px;height:32px;" 
					onclick="closeInfoDialog();">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/donationControl/donation.js"></script>
<script src="../js/loginController/loginAndLogout.js" ></script>
<script type="text/javascript">
</script>
</html>




