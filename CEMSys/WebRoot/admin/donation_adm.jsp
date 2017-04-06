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
<title>捐赠公告设置</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
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
		<form action="${pageContext.request.contextPath }/donation/show_admin.action" method="post" id="queryForm">
		<table cellspacing="0" cellpadding="0" class="queryTable">
		<tr>
			<td>捐赠人：</td>
			<td><input type="text" name="truename" id="truename" value="${queryVo.truename }"/></td>
			<td>捐赠用途：</td>
			<td><input type="text" name="donationProject" id="donationProject" value="${queryVo.donationProject }"/></td>
			<td>捐赠类别：</td>
			<td>
			<select  name="donationType" id="donationType" class="selectSet">
				<option value="">全部</option>
				<option value="0">基金</option>
				<option value="1">其他</option>	
			</select>
			</td>
			<td><input type="submit" value="查询" class="btn-query" style="background-color: #1096db;"/></td>
		</tr>
		<tr>
			<td>从：</td>
			<td><input type="date" class="date" name="foredate" id="foredate" value="${queryVo.foredate }"/></td>
			<td>到：</td>
			<td><input type="date" class="date" name="afterdate" id="afterdate" value="${queryVo.afterdate }"/></td>
			<td>每页显示：</td>
			<td>
			<select class="selectSet" name="pageSize" id="pageSize" >
				<c:forEach var="pageSize" items="${pageSizeList }">
					<option>${pageSize }</option>						
				</c:forEach>
			</select>
			</td>
			<td><input type="button" value="重置" class="btn-query" style="background-color: #5CB85C;" onclick="resetForm();"/></td>
		</tr>
		</table>
		<!-- 隐藏表单提交pageIndex -->
		<input type="hidden" name="pageIndex" id="pageIndex">
		</form>
	</div>
	<!-- 提前修正pageIndex和捐赠物品种类 -->
	<script type="text/javascript">
		var options = document.getElementById("pageSize").options;
		var size = options.length;
		for(var i=0;i<size;i++){
			if(options[i].value=='${queryVo.pageSize}'){
				options[i].selected=true;
			}
		}
		var options = document.getElementById("donationType").options;
		var size = options.length;
		for(var i=0;i<size;i++){
			if(options[i].value=='${queryVo.donationType}'){
				options[i].selected=true;
			}
		}
	</script>
	<table class="table table-bordered table-striped">
		<thead>
			<th width="120px">捐赠人</th>
			<th width="100px">捐赠学号</th>
			<th>捐赠用途</th>
			<th width="120px">捐赠物品类别</th>
			<th>捐赠明细</th>
			<th width="100px">捐赠时间</th>
			<th width="140px;">操作</th>
		</thead>
		<tbody>
			<c:forEach var="donation" items="${donationList }">
			<tr>
				<td style="display: none;">${donation.donationId }</td>
				<td>${donation.truename }</td>
				<td>${donation.studNumber }</td>
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
				<td>
				<button class="btn btn-primary" data-toggle="modal" data-target="#update" onclick="fillTheUpdateForm(this);">编辑</button>
				<button class="btn btn-warning" onclick="deleteRecord('${pageContext.request.contextPath}','${queryVo.pageIndex }',this);">删除</button>
				</td>
			</tr>
			</c:forEach>
		</tbody>		
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
	<!-- 添加捐赠记录 -->
	<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="customModal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="customModal">
						添加捐赠记录
					</h4>
				</div>
				<form action="${pageContext.request.contextPath }/donation/insert.action" method="post" id="ff_add">
				<div class="modal-body">
					<div class="addDiv">
						<div class="form-group">
							<label for="truename_add">捐赠人：</label>
							<input class="form-control" id="truename_add" name="truename"/>
						</div>
						<div class="errorInfoContent" id="truenameError_add" style="display: none;"></div>
						<div class="form-group">
							<label for="studNumber_add">捐赠人学号：</label>
							<input class="form-control" id="studNumber_add" name="studNumber"/>
						</div>
						<div class="errorInfoContent" id="studNumberError_add" style="display: none;"></div>
						<div class="form-group">
							<label for="donationProject_add">捐赠用途：</label>
							<input class="form-control" id="donationProject_add" name="donationProject" />
						</div>
						<div class="errorInfoContent" id="donationProjectError_add" style="display: none;"></div>
						<div class="form-group">
							<label for="donationType_add">捐赠物品的类别：</label>
							<select class="form-control" id="donationType_add" name="donationType">
	<!-- 							<option value="">全部</option> -->
								<option value="0">基金</option>
								<option value="1">其他</option>	
							</select>
						</div>
						<div class="errorInfoContent" id="donationTypeError_add" style="display: none;"></div>
						<div class="form-group">
							<label for="donationItem_add">捐赠明细：</label>
							<input type="text" class="form-control" id="donationItem_add" name="donationItem">
						</div>
						<div class="errorInfoContent" id="donationItemError_add" style="display: none;"></div>
						<div class="form-group">
							<label for="donationDate_add">捐赠日期：</label>
							<input type="date" class="form-control" id="donationDate_add" name="donationDate">
						</div>
						<div class="errorInfoContent" id="donationDateError_add" style="display: none;"></div>
					</div>
				</div>
				</form>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-info" onclick="resetForm();">重置
					</button>
					<button type="button" class="btn btn-success" onclick="submitInsertForm('${pageContext.request.contextPath}','add');">
						提交
					</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 更新捐赠记录 -->
	<div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="customModal_update" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="customModal_update">
						添加捐赠记录
					</h4>
				</div>
				<form action="${pageContext.request.contextPath }/donation/update.action" method="post" id="ff_update">
				<div class="modal-body">
					<div class="addDiv">
						<input type="hidden" id="donationId_update" name="donationId"/>
						<div class="form-group">
							<label for="truename_update">捐赠人：</label>
							<input class="form-control" id="truename_update" name="truename"/>
						</div>
						<div class="errorInfoContent" id="truenameError_update" style="display: none;"></div>
						<div class="form-group">
							<label for="studNumber_update">捐赠人学号：</label>
							<input class="form-control" id="studNumber_update" name="studNumber"/>
						</div>
						<div class="errorInfoContent" id="studNumberError_update" style="display: none;"></div>
						<div class="form-group">
							<label for="donationProject_update">捐赠用途：</label>
							<input class="form-control" id="donationProject_update" name="donationProject" />
						</div>
						<div class="errorInfoContent" id="donationProjectError_update" style="display: none;"></div>
						<div class="form-group">
							<label for="donationType_update">捐赠物品的类别：</label>
							<select class="form-control" id="donationType_update" name="donationType">
	<!-- 							<option value="">全部</option> -->
								<option value="0">基金</option>
								<option value="1">其他</option>	
							</select>
						</div>
						<div class="errorInfoContent" id="donationTypeError_update" style="display: none;"></div>
						<div class="form-group">
							<label for="donationItem_update">捐赠明细：</label>
							<input type="text" class="form-control" id="donationItem_update" name="donationItem">
						</div>
						<div class="errorInfoContent" id="donationItemError_update" style="display: none;"></div>
						<div class="form-group">
							<label for="donationDate_update">捐赠日期：</label>
							<input type="date" class="form-control" id="donationDate_update" name="donationDate">
						</div>
						<div class="errorInfoContent" id="donationDateError_update" style="display: none;"></div>
					</div>
				</div>
				</form>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-info" onclick="resetForm();">重置
					</button>
					<button type="button" class="btn btn-success" onclick="submitUpdateForm('${pageContext.request.contextPath}','update');">
						更新
					</button>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../baseView/footer.jsp"></jsp:include>
</body>
<script src="../js/jquery-1.9.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/loginController/loginAndLogout.js"></script>
<script src="../js/donationControl/donation_adm.js"></script>
</html>