<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>校友会信息管理</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/view_set/head.css">
<link rel="stylesheet" href="../css/view_set/footer.css">
<link rel="stylesheet" href="../css/view_set/alumniAssociationSet.css">
</head>
<body>
<jsp:include page="header_admin.jsp"></jsp:include>
<div class="outer">
	<button class="btn btn-primary" style="margin:10px 0 0 10px;" data-toggle="modal" data-target="#add">添加校友会</button>
	<hr style="margin:10px;padding: 0;">
	<table class="table table-bordered table-striped">
		<thead>
			<th>校友会名称</th>
			<th>联系人</th>
			<th>联系方式</th>
			<th>校友会照片</th>
			<th width="150px;">操作</th>
		</thead>
		<tbody>
			<c:forEach var="pojo" items="${alumniAssoList }">
				<tr>
				<td style="display:none;">${pojo.alumniAssociationId }</td>
				<td>${pojo.alumniAssociationName }</td>
				<td>${pojo.contactPerson }</td>
				<td>${pojo.contactWay }</td>
				<td>
				<span id="/fileUpload/alumniAssociationImg/${pojo.img }">
				<a style="cursor:pointer;" onclick="showImg(this);" data-toggle="modal" data-target="#showImg">查看图片</a>
				</span>
				</td>
				<td>
				<button class="btn btn-info" data-toggle="modal" data-target="#update" onclick="fillUpdateForm(this);">编辑</button>
				<button class="btn btn-warning"
				 onclick="deleteRecord('${pageContext.request.contextPath}/alumiAssociation/delete_adm.action',this);">删除</button>
				</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<!-- 添加校友会信息 -->
<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
	<form action="${pageContext.request.contextPath }/alumiAssociation/insert_adm.action" enctype="multipart/form-data" method="post" id="ff_add">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					添加校友会信息
				</h4>
			</div>
			<div class="modal-body">
			<div class="addDiv">
				<div class="form-group">
					<label for="alumniAssociationName_add">校友会名称</label>
					<input class="form-control" id="alumniAssociationName_add" name="alumniAssociationName"/>
				</div>
				<div class="errorInfoContent" id="alumniAssociationNameError_add" style="display: none;"></div>
				<div class="form-group">
					<label for="contactPerson_add">校友会联系人</label>
					<input class="form-control" id="contactPerson_add" name="contactPerson"></input>
				</div>
				<div class="errorInfoContent" id="contactPersonError_add" style="display: none;"></div>
				<div class="form-group">
					<label for="contactWay_add">联系方式</label>
					<input type="text" class="form-control" id="contactWay_add" name="contactWay"/>
				</div>
				<div class="errorInfoContent" id="contactWayError_add" style="display: none;"></div>
				<div class="form-group">
					<label for="img_add">校友会附图</label>
					<input type="file" class="form-control" id="img_add" name="file"/>
				</div>
				<div class="errorInfoContent" id="imgError_add" style="display: none;"></div>
			</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-info" onclick="javascript:document.getElementById('ff_add').reset();">重置
				</button>
				<button type="button" class="btn btn-success" onclick="submitForm('add');return false;">
					提交
				</button>
			</div>
		</div>
	</form>
	</div>
</div>
<!-- 更新校友会信息-->
<div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="updateLabel" aria-hidden="true">
	<div class="modal-dialog">
	<form action="${pageContext.request.contextPath }/alumiAssociation/update_adm.action" enctype="multipart/form-data" method="post" id="ff_update">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="updateLabel">
					更新校友会信息
				</h4>
			</div>
			<div class="modal-body">
			<div class="addDiv">
				<input type="hidden" id="ID" name="alumniAssociationId">
				<div class="form-group">
					<label for="alumniAssociationName_update">校友会名称</label>
					<input class="form-control" id="alumniAssociationName_update" name="alumniAssociationName"/>
				</div>
				<div class="errorInfoContent" id="alumniAssociationNameError_update" style="display: none;"></div>
				<div class="form-group">
					<label for="contactPerson_update">校友会联系人</label>
					<input class="form-control" id="contactPerson_update" name="contactPerson"></input>
				</div>
				<div class="errorInfoContent" id="contactPersonError_update" style="display: none;"></div>
				<div class="form-group">
					<label for="contactWay_update">联系方式</label>
					<input type="text" class="form-control" id="contactWay_update" name="contactWay"/>
				</div>
				<div class="errorInfoContent" id="contactWayError_update" style="display: none;"></div>
				<div class="form-group">
					<label for="img_update">校友会附图</label>
					<input type="file" class="form-control" id="img_update" name="file"/>
				</div>
				<div class="errorInfoContent" id="imgError_update" style="display: none;"></div>
			</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-info" onclick="javascript:document.getElementById('ff_add').reset();">重置
				</button>
				<button type="button" class="btn btn-success" onclick="submitForm('update');return false;">
					提交
				</button>
			</div>
		</div>
	</form>
	</div>
</div>
<!-- 显示图片 -->
<div class="modal fade" id="showImg" tabindex="-1" role="dialog" aria-labelledby="imgLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="imgLabel">
					查看图片
				</h4>
			</div>
			<div class="modal-body">
				<div style="background-color:red;width:560px;height:350px;">
					<img alt="" src="" id="imgDetail">
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal" onclick="clearImgCache();">关闭
				</button>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../baseView/footer.jsp"></jsp:include>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/loginController/loginAndLogout.js"></script>
<script src="../js/alumniAssociationController/alumniAssociationControl.js"></script>
</html>