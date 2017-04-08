/**
 * 校友会界面的js控制
 */
var prefix = "<font color='orange'>";
var suffix = "</font>"
function checkName(operation) {
	var name = document.getElementById("alumniAssociationName_" + operation).value;
	var errorDiv = document.getElementById("alumniAssociationNameError_"
			+ operation);
	var flag = false;
	if (name == '' || name.length == 0) {
		errorDiv.style.display = "block";
		errorDiv.innerHTML = prefix + "名称不能为空！" + suffix;
	} else {
		errorDiv.style.display = "none";
		flag = true;
	}
	return flag;
}
function checkContactPerson(operation) {
	var contactPerson = document.getElementById("contactPerson_" + operation).value;
	var errorDiv = document.getElementById("contactPersonError_" + operation);
	var flag = false;
	if (contactPerson == '' || contactPerson.length == 0) {
		errorDiv.style.display = "block";
		errorDiv.innerHTML = prefix + "联系人不能为空！" + suffix;
	} else {
		errorDiv.style.display = "none";
		flag = true;
	}
	return flag;
}
function checkContactWay(operation) {
	var contactWay = document.getElementById("contactWay_" + operation).value;
	var errorDiv = document.getElementById("contactWayError_" + operation);
	var flag = false;
	if (contactWay == '' || contactWay.length == 0) {
		errorDiv.style.display = "block";
		errorDiv.innerHTML = prefix + "联系方式不能为空！" + suffix;
	} else {
		errorDiv.style.display = "none";
		flag = true;
	}
	return flag;
}
function checkImg(operation) {
	var file = document.getElementById("img_" + operation).files[0];
	var errorDiv = document.getElementById("imgError_" + operation);
	var flag = false;
	var reg = /\.png|\.jpg|\.bmp|\.gif|\.JPG|\.PNG|\.GIF|\.jpeg|\.JPEG/;
	if(operation=='add'){
		if (file != null) {
			if (!reg.test(file.name)) {
				errorDiv.style.display = "block";
				errorDiv.innerHTML = prefix + "格式不正确，请确保上传的是图片" + suffix;
			} else {
				errorDiv.style.display = "none";
				flag = true;
			}
		} else {
			errorDiv.style.display = "block";
			errorDiv.innerHTML = prefix + "请上传图片" + suffix;
			flag = false;
		}
	}
	return flag;
}
/**
 * @param operation add or update
 */
function submitForm(operation) {
	var f1 = checkName(operation);
	var f2 = checkContactPerson(operation);
	var f3 = checkContactWay(operation);
	var f4 = checkImg(operation);
	if (f1 && f2 && f3) {
		if((operation=='add' && f4) || (operation=="update")){
			document.getElementById("ff_"+operation).submit();
		}else{
			window.alert("信息尚且存在不合法的地方，请仔细检查~");
		}
	} else {
		window.alert("信息尚且存在不合法的地方，请仔细检查~");
	}
}

function showImg(obj){
	console.log(obj.parentNode.getAttribute("id"));
	var img = document.getElementById("imgDetail");
	img.setAttribute("src",obj.parentNode.getAttribute("id"));
	img.onload=function(){
		var width = img.width;
		var height = img.height;
		if(width<=560 && height<=350){
			img.style.marginLeft=(560-width)/2+"px";
			img.style.marginRight=(560-width)/2+"px";
			img.style.marginTop=(350-height)/2+"px";
			img.style.marginTop=(350-height)/2+"px";
		}else if(width<=560 && height>350){
			var newWidth = 350*width/height;
			img.style.marginLeft=(560-newWidth)/2+"px";
			img.style.marginRight=(560-newWidth)/2+"px";
			img.setAttribute("width",newWidth+"px");
			img.setAttribute("height","350px");
		}else if(width>560 && height<=350){
			var newHeight = 560*height/width;
			img.style.marginTop=(350-newHeight)/2+"px";
			img.style.marginBottom=(350-newHeight)/2+"px";
			img.setAttribute("width","560px");
			img.setAttribute("height",newHeight);
		}else{
			if(width/560>=height/350){
				var newHeight=height*560/width;
				var newWidth = width*newHeight/height;
				img.setAttribute("width","560px");
				img.setAttribute("height",newHeight);
			}else{
				var newWidth = width*350/height;
				var newHeight = height*newWidth/width;
				img.setAttribute("width",newWidth);
				img.setAttribute("height","350px");
			}
		}
	}
}
function clearImgCache(){
	var img = document.getElementById("imgDetail");
	img.removeAttribute("src");
	img.removeAttribute("width");
	img.removeAttribute("height");
	img.removeAttribute("style");
}
function fillUpdateForm(obj){
	var errorDivs = document.getElementsByClassName("errorInfoContent");
	var size = errorDivs.length;
	for(var i=0;i<size;i++){
		errorDivs[i].style.display="none";
		errorDivs[i].innerHTML="";
	}
	var tds = obj.parentNode.parentNode.children;
	console.log(tds);
	document.getElementById("ID").value=tds[0].innerHTML;
	document.getElementById("alumniAssociationName_update").value=tds[1].innerHTML;
	document.getElementById("contactPerson_update").value=tds[2].innerHTML;
	document.getElementById("contactWay_update").value=tds[3].innerHTML;
}
function deleteRecord(url,obj){
	if(window.confirm("确认要删除吗？")){
		var tds = obj.parentNode.parentNode.children;
		console.log(tds);
		window.open(url+"?id="+obj.parentNode.parentNode.children[0].innerHTML,"_self");
	}else{
		return;
	}
}
function resize(obj,imgW,imgH){
//	var newHeight = 400*imgW/1000;
//	obj.setAttribute("width","1000px");
//	obj.setAttribute("height",newHeight);
	var width = obj.width;
	var height = obj.height;
	if(width<=1000 && height<=400){
		obj.style.marginLeft=(1000-width)/2+"px";
		obj.style.marginRight=(1000-width)/2+"px";
		obj.style.marginTop=(400-height)/2+"px";
		obj.style.marginTop=(400-height)/2+"px";
	}else if(width<=1000 && height>400){
		var newWidth = 400*width/height;
		obj.style.marginLeft=(1000-newWidth)/2+"px";
		obj.style.marginRight=(1000-newWidth)/2+"px";
		obj.setAttribute("width",newWidth+"px");
		obj.setAttribute("height","400px");
	}else if(width>1000 && height<=400){
		var newHeight = 1000*height/width;
		obj.style.marginTop=(400-newHeight)/2+"px";
		obj.style.marginBottom=(400-newHeight)/2+"px";
		obj.setAttribute("width","1000px");
		obj.setAttribute("height",newHeight);
	}else{
		if(width/1000>=height/400){
			var newHeight=height*1000/width;
			var newWidth = width*newHeight/height;
			obj.setAttribute("width","1000px");
			obj.setAttribute("height",newHeight);
		}else{
			var newWidth = width*400/height;
			var newHeight = height*newWidth/width;
			obj.setAttribute("width",newWidth);
			obj.setAttribute("height","400px");
		}
	}
}





