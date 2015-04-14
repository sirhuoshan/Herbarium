/** 
 * Project Name:Herbarium 
 * File Name:UserController.java 
 * Package Name:cn.edu.bjfu.herbarium.web.common 
 * Date:2015年3月30日 下午9:20:07 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.web.common;  

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjfu.herbarium.domain.AutoJson;
import cn.edu.bjfu.herbarium.domain.PlantsSpeciesInfo;
import cn.edu.bjfu.herbarium.util.Pagination;

/** 
 * ClassName:UserController <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月30日 下午9:20:07 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface UserController<T>{
	/**
	 * 
	 * getPage:<br />
	 * TODO 获取数据 带分页的
	 *
	 * @author wangcan
	 * 2015年3月31日
	 * @param obj
	 * @param page
	 * @param rows
	 * @return
	 */
	public abstract ModelAndView getPage(String q, int page, int rows) ;
	
	/**
	 * 
	 * auto:<br />
	 * TODO 自动补全
	 *
	 * @author wangcan
	 * 2015年3月31日
	 * @param q
	 * @param limit
	 * @return
	 */
	public abstract List<AutoJson> auto(String q,int limit);
	
	/**
	 * 
	 * get:<br />
	 * TODO
	 *
	 * @author wangcan
	 * 2015年4月2日
	 * @param species_id
	 * @return
	 */
	public abstract ModelAndView get(int species_id);
}
 