/**
 * 学院事件界面的控制
 */
/**
 * 检查标题是否合法
 */
var prefix = "<font color='orange'>";
var suffix = "</font>"
var titleCheck = false;
var summaryCheck = false;
var dateCheck = false;
var imgCheck = false;
function checkTitle(operation) {
	var titleContent = document.getElementById("eventTitle_"+operation).value;
	var eventTitleError = document.getElementById("eventTitleError_"+operation);
	if (titleContent.length > 0) {
		if (titleContent.length > 50) {
			eventTitleError.style.display = "block";
			eventTitleError.innerHTML = prefix + "最多输入50个字符" + suffix;
			return;
		}
	} else {
		eventTitleError.style.display = "block";
		eventTitleError.innerHTML = prefix + "请输入标题" + suffix;
		titleCheck = false;
		return;
	}
	eventTitleError.style.display = "none";
	titleCheck = true;
}
function checkDetail(operation) {
	var eventDetail = document.getElementById("eventDetail_"+operation).value;
	var eventDetailError = document.getElementById("eventDetailError_"+operation);
	if (eventDetail.length > 0) {
		if (eventDetail.length > 250) {
			eventDetailError.style.display = "block";
			eventDetailError.innerHTML = prefix + "事件概要内容长度不能超出500字符" + suffix;
			summaryCheck = false;
			return;
		}
	} else {
		eventDetailError.style.display = "block";
		eventDetailError.innerHTML = prefix + "请输入事件概要，内容长度不要超过500字符" + suffix;
		summaryCheck = false;
		return;
	}
	eventDetailError.style.display = "none";
	summaryCheck = true;
}
function checkDate(operation) {
	var eventDate = document.getElementById("eventDate_"+operation).value;
	var eventDateError = document.getElementById("eventDateError_"+operation);
	if (eventDate.length == 0) {
		eventDateError.style.display = "block";
		eventDateError.innerHTML = prefix + "请输入或选择事件日期" + suffix;
		dateCheck = false;
		return;
	}
	eventDateError.style.display = "none";
	dateCheck = true;
}
function checkImg(operation) {
	var image = document.getElementById("image_"+operation).files[0];
	var imageError = document.getElementById("imageError_"+operation);
	if (image == null) {
		imageError.style.display = "block";
		imageError.innerHTML = prefix + "请上传图片" + suffix;
		return;
	} else {
		var reg = /\.png|\.jpg|\.bmp|\.gif|\.JPG|\.PNG|\.GIF|\.jpeg|\.JPEG/;
		if (!reg.test(image.name)) {
			imageError.style.display = "block";
			imageError.innerHTML = prefix + "格式不正确，请确保上传的是图片" + suffix;
			return;
		}
	}
	imageError.style.display = "none";
	imgCheck = true;
}
function resetForm() {
	var errorInfoDivs = document.getElementsByClassName("errorInfoContent");
	document.getElementById("ff_add").reset();
	for (var i = 0; i < errorInfoDivs.length; i++) {
		errorInfoDivs[i].style.display = "none";
		errorInfoDivs[i].innerHTML = "";
	}
}
function submitForm(operation,form,pageIndex) {
	checkTitle(operation);
	checkDetail(operation);
	checkDate(operation);
	checkImg(operation);
	//如果是update操作那么上传图片的表单可以为空，因为用户可能不更改图片而是更改其他内容
	if (titleCheck && summaryCheck && dateCheck){
		if(operation!="update"){
			if(imgCheck){
				alert("Go!");
			}else{
				window.alert("提交的信息尚且存在错误，请检查");
			}
			
		}else{
			alert("Go!");
		}
		titleCheck = false;
		summaryCheck = false;
		dateCheck = false;
		imgCheck = false;
		if(form=='ff_add'){
			document.getElementById(form).submit();
		}else{//如果是更新操作 跳转到另一函数进行异步提交,这个地方我自己都觉得写得耦合太严重
			document.getElementById("ff_update").submit();
		}
	}else{
		window.alert("提交的信息尚且存在错误，请检查");
	}
}
function fillUpdateInfo(obj){
	var tds = obj.parentNode.parentNode.children;
	document.getElementById("eventId_update").value=tds[0].innerText;
	document.getElementById("eventTitle_update").value=tds[1].innerText;
	document.getElementById("eventDetail_update").value=tds[2].innerText;
	document.getElementById("eventDate_update").value=tds[3].innerText;
	console.log(document.getElementById("eventId_update").value);
}
function submitFormOfQuery(pageIndex){
	document.getElementById("pageIndex").value=pageIndex;
	document.getElementById("ff_query").submit();
}

function deleteRecord(url,obj,pageIndex){
	if(!window.confirm("确认要删除这条记录吗？")){
		console.log(obj.parentNode.parentNode.children[0].innerText);
		return;
	}
	$.ajax({
		type:'POST',
		url:url,
		async:true,
		data:"eventId="+obj.parentNode.parentNode.children[0].innerText,
		error:function(){
			window.alert("数据删除失败！");
		},
		success:function(){
			window.alert("删除成功！");
			//重新提交查询表单，刷新数据
			submitFormOfQuery(pageIndex);
		}
	});
}
/*
 * 加载事件标题以及时间详细介绍
 */
function showInfo(url,type,obj){
	document.getElementById("infoBody").innerText="正在加载信息，请稍后...";
	var tr = obj.parentNode.parentNode.parentNode;
	var flag;
	if(type=='detail'){
		flag=1;
		document.getElementById("myModalLabel_info").innerHTML="事件详细查看";
	}else{
		flag=2;
		document.getElementById("myModalLabel_info").innerHTML="事件标题查看";
	}
	$.ajax({
		type:'POST',
		url:url,
		async:true,
		data:"eventId="+tr.children[0].innerText+"&flag="+flag,
		error:function(){
			window.alert("数据加载失败！");
		},
		success:function(data){
			document.getElementById("infoBody").innerText=data;
		}
	});
}
/*
 * 加载图片
 */
function loadImg(url,obj,systemDomain){
	document.getElementById("infoBody").innerText="正在加载图片，请稍后...";
	var tr = obj.parentNode.parentNode;
	$.ajax({
		type:'POST',
		url:url,
		async:true,
		data:"eventId="+tr.children[0].innerText,
		error:function(){
			window.alert("数据加载失败！");
		},
		success:function(data){
			document.getElementById("imgInfo").src="http://"+systemDomain+"/fileUpload/collegeEventImgs/"+data;
		}
	});
}



