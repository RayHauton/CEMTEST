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
		flag = false;
		errorDiv.innerHTML = prefix + "请选择归属的学位水平" + suffix;
		errorDiv.style.display = "block";
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
			window.alert("可以提交了");
			document.getElementById("ff_add").submit();
		}
	} else {
		window.alert("信息尚未存在未完善之处，请检查！");
	}
}
/**
 * 每次点击新增按钮的时候恢复错误提示div原来的状态（不显示，内容为空）
 */
function resetErrorDiv(){
	var errorDivArr = document.getElementsByClassName("errorInfo");
	var divsSize = errorDivArr.length;
	for(var i=0;i<divsSize;i++){
		var errorDiv = errorDivArr[i];
		errorDiv.innerHTML = "";
		errorDiv.style.display = "none";
	}
}













