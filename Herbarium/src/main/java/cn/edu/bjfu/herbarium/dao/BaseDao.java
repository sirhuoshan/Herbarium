/** 
 * Project Name:Herbarium 
 * File Name:BaseDao.java 
 * Package Name:cn.edu.bjfu.herbarium.dao 
 * Date:2015年3月7日 下午5:21:05 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.dao;  

import java.util.List;
import java.util.Map;

import cn.edu.bjfu.herbarium.domain.BacteriumCategory;

/** 
 * ClassName:BaseDao <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月7日 下午5:21:05 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface BaseDao<T>{
	public abstract List<T> getPage(Map<String,Object> map);

    public abstract List<T> get(Map<String,Object> map);

    public abstract List<T> getAll();

    public abstract int getTotal(Map<String,Object> map);

    public abstract List getCategoryJson();
    
    public abstract void post(T t);
    
    public abstract void put(T t);
    
    public abstract void delete(Long id);
}
 