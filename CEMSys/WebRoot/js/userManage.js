

	
	
	function downloadUsers(){
		var aim = "../userManage/downloadUsers_adm.action"
		var result = confirm('是否导出所有用户信息至Excel')
		if(result)
			window.location.assign(aim);
		
	};
	function deleteFun(studNumber) {
		var result =confirm('是否删除此用户');
		if(result){
			var params={};
			params.studNumber = studNumber;
			$.ajax({
				type:"POST",
				async:false,
				url:"../userManage/userDelete_adm.action",
				data:params,
				error:function(){
					alert("失败");
				},
				success:function(date){
					if(date=="success"){
						alert("删除成功");
						queryAll();
					}					
					else{
						alert("用户不存在或用户已被删除");
					}
				}
				
			})
			}
		else
			alert("确认取消删除");
	};
	
	function check(){
		var params =  $('#disapproved').serializeArray();
		$.ajax({
			type:"post",
			async:false,
			url:"../userManage/check_adm",
			data:params,
			error:function(){
				alert("失败");
			},
			success:function(data){
				alert("成功");
				queryAll();
			}
		})
	};
	
	function detail(studNumber){
		var params={};
		params.studNumber = studNumber;
		$.ajax({
			type:"post",
			async:false,
			url:"../userManage/findUser_adm",
			data:params,
			error:function(){
				alert("失败")
			},
			success:function(data){
				var de = new Array();
				de = data.split("/")
				for(i = 0;i<de.length;i++){
					switch (i) {
					case 0:
						document.getElementById("username").innerHTML=de[i];
						break;
					case 1:
						document.getElementById("trueName").innerHTML=de[i];
						break;
					case 2:
						document.getElementById("sex").innerHTML=de[i];
						break;
					case 3:
						document.getElementById("studnumber").innerHTML=de[i];
						break;
					case 4:
						document.getElementById("birth").innerHTML=de[i];
						break;
					case 5:
						document.getElementById("mobile").innerHTML=de[i];
						break;
					case 6:
						document.getElementById("email").innerHTML=de[i];
						break;
					case 7:
						document.getElementById("address").innerHTML=de[i];
						break;
					case 8:
						document.getElementById("entrancedate").innerHTML=de[i];
						
						break;
					case 9:
						document.getElementById("graduateDate").innerHTML=de[i];
						break;
					}
				} 
			}
			
		})
	};
	


	
	