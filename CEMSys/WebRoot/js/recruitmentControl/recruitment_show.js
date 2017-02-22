/**
 * 这个js是用于招聘信息显示界面的控制
 */
// 用于：当选择了查看全部信息按钮的时候，隐藏其他表单元素
function hideFormElementWhenChooseViewAll() {
	if (document.getElementById("viewAll").checked) {
		document.getElementById("publishPerson").disabled = "disabled";
		document.getElementById("pubForedate").disabled = "disabled";
		document.getElementById("pubAfterdate").disabled = "disabled";
		document.getElementById("pubCompany").disabled = "disabled";
	} else {
		document.getElementById("publishPerson").disabled = "";
		document.getElementById("pubForedate").disabled = "";
		document.getElementById("pubAfterdate").disabled = "";
		document.getElementById("pubCompany").disabled = "";
	}
}
