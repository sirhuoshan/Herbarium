/** 
 * Project Name:Herbarium 
 * File Name:PlantsCollectService.java 
 * Package Name:cn.edu.bjfu.herbarium.service 
 * Date:2015年3月12日 上午12:30:30 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.service.impl;  

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.bjfu.herbarium.dao.PlantsCollectDao;
import cn.edu.bjfu.herbarium.domain.PlantsCollect;
import cn.edu.bjfu.herbarium.domain.PlantsSpeciesInfo;
import cn.edu.bjfu.herbarium.service.PlantsCollectService;
import cn.edu.bjfu.herbarium.util.ObjectToMap;
import cn.edu.bjfu.herbarium.util.Pagination;

/** 
 * ClassName:PlantsCollectService <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月12日 上午12:30:30 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
@Service
public class PlantsCollectServiceImpl implements PlantsCollectService{
	@Autowired
	private PlantsCollectDao plantsCollectDao;
	
	public Pagination get(Pagination pagination, Map<String, Object> map)
			throws Exception {
		Map<String,Object> pageMap = ObjectToMap.toMap(pagination);
		map.putAll(pageMap);
        int total = plantsCollectDao.getTotal(map);
        List<PlantsCollect> rows = plantsCollectDao.getPage(map);
        pagination.setRows(rows);
        pagination.setTotal(total);
        return pagination;
	}

	public List<PlantsCollect> get(Map<String, Object> map) throws Exception {
		return plantsCollectDao.get(map);
	}

	public void post(PlantsCollect t) throws Exception {
		plantsCollectDao.post(t);
	}

	public void put(PlantsCollect t) throws Exception {
		plantsCollectDao.put(t);
	}

	public void delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
 