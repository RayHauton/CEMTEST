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
//弹出显示捐赠人信息的模态框
function showInfoDialog(){
	$("#infoDialog").slideToggle(200);
}
/*
 * 获取捐赠人的信息（异步加载）如果直接在表格显示捐赠人信息 
 * 那么后台关联查询不但会拖慢速度 内存压力也会增大，
 * 所以让用户触发获得其感兴趣的捐赠人的信息的事件
 */
function getDonorInfo(userId){
	$.ajax({
		type:'POST',
		data:userId,
		async:true,
		error:function(){
			alert("服务器发生错误！");
		},
		success:function(data){
			//解析json字符串
			var obj = eval("("+data+")");
		}
	});
}






