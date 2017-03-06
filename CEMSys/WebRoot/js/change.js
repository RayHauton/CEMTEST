//封装sibling函数方法
function sibling(obj, callback) {
	var pDom = obj.parentNode;// 找到父亲节点
	var childs = pDom.children;// 找到父亲的所有孩子
	for (var i = 0; i < childs.length; i++) {
		if (obj != childs[i]) {
			// 如果Obj和父亲节点的孩子不相等，执行回调函数
			callback.call(childs[i]);
			// 让回调函数的this指向孩子节点而不是window
		}
		;
	}
	;
};
function getId(id) {
	return document.getElementById(id);
};
var liDom = getId("select").children;
var o = document.getElementById('box');
for (var i = 0; i < liDom.length; i++) {
	liDom[i].index = i;// 记录索引
	liDom[i].onclick = function() {// 绑定点击事件
		this.className = "on";// 使触发点击事件的DOM对象具有"on"样式
		sibling(this, function() {// DOM对象的兄弟节点去除"on"样式
			this.className = "";
		});
		var conDom = getId("content").children[this.index];// 根据索引找到对应的divDom，
		conDom.style.display = "block";// 使divDom的display状态为block
		sibling(conDom, function() {// divDom的兄弟节点的display状态为none
			this.style.display = "none";
		});
		o.style.height = $("#content").height()+40+"px";
		
		
	};
};

function baseSkip() {
	alert("kaishi");
	var params = $("#base").serializeArray();
	$.ajax({
		type : "POST",
		async : false,
		url : "../infoSys/updatebaseInf.action",
		data : params,
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
			alert(textStatus);
		},
		success : function(data) {
			// var objs = jQuery.parseJSON(data);
			if (data == "noExist") {
				alert("用户不存在");
			} else {
				liDom[1].index = 1;// 记录索引
				liDom[1].className = "on";// 使触发点击事件的DOM对象具有"on"样式
				sibling(liDom[1], function() {// DOM对象的兄弟节点去除"on"样式
					this.className = "";
				});
				var conDom = getId("content").children[1];// 根据索引找到对应的divDom，
				conDom.style.display = "block";// 使divDom的display状态为block
				sibling(conDom, function() {// divDom的兄弟节点的display状态为none
					this.style.display = "none";
				});
				alert(data)
			}
		}
	});
};

function occupationSkip() {
	alert("工作开始");
	var params = $("#occupation").serializeArray();
	$.ajax({
		type : "POST",
		async : false,
		url : "../infoSys/jopInf.action",
		data : params,
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
			alert(textStatus);
		},
		success : function(data) {
			// var objs = jQuery.parseJSON(data);
			if (data == "noExist") {
				alert("用户不存在");
			} else {
				liDom[2].index = 2;// 记录索引
				liDom[2].className = "on";// 使触发点击事件的DOM对象具有"on"样式
				sibling(liDom[2], function() {// DOM对象的兄弟节点去除"on"样式
					this.className = "";
				});
				var conDom = getId("content").children[2];// 根据索引找到对应的divDom，
				conDom.style.display = "block";// 使divDom的display状态为block
				sibling(conDom, function() {// divDom的兄弟节点的display状态为none
					this.style.display = "none";
				});
				alert(data)
			}
		}
	});
};

function jobSkip() {
	alert("职业开始");
	var params = $("#job").serializeArray();
	$.ajax({
		type : "POST",
		async : false,
		url : "../infoSys/jobCon.action",
		data : params,
		datatype : "text",
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
			alert(textStatus);
		},
		success : function(data) {
			// var objs = jQuery.parseJSON(data);
			if (data == "noExist") {
				alert("用户不存在");
			} else {
				alert(data)
				window.location.href = '../index.jsp';
			}
		}
	});
};
function mytest(){
	alert(o.style.height);
	o.style.height = $("#content").height()+40+"px";
	var AA = getId("select").children;
/*	for (var i = 0; i < AA.length; i++) {
		alert(AA[i].getElementsByTagName("a")[0].href);
		};*/

	for (var i = 0; i < AA.length; i++) {
		AA[i].getElementsByTagName("a")[0].href = "#";
		};
	/*for (var i = 0; i < AA.length; i++) {
		alert(AA[i].getElementsByTagName("a")[0].href);
		};*/
	};

window.onload= mytest;

