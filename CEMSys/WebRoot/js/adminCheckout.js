$.fn.toggleCheckbox = function () {
    this.attr('checked', !this.attr('checked'));
}

$('.check-box').on('click', function () {
    $(this).find(':checkbox').toggleCheckbox();
    $(this).toggleClass('checkedBox');
	var a = $('#temp').attr('checked');
	var xx = $(this).children('i').children('input').attr('checked');
	if(a=='checked'&&!(xx=='checked')){
		$('#selectAll').find(':checkbox').toggleCheckbox();
		$('#selectAll').toggleClass('checkedBox');
	}
});

$(function(){
	$('#selectAll').click(function() {
		var a = $('#temp').attr('checked');
		if(a=='checked'){
			$('.check-box[id!=selectAll]').each(function(){
				var xx = $(this).children('i').children('input').attr('checked');
				if(!(xx=='checked')){
					$(this).trigger('click');
				}
			});
		}else{
			$('.check-box[id!=selectAll]').each(function(){
				var xx = $(this).children('i').children('input').attr('checked');
				if(xx=='checked'){
					$(this).trigger('click');
				}
			});
		}
	});
});

var sum = $('.check-box[id!=selectAll]').length;
$(function(){
	$('.check-box').click(function(){
		var flag = 0;
		$('.check-box[id!=selectAll]').each(function(){
			var xx = $(this).children('i').children('input').attr('checked');
			if(xx=='checked'){
				flag++;
			}
		});
		if(flag==sum){
			$('#selectAll').find(':checkbox').toggleCheckbox();
			$('#selectAll').toggleClass('checkedBox');
		}
	});
});

$(function(){
	$("img").mouseover(function(){ 
		var a = $(this).attr("id");
		var i = a.substr(3,4);
		var notice = $("#notice"+i);
		$("#img"+i).mousemove(function(e){
			notice.css({
				top : e.pageY,
				left :e.pageX
			}).show();
		}).mouseout(function(){
			notice.hide();
		});
	});
	$(".notice").mouseover(function(){ 
		$(this).show();
	}).mouseout(function(){
		$(this).hide();
	});
});

$(function(){
	
	
});

function submitForm(pageIndex) {
	document.getElementById("pageIndex").value=pageIndex;
	document.getElementById("form").submit();
}

$(function(){
	var flag1;
	$('#pass').click(function(){
		flag1 = false;
		$('.check-box[id!=selectAll]').each(function(){
			var xx = $(this).children('i').children('input').attr('checked');
			if(xx=='checked'){
				flag1=true;
			}
		});
		$('#tempInput').val("1");
		if(!flag1){
			alert("请选择需要批量通过审核的用户");
			return false;
		}
	});
	var flag2;
	$('#refuse').click(function(){
		flag2 = false;
		$('.check-box[id!=selectAll]').each(function(){
			var xx = $(this).children('i').children('input').attr('checked');
			if(xx=='checked'){
				flag2=true;
			}
		});
		$('#tempInput').val("-");
		if(!flag2){
			alert("请选择需要批量不通过审核的用户");
			return false;
		}
		
	});
});





