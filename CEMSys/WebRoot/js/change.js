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

function inChinaF() {
	var inC = document.getElementById('inChinaD');
	var out = document.getElementById('outChinaD');
	var o1 = document.getElementById('box');
	inC.style.display = "block";
	out.style.display = "none";
	o1.style.height = $("#content").height() + 30 + "px";
};

function outChinaF() {
	var o2 = document.getElementById('box');
	var inC = document.getElementById('inChinaD');
	var out = document.getElementById('outChinaD');
	inC.style.display = "none";
	out.style.display = "block";
	o2.style.height = $("#content").height() + 10 + "px";
};

function getId(id) {
	return document.getElementById(id);
};

var liDom = getId("select").children;
var o = document.getElementById('box');
o.style.width = $("#navBody").width()+300+"px";
o.style.height = $("#content").height() + 40 + "px";

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
		o.style.height = $("#content").height() + 40 + "px";
	};
};

function baseSkip() {
	var params = {
		truename : $("#truename").val(),
		sex : $("#sex").val(),
		birth : $("#birth").val(),
		country : $("#country").val(),
		address : $("#address").val,
		province1 : $("#province1").val(),
		city1 : $("#city1").val(),
		district1 : $("#district1").val()
	};
	;
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
				o.style.height = $("#content").height() + 40 + "px";
			}
		}
	});
};

function occupationSkip() {
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
				o.style.height = $("#content").height() + 40 + "px";
			}
		}
	});
};

function jobSkip() {
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
				window.location.href = '../index.jsp';
			}
		}
	});
};
function mytest() {
	o.style.height = $("#content").height() + 40 + "px";
	var AA = getId("select").children;
	/*
	 * for (var i = 0; i < AA.length; i++) {
	 * alert(AA[i].getElementsByTagName("a")[0].href); };
	 */

	for (var i = 0; i < AA.length; i++) {
		AA[i].getElementsByTagName("a")[0].href = "#";
	}
	;
	/*
	 * for (var i = 0; i < AA.length; i++) {
	 * alert(AA[i].getElementsByTagName("a")[0].href); };
	 */
};

window.onload = mytest;
