/**
 * 
 */

/**
 * 弹出框
 * @param title 标题
 * @param timeout 延迟的时间
 * @param msg 弹出的信息
 * @param type 弹出框的类型 
 */
function msg(title,timeout,msg,type){
	$.messager.show({
		title:title,
		msg:msg,
		timeout:timeout,
		showType:type
	});
}

/**
 * 
 * @param title 弹出框标题
 * @param msg 弹出信息
 * @param type 弹出框类型 error/info/question/warning
 */
function alertInfo(title,msg,type){
	$.messager.alert(title,msg,type);
}