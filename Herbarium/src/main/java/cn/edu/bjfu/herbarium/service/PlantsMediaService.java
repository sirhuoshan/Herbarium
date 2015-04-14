/** 
 * Project Name:Herbarium 
 * File Name:PlantsMediaService.java 
 * Package Name:cn.edu.bjfu.herbarium.service 
 * Date:2015年3月12日 上午12:31:43 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.service;  

import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjfu.herbarium.domain.PlantsMedia;

/** 
 * ClassName:PlantsMediaService <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月12日 上午12:31:43 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface PlantsMediaService extends BaseService<PlantsMedia>{
	public PlantsMedia post1(MultipartFile file,String filename,PlantsMedia t) throws Exception;
}
 