/** 
 * Project Name:Herbarium 
 * File Name:PlantsSpeciesServiceImpl.java 
 * Package Name:cn.edu.bjfu.herbarium.service.impl 
 * Date:2015年3月9日 上午11:20:06 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.service.impl;  

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.bjfu.herbarium.dao.PlantsSpeciesInfoDao;
import cn.edu.bjfu.herbarium.domain.PlantsCategory;
import cn.edu.bjfu.herbarium.domain.PlantsSpeciesInfo;
import cn.edu.bjfu.herbarium.service.PlantsCategoryService;
import cn.edu.bjfu.herbarium.service.PlantsSpeciesInfoService;
import cn.edu.bjfu.herbarium.util.ObjectToMap;
import cn.edu.bjfu.herbarium.util.Pagination;

/** 
 * ClassName:PlantsSpeciesServiceImpl <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月9日 上午11:20:06 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
@Service
public class PlantsSpeciesInfoServiceImpl implements PlantsSpeciesInfoService<PlantsSpeciesInfo>{
	@Autowired
	private PlantsSpeciesInfoDao plantsSpeciesInfoDao;
	
	public Pagination get(Pagination pagination, Map<String, Object> map)
			throws Exception {
		Map<String,Object> pageMap = ObjectToMap.toMap(pagination);
		map.putAll(pageMap);
        int total = plantsSpeciesInfoDao.getTotal(map);
        List<PlantsSpeciesInfo> rows = plantsSpeciesInfoDao.getPage(map);
        pagination.setRows(rows);
        pagination.setTotal(total);
        return pagination;
	}

	public List<PlantsSpeciesInfo> get(Map<String, Object> map)
			throws Exception {
		return plantsSpeciesInfoDao.get(map);
	}
	
	public void post(PlantsSpeciesInfo t) throws Exception {
		plantsSpeciesInfoDao.post(t);
	}

	public void put(PlantsSpeciesInfo t) throws Exception {
		plantsSpeciesInfoDao.put(t);
	}

	public void delete(Long id) throws Exception {
		plantsSpeciesInfoDao.delete(id);
	}

	public List<PlantsSpeciesInfo> getAutoData(Map<String,Object> searchMap) {
		return plantsSpeciesInfoDao.getAutoData(searchMap);
	}

}
 