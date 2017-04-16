function downloadUsers() {
	var aim = "../userManage/downloadUsers_adm.action"
	var result = confirm('是否导出所有用户信息至Excel')
	if (result)
		window.location.assign(aim);

};
function deleteFun(username) {
	var result = confirm('是否删除此用户');
	if (result) {
		var params = {};
		params.username = username;
		$.ajax({
			type : "POST",
			async : false,
			url : "../userManage/userDelete_adm.action",
			data : params,
			error : function() {
				alert("失败");
			},
			success : function(date) {
				if (date == "success") {
					alert("删除成功");
					queryAll();
				} else {
					alert("用户不存在或用户已被删除");
				}
			}

		})
	}
};

/*
 * function check(){ var params = $('#disapproved').serializeArray(); $.ajax({
 * type:"post", async:false, url:"../userManage/check_adm", data:params,
 * error:function(){ alert("失败"); }, success:function(data){ alert("成功");
 * queryAll(); } }) };
 */

function detail(username) {
	var params = {};
	params.username = username;
	$.ajax({
		type : "post",
		async : false,
		url : "../userManage/findUser_adm",
		data : params,
		error : function() {
			alert("失败");
		},
		success : function(data) {
			var de = new Array();
			de = data.split("/")
			for (i = 0; i < de.length; i++) {
				switch (i) {
				case 0:
					document.getElementById("de-username").value = de[i];
					break;
				case 1:
					document.getElementById("de-trueName").value = de[i];
					break;
				case 2:
					document.getElementById("de-sex").value = de[i];
					break;
				case 3:
					document.getElementById("de-studnumber").value = de[i];
					break;
				case 4:
					document.getElementById("de-birth").value = de[i];
					break;
				case 5:
					document.getElementById("de-mobile").value = de[i];
					break;
				case 6:
					document.getElementById("de-email").value = de[i];
					break;
				case 7:
					document.getElementById("de-address").value = de[i];
					break;
				case 8:
					document.getElementById("de-entrancedate").value = de[i];
					break;
				case 9:
					document.getElementById("de-graduateDate").value = de[i];
					break;

				}
			}
			var option1 = document.getElementById("de-degree").options;
			var size1 = option1.length;
			for (var m = 0; m < size1; m++) {
				if (option1[m].value == de[10]) {
					option1[m].selected = true;
				}
			}
			;

			var option2 = document.getElementById("de-major").options;
			var size2 = option2.length;
			for (var q = 0; q < size2; q++) {
				if (option2[q].value == de[11]) {
					option2[q].selected = true;
				}
			}
			;

		}
	})
};

