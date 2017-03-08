<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<button class="btn btn-primary btn-custom" data-toggle="modal" data-target="#myModal">
		添加学院事件
	</button>
	<hr>
	<!-- 按钮触发模态框 -->
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		<form action="${pageContext.request.contextPath }/collegeEvent/add.action" enctype="multipart/form-data" method="post" id="ff">
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
						<label for="eventTitle">①事件标题</label>
						<input class="form-control" id="eventTitle" name="eventTitle" onblur="checkTitle();"/>
					</div>
					<div class="errorInfoContent" id="eventTitleError" style="display: none;"></div>
					<div class="form-group">
						<label for="eventDetail">②事件简述</label>
						<textarea class="form-control" id="eventDetail" name="eventDetail" onblur="checkDetail();"></textarea>
					</div>
					<div class="errorInfoContent" id="eventDetailError" style="display: none;"></div>
					<div class="form-group">
						<label for="eventDate">③事件日期</label>
						<input type="month" class="form-control" id="eventDate" name="eventDate" onblur="checkDate();"/>
					</div>
					<div class="errorInfoContent" id="eventDateError" style="display: none;"></div>
					<div class="form-group">
						<label for="eventImg">④事件附图</label>
						<input type="file" class="form-control" id="image" name="image" onchange="checkImg();"/>
<!-- 							<button class="btn btn-info" onclick="javascript:document.getElementById('eventImg').click();">上传图片</button> -->
					</div>
					<div class="errorInfoContent" id="imageError" style="display: none;"></div>
				</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-warning" onclick="resetForm();">重置
					</button>
					<button type="button" class="btn btn-primary" onclick="submitForm();">
						提交
					</button>
				</div>
			</div>
		</form>
		</div>
	</div>
	<table class="table table-striped" cellpadding="0" cellspacing="0">
		<thead>
			<th>事件标题</th>
			<th>事件简介</th>
			<th>事件日期</th>
			<th>事件配图</th>
		</thead>
		<tr>
			<td>不知道</td>
			<td>不知道</td>
			<td>不知道</td>
			<td>不知道</td>
		</tr>
		<tr>
			<td>不知道</td>
			<td>不知道</td>
			<td>不知道</td>
			<td>不知道</td>
		</tr>
		<tr>
			<td>不知道</td>
			<td>不知道</td>
			<td>不知道</td>
			<td>不知道</td>
		</tr>
		<tr>
			<td>不知道</td>
			<td>不知道</td>
			<td>不知道</td>
			<td>不知道</td>
		</tr>
	</table>
</div>
<jsp:include page="../baseView/footer.jsp"></jsp:include>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/collegeEventController/collegeEventControl.js"></script>
<script type="text/javascript">
	$("#addBtn").click(function () {
		$(".addDiv").fadeToggle(200);
	});
</script>
</html>