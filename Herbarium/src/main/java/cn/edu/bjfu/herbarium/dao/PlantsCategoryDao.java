/** 
 * Project Name:Herbarium 
 * File Name:PlantsCategoryDao.java 
 * Package Name:cn.edu.bjfu.herbarium.dao 
 * Date:2015年3月7日 下午5:20:40 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.dao;  

import java.util.List;
import java.util.Map;

import cn.edu.bjfu.herbarium.domain.PlantsCategory;

/** 
 * ClassName:PlantsCategoryDao <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月7日 下午5:20:40 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface PlantsCategoryDao extends BaseDao<PlantsCategory>{
	public abstract List<PlantsCategory> getAutoData(Map<String, Object> map);
}
 