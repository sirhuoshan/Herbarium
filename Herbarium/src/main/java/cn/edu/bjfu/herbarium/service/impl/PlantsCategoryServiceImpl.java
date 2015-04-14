/** 
 * Project Name:Herbarium 
 * File Name:PlantsServiceImpl.java 
 * Package Name:cn.edu.bjfu.herbarium.service.impl 
 * Date:2015年3月7日 下午4:52:05 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.service.impl;  

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.edu.bjfu.herbarium.dao.PlantsCategoryDao;
import cn.edu.bjfu.herbarium.domain.BacteriumCategory;
import cn.edu.bjfu.herbarium.domain.PlantsCategory;
import cn.edu.bjfu.herbarium.domain.PlantsSpeciesInfo;
import cn.edu.bjfu.herbarium.service.PlantsCategoryService;
import cn.edu.bjfu.herbarium.util.ObjectToMap;
import cn.edu.bjfu.herbarium.util.Pagination;

/** 
 * 
 * ClassName: PlantsCategoryServiceImpl <br />
 * Function: TODO ADD FUNCTION. <br />
 * date: 2015年3月7日 下午4:53:14 <br />
 * 
 * @author wangcan
 * @version  
 * @since JDK 1.6
 */
@Service
public class PlantsCategoryServiceImpl implements PlantsCategoryService{
	@Autowired
	private PlantsCategoryDao plantsCategoryDao;
	
	public Pagination get(Pagination pagination, Map<String, Object> map) throws Exception {
		Map<String,Object> pageMap = ObjectToMap.toMap(pagination);
		map.putAll(pageMap);
        int total = plantsCategoryDao.getTotal(map);
        List<PlantsCategory> rows = plantsCategoryDao.getPage(map);
        pagination.setRows(rows);
        pagination.setTotal(total);
        return pagination;
	}

	public List<PlantsCategory> get(Map<String, Object> map) throws Exception {
		 List<PlantsCategory> list = plantsCategoryDao.get(map);
	     return list;
	}
	
	public List<PlantsCategory> getAutoData(Map<String, Object> map){
		 List<PlantsCategory> list = plantsCategoryDao.getAutoData(map);
	     return list;
	}


	public void post(PlantsCategory t) throws Exception {
		plantsCategoryDao.post(t);
	}

	public void put(PlantsCategory t) throws Exception {
		plantsCategoryDao.put(t);
	}

	public void delete(Long id) throws Exception {
		plantsCategoryDao.delete(id);
	}

	public List getCategoriesInPath(String category_path)throws Exception{
        List categories = new ArrayList();
        if(!StringUtils.isEmpty(category_path)){
            String parent_ids[] = category_path.split("_");
            for(int i = parent_ids.length - 1; i >= 0; i--){
                Map<String,Object> searchMap = new HashMap<String,Object>();
                searchMap.put("parent_id", parent_ids[i]);
                List<PlantsCategory> list = get(searchMap);
                categories.add(list);
            }
        }
        return categories;
    }
	
	public List<PlantsCategory> getCategoryInPath(String category_path)throws Exception{
        List<PlantsCategory> categories = new ArrayList<PlantsCategory>();
        if(!StringUtils.isEmpty(category_path))
        {
            String class_ids[] = category_path.split("_");
            for(int i = class_ids.length - 1; i >= 0; i--)
            {
                Map<String,Object> searchMap = new HashMap<String,Object>();
                searchMap.put("class_id", class_ids[i]);
                List<PlantsCategory> list = get(searchMap);
                if(list.size() == 1){
                	PlantsCategory pc = (PlantsCategory) list.get(0);
                	categories.add(pc);
                }
            }
        }
        return categories;
    }
	
}
 