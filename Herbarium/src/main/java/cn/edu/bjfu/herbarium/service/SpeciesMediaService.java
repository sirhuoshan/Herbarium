/** 
 * Project Name:Herbarium 
 * File Name:SpeciesMediaService.java 
 * Package Name:cn.edu.bjfu.herbarium.service 
 * Date:2015年3月11日 上午10:56:44 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.service;  

import org.springframework.web.multipart.MultipartFile;

/** 
 * ClassName:SpeciesMediaService <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月11日 上午10:56:44 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface SpeciesMediaService<T> extends BaseService<T>{
	/**
	 * 
	 * post:<br />
	 * TODO 新增图片
	 *
	 * @author wangcan
	 * 2015年3月11日
	 * @param file
	 * @param t
	 * @throws Exception
	 */
    public abstract T post(MultipartFile file,String filename,T t) throws Exception;
}
 