
function sendMail(){
	var toUsers = document.getElementById("toUsers").value;
	var subject = document.getElementById("subject").value;
	var content = ue.getContent();
	
}
function upload(test){
	var floor = $(test).attr("name");
	document.getElementById("file"+floor).click();
}

function showOther(test){
	var file = $(test).attr('name');
	$("#file"+file).toggle();
	$('#button'+file).toggle();
	var total = 3;
	$("#button"+2).toggle();
}


var ajax_option = {
		url:$('#basePath').val() + "/mail/mailToUser",
		success:function(){
			alert(succ);
		}
}
function mailToAllUsers(){
	$('#form1').ajaxSubmit(ajax_option);
}

//以下为ajax formdata使用
function mailTolAllUserByFormData(){
	alert(1);
	var form = new FormData($('#form1')[0]);
	alert(2);
	$.ajax({
		type: "post",
		async: false,
		cache:false,
        url: $('#basePath').val()+"/mail/mailToUser",
        data: form,
        cache: false,
        data: formData,
        processData: false,
        contentType: false
	}).done(function(res){
		alert(111);
	}).fail(function(res){
		alert(222);
	});
}


var subject = document.getElementById('subject').value;

function mailtoall() {
    var text = $('#summernote').summernote('code');
    var tomail = "alluser";
    $.ajax({
		type: "post",
		async: false,
        url: $('#basePath').val()+"/mail/mailTo",
        data: {
        	users:tomail,
        	subject:subject,
        	content:text
        },
        dataType: "text",
        success: function () {
        	alert(1);
           window.location.reload();
        },
        error: function () {
            alert("请求失败");
        }
	});
}

