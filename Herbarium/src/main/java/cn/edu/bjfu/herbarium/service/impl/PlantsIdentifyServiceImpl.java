/** 
 * Project Name:Herbarium 
 * File Name:PlantsIdentifyService.java 
 * Package Name:cn.edu.bjfu.herbarium.service 
 * Date:2015年3月12日 上午12:31:09 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.service.impl;  

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.bjfu.herbarium.dao.PlantsIdentifyDao;
import cn.edu.bjfu.herbarium.domain.PlantsIdentify;
import cn.edu.bjfu.herbarium.service.BaseService;
import cn.edu.bjfu.herbarium.service.PlantsIdentifyService;
import cn.edu.bjfu.herbarium.util.Pagination;

/** 
 * ClassName:PlantsIdentifyService <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月12日 上午12:31:09 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
@Service
public class PlantsIdentifyServiceImpl implements PlantsIdentifyService{
	
	@Autowired
	private PlantsIdentifyDao plantsIdentifyDao;
	
	public Pagination get(Pagination pagination, Map<String, Object> map)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PlantsIdentify> get(Map<String, Object> map) throws Exception {
		return plantsIdentifyDao.get(map);
	}

	public void post(PlantsIdentify t) throws Exception {
		plantsIdentifyDao.post(t);
	}

	public void put(PlantsIdentify t) throws Exception {
		plantsIdentifyDao.put(t);
	}

	public void delete(Long id) throws Exception {
		plantsIdentifyDao.delete(id);
	}

}
 