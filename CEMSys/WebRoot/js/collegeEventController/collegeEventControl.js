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
function checkTitle() {
	var titleContent = document.getElementById("eventTitle").value;
	var eventTitleError = document.getElementById("eventTitleError");
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
function checkDetail() {
	var eventDetail = document.getElementById("eventDetail").value;
	var eventDetailError = document.getElementById("eventDetailError");
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
function checkDate() {
	var eventDate = document.getElementById("eventDate").value;
	var eventDateError = document.getElementById("eventDateError");
	if (eventDate.length == 0) {
		eventDateError.style.display = "block";
		eventDateError.innerHTML = prefix + "请输入或选择事件日期" + suffix;
		dateCheck = false;
		return;
	}
	eventDateError.style.display = "none";
	dateCheck = true;
}
function checkImg() {
	var image = document.getElementById("image").files[0];
	var imageError = document.getElementById("imageError");
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
	document.getElementById("ff").reset();
	for (var i = 0; i < errorInfoDivs.length; i++) {
		errorInfoDivs[i].style.display = "none";
		errorInfoDivs[i].innerHTML = "";
	}
}
function submitForm() {
	if (titleCheck && summaryCheck && dateCheck && imgCheck){
		alert("Go!");
		document.getElementById("ff").submit();
	}else{
		window.alert("提交的信息尚且存在错误，请检查");
	}
}
