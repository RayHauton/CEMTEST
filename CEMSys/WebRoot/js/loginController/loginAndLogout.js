function login(prefix, action, target) {
	// alert($('#loginInfo').serialize());
	if ($("#loginMethod").val().trim().length == 0) {
		window.alert("用户名不能为空");
		return;
	}
	$.ajax({
		cache : false,
		type : "POST",
		url : prefix + action,
		data : $('#loginInfo').serialize(),
		async : true,
		error : function() {
			window.alert("服务器错误！");
		},
		success : function(data) {
			if (data == "succ_general") {
				if(target.length==0){
					window.open(prefix, "_self");
				}else{
					window.open(target, "_self");
				}
				return;
			} else if (data == "succ_admin") {// 管理员登录
//				window.open(prefix + "/admin/adminIndex.jsp", "_self");
				if(target.length==0){
					window.open(prefix+"/admin/adminIndex.jsp","_self");
				}else{
					window.open(target, "_self");
				}
				return;
			} else if (data == "notExist") {
				window.alert("用户不存在，请尝试其他登录方式！");
				return;
			} else if (data == "notCheck") {
				window.alert("抱歉，账号尚未审核！");
				return;
			} else if (data == "notPass") {
				window.alert("账号未通过审核！请重新注册，并保证注册信息的正确！");
				return;
			} else if (data == "privilegeValidationFail") {
				window.alert("您无权访问此界面！");
				return;
			} else {
				window.alert("密码错误！");
				return;
			}
		}
	});
	return false;
}
/*
 * 这个地方我都觉得自己写的有点诡异，，，，，，
 */
function checkIdentifyCode(prefix, willTo) {
	var code = document.getElementById("idenCode").value;
	$.ajax({
		type : "POST",
		url : prefix + "/getCode.action",
		data : {},
		async : true,
		error : function() {
			window.alert("服务器错误");
			// customAlert("服务器错误！","error");
		},
		success : function(data) {
			if (data == code) {
				/*
				 * 验证码通过，再检验用户名和密码
				 */
				login(prefix, "/login.action", willTo);
			} else {
				window.alert("验证码不正确");
				// customAlert("验证码不正确！","error");
			}
		}
	});
}
/**
 * 
 * @param prefix
 *            localhost:8080
 * @param action
 *            请求的action
 * @param target
 *            注销成功跳转的请求路径
 */
function logout(prefix, action, target) {
	$.post(prefix + action, {}, function(data, status) {
		if (status == 'success') {
			if (data == 'succ') {
				window.alert("注销成功！");
				window.location.href = prefix + target;
			} else {
				window.alert("尚未登录或者出现未知错误！")
			}
		} else {
			window.alert("服务器错误！");
		}

	});
}
