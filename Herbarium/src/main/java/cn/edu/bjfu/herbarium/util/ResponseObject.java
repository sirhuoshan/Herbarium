/** 
 * Project Name:Herbarium 
 * File Name:ResponseObject.java 
 * Package Name:cn.edu.bjfu.herbarium.util 
 * Date:2015年2月19日 下午9:05:31 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.util;  
/** 
 * ClassName:ResponseObject <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年2月19日 下午9:05:31 <br/> 
 * @author   huoshansir 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class ResponseObject {
	//返回的状态 true 或 false 
	private boolean status;
	//返回对象
	private Object obj;
	public ResponseObject(boolean status,Object obj){
		this.status = status;
		this.obj = obj;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}


	public final static String saveSucMsg = "保存成功！";
	public final static String editSucMsg = "修改成功！";
	public final static String delSucMsg = "删除成功！";
	public final static String saveErrorMsg = "保存失败！";
	public final static String editErrorMsg = "修改失败！"; 
	public final static String delErrorMsg = "删除失败！";
	public final static String getErrorMsg = "获取信息失败！";

}
 