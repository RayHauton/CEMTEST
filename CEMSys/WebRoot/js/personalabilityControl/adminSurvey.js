var num=1;
$(function() {
	$("#addImg").click(function() {
		str='<div id="addDiv'+(num)+'">'+
			'<label>第</label>'+
			'<input class="form-control" placeholder="输入1-39内的整数" name="titleNum">'+
			'<label>&emsp;&ensp;题&emsp;选择</label>'+
			'<input class="form-control" placeholder="输入1-5内的整数" name="scoreNum">'+
			'<label>&emsp;&ensp;分&emsp;</label>&#8197;'+
			'<img alt="" src="../images/delete.png" height=20px; class="deleteImg" id="deleteImg'+(num++)+'">'+
			'<br/>'
		+'</div>'
		$("#addDiv").append(str);
	});
});

$(function(){
	$(document).click(function (e) { 
		var imgID = $(e.target).attr('id');
		var Id = imgID.substring(9,11);
		if(Id!="")
			$('#addDiv'+Id).remove();
	}); 
});


$(function(){
	$("#aLight").click(function() {
		$("#light").css('display', 'none');
		$("#fade").css('display', 'none');
	});
});

$('#tableDiv tbody').on( 'click', 'td',function () {
	var index = $(this).parent().parent().find("tr").index($(this).parent()[0])+1; //行号
	var row = $(this).parent().find("td").index($(this)[0])+1; //列号
	var userId = $("tr:eq("+index+") td:eq(5)").html();
	if(row==4){
		$.ajax({
			url : "../adminSurveySys/showSurveyDetail",
			type : 'post',
			data : {userId:userId},
			dataType : 'html',
			success : function(data, status) {
				if (status == "success") {
					var objs = (jQuery.parseJSON(data))[0].activityName;
					var strs = new Array();
					if (objs != null) {
						strs = objs.split(",");
						var num = strs.length;
						if (num == 26)
							num = 14;
						else
							num = 1;
						for (i = 0; i < strs.length; i++)
							$("input:radio[id=" + (i + num) + "][value="+ strs[i] + "]").attr("checked",true);
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
		$("#light").css('display', 'block');
		$("#fade").css('display', 'block');
	});
});

$(function(){
	var notice = $("#notice");
	notice.hide();
	$("#addImg").mousemove(function(e){
		$("#noticeSpan").html('增加查询信息');
		notice.css({
			top : e.pageY,
			left : e.pageX
		}).show();
	}).mouseout(function(){
		notice.hide();
	});
});

$(function(){
	$(document).click(function(){
		var notice = $("#notice");
		notice.hide();
		$(".deleteImg").mousemove(function(e){
			$("#noticeSpan").html('删除查询条件');
			notice.css({
				top : e.pageY,
				left : e.pageX
			}).show();
		}).mouseout(function(){
			notice.hide();
		});
	});
});

$(function(){
	var j = 0;
	var flag = 1;
	$("#submitButton").click(function() {
		$("input").each(function(){
			j++;
			flag = 1;
			if(j%2!=0){
				if($("input[name='titleNum']").val()==''){
					alert('请输入第'+ (parseInt(j/2)+1)+'个条件的题号或删除该条件');
					flag = 0;
					j = 0;
					return false;
				}else if($("input[name='titleNum']").val()>39||$(this).val()<1){
					alert('请在第'+(parseInt(j/2)+1)+'个条件的题号中输入1-39以内的整数');
					flag = 0;
					j = 0;
					return false;
				}
			}else{ 
				if($("input[name='scoreNum']").val()==''){
					alert('请输入第'+(parseInt(j/2))+'个条件的得分或删除该条件');
					flag = 0;
					j = 0;
					return false;
				}else if($("input[name='scoreNum']").val()>39||$(this).val()<1){
					alert('请在第'+(parseInt(j/2))+'个条件的得分中输入1-5以内的整数');
					flag = 0;
					j = 0;
					return false;
				}
			}
		});
		if(flag==0)
			return false;
		else{
			return true;
		}
	});
});





