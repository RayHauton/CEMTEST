<!-- 
	create by linhd;
	2017/2/19
	招聘信息发布界面
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/view_set/recruitment_pub.css">
<link rel="stylesheet" href="../css/view_set/head.css">
<link rel="stylesheet" href="../css/view_set/footer.css">
<link rel="stylesheet" href="../css/person_detail.css">
<title>发布招聘信息</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<input type="hidden" value="${pageContext.request.contextPath }" id="basePath"/>
	<div class="outer">
		<form action="${pageContext.request.contextPath }/recruitment/publish.action" method="post" enctype="multipart/form-data" id="form">
			<div class="head">
<!-- 				<div class="imgDiv"> -->
<!-- 					<img alt="" src="../img/edit.png"> -->
<!-- 				</div> -->
				<span>发布招聘信息</span>
			</div>
			<div class="info">
				<table class="table table-bordered table-striped" cellpadding="0"
					cellspacing="0">
					<tbody>
						<tr>
							<td style="width: 330px;">发布人</td>
							<td style="display: none;"><input type="hidden" name="userId" id="userId"
								value="${sessionScope.user.userId}"/></td>
							<td style="padding: 0px;"><input type="text" name="truename" readonly="readonly"
								value="${sessionScope.user.truename}" class="input_set" /></td>
						</tr>
						<tr>
							<td>单位名称</td>
							<td style="padding: 0px;"><input type="text" name="companyName"
								value="" class="input_set" id="companyName"/></td>
						</tr>
						<tr>
							<td>联系方式</td>
							<td style="padding: 0px;"><input type="text" name="connectWay"
								value="" class="input_set" id="connectWay"/></td>
						</tr>
						<tr>
							<td>附件上传</td>
							<td style="padding: 0px;"><input type="file" name="attachment"
								value="" class="input_set" style="display: none;"
								id="fileUpload" onchange="showFile();" />
								<button class="fileBtn" type="button"
									onclick="javascript:document.getElementById('fileUpload').click();">点击上传文件(rar|zip)</button>
								<span id="fileError" style="padding: 0;margin: 0;"></span>
							</td>
						</tr>
						<tr>
							<td>简要信息</td>
							<td style="padding: 0px;"><textarea name="summary" id="summary"
									class="textarea_set" placeholder="不超过100个字符,如果字数太多请用文档压缩成附件上传"></textarea></td>
						</tr>
					</tbody>
				</table>
				<table class="table table-bordered table-striped" cellpadding="0"
					cellspacing="0">
					<caption
						style="padding-top: 0; text-align: center; font-weight: bold; font-size: 16px;">附件信息</caption>
					<thead>
						<th>文件名称</th>
						<th>文件大小</th>
						<!-- 					<th>文件类型</th> -->
						<th>最后修改日期</th>
					</thead>
					<tbody>
						<tr>
							<td id="flnm">...</td>
							<td id="flsz">...</td>
							<!-- 						<td id="fltp">ss</td> -->
							<td id="flmddt">...</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btnDiv">
				<button class="btn btn-info" type="button" onclick="resetFrom();">重置</button>
				<button class="btn btn-success" type="button" onclick="checkFormIllegal();"
					style="background-color: #50E450; margin-right: 15px;">提交</button>
			</div>
			<div class="errorDivOuter">
				<div class="errorDivInnerOne" id="errorDivInnerOne" style="display: none;">
					提示信息
				</div>
				<div class="errorDiv" id="errorDiv">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/recruitmentControl/recruitment_pub.js"></script>
<script src="../js/loginController/loginAndLogout.js" ></script>
</html>