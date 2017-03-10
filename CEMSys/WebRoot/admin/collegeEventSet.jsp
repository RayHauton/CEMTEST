<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.cem.util.BaseDataUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setAttribute("pageSizeList", BaseDataUtil.getPageSizes());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学院大事件管理界面</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/view_set/head.css">
<link rel="stylesheet" href="../css/view_set/footer.css">
<link rel="stylesheet" href="../css/view_set/adminViewSet/collegeEventSet.css">
</head>
<body>
<jsp:include page="header_admin.jsp"></jsp:include>
<div class="outer">
<!-- 	<button class="btn btn-primary btn-custom" id="addBtn">添加学院事件</button> -->
	<button class="btn btn-primary btn-custom" data-toggle="modal" data-target="#add">
		添加学院事件
	</button>
	<div class="query">
		<form action="${pageContext.request.contextPath }/collegeEvent/show_adm.action" method="post" id="ff_query">
			&nbsp;&nbsp;从：<input type="month" name="foredate" id="foredate" value="${queryVo.foredate }">
			&nbsp;至：<input type="month" name="afterdate" id="afterdate" value="${queryVo.afterdate }">
			&nbsp;每页显示：
			<select class="" name="pageSize" id="pageSize" style="padding: 0px;">
				<c:forEach var="pageSize" items="${pageSizeList }">
					<option value="${pageSize }">${pageSize }</option>						
				</c:forEach>
			</select>
			<!-- 分页页码隐藏表单 -->
			<input type="hidden" name="pageIndex"  id="pageIndex">
			<button type="submit" class="btn btn-success" style="height:28px;padding: 0;width: 70px;margin-left: 10px;">查询</button>
		</form>
	</div>
	<hr>
	<table class="table table-striped table-bordered" cellpadding="0" cellspacing="0">
		<thead>
			<th width="240px">事件标题（点击查看详情）</th>
			<th width="380px">事件简介（点击查看详情）</th>
			<th width="80px">事件日期</th>
			<th width="100px">事件配图</th>
			<th width="150px">操作</th>
		</thead>
		<c:forEach var="pojo" items="${resultList }">
			<tr>
				<td style="display: none;">${pojo.eventId }</td>
				<td>
				<span style="width: 240px;display:block;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">
				${pojo.eventTitle }
				</span>
				</td>
				<td style="white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">
				<span style="width: 380px;display:block;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">
				${pojo.eventDetail }
				</span>
				</td>
				<td>${pojo.eventDate }</td>
				<td><a>查看图片</a></td>
				<td>
				<button class="btn btn-primary" data-toggle="modal" data-target="#update" onclick="fillUpdateInfo(this)">编辑</button>
				<button class="btn btn-warning">删除</button>
				</td>
		</c:forEach>
		</tr>
	</table>
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
		<!-- 按钮触发模态框 -->
	<!-- 模态框（Modal） -->
	<!-- 添加事件内容 -->
	<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		<form action="${pageContext.request.contextPath }/collegeEvent/add.action" enctype="multipart/form-data" method="post" id="ff_add">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						添加学院事件
					</h4>
				</div>
				<div class="modal-body">
				<div class="addDiv">
					<div class="form-group">
						<label for="eventTitle_add">①事件标题</label>
						<input class="form-control" id="eventTitle_add" name="eventTitle" onblur="checkTitle('add');"/>
					</div>
					<div class="errorInfoContent" id="eventTitleError_add" style="display: none;"></div>
					<div class="form-group">
						<label for="eventDetail_add">②事件简述</label>
						<textarea class="form-control" id="eventDetail_add" name="eventDetail" onblur="checkDetail('add');"></textarea>
					</div>
					<div class="errorInfoContent" id="eventDetailError_add" style="display: none;"></div>
					<div class="form-group">
						<label for="eventDate_add">③事件日期</label>
						<input type="month" class="form-control" id="eventDate_add" name="eventDate" onblur="checkDate('add');"/>
					</div>
					<div class="errorInfoContent" id="eventDateError_add" style="display: none;"></div>
					<div class="form-group">
						<label for="eventImg_add">④事件附图</label>
						<input type="file" class="form-control" id="image_add" name="image" onchange="checkImg('add');"/>
<!-- 							<button class="btn btn-info" onclick="javascript:document.getElementById('eventImg').click();">上传图片</button> -->
					</div>
					<div class="errorInfoContent" id="imageError_add" style="display: none;"></div>
				</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-warning" onclick="resetForm();">重置
					</button>
					<button type="button" class="btn btn-primary" onclick="submitForm('add','ff_add','${queryVo.pageIndex }');">
						提交
					</button>
				</div>
			</div>
		</form>
		</div>
	</div>
	<!-- 编辑事件内容 -->
	<div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_update" aria-hidden="true">
		<div class="modal-dialog">
		<form action="${pageContext.request.contextPath }/collegeEvent/update.action" enctype="multipart/form-data" method="post" id="ff_update">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel_update">
						编辑学院事件
					</h4>
				</div>
				<div class="modal-body">
				<div class="addDiv">
					<!-- 隐藏表单存储事件ID -->
					<input type="hidden" name="eventId" id="eventId_update"/>
					<div class="form-group">
						<label for="eventTitle_update">①事件标题</label>
						<input class="form-control" id="eventTitle_update" name="eventTitle" onblur="checkTitle('update');"/>
					</div>
					<div class="errorInfoContent" id="eventTitleError_update" style="display: none;"></div>
					<div class="form-group">
						<label for="eventDetail_update">②事件简述</label>
						<textarea class="form-control" id="eventDetail_update" name="eventDetail" onblur="checkDetail('update');"></textarea>
					</div>
					<div class="errorInfoContent" id="eventDetailError_update" style="display: none;"></div>
					<div class="form-group">
						<label for="eventDate_update">③事件日期</label>
						<input type="month" class="form-control" id="eventDate_update" name="eventDate" onblur="checkDate('update');"/>
					</div>
					<div class="errorInfoContent" id="eventDateError_update" style="display: none;"></div>
					<div class="form-group">
						<label for="eventImg_update">④事件附图</label>
						<input type="file" class="form-control" id="image_update" name="image" onchange="checkImg('update');"/>
<!-- 							<button class="btn btn-info" onclick="javascript:document.getElementById('eventImg').click();">上传图片</button> -->
					</div>
					<div class="errorInfoContent" id="imageError_update" style="display: none;"></div>
				</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-warning" onclick="resetForm();">重置
					</button>
					<button type="button" class="btn btn-primary" onclick="submitForm('update','ff_update','${queryVo.pageIndex }');">
						提交
					</button>
				</div>
			</div>
		</form>
		</div>
	</div>
</div>
<jsp:include page="../baseView/footer.jsp"></jsp:include>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/collegeEventController/collegeEventControl.js"></script>
<script src="../js/loginController/loginAndLogout.js"></script>
<script type="text/javascript">
	window.onload=function(){
		var options = document.getElementById("pageSize").options;
		var size=options.length;
		for(var i=0;i<size;i++){
			if(options[i].innerText=='${queryVo.pageSize}'){
				options[i].selected=true;
			}
		}
	}
</script>
</html>