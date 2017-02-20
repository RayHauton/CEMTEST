/**
 * 这js是发布招聘信息界面的控制
 */
/**
 * 检查表单数据是否合法，并显示错误信息
 */
var prefix = "<font color='red'><b>";
var suffix = "</b></font>";
function checkFormIllegal() {
	var flag = true;//标志位
	var companyName = document.getElementById("companyName").value;
	var connectWay = document.getElementById("connectWay").value;
	var summary = document.getElementById("summary").value;
	var errorDiv = document.getElementById("errorDiv");
	var errorDivInnerOne = document.getElementById("errorDivInnerOne");
	errorDiv.innerHTML="";
	errorDiv.style.borderRadius="";
	if(companyName=='' || companyName.length==0){
		errorDivInnerOne.style.display="block";
		errorDiv.style.borderRadius="3px";
		errorDiv.style.border="1px solid red";
		errorDiv.innerHTML+=prefix+"单位名称"+suffix+"不能为"+prefix+"空"+suffix+"！</br>";
		flag=false;
	}
	if(connectWay=='' || connectWay.length==0){
		errorDivInnerOne.style.display="block";
		errorDiv.style.borderRadius="3px";
		errorDiv.style.border="1px solid red";
		errorDiv.innerHTML+=prefix+"联系方式"+suffix+"不能为"+prefix+"空"+suffix+"！</br>";
		flag=false;
	}
	if(summary=='' || summary.length==0){
		errorDivInnerOne.style.display="block";
		errorDiv.style.borderRadius="3px";
		errorDiv.style.border="1px solid red";
		errorDiv.innerHTML+=prefix+"信息简介"+suffix+"不能为"+prefix+"空"+suffix+"！</br>";
		flag=false;
	}
	if(flag){
		errorDivInnerOne.style.display="none";
		errorDiv.style.border="none";
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
	errorDivInnerOne.style.display="none";
	errorDiv.style.border="none";
	errorDiv.innerHTML="";
}
/**
 * 显示上传的附件信息
 * 
 * @returns
 */
function showFile() {
	var file = document.getElementById("fileUpload").files[0];
	document.getElementById("flnm").innerHTML = file.name;
	document.getElementById("flsz").innerHTML = (file.size / 1024).toFixed(2)
			+ "kb";
	// document.getElementById("fltp").innerHTML=file.type;
	document.getElementById("flmddt").innerHTML = new Date(file.lastModified)
			.toLocaleDateString();
}