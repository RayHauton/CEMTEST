// index manu js
function manu(id,id1){
	var btn = $(id);
	var parent = btn.parentNode;
	var obj = parent.children[1];
	var flag = 0;
	var bgBox = $(id1);	
	btn.onclick = function(){		
		if (flag){
			obj.style.display = "none";
			flag = 0;
		}else{
			obj.style.display = "block";
			flag = 1;
		};		
	};
	window.onresize = function(){
		if(window.outerWidth > 475){
			obj.style.display = "";
		}else{
			obj.style.display = "none";
		};
	};
};

function $(id){
	return document.getElementById(id);
};