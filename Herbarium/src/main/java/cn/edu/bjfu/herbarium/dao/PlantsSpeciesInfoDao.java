/** 
 * Project Name:Herbarium 
 * File Name:PlantsSpeciesDao.java 
 * Package Name:cn.edu.bjfu.herbarium.dao 
 * Date:2015年3月9日 上午11:24:55 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.dao;  

import java.util.List;
import java.util.Map;

import cn.edu.bjfu.herbarium.domain.PlantsCategory;
import cn.edu.bjfu.herbarium.domain.PlantsSpeciesInfo;

/** 
 * ClassName:PlantsSpeciesDao <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月9日 上午11:24:55 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface PlantsSpeciesInfoDao extends BaseDao<PlantsSpeciesInfo>{
	public abstract List<PlantsSpeciesInfo> getAutoData(Map<String, Object> map);
}
 