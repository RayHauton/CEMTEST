<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>捐赠公告设置</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/view_set/head.css">
<link rel="stylesheet" href="../css/view_set/footer.css">
<link rel="stylesheet" href="../css/view_set/footer.css">
<link rel="stylesheet" href="../css/view_set/adminViewSet/donation_admin.css">
</head>
<body>
<jsp:include page="header_admin.jsp"></jsp:include>
<div class="outer">
	<button class="btn btn-primary btn-custom" data-toggle="modal" data-target="#add">
		添加捐赠记录
	</button>
	<!-- 查询条件表单 -->
	<div class="query">
		<table cellspacing="0" cellpadding="0" class="queryTable">
		<tr>
			<td>捐赠人：</td>
			<td><input type="text"/></td>
			<td>捐赠用途：</td>
			<td><input type="text"/></td>
			<td>捐赠类别：</td>
			<td><input type="text"/></td>
			<td><input type="button" value="查询" class="btn-query" style="background-color: #1096db;"/></td>
		</tr>
		<tr>
			<td>从：</td>
			<td><input type="date" class="date"/></td>
			<td>到：</td>
			<td><input type="date" class="date"/></td>
			<td>每页显示：</td>
			<td>
			<select class="pageSizeSelection">
				<option>1</option>
				<option>2</option>
				<option>3</option>
			</select>
			</td>
			<td><input type="reset" value="重置" class="btn-query" style="background-color: #5CB85C;"/></td>
		</tr>
		</table>
	</div>
	<table class="table table-bordered table-striped">
		<thead>
			<th>捐赠人</th>
			<th>捐赠用途</th>
			<th>捐赠物品类别</th>
			<th>捐赠明细</th>
			<th>捐赠时间</th>
			<th width="140px;">操作</th>
		</thead>
		<tbody>
			<tr>
				<td>林华栋</td>
				<td>学院建设</td>
				<td>基金</td>
				<td>100块</td>
				<td>2017-03-14</td>
				<td>
				<button class="btn btn-primary">编辑</button>
				<button class="btn btn-warning">删除</button>
				</td>
			</tr>
			<tr>
				<td>林华栋</td>
				<td>学院建设</td>
				<td>基金</td>
				<td>100块</td>
				<td>2017-03-14</td>
				<td>
				<button class="btn btn-primary">编辑</button>
				<button class="btn btn-warning">删除</button>
				</td>
			</tr>
			<tr>
				<td>林华栋</td>
				<td>学院建设</td>
				<td>基金</td>
				<td>100块</td>
				<td>2017-03-14</td>
				<td>
				<button class="btn btn-primary">编辑</button>
				<button class="btn btn-warning">删除</button>
				</td>
			</tr>
			<tr>
				<td>林华栋</td>
				<td>学院建设</td>
				<td>基金</td>
				<td>100块</td>
				<td>2017-03-14</td>
				<td>
				<button class="btn btn-primary">编辑</button>
				<button class="btn btn-warning">删除</button>
				</td>
			</tr>
			<tr>
				<td>林华栋</td>
				<td>学院建设</td>
				<td>基金</td>
				<td>100块</td>
				<td>2017-03-14</td>
				<td>
				<button class="btn btn-primary">编辑</button>
				<button class="btn btn-warning">删除</button>
				</td>
			</tr>
			<tr>
				<td>林华栋</td>
				<td>学院建设</td>
				<td>基金</td>
				<td>100块</td>
				<td>2017-03-14</td>
				<td>
				<button class="btn btn-primary">编辑</button>
				<button class="btn btn-warning">删除</button>
				</td>
			</tr>
		</tbody>		
	</table>
	<!-- 添加捐赠记录 -->
	<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="customModal" aria-hidden="true">
		<div class="modal-dialog">
		<form action="${pageContext.request.contextPath }/collegeEvent/add.action" enctype="multipart/form-data" method="post" id="ff_add">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="customModal">
						添加捐赠记录
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
					<button type="button" class="btn btn-info" onclick="resetForm();">重置
					</button>
					<button type="button" class="btn btn-success" onclick="submitForm('add','ff_add','${queryVo.pageIndex }');">
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
<script src="../js/loginController/loginAndLogout.js"></script>
</html>