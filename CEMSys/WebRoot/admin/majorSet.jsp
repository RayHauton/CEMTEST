<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.cem.util.BaseDataUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
BaseDataUtil baseDataUtil = new BaseDataUtil();
request.setAttribute("degreeList", baseDataUtil.getDegrees());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>经管院专业信息管理</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/view_set/head.css">
<link rel="stylesheet" href="../css/view_set/footer.css">
<link rel="stylesheet" href="../css/view_set/adminViewSet/majorSet.css">
</head>
<body>
<jsp:include page="header_admin.jsp"></jsp:include>
<!-- 页面主题内容开始 -->
<div class="outer">
    <button class="btn btn-primary" style="margin-top: 10px;margin-left:10px;" data-toggle="modal" data-target="#add" onclick="resetErrorDiv()">添加专业信息</button>
    <hr style="padding: 0;margin-top: 10px;">
    <table class="table  table-striped">
        <thead>
            <th>专业代号</th>
            <th>专业名称</th>
            <th>所属学历代号</th>
            <th>所属学历</th>
            <th width="220px">操作</th>
        </thead>
        <tbody>
        	<c:forEach var="majorCustom" items="${majorCustomList }">
	            <tr>
	                <td>${majorCustom.majorId }</td>
	                <td>${majorCustom.majorName }</td>
	                <td>${majorCustom.degreeId }</td>
	                <td>${majorCustom.degreeName }</td>
	                <td>
	                    <button class="btn btn-info">编辑</button>
	                    <button class="btn btn-warning">删除</button>
	                </td>
	            </tr>
        	</c:forEach>
        </tbody>
    </table>
</div>
<!-- 添加专业信息 -->
<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_info" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel_info">添加专业信息
				</h4>
			</div>
			<div class="modal-body">
				<div id="infoBody">
				<form action="${pageContext.request.contextPath }/majorSet/insert_adm.action" id="ff_add" method="post">
				<div class="form-group">
					<label for="majorName_add">专业名称</label>
					<input type="text" class="form-control" id="majorName_add" name="majorName">
				</div>
				<div class="errorInfo" id="majorNameError_add" style="display: none;"></div>
				<b>归属于哪个学位？（可多选）</b>
				<div class="checkbox">
					<c:forEach var="degree" items="${degreeList }">
						<label><input type="checkbox" name="degreeId_add" value="${degree.degreeId }">${degree.degreeName }</label>|
					</c:forEach>
				</div>
				<div class="errorInfo" id="degreeNameError_add" style="display: none;"></div>
				</form>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success" onclick="submitAddForm('add')">提交</button>
				<button type="button" class="btn btn-warning" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../baseView/footer.jsp"></jsp:include>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/loginController/loginAndLogout.js"></script>
<script src="../js/majorController/majorSetController.js"></script>
</html>