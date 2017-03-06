var num=1;
$(function() {
	$("#addImg")
		.click(function() {
			str='<div id="addDiv'+(num)+'">'+
				'<label>第</label>'+
				'<input class="form-control" placeholder="输入1-39内的整数">'+
				'<label>&emsp;&ensp;题&emsp;选择</label>'+
				'<input class="form-control" placeholder="输入1-5内的整数">'+
				'<label>&emsp;&ensp;分&emsp;</label>'+
				'<img alt="" src="../images/delete.png" height=20px; id="deleteImg'+(num++)+'">'+
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