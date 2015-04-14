/** 
 * Project Name:Herbarium 
 * File Name:CategoryService.java 
 * Package Name:cn.edu.bjfu.herbarium.service 
 * Date:2015年3月7日 下午10:54:12 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.service;  

import java.util.List;
import java.util.Map;

import cn.edu.bjfu.herbarium.domain.BacteriumCategory;
import cn.edu.bjfu.herbarium.domain.PlantsCategory;
import cn.edu.bjfu.herbarium.domain.PlantsSpeciesInfo;

/** 
 * ClassName:CategoryService <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月7日 下午10:54:12 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface CategoryService<T> {
	/**
	 * 
	 * getCategoriesInPath:<br />
	 * TODO 获取在路径上的类别的子类别
	 *
	 * @author wangcan
	 * 2015年3月8日
	 * @param category_path
	 * @return
	 * @throws Exception
	 */
	public abstract List getCategoriesInPath(String category_path)throws Exception;
	
	/**
	 * 
	 * getCategoryInPath:<br />
	 * TODO 获取在路径上的类别
	 *
	 * @author wangcan
	 * 2015年3月8日
	 * @param category_path
	 * @return
	 */
	public abstract List<T> getCategoryInPath(String category_path)throws Exception;
	
	/**
	 * 
	 * getAutoData:<br />
	 * TODO 自动补全的查询
	 *
	 * @author wangcan
	 * 2015年3月10日
	 * @param map
	 * @return
	 */
	public abstract List<T> getAutoData(Map<String, Object> map);

}
 