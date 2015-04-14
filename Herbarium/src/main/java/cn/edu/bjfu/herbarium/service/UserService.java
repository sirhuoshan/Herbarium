/** 
 * Project Name:Herbarium 
 * File Name:UserService.java 
 * Package Name:cn.edu.bjfu.herbarium.service 
 * Date:2015年3月31日 上午11:51:02 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.service;  

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjfu.herbarium.domain.AutoJson;
import cn.edu.bjfu.herbarium.domain.PlantsSpeciesInfo;
import cn.edu.bjfu.herbarium.util.Pagination;

/** 
 * ClassName:UserService <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月31日 上午11:51:02 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface UserService<T> {
	/**
	 * 
	 * auto:<br />
	 * TODO 自动补全
	 *
	 * @author wangcan
	 * 2015年3月31日
	 * @param searchMap
	 * @return
	 */
	public abstract List<AutoJson> auto(Map<String,Object> searchMap);
	
	/**
	 * 
	 * get:<br />
	 * TODO 带分页的查询
	 *
	 * @author wangcan
	 * 2015年3月31日
	 * @param pagination
	 * @param map
	 * @return
	 */
	public abstract Pagination get(Pagination pagination, Map<String, Object> map) throws Exception ;
	
	/**
	 * 
	 * get:<br />
	 * TODO 通过属性获取物种信息和多媒体
	 *
	 * @author wangcan
	 * 2015年4月2日
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public abstract ModelAndView get(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * getRelateSpecies:<br />
	 * TODO 获取相关物种
	 *
	 * @author wangcan
	 * 2015年4月10日
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public abstract List<PlantsSpeciesInfo> getRelateSpecies (Pagination pagination,Map<String, Object> map) throws Exception;
}
 