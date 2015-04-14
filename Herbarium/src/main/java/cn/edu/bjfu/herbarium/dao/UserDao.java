/** 
 * Project Name:Herbarium 
 * File Name:UserDao.java 
 * Package Name:cn.edu.bjfu.herbarium.dao 
 * Date:2015年3月31日 上午11:49:49 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.dao;  

import java.util.List;
import java.util.Map;

import cn.edu.bjfu.herbarium.domain.AutoJson;
import cn.edu.bjfu.herbarium.util.Pagination;

/** 
 * ClassName:UserDao <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月31日 上午11:49:49 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface UserDao <T>{
	public abstract List<AutoJson> auto(Map<String,Object> searchMap);
	
	public abstract int getTotal(Map<String,Object> map);
	 
	public abstract List<T> getPage(Map<String,Object> map);
	
	public abstract List<T> getRelateSpecies(Map<String,Object> map);
}
 