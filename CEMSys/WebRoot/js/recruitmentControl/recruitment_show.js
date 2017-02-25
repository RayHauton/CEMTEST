/**
 * 这个js是用于招聘信息显示界面的控制
 */
// 用于：当选择了查看全部信息按钮的时候，隐藏其他表单元素
function hideFormElementWhenChooseViewAll() {
	if (document.getElementById("viewAll").checked) {
		document.getElementById("viewAll").value="viewAll";
		document.getElementById("publishPerson").disabled = "disabled";
		document.getElementById("pubForedate").disabled = "disabled";
		document.getElementById("pubAfterdate").disabled = "disabled";
		document.getElementById("pubCompany").disabled = "disabled";
	} else {
		document.getElementById("viewAll").value="";
		document.getElementById("publishPerson").disabled = "";
		document.getElementById("pubForedate").disabled = "";
		document.getElementById("pubAfterdate").disabled = "";
		document.getElementById("pubCompany").disabled = "";
	}
}
/*
 * 用于填充搜索记录表单并提交，
 * 考虑到pageIndex和pageSize不方便提交，
 * 所以在本表单用两个隐藏表单存储数据
 * flag:作用：判断事分页页码点击还是搜索表单模态窗里面的提交按钮触发的本函数
 */
function submitSearchForm(flag,pageIndex){
	if(flag=="divPg"){
		//此时要填充pageIndex
		document.getElementById("pageIndex_hdn").value=pageIndex;
		
	}
//	alert(document.getElementById("viewAll").value);
	/*
	 *如果是搜索输入模态窗中点击提交按钮触发的函数那么不需要设置pageIndex,
	 *因为此时进行了搜索；所以pageSIze可以保留原始数据，
	 *pageIndex要重新回到从第一页显示
	 */
	//设置pageSize
	var pageSizeSelection = document.getElementById("pageSizeSelection");
	document.getElementById("pageSize_hdn").value=pageSizeSelection.options[pageSizeSelection.selectedIndex].value;
	document.getElementById("searchForm").submit();
}













