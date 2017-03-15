/**
 * 管理员用户的捐赠公告界面的js控制
 */
var prefix = "<font color='orange'>";
var suffix = "</font>";
function submitFormOfQuery(pageIndex) {
	document.getElementById("pageIndex").value = pageIndex;
	document.getElementById("queryForm").submit();
}
// 检验捐赠人姓名是否为空
function checkTrueName(operation) {
	var truename = document.getElementById("truename_" + operation).value;
	var check = true;
	var div = document.getElementById("truenameError_" + operation);
	if (truename.length == 0) {
		div.style.display = "block";
		div.innerHTML = prefix + "请填写捐赠人姓名" + suffix;
		check = false;
	} else {
		div.style.display = "none";
		div.innerHTML = "";
		check = true;
	}
	return check;
}
// 检验捐赠人学号
function checkStudNumber(operation) {
	var studNumber = document.getElementById("studNumber_" + operation).value;
	var check = true;
	var div = document.getElementById("studNumberError_" + operation);
	if (studNumber.length == 0) {
		div.style.display = "block";
		div.innerHTML = prefix + "请填写学号" + suffix;
		check = false;
	} else {
		div.style.display = "none";
		div.innerHTML = "";
		check = true;
	}
	return check;
}
// 检验捐赠用途
function checkDonationProject(operation) {
	var donationProject = document.getElementById("donationProject_"
			+ operation).value;
	var check = true;
	var div = document.getElementById("donationProjectError_" + operation);
	if (donationProject.length == 0) {
		div.style.display = "block";
		div.innerHTML = prefix + "请填写捐赠用途" + suffix;
		check = false;
	} else {
		div.style.display = "none";
		div.innerHTML = "";
		check = true;
	}
	return check;
}
// 检查捐赠物品
function checkDonationItem(operation) {
	var donationItem = document.getElementById("donationItem_" + operation).value;
	var check = true;
	var div = document.getElementById("donationItemError_" + operation);
	if (donationItem.length == 0) {
		div.style.display = "block";
		div.innerHTML = prefix + "请填写捐赠明细（物品详情）" + suffix;
		check = false;
	} else {
		div.style.display = "none";
		div.innerHTML = "";
		check = true;
	}
	return check;
}
// 检验捐赠日期
function checkDonationDate(operation) {
	var donationDate = document.getElementById("donationDate_" + operation).value;
	var check = true;
	var div = document.getElementById("donationDateError_" + operation);
	if (donationDate.length == 0) {
		div.style.display = "block";
		div.innerHTML = prefix + "请填写捐赠日期" + suffix;
		check = false;
	} else {
		div.style.display = "none";
		div.innerHTML = "";
		check = true;
	}
	return check;
}
// 检查增加记录表单是否可以提交
function submitInsertForm(urlPrefix, operation) {
	var studNumber = document.getElementById("studNumber_" + operation).value;
	var truename = document.getElementById("truename_" + operation).value;
	if (checkTrueName(operation) && checkStudNumber(operation)
			&& checkDonationProject(operation) && checkDonationDate(operation)
			&& checkDonationItem(operation)) {
		// 此处要检查学号和姓名是否能对应起来
		$.ajax({
			type : 'POST',
			data : 'studNumber=' + studNumber + "&truename=" + truename,
			url : urlPrefix + "/donation/checkUserInfo.action",
			async : true,
			error : function() {
				alert("未知错误~");
			},
			success : function(data) {
				if (data == 'right') {// 说明学号和真实姓名匹配，可以提交增加(更新)记录表单
//					console.log(document.getElementById("ff_add"));
					document.getElementById("ff_"+operation).submit();
				} else if (data == "fault") {// 学号和姓名不匹配，拒绝添加
					alert("姓名与该学号对应的用户的姓名不匹配！请检查");
					return;
				} else if (data == "notExist") {// 学号对应的用户不存在，拒绝添加
					alert("该学号对应的用户不存在，学号无效，请检查");
				}
			}
		});
	}
}
/*
 * 删除记录控制
 */
function deleteRecord(urlPrefix,pageIndex,obj){
	console.log(obj.parentNode.parentNode.children[1].innerText);
	var donationId = obj.parentNode.parentNode.children[1].innerText;
	if(!window.confirm("确认要删除吗?")){
		return;
	}
	$.ajax({
		type:'POST',
		url:urlPrefix+"/donation/delete.action",
		data:'donationId='+donationId,
		async:true,
		error:function(){
			alert("服务器错误");
		},
		success:function(data){
			if(data=='succ'){
				alert("删除成功");
				submitFormOfQuery(pageIndex);
			}else{
				alert("删除失败");
			}
		}
	});
}
/**
 * @Param obj 按钮对象
 * 出发更新按钮的时候将对应信息填充进更新表单
 */
function fillTheUpdateForm(obj){
	var tds = obj.parentNode.parentNode.children;
	document.getElementById("donationId_update").value=tds[0].innerText;
	document.getElementById("truename_update").value=tds[1].innerText;
	document.getElementById("studNumber_update").value=tds[2].innerText;
	document.getElementById("donationProject_update").value=tds[3].innerText;
//	document.getElementById("donationType_update").value=tds[4];
	document.getElementById("donationItem_update").value=tds[5].innerText;
	document.getElementById("donationDate_update").value=tds[6].innerText;
	var options = document.getElementById("donationType_update").options;
	var size = options.length;
	for(var i=0;i<size;i++){
		if(options[i].innerText==tds[4].innerText){
			options[i].selected=true;
		}
	}
}
function submitUpdateForm(urlPrefix, operation){
	submitInsertForm(urlPrefix, operation);//调用插入记录的时候的验证代码，是通用的
}

function resetForm(){
	document.getElementById("truename").value="";
	document.getElementById("donationProject").value="";
	document.getElementById("donationType").options[0].selected=true;
	document.getElementById("foredate").value="";
	document.getElementById("afterdate").value="";
	document.getElementById("pageSize").options[0].selected=true;
}








