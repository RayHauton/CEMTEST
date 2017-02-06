/**
 * 注册时候注册信息的检测
 */
var succPrefix = "<font color='blue' size='3'><b>";
var succSuffix = "</b></font>";
var errorPrefix = "<font color='red'>";
var errorSuffix = "</font>";
/*
 * 表单验证标志
 */
var username_chk=false;
var mobile_chk=false;
var email_chk=false;
var studNum_chk=false;
function checkUnique(which, elemtId, infoId) {
	// 获取检查的元素value
	var checkEle = document.getElementById(elemtId).value;
	var urlPrefix = document.getElementById("urlPrefix").value;
	var succCallbackFun;
	if (which == 'username') {
		var firstCheck = checkUsername(checkEle);
		if (firstCheck != '') {
			document.getElementById(infoId).innerHTML = errorPrefix
					+ firstCheck + errorSuffix;
			username_chk=false;
			return;
		}
		succCallbackFun = function(data) {
			if (data == 'usernameExist') {
				// 说明用户名已经存在
				document.getElementById(infoId).innerHTML = errorPrefix
						+ "用户名已经存在" + errorSuffix;
				username_chk=false;
			} else {
				document.getElementById(infoId).innerHTML = succPrefix + "√"
						+ succSuffix;
				username_chk=true;
			}
		}
	} else if (which == 'mobile') {
		var firstCheck = checkMobile(checkEle);
		if (firstCheck != '') {
			document.getElementById(infoId).innerHTML = errorPrefix
					+ firstCheck + errorSuffix;
			mobile_chk=false;
			return;
		}
		succCallbackFun = function(data) {
			if (data == 'mobileExist') {
				// 说明使用该手机号的用户已经存在
				document.getElementById(infoId).innerHTML = errorPrefix
						+ "该手机号已经注册" + errorSuffix;
				mobile_chk=false;
			} else {
				document.getElementById(infoId).innerHTML = succPrefix + "√"
						+ succSuffix;
				mobile_chk=true;
			}
		}
	} else if (which == 'email') {
		var firstCheck = checkEmail(checkEle);
		if (firstCheck != '') {
			document.getElementById(infoId).innerHTML = errorPrefix
					+ firstCheck + errorSuffix;
			email_chk=false;
			return;
		}
		succCallbackFun = function(data) {
			if (data == 'emailExist') {
				// 说明该邮箱已经注册
				document.getElementById(infoId).innerHTML = errorPrefix
						+ "该邮箱已经注册" + errorSuffix;
				email_chk=false;
			} else {
				document.getElementById(infoId).innerHTML = succPrefix + "√"
						+ succSuffix;
				email_chk=true;
			}
		}
	} else if (which == 'studNum') {
		var firstCheck = checkStudNum(checkEle);
		if(firstCheck==0){
			//未填学号
			studNum_chk=true;
			return;
		}else if(firstCheck==1){
			//学号格式正确
			studNum_chk=true;
		}else{
			//学号格式不正确
			document.getElementById(infoId).innerHTML = errorPrefix
			+ firstCheck + errorSuffix;
			studNum_chk=false;
			return;
		}
		succCallbackFun = function(data) {
			if (data == 'studNumberExist') {
				// 说明该学号已经注册
				document.getElementById(infoId).innerHTML = errorPrefix
						+ "该学号已经注册" + errorSuffix;
				studNum_chk=false;
			} else {
				document.getElementById(infoId).innerHTML = succPrefix + "√"
						+ succSuffix;
				studNum_chk=true;
			}
		}
	}
	$.ajax({
		cache : false,
		type : "POST",
		url : urlPrefix + "/registerCheck.action",
		data : {
			check : which,
			checkValue : checkEle
		},
		async : true,
		error : function() {
			window.alert("服务器错误！");
		},
		success : succCallbackFun
	});
}
/*
 * 检查表单是否可以提交
 */
function checkFormIfCouldSubmit(){
	if(username_chk && email_chk && mobile_chk && studNum_chk){
		window.alert("yes!");
		return true;
	}else{
		alert("no!");
		return false;
	}
}
/*
 * 检查学号是否正确
 */
function checkStudNum(studNum){
	//学号可以不填
	var reg=/^\d{9,10}$/;
	if(studNum!='' && studNum.length!=0 && !reg.test(studNum)){
		return '请输入正确的学号';//能进到这个控制块内部说明用户一定输入了学号 并且学号格式不对，否则逻辑短路跳到else；
	}else if(studNum=='' || studNum.length==0){
		return 0;
	}else{
		return 1;
	}
}
/*
 * 检查邮箱是否正确
 */
function checkEmail(email) {
	if (email == '' || email.length == 0) {
		return "邮箱不能为空";
	} else {
		var reg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
		if (!reg.test(email)) {
			return "请输入正确的邮箱";
		} else {
			return '';
		}
	}
}
/*
 * 检查用户名是否为空
 */
function checkUsername(username) {
	if (username == '' || username.length == 0) {
		return "用户名不能为空";
	} else {
		return '';
	}
}
/*
 * 检查手机号是否合法
 */
function checkMobile(mobile) {
	if (mobile == '' || mobile.length == 0) {
		return "手机号不能为空";
	} else {
		// 判断是否是手机号
		var reg = /^1[3|4|5|7|8][0-9]{9}$/; // 验证规则
		var flag = reg.test(mobile);
		if (!flag) {
			return "请填写正确的手机号码";
		} else {
			return '';
		}
	}
}
