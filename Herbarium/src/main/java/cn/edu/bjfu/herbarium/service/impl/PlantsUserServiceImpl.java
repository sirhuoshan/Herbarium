/** 
 * Project Name:Herbarium 
 * File Name:PlantsUserServiceImpl.java 
 * Package Name:cn.edu.bjfu.herbarium.service.impl 
 * Date:2015年3月31日 下午12:36:25 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.service.impl;  

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjfu.herbarium.dao.PlantsUserDao;
import cn.edu.bjfu.herbarium.domain.AutoJson;
import cn.edu.bjfu.herbarium.domain.PlantsCategory;
import cn.edu.bjfu.herbarium.domain.PlantsSpeciesInfo;
import cn.edu.bjfu.herbarium.domain.PlantsSpeciesMedia;
import cn.edu.bjfu.herbarium.service.PlantsCategoryService;
import cn.edu.bjfu.herbarium.service.PlantsSpeciesInfoService;
import cn.edu.bjfu.herbarium.service.PlantsSpeciesMediaService;
import cn.edu.bjfu.herbarium.service.PlantsUserService;
import cn.edu.bjfu.herbarium.util.ObjectToMap;
import cn.edu.bjfu.herbarium.util.Pagination;

/** 
 * ClassName:PlantsUserServiceImpl <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月31日 下午12:36:25 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
@Service
public class PlantsUserServiceImpl implements PlantsUserService<PlantsSpeciesInfo>{
	
	@Autowired
	private PlantsUserDao<PlantsSpeciesInfo> plantsUserDao;
	@Autowired
	private PlantsSpeciesInfoService<PlantsSpeciesInfo> plantsSpeciesInfoService;
	@Autowired
	private PlantsSpeciesMediaService<PlantsSpeciesMedia> plantsSpeciesMediaService;
	@Autowired
	private PlantsCategoryService plantsCategoryService;
	
	public List<AutoJson> auto(Map<String,Object> searchMap) {
		return plantsUserDao.auto(searchMap);
	}
	
	public Pagination get(Pagination pagination, Map<String, Object> map)
			throws Exception {
		Map<String,Object> pageMap = ObjectToMap.toMap(pagination);
		map.putAll(pageMap);
        int total = plantsUserDao.getTotal(map);
        List<PlantsSpeciesInfo> rows = plantsUserDao.getPage(map);
        pagination.setRows(rows);
        pagination.setTotal(total);
        return pagination;
	}
	
	
	public ModelAndView get(Map<String, Object> map) throws Exception{
		ModelAndView view = new ModelAndView();
		List<PlantsSpeciesInfo> list = plantsSpeciesInfoService.get(map);
		if(list.size() ==1 ){
			PlantsSpeciesInfo psinfo = list.get(0);
			view.addObject("psinfo", psinfo);
			//取四张图片
			Pagination pagination = new Pagination(0, 4);
			pagination = plantsSpeciesMediaService.get(pagination, map);
			view.addObject("medias", pagination);
			//获取类别
			Map<String,Object> map1 = new HashMap<String,Object>();
			map1.put("class_id", psinfo.getGenus());
			List<PlantsCategory> plantsCategories = plantsCategoryService.get(map1);
			if(plantsCategories.size() == 1){
				PlantsCategory pc = plantsCategories.get(0);
				String category_path = pc.getClass_path();
				plantsCategories = plantsCategoryService.getCategoryInPath(category_path);
				view.addObject("plantsCategories", plantsCategories);
			}
			//获取6个相关类群
			Pagination pagination2 = new Pagination(0, 6);
			Map<String,Object> map2 = new HashMap<String,Object>();
			map2.put("genus",psinfo.getGenus());
			map2.put("species_id",psinfo.getSpecies_id());
			List<PlantsSpeciesInfo> relateSpecies = this.getRelateSpecies(pagination2, map2);
			view.addObject("relateSpecies", relateSpecies);
			
 		}else{
			view.setViewName("error/error");
		}
		return view;
	}

	public List<PlantsSpeciesInfo> getRelateSpecies(Pagination pagination,
			Map<String, Object> map) throws Exception {
		Map<String,Object> pageMap = ObjectToMap.toMap(pagination);
		map.putAll(pageMap);
		return plantsUserDao.getRelateSpecies(map);
	}
}
 