/** 
 * Project Name:Herbarium 
 * File Name:SpeciesService.java 
 * Package Name:cn.edu.bjfu.herbarium.service 
 * Date:2015年3月9日 上午11:20:40 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.service;  

import java.util.List;
import java.util.Map;

import cn.edu.bjfu.herbarium.domain.PlantsSpeciesInfo;

/** 
 * ClassName:SpeciesService <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月9日 上午11:20:40 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface SpeciesService<T> extends BaseService<T>{
	/**
	 * 
	 * getAutoData:<br />
	 * TODO 自动补全获取数据
	 *
	 * @author wangcan
	 * 2015年3月14日
	 * @param t
	 * @return
	 */
	public abstract List<T> getAutoData(Map<String,Object> searchMap);
}
 