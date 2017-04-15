/**
 * 专业信息设置的js控制
 */
var prefix = "<font color='orange' size='2'>";
var suffix = "</font>"
function checkMajorName(operation) {
	var majorName = document.getElementById("majorName_" + operation).value;
	var errorDiv = document.getElementById("majorNameError_" + operation);
	var flag = true;
	if (majorName == '' || majorName.length == 0) {
		errorDiv.innerHTML = prefix + "请输入专业名称" + suffix;
		errorDiv.style.display = "block";
		flag = false;
	} else {
		errorDiv.innerHTML = "";
		errorDiv.style.display = "none";
	}
	return flag;
}
/**
 * 检查选了那些学位
 * 
 * @param operation
 */
function checkWhichDegreeBelongTo(operation) {
	var degrees = document.getElementsByName("degreeId_" + operation);
	var size = degrees.length;
	var count = 0;
	var flag = true;
	for (var i = 0; i < size; i++) {
		if (degrees[i].checked) {
			count++;
		}
	}
	var errorDiv = document.getElementById("degreeNameError_" + operation);
	if (count == 0) {
		if (operation == "add") {
			flag = false;
			errorDiv.innerHTML = prefix + "请选择归属的学位水平" + suffix;
			errorDiv.style.display = "block";
		}
	} else {
		errorDiv.innerHTML = "";
		errorDiv.style.display = "none";
	}
	console.log(count);
	return flag;
}
function submitAddForm(operation) {
	var checkMajorBelongTo = checkWhichDegreeBelongTo(operation);
	var checkName = checkMajorName(operation);
	if (checkMajorBelongTo && checkName) {
		if (window.confirm("确认要添加专业信息吗？")) {
//			window.alert("可以提交了");
			document.getElementById("ff_add").submit();
		}
	} else {
		window.alert("信息尚未存在未完善之处，请检查！");
	}
}
/**
 * 每次点击新增按钮的时候恢复错误提示div原来的状态（不显示，内容为空）
 */
function resetErrorDiv() {
	var errorDivArr = document.getElementsByClassName("errorInfo");
	var divsSize = errorDivArr.length;
	for (var i = 0; i < divsSize; i++) {
		var errorDiv = errorDivArr[i];
		errorDiv.innerHTML = "";
		errorDiv.style.display = "none";
	}
}
/**
 * 根据专业获取归属学位信息
 */
function getDegreeIdByMajorId(url, obj) {
	resetErrorDiv();
	var majorId = obj.parentNode.parentNode.children[0].innerHTML;
	var majorName = obj.parentNode.parentNode.children[1].innerHTML;
	document.getElementById("majorId_hidden").value = majorId;
	document.getElementById("majorName_update").value = majorName;
	var degreeFromFront = document.getElementsByName("degreeId_update");
	var degreeCountFromFront = degreeFromFront.length;
	for (var i = 0; i < degreeCountFromFront; i++) {
		degreeFromFront[i].checked = false;
	}
	$.ajax({
		type : 'POST',
		url : url,
		async : true,
		data : "majorId=" + majorId,
		error : function() {
			window.alert("服务器错误！");
		},
		success : function(data) {
//			window.alert(data);
			// 解析数据
			var dataArr = data.split("|");
			var degreeCountFromBack = dataArr.length;
			for (var i = 0; i < degreeCountFromBack; i++) {
				for (var j = 0; j < degreeCountFromFront; j++) {
					console.log(degreeFromFront[degreeCountFromFront]);
					if (dataArr[i] == degreeFromFront[j].value) {
						degreeFromFront[j].checked = true;
					}
				}
			}
		}
	});
}
function submitUpdateForm() {
	var check_major = checkMajorName("update");
	var check_degree = checkWhichDegreeBelongTo("update");
	if (check_major && check_degree) {
		// 提交表单
		if (window.confirm("确认要更新专业信息吗？")) {
			document.getElementById("ff_update").submit();
		}
		return;
	} else {
		window.alert("信息尚且存在错误，请检查");
	}
}

function deleteRecord(obj, url) {
	var majorId = obj.parentNode.parentNode.children[0].innerHTML;
	if (window.confirm("确认要删除吗？")) {
		window.open(url + "?majorId=" + majorId, "_self");
	} else {
		return;
	}
}
