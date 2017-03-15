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
// 提交增加记录表单
function submitInsertForm(urlPrefix,operation) {
	var studNumber = document.getElementById("studNumber_" + operation).value;
	var truename = document.getElementById("truename_" + operation).value;
	if (checkTrueName(operation) && checkStudNumber(operation)
			&& checkDonationProject(operation) && checkDonationDate(operation)) {
		// 此处要检查学号和姓名是否能对应起来
		$.ajax({
			type : 'POST',
			data : 'studNumber='+studNumber+"&truename="+truename,
			url:urlPrefix+"/user/checkUserInfo.action",
			async:true,
			error:function(){
				alert("未知错误~");
			},
			success:function(data){
				if(data=='right'){//说明学号和真实姓名匹配，可以提交增加记录表单
					document.getElementById("ff_add").submit();
				}else if(data=="fault"){//学号和姓名不匹配，拒绝添加
					alert("姓名与该学号对应的用户的姓名不匹配！请检查");
					return;
				}else if(data=="notExist"){//学号对应的用户不存在，拒绝添加
					alert("该学号对应的用户不存在，学号无效，请检查");
				}
			}
		});
	}
}
