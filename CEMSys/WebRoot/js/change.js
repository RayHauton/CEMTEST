//封装sibling函数方法
function sibling(obj,callback){
	var pDom = obj.parentNode;//找到父亲节点
	var childs = pDom.children;//找到父亲的所有孩子
	for (var i = 0; i < childs.length; i++) {
		if (obj!=childs[i]) {
		//如果Obj和父亲节点的孩子不相等，执行回调函数
			callback.call(childs[i]);
			//让回调函数的this指向孩子节点而不是window
		};
	};
};	
function getId(id){
	return document.getElementById(id);
};
var liDom = getId("select").children;		
for (var i = 0; i < liDom.length; i++) {
	liDom[i].index = i;//记录索引
	liDom[i].onclick = function(){//绑定点击事件
		this.className = "on";//使触发点击事件的DOM对象具有"on"样式			
		sibling(this,function(){//DOM对象的兄弟节点去除"on"样式
			this.className = "";
			});
		var conDom = getId("content").children[this.index];//根据索引找到对应的divDom，
		conDom.style.display = "block";//使divDom的display状态为block
		sibling(conDom,function(){//divDom的兄弟节点的display状态为none
			this.style.display = "none";
			});
		};
};