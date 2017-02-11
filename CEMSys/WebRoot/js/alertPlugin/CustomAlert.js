/**
 * 封装alert
 */
function customAlert(txt,kind){
	switch (kind){
	case "info" :
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		break;
	case "confirm":
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.confirm);
		break;
	case "warning":
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.warning);
		break;
	case "error":
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
		break;
	case "success":
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.success);
		break;
	}
}