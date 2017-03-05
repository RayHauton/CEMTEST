/**
 * 论坛的控制
 */
function postForum(){
//	var forumContent = ue.getPlainTxt();
	var forumContent = ue.getContent();
	var forumTitle = document.getElementById("forumTitle").value;
	if(forumTitle == "" || forumTitle == null){
		alert("标题不能够为空");
		return 
	};
	if(forumTitle.length>25){
		alert("标题过长");
		return
	};
	$.ajax({
		type: "post",
		async: false,
        url: $('#basePath').val()+"/forum/insertForum",
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

function countChar(inputName,spanName){
	var length = document.getElementById(inputName).value.length;
	document.getElementById(spanName).innerHTML=length;
}

function reply(test){
	// 当前楼层的用户id hostId
	var forumId = document.getElementById("forumId").value;
	var forumTitle = document.getElementById("forumTitle").value;
	var floor = $(test).attr("name");
	var replyContent = document.getElementById("replyToHost"+floor.toString()).value;
	var userId = document.getElementById("userId"+floor.toString()).value;
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
        	floor:floor,
        	forumTitle:forumTitle,
        	userId:userId
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

function replyHost(){
	alert(0);
	var forumId = document.getElementById("forumId").value;
	alert(1);
	var replyContent = document.getElementById("textArea").value;
	alert(2);
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

function deleteForum(forumId){
	var forumId = $(forumId).attr('name');
	$.ajax({
		type:'post',
		async: false,
        url: $('#basePath').val()+"/forum/deleteForum",
        data: {
        	forumId:forumId,
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

function deleteReply(replyId){
	var replyId = $(replyId).attr('name');
	var forumId = document.getElementById("forumId").value;
	$.ajax({
		type:'post',
		async: false,
        url: $('#basePath').val()+"/forum/deleteReply",
        data: {
        	replyId:replyId,
        	forumId:forumId
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

/**
 * 消息通知js
 */
setTimeout(function(){
	Push();
//	alert("set timeout");
},200);

setInterval(function(){
	Push();
//	alert("interval");
},3000);

function Push(){
	$.ajax({
		type:'post',
		url:$('#basePath').val()+'/forum/messageInfo',
		data:{},
		beforeSend:function(){},
		success:function(data){
			var object = eval("("+data+")");//eval使用前要先加括号，才能得到完整的json数据
			if(object.msg!=0){
				$('#tongzhi-content').html(object.msg);//更新消息数目
				$('#tongzhi').show();//将消息显示出来
			}else{
				$('#tongzhi').hide();//隐藏消息
			}
		},
		error:function(){
			alert("error");
		}
	});
}

/**
 * 对时间进行转换
 */
function timeTranslate(time){
	function zeroize(num){
		return (String(num).length==1?'0':'')+num;
	}
	var currentTime = parseInt(new Date().getTime / 1000);//获得当前时间
	var timestamp =Date.parse(time)/1000;
	return timestamp;
	
}

















/**
 * 以下是百度编辑器的js
 */


//实例化编辑器
//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
var ue = UE.getEditor('editor');
//ue.setHeight(300);

function isFocus(e){
    alert(UE.getEditor('editor').isFocus());
    UE.dom.domUtils.preventDefault(e)
}
function setblur(e){
    UE.getEditor('editor').blur();
    UE.dom.domUtils.preventDefault(e)
}
function insertHtml() {
    var value = prompt('插入html代码', '');
    UE.getEditor('editor').execCommand('insertHtml', value)
}
function createEditor() {
    enableBtn();
    UE.getEditor('editor');
}
function getAllHtml() {
    alert(UE.getEditor('editor').getAllHtml())
}
function getContent() {
    var arr = [];
    arr.push("使用editor.getContent()方法可以获得编辑器的内容");
    arr.push("内容为：");
    arr.push(UE.getEditor('editor').getContent());
    alert(arr.join("\n"));
}
function getPlainTxt() {
    var arr = [];
    arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
    arr.push("内容为：");
    arr.push(UE.getEditor('editor').getPlainTxt());
    alert(arr.join('\n'))
}
function setContent(isAppendTo) {
    var arr = [];
    arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
    UE.getEditor('editor').setContent('欢迎使用ueditor', isAppendTo);
    alert(arr.join("\n"));
}
function setDisabled() {
    UE.getEditor('editor').setDisabled('fullscreen');
    disableBtn("enable");
}

function setEnabled() {
    UE.getEditor('editor').setEnabled();
    enableBtn();
}

function getText() {
    //当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
    var range = UE.getEditor('editor').selection.getRange();
    range.select();
    var txt = UE.getEditor('editor').selection.getText();
    alert(txt)
}

function getContentTxt() {
    var arr = [];
    arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
    arr.push("编辑器的纯文本内容为：");
    arr.push(UE.getEditor('editor').getContentTxt());
    alert(arr.join("\n"));
}
function hasContent() {
    var arr = [];
    arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
    arr.push("判断结果为：");
    arr.push(UE.getEditor('editor').hasContents());
    alert(arr.join("\n"));
}
function setFocus() {
    UE.getEditor('editor').focus();
}
function deleteEditor() {
    disableBtn();
    UE.getEditor('editor').destroy();
}
function disableBtn(str) {
    var div = document.getElementById('btns');
    var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
    for (var i = 0, btn; btn = btns[i++];) {
        if (btn.id == str) {
            UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
        } else {
            btn.setAttribute("disabled", "true");
        }
    }
}
function enableBtn() {
    var div = document.getElementById('btns');
    var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
    for (var i = 0, btn; btn = btns[i++];) {
        UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
    }
}

function getLocalData () {
    alert(UE.getEditor('editor').execCommand( "getlocaldata" ));
}

function clearLocalData () {
    UE.getEditor('editor').execCommand( "clearlocaldata" );
    alert("已清空草稿箱")
}
