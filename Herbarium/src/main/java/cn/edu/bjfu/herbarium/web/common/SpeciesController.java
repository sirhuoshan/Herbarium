/** 
 * Project Name:Herbarium 
 * File Name:SpeciesController.java 
 * Package Name:cn.edu.bjfu.herbarium.web.common 
 * Date:2015年3月9日 上午11:13:07 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.web.common;  

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjfu.herbarium.domain.PlantsCategory;
import cn.edu.bjfu.herbarium.util.Pagination;
import cn.edu.bjfu.herbarium.util.ResponseObject;
import cn.edu.bjfu.herbarium.web.BacteriumSpeciesController;

/** 
 * ClassName:SpeciesController <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月9日 上午11:13:07 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface SpeciesController<T> extends CommonController<T>{
	/**
	 * 
	 * tree:<br />
	 * TODO 去物种管理的页面
	 *
	 * @author wangcan
	 * 2015年3月7日
	 * @return
	 */
	public abstract ModelAndView species();
	
	/**
	 * 
	 * auto:<br />
	 * TODO 自动补全获取数据
	 *
	 * @author wangcan
	 * 2015年3月14日
	 * @return
	 */
	public abstract List<T> getAutoData(T t);
}
 