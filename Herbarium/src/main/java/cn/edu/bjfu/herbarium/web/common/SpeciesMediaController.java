/** 
 * Project Name:Herbarium 
 * File Name:MediaController.java 
 * Package Name:cn.edu.bjfu.herbarium.web.common 
 * Date:2015年3月11日 上午10:34:49 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.web.common;  

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjfu.herbarium.util.ResponseObject;

/** 
 * ClassName:MediaController <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月11日 上午10:34:49 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface SpeciesMediaController<T> extends CommonController<T>{
	
	/**
	 * 
	 * media:<br />
	 * TODO 去多媒体展示页面
	 *
	 * @author wangcan
	 * 2015年3月11日
	 * @return
	 */
	public abstract ModelAndView media(Long id);
	
	/**
	 * 
	 * post:<br />
	 * TODO 上传多媒体
	 *
	 * @author wangcan
	 * 2015年3月11日
	 * @param file
	 * @param t
	 */
	public abstract ResponseObject post(MultipartFile file,String filename,T t);
}
 