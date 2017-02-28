/**
 * 论坛的控制
 */
function postForum(){
	var forumContent = document.getElementById("textArea").value;
	var forumTitle = document.getElementById("forumTitle").value;
	if(forumTitle == "" || forumTitle == null){
		alert("标题不能够为空");
		return 
	};
	$.ajax({
		type: "post",
		async: false,
        url: $('#basePath').val()+"/forum/insertForum",
// data: {"forumTitle="+forumTitle ,"forumContent="+forumContent},
        data:{forumTitle:forumTitle,
        	forumContent:forumContent
        },
        dataType: "text",
        success: function (data) {
           alert('请求成功');
           window.location.reload();
        },
        error: function (msg) {
            alert("请求失败");
        }
	})
	
// document.location=$('#basePath').val()+"/forum/insertForum?forumTitle="+forumTitle;
}

function reply(test){
	// 当前楼层的用户id hostId
	var forumId = document.getElementById("forumId").value;
	var floor = $(test).attr("name");
	var replyContent = document.getElementById("replyToHost"+floor.toString()).value;
	if(replyContent == "" || replyContent== null){
		alert("请输入");
		return;
	}
	$.ajax({
		type: "post",
		async: false,
        url: $('#basePath').val()+"/forum/insertReply",
        data: {
        	replyText:replyContent,
        	forumId:forumId,
        	floor:floor
        },
        dataType: "text",
        success: function () {
           alert('请求成功');
           window.location.reload();
        },
        error: function () {
            alert("请求失败");
        }
	});
}

// function reply(id){
// alert(id);
// var forumId = document.getElementById("forumId").value;
// alert(forumId);
// }


function checkNull(){
	if(document.getElementById("textArea").value == '' || document.getElementById("textArea").value == null){
		return false;
	}else{
		return true;
	}
}

function sAlert(strTitle,strContent ){
	 var msgw,msgh,bordercolor;
	 msgw=400;// 提示窗口的宽度
	 msgh=100;// 提示窗口的高度
	 titleheight=25 // 提示窗口标题高度
	 bordercolor="#336699";// 提示窗口的边框颜色
	 titlecolor="#99CCFF";// 提示窗口的标题颜色
	 var sWidth,sHeight;
	 sWidth=document.body.offsetWidth;
	 sHeight=screen.height;
	 var bgObj=document_createElement_x_x("div");
	 bgObj.setAttribute('id','bgDiv');
	 bgObj.style.position="absolute";
	 bgObj.style.top="0";
	 bgObj.style.background="#777";
	 bgObj.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";
	 bgObj.style.opacity="0.6";
	 bgObj.style.left="0";
	 bgObj.style.width=sWidth + "px";
	 bgObj.style.height=sHeight + "px";
	 bgObj.style.zIndex = "10000";
	 document.body.a(bgObj);
	 var msgObj=document_createElement_x_x("div")
	 msgObj.setAttribute("id","msgDiv");
	 msgObj.setAttribute("align","center");
	 msgObj.style.background="white";
	 msgObj.style.border="1px solid " + bordercolor;
	 msgObj.style.position = "absolute";
	 msgObj.style.left = "50%";
	 msgObj.style.top = "50%";
	 msgObj.style.font="12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
	 msgObj.style.marginLeft = "-225px" ;
	 msgObj.style.marginTop = -75+document.documentElement.scrollTop+"px";
	 msgObj.style.width = msgw + "px";
	 msgObj.style.height =msgh + "px";
	 msgObj.style.textAlign = "center";
	 msgObj.style.lineHeight ="25px";
	 msgObj.style.zIndex = "10001";
	 var title=document_createElement_x_x("h4");
	 title.setAttribute("id","msgTitle");
	 title.setAttribute("align","right");
	 title.style.margin="0";
	 title.style.padding="3px";
	 title.style.background=bordercolor;
	 title.style.filter="progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100);";
	 title.style.opacity="0.75";
	 title.style.border="1px solid " + bordercolor;
	 title.style.height="18px";
	 title.style.font="12px Verdana, Geneva, Arial, Helvetica, sans-serif";
	 title.style.color="white";
	 title.style.cursor="pointer";
	 title.title = "点击关闭";
	 title.innerHTML="<table border='0' width='100%'><tr><td align='left'><b>"+ strTitle +"</b></td><td>关闭</td></tr></table></div>";
	 title.onclick=function(){
	 document.body.removeChild(bgObj);
	 document.getElementByIdx_x_x("msgDiv").removeChild(title);
	 document.body.removeChild(msgObj);
	 }
	 document.body.a(msgObj);
	 document.getElementByIdx_x_x("msgDiv").a(title);
	 var txt=document_createElement_x_x("p");
	 txt.style.margin="1em 0";
	 txt.setAttribute("id","msgTxt");
	 txt.innerHTML=strContent;
	 document.getElementByIdx_x_x("msgDiv").a(txt);
	}