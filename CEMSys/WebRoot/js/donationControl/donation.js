/**
 * 捐赠界面的控制
 */
//提交分页查询表单（表单数据缺少pageIndex 所以要先追加pageIndex数据然后提交表单）
function submitForm(pageIndex) {
	document.getElementById("pageIndex").value=pageIndex;
	document.getElementById("searchForm").submit();
}
//重置表单（此处设置button type为reset无效）
function resetForm(){
	document.getElementById("truename").value="";
	document.getElementById("donationProject").value="";
	document.getElementById("foredate").value="";
	document.getElementById("afterdate").value="";
	document.getElementById("pageSize").options[0].selected=true;
	document.getElementById("donationType").options[0].selected=true;
}
//关闭显示捐赠人信息的模态框
function closeInfoDialog(){
	$("#infoDialog").slideToggle(200);
}
//弹出显示捐赠人信息的模态框
function showInfoDialog(obj,url){
	document.getElementById("infoTable").style.display="none";
	document.getElementById("loading").style.display="block";
	var parent = obj.parentNode;
	var prev = parent.previousSibling.previousSibling;
	var html = prev.innerHTML;
	$("#infoDialog").slideToggle(200);
	$.ajax({
		type:'POST',
		url:url,
		data:'userId='+html,
		async:true,
		error:function(){
			alert("服务器发生错误！");
		},
		success:function(data){
			//解析json字符串
			console.log(data);
			var obj = eval(data);
			document.getElementById("truename_json").innerHTML=obj.truename;
			document.getElementById("entranceDate").innerHTML=obj.entranceDate;
			document.getElementById("majorName").innerHTML=obj.majorName;
			document.getElementById("degreeName").innerHTML=obj.degreeName;
			document.getElementById("loading").style.display="none";
			document.getElementById("infoTable").style.display="table";
		}
	});
}






