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
var username_chk = false;
var mobile_chk = false;
var email_chk = false;
var studNum_chk = false;
var truename_chk = false;
var password_chk = false;
var confirmPass_chk = false;
var admitedDate_chk = false;
var major_chk = false;
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
			username_chk = false;
			return;
		}
		succCallbackFun = function(data) {
			if (data == 'usernameExist') {
				// 说明用户名已经存在
				document.getElementById(infoId).innerHTML = errorPrefix
						+ "用户名已经存在" + errorSuffix;
				username_chk = false;
			} else {
				document.getElementById(infoId).innerHTML = succPrefix + "√"
						+ succSuffix;
				username_chk = true;
			}
		}
	} else if (which == 'mobile') {
		var firstCheck = checkMobile(checkEle);
		if (firstCheck != '') {
			document.getElementById(infoId).innerHTML = errorPrefix
					+ firstCheck + errorSuffix;
			mobile_chk = false;
			return;
		}
		succCallbackFun = function(data) {
			if (data == 'mobileExist') {
				// 说明使用该手机号的用户已经存在
				document.getElementById(infoId).innerHTML = errorPrefix
						+ "该手机号已经注册" + errorSuffix;
				mobile_chk = false;
			} else {
				document.getElementById(infoId).innerHTML = succPrefix + "√"
						+ succSuffix;
				mobile_chk = true;
			}
		}
	} else if (which == 'email') {
		var firstCheck = checkEmail(checkEle);
		if (firstCheck != '') {
			document.getElementById(infoId).innerHTML = errorPrefix
					+ firstCheck + errorSuffix;
			email_chk = false;
			return;
		}
		succCallbackFun = function(data) {
			if (data == 'emailExist') {
				// 说明该邮箱已经注册
				document.getElementById(infoId).innerHTML = errorPrefix
						+ "该邮箱已经注册" + errorSuffix;
				email_chk = false;
			} else {
				document.getElementById(infoId).innerHTML = succPrefix + "√"
						+ succSuffix;
				email_chk = true;
			}
		}
	} else if (which == 'studNum') {
		var firstCheck = checkStudNum(checkEle);
		if (firstCheck == 0) {
			// 未填学号
			studNum_chk = true;
			return;
		} else if (firstCheck == 1) {
			// 学号格式正确
			studNum_chk = true;
		} else {
			// 学号格式不正确
			document.getElementById(infoId).innerHTML = errorPrefix
					+ firstCheck + errorSuffix;
			studNum_chk = false;
			return;
		}
		succCallbackFun = function(data) {
			if (data == 'studNumberExist') {
				// 说明该学号已经注册
				document.getElementById(infoId).innerHTML = errorPrefix
						+ "该学号已经注册" + errorSuffix;
				studNum_chk = false;
			} else {
				document.getElementById(infoId).innerHTML = succPrefix + "√"
						+ succSuffix;
				studNum_chk = true;
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
function checkFormIfCouldSubmit(urlPrefix) {
	if (username_chk && email_chk && mobile_chk && studNum_chk && truename_chk
			&& password_chk && confirmPass_chk && admitedDate_chk && major_chk) {
		window.alert("yes!");
		$.ajax({
			type : "POST",
			url : urlPrefix+"/register.action",
			data : $("#regisForm").serialize(),
			async : true,
			error : function() {
				window.alert("服务器错误！");
			},
			success : function(data) {
				if(data=="succ"){
					window.alert("注册成功，请耐心等待管理员审核，并且时刻关注注册进度通知的邮件！");
					window.location.href=urlPrefix+"/index.jsp";
				}else{
					window.alert("注册失败！请重试");
				}
			}
		});
		return true;
	} else {
		alert("no!");
		return false;
	}
}
/*
 * 检查学号是否正确
 */
function checkStudNum(studNum) {
	// 学号可以不填
	var reg = /^\d{9,10}$/;
	if (studNum != '' && studNum.length != 0 && !reg.test(studNum)) {
		return '请输入正确的学号';// 能进到这个控制块内部说明用户一定输入了学号 并且学号格式不对，否则逻辑短路跳到else；
	} else if (studNum == '' || studNum.length == 0) {
		return 0;
	} else {
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
/*
 * 检验入学年份
 */
function checkAdmitDate() {
	var admitDate = document.getElementById("admitDate").value;
	var checkAdmitDate = document.getElementById("checkAdmitDate");
	if (admitDate != '' && admitDate.length != 0) {
		admitedDate_chk = true;
		checkAdmitDate.innerHTML = succPrefix + "√" + succSuffix;
	} else {
		admitedDate_chk = false;
		checkAdmitDate.innerHTML = errorPrefix + "请选择入学日期" + errorSuffix;
	}
}
/*
 * 检验专业
 */
function checkMajor() {
	var majorSelected = document.getElementById("majorSection").value;
	var checkMajorSection = document.getElementById("checkMajorSection");
	if (majorSelected == 'default') {
		// 没选专业
		checkMajorSection.innerHTML = errorPrefix + "请选择专业" + errorSuffix;
		major_chk = false;
	} else {
		checkMajorSection.innerHTML = succPrefix + "√" + succSuffix;
		major_chk = true;
	}
}
/*
 * 检验注册时候的确认密码
 */
function checkConfirmPassword() {
	var password = document.getElementById("password").value;
	var confirmPassword = document.getElementById("confirmPassword").value;
	var checkConfirmPassword = document.getElementById("checkConfirmPassword");
	if (password != '' && password.length != 0) {
		confirmPass_chk = (password == confirmPassword);
		if (confirmPass_chk) {
			checkConfirmPassword.innerHTML = succPrefix + "√" + succSuffix;
		} else {
			checkConfirmPassword.innerHTML = errorPrefix + "密码不一致"
					+ errorSuffix;
		}
	} else {
		/*
		 * 密码尚未填写的时候，这时候不做任何操作
		 */
		confirmPass_chk = false;
		return;
	}
}
/*
 * 检验注册时候的密码
 */
function checkPassword() {
	var password = document.getElementById("password").value;
	var warningInfo = document.getElementById("checkPassword");
	if (password != '' && password.length != 0) {
		/*
		 * 检验密码长度,密码不能为中文
		 */
		var reg = /[\u4E00-\u9FA5]/i;
		if (!reg.test(password)) {
			/*
			 * 密码不含有中文,判断长度
			 */
			if (password.length >= 8 && password.length <= 20) {
				warningInfo.innerHTML = succPrefix + "√" + succSuffix;
				password_chk = true;
			} else {
				warningInfo.innerHTML = errorPrefix + "密码长度在8-20个字符之间！"
						+ errorSuffix;
				password_chk = false;
			}

		} else {
			warningInfo.innerHTML = errorPrefix + "密码不能含有中文！" + errorSuffix;
			password_chk = false;
		}

	} else {
		warningInfo.innerHTML = errorPrefix + "密码不能为空" + errorSuffix;
		password_chk = false;
	}
}
/*
 * 检验注册姓名
 */
function checkTruename() {
	var truename = document.getElementById("truename").value;
	var warningInfo = document.getElementById("checkTruename");
	if (truename == '' || truename.length == 0) {
		warningInfo.innerHTML = errorPrefix + "姓名不能为空" + errorSuffix;
		truename_chk = false;
	} else {
		warningInfo.innerHTML = succPrefix + "√" + succSuffix;
		truename_chk = true;
	}
}
/*
 * 根据选择的学位不同选择对应的专业
 */
function getMajorsAccordingDegree(url) {
	var degreeId = document.getElementById("degreeSelect").value;
	var majorOptions = document.getElementById("majorSection").options;
	var optArray = new Array();
	majorOptions[0].selected = true;// 设置默认选中的选项
	for (var i = 1; i < majorOptions.length; i++) {// 下标从1开始，忽略一开始的默认选中--“请选择专业提示”
		var temp = majorOptions[i];
		optArray[temp.value] = temp;// 利用option的value作为数组下标存储对应的option对象
		/*
		 * 将除了默认选中的option以外所有的option的display设置为不可见， 这样避免了数组元素包含与否的查找，提高速度；
		 * 初始将所有的option置为不可见， 在后面的后台异步传输完成后根据数据设置相应需要显示的option
		 */
		temp.style.display = "none";
	}
	$.ajax({
		type : "POST",
		url : url,
		data : "degreeId=" + degreeId,
		async : true,
		error : function() {
			window.alert("服务器错误！");
		},
		success : function(data) {
			var obj = eval("(" + data + ")");
			// window.alert(obj[0]);
			for (var i = 0; i < obj.length; i++) {
				optArray[obj[i]].style.display = "inline";
			}

		}
	});
}
