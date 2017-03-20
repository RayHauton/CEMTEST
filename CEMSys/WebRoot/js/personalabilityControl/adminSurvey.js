$('#tableDiv tbody').on( 'click', 'td',function () {
	var index = $(this).parent().parent().find("tr").index($(this).parent()[0])+1; //行号
	var row = $(this).parent().find("td").index($(this)[0])+1; //列号
	var userId = $("tr:eq("+index+") td:eq(5)").html();
	if(row==4){
		$.ajax({
			url : "../adminSurveySys/showSurveyDetail_adm.action",
			type : 'post',
			data : {userId:userId},
			dataType : 'html',
			success : function(data, status) {
				if (status == "success") {
					var objs = (jQuery.parseJSON(data))[0].surveyData;
					var strs = new Array();
					if (objs != null) {
						strs = objs.split(",");
						var num = strs.length;
						if (num == 26)
							num = 14;
						else
							num = 1;
						for (i = 0; i < strs.length; i++){
							$("input:radio[id=" + (i + num) + "][value="+ strs[i] + "]").prop("checked",true);
						}
					}
				}
			},
			error : function(xhr,textStatus, errorThrown) {
				alert("error");
			}
		});
	}else if(row==5){
		$.ajax({
			url : "../adminSurveySys/showUserDetail_adm.action",
			type : 'post',
			data : {userId:userId},
			dataType : 'html',
			success : function(data, status) {
				if (status == "success") {
					var objs = (jQuery.parseJSON(data))[0].userData;
					var strs = new Array();
					if (objs != null) {
						strs = objs.split(",");
						$('#UserId').html(userId);
						$('#Username').html(strs[0]);
						$('#Truename').html(strs[1]);
						$('#Sex')
						.html(strs[2]);
						$('#StudentNum').html(strs[3]);
						$('#Birth').html(strs[4]);
						$('#Mobile').html(strs[5]);
						$('#EMail').html(strs[6]);
						$('#Address').html(strs[7]);
						$('#EntranceDate').html(strs[8]);
						$('#GraduateDate').html(strs[9]);
					}
				}
			},
			error : function(xhr,textStatus, errorThrown) {
				alert("error");
			}
		});
	}
});

$(function(){	
	$("button[name='surveyDetails']").click(function() {
		$("#surveyLight").css('display', 'block');
		$("#fade").css('display', 'block');
	});
});
$(function(){
	$("#surveyClose").click(function() {
		$("#surveyLight").css('display', 'none');
		$("#fade").css('display', 'none');
		var inputList = $("input[type='radio']");
	　　for(var x=0;x<inputList.length;x++){
	　　　　inputList[x].checked=false;  //取消选中
	　　}
	});
});
$(function(){	
	$("button[name='userDetails']").click(function() {
		$("#userLight").css('display', 'block');
		$("#fade").css('display', 'block');
	});
});
$(function(){
	$("#userClose").click(function() {
		$("#userLight").css('display', 'none');
		$("#fade").css('display', 'none');
	});
});


$(function(){
	var flag = 1;
	$("#submitButton").click(function() {
		if($("input[name='titleNum']").val()!=""&&($("input[name='titleNum']").val()>39||$("input[name='titleNum']").val()<1)){
			alert('请在题号中输入1-39以内的整数');
			flag = 0;
			return false;
		}
		if($("input[name='scoreNum']").val()!=""&&($("input[name='scoreNum']").val()>5||$("input[name='scoreNum']").val()<1)){
			alert('请在中输入1-5以内的整数');
			flag = 0;
			return false;
		}
		if($("input[name='titleNum']").val()==""&&$("input[name='scoreNum']").val()!=""){
			alert('请输入题号');
			flag = 0;
			return false;
		}
		if($("input[name='titleNum']").val()!=""&&$("input[name='scoreNum']").val()==""){
			alert('请输入得分');
			flag = 0;
			return false;
		}
			
	});
	if(flag==0)
		return false;
	else
		return true;
});
function submitForm(pageIndex) {
	document.getElementById("pageIndex").value=pageIndex;
	document.getElementById("form").submit();
}






