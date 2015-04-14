/** 
 * Project Name:Herbarium 
 * File Name:PlantsStorageService.java 
 * Package Name:cn.edu.bjfu.herbarium.service 
 * Date:2015年3月12日 上午12:33:05 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.service.impl;  

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.bjfu.herbarium.dao.PlantsStorageDao;
import cn.edu.bjfu.herbarium.domain.PlantsStorage;
import cn.edu.bjfu.herbarium.service.PlantsStorageService;
import cn.edu.bjfu.herbarium.util.Pagination;

/** 
 * ClassName:PlantsStorageService <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月12日 上午12:33:05 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
@Service
public class PlantsStorageServiceImpl implements PlantsStorageService{
	@Autowired
	private PlantsStorageDao plantsStorageDao;
	
	public Pagination get(Pagination pagination, Map<String, Object> map)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PlantsStorage> get(Map<String, Object> map) throws Exception {
		return plantsStorageDao.get(map);
	}

	public void post(PlantsStorage t) throws Exception {
		plantsStorageDao.post(t);
	}

	public void put(PlantsStorage t) throws Exception {
		plantsStorageDao.put(t);
	}

	public void delete(Long id) throws Exception {
		plantsStorageDao.delete(id);
	}
}
 