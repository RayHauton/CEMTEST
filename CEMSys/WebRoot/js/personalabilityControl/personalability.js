$(function() {
	alert(123);
	$("#SelfabilityqualitySubmit")
		.click(function() {
			var flag = 0;
			for (var i = 26; i < 39; i++) {
				var val = $('#SelfabilityqualityTable input:radio[id='+ i + ']:checked').val();
				if (val == null) {
					alert("第" + i + "题未选择")
					flag = 1;
					break;
				}
			}
			if (flag == 1)
				return false;
			else if (flag == 0) {
				var data = $("#SelfabilityqualityForm").serializeArray();
				$.ajax({
					url : "${pageContext.request.contextPath}/surveySys/saveSelfabilityquality",
					type : 'post',
					data : data,
					dataType : 'html',
					success : function(data, status) {
						if (status == "success") {
							var objs = jQuery.parseJSON(data);
							alert(objs[0].activityName);
						}
					},
					error : function(xhr,textStatus, errorThrown) {
						alert("error");
					}
					});
			}
		});
});

$(function() {
	$("#MajorabilitycultivationqualitySubmit")
		.click(function() {
			var flag = 0;
			for (var i = 39; i < 64; i++) {
				var val = $('#Majorabilitycultivationquality input:radio[id='+ i + ']:checked').val();
				if (val == null) {
					alert("第" + i + "题未选择")
					flag = 1;
					break;
				}
			}
			if (flag == 1)
				return false;
			else if (flag == 0) {
				var data = $("#MajorabilitycultivationqualityForm").serializeArray();
				$.ajax({
					url : "${pageContext.request.contextPath}/surveySys/saveMajorabilitycultivationquality",
					type : 'post',
					data : data,
					dataType : 'html',
					success : function(data, status) {
						if (status == "success") {
							var objs = jQuery.parseJSON(data);
							alert(objs[0].activityName);
						}
					},
					error : function(xhr,textStatus, errorThrown) {
						alert("error");
					}
					});
			}
		});
});

$(function() {
	var url = location.href;
	var paraString = url.substring(url.indexOf("?") + 1);
	if (paraString == 'SelfabilityqualityHref') {
		$('#Majorabilitycultivationquality').css('display', 'none');
		$('#SelfabilityqualityP').css('display', 'block');
		$('#SelfabilityqualityTable').css('display', 'table');
		$('#SelfabilityqualityH2').css('display', 'block');
		$('#SelfabilityqualityBtn').css('display', 'block');
	} else {
		$('#Majorabilitycultivationquality').css('display', 'block');
		$('#SelfabilityqualityP').css('display', 'none');
		$('#SelfabilityqualityTable').css('display', 'none');
		$('#SelfabilityqualityH2').css('display', 'none');
		$('#SelfabilityqualityBtn').css('display', 'none');
	}
});


