<%--
Created by IntelliJ IDEA.
User: RayHauton
Date: 2016/12/6
Time: 21:22
To change this template use File | Settings | File Templates.
--%>
<%@page import="com.cem.util.BeanUtil"%>
<%@page import="com.cem.serviceImpl.SystemInfoGetterService"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
if(session.getAttribute("systemDomain")==null){
	session.setAttribute("systemDomain", ((SystemInfoGetterService)BeanUtil.getBean(SystemInfoGetterService.class)).getSystemDomain());
}
%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="../css/view_set/base.css">
	<link rel="stylesheet" href="../css/view_set/timeline.css">
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/bootstrap.css">
	<link rel="stylesheet" href="../css/view_set/head.css">
	<link rel="stylesheet" href="../css/view_set/footer.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
<div class="box">
	<div class="check">
	<form action="${pageContext.request.contextPath }/collegeEvent/show.action" method="post" id="ff">
		<!-- 设置页面显示记录数量（定值：6） -->
		<input type="hidden" name="pageSize" value="6"/>
		<table class="">
			<tr>
				<td>从：<input type="month" class="inputSet" id="foredate" name="foredate" value="${queryVo.foredate }"/></td>
				<td>至：<input type="month" class="inputSet" id="afterdate" name="afterdate" value="${queryVo.afterdate }"/></td>
				<td><button class="btn-custom">查询</button></td>
			</tr>
		</table>
		<!-- 分页页码隐藏表单 -->
		<input type="hidden" name="pageIndex" id="pageIndex">
	</form>
	</div>
	<!-- 单个事件 resultList-->
	<c:forEach var="pojo" items="${resultList }">
		<div class="each">
			<div class="time">
				${pojo.eventDate }
			</div>
			<div class="linebox">
				<div class="line"></div>
			</div>
			<div class="content">
				<span class="title">${pojo.eventTitle }</span>
				<div class="detail">
					${pojo.eventDetail }
				</div>
			</div>
			<div class="imgDiv">
				<img alt="" src="http://${sessionScope.systemDomain }/fileUpload/collegeEventImgs/${pojo.eventImg}"
				 width="<fmt:formatNumber type="number" value="${pojo.width*100 div pojo.height }" maxFractionDigits="0"/>px" height="100px">
			</div>
		</div>
	</c:forEach>
	<!-- 分页 -->
		<div style="display:inline-block;margin-left: 290px;margin-right: auto;margin-top: 20px;">
			<ul class="pagination dividePage"  style="margin-top: 0;float: left;">
				<c:choose>
					<c:when test="${queryVo.pageIndex>=2 }">
						<li>
						<a onclick="submitFormOfQuery('${queryVo.pageIndex-1 }');" style="cursor: pointer;">
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
							<a  name="pageTag" onclick="submitFormOfQuery('${status.current-1 }');" style="cursor: pointer;">${status.current-1 }</a>
						</li>
					</c:if>
					<c:if test="${status.current<=queryVo.pageCount }">
						<li>
							<a name="pageTag" onclick="submitFormOfQuery('${status.current }')" style="cursor: pointer;">${status.current }</a>
						</li>
					</c:if>
				</c:forEach>		
<!-- 				<li class="active"><a href="#">1</a></li> -->
				
				<c:choose>
					<c:when test="${queryVo.pageIndex<queryVo.pageCount }">
						<li>
						<a onclick="submitFormOfQuery('${queryVo.pageIndex+1 }')" style="cursor: pointer;">
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
			<div class="record">
				<span>共<font>${queryVo.recordCount }</font>条记录，当前是第<font>${queryVo.pageIndex }</font>页，共<font>${queryVo.pageCount }</font>页</span>
			</div>
		</div>
</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/loginController/loginAndLogout.js"></script>
<script type="text/javascript">
	window.onload=function(){
		document.getElementById("foredate").value='${queryVo.foredate}';
		document.getElementById("afterdate").value='${queryVo.afterdate}';
	}
	function submitFormOfQuery(pageIndex){
		document.getElementById("pageIndex").value=pageIndex;
		document.getElementById("ff").submit();
	}
</script>
</html>














