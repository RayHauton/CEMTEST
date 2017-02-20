/**
 * 这个js是发布招聘信息界面的控制
 */
function submitForm(){//真正的提交表单
	var formData = new FormData();
	formData.append("userId",$("#userId"));
	formData.append("truename",$("#truename"));
	formData.append("companyName",$("#companyName"));
	formData.append("connectWay",$("#connectWay"));
	formData.append("connectWay",$("#connectWay"));
	formData.append("attachment",$("#fileUpload")[0].files[0]);
	formData.append("summary",$("#summary"));
	$.ajax({
		type:'POST',
		url:$("#basePath").val()+"/recruitment/publish.action",
		data:formData,
		processData:false,
		contentType:false,
		beforeSend:function(){
			//gif显示
		},
		success:function(data){
			if(data=="succ"){
				window.alert("信息发布成功！");
			}
		},
		error:function(){
			window.alert("服务器错误！");
		}
	});
}
/**
 * 检查表单数据是否合法，并显示错误信息
 */
var prefix = "<font color='red'><b>";
var suffix = "</b></font>";
function checkFormIllegal() {
	var flag = true;// 标志位
	var companyName = document.getElementById("companyName").value;
	var connectWay = document.getElementById("connectWay").value;
	var summary = document.getElementById("summary").value;
	var errorDiv = document.getElementById("errorDiv");
	var errorDivInnerOne = document.getElementById("errorDivInnerOne");
	errorDiv.innerHTML = "";
	errorDiv.style.borderRadius = "";
	if (companyName == '' || companyName.length == 0) {
		errorDivInnerOne.style.display = "block";
		errorDiv.style.borderRadius = "3px";
		errorDiv.style.border = "1px solid red";
		errorDiv.innerHTML += prefix + "单位名称" + suffix + "不能为" + prefix + "空"
				+ suffix + "！</br>";
		flag = false;
	}
	if (connectWay == '' || connectWay.length == 0) {
		errorDivInnerOne.style.display = "block";
		errorDiv.style.borderRadius = "3px";
		errorDiv.style.border = "1px solid red";
		errorDiv.innerHTML += prefix + "联系方式" + suffix + "不能为" + prefix + "空"
				+ suffix + "！</br>";
		flag = false;
	}
	if (summary == '' || summary.length == 0 || summary.length>100) {
		errorDivInnerOne.style.display = "block";
		errorDiv.style.borderRadius = "3px";
		errorDiv.style.border = "1px solid red";
		if(summary.length<=100){
			errorDiv.innerHTML += prefix + "信息简介" + suffix + "不能为" + prefix + "空"
			+ suffix + "！</br>";
		}else{
			errorDiv.innerHTML += prefix+"信息简介"+suffix+"长度超出了"+prefix+"100"+suffix+"汉字";;
		}
		flag = false;
	}
	if (flag && checkFileWhenSubmit) {
		errorDivInnerOne.style.display = "none";
		errorDiv.style.border = "none";
		document.getElementById("fileError").innerHTML="";
		alert("可以提交了");
		document.getElementById("form").submit();
	}
}
function checkFileWhenSubmit(){
	if(fileTypeFlag || document.getElementById("fileUpload").files[0]==null){
		//当用户没有上传文档或者上传文档格式正确的时候返回true，意味着表单的文件数据已经合法
		return true;
	}else{
		return false;
	}
}
/**
 * 重置表单
 */
function resetFrom() {
	document.getElementById("form").reset();
	document.getElementById("flnm").innerHTML = "...";
	document.getElementById("flsz").innerHTML = "...";
	// document.getElementById("fltp").innerHTML=file.type;
	document.getElementById("flmddt").innerHTML = "...";
	var errorDiv = document.getElementById("errorDiv");
	var errorDivInnerOne = document.getElementById("errorDivInnerOne");
	errorDivInnerOne.style.display = "none";
	errorDiv.style.border = "none";
	errorDiv.innerHTML = "";
	document.getElementById("fileError").innerHTML="";
	fileTypeFlag = false;
}
/**
 * 显示上传的附件信息
 * 
 * @returns
 */
var fileTypeFlag = false;//判断文件类型是否正确，便于提交表单的时候进行检验
function showFile() {
	var file = document.getElementById("fileUpload").files[0];
	var reg = /\.rar|\.zip/;
	if (!reg.test(file.name)) {
		fileCheckFlag = false;
		document.getElementById("fileError").innerHTML=prefix+"文件类型不正确！*.rar或*.zip"+suffix;
		return;
	}else{
		document.getElementById("fileError").innerHTML="";
	}
	fileCheckFlag = true;
	document.getElementById("flnm").innerHTML = file.name;
	document.getElementById("flsz").innerHTML = (file.size / 1024).toFixed(2)
			+ "kb";
	// document.getElementById("fltp").innerHTML=file.type;
	document.getElementById("flmddt").innerHTML = new Date(file.lastModified)
			.toLocaleDateString();
}
