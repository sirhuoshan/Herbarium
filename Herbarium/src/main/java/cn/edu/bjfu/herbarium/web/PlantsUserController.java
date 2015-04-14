/** 
 * Project Name:Herbarium 
 * File Name:PlantsInfoController.java 
 * Package Name:cn.edu.bjfu.herbarium.web 
 * Date:2015年3月30日 下午9:08:22 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.web;  

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjfu.herbarium.domain.AutoJson;
import cn.edu.bjfu.herbarium.domain.PlantsSpeciesInfo;
import cn.edu.bjfu.herbarium.service.PlantsSpeciesInfoService;
import cn.edu.bjfu.herbarium.service.PlantsUserService;
import cn.edu.bjfu.herbarium.util.ObjectToMap;
import cn.edu.bjfu.herbarium.util.Pagination;
import cn.edu.bjfu.herbarium.util.ResponseObject;
import cn.edu.bjfu.herbarium.web.common.UserController;

/** 
 * ClassName:PlantsInfoController <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月30日 下午9:08:22 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */

@Controller
@RequestMapping("/plants")
public class PlantsUserController implements UserController<PlantsSpeciesInfo>{
	
	@Autowired
	private PlantsUserService<PlantsSpeciesInfo> plantsUserService;
	@RequestMapping(value="/{page}/{limit}",method = RequestMethod.GET)
	public ModelAndView getPage(String q,@PathVariable("page") int page,@PathVariable("limit") int limit) {
		Pagination pagination = new Pagination(page, limit);
		ModelAndView view  = new ModelAndView();
        try{
            Map<String,Object> searchMap = new HashMap<String,Object>();
            searchMap.put("q", q);
            pagination = plantsUserService.get(pagination, searchMap);
            view.addObject("pagination", pagination);
            view.addObject("q", q);
            view.setViewName("users/speciesList");
        }
        catch(Exception e){
        	view.setViewName("error/error");
            e.printStackTrace();
        }
        return view;
	}
	
	@RequestMapping(value="/{species_id}",method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("species_id") int species_id){
		ModelAndView view = new ModelAndView();
		try{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("species_id", species_id);
			view  = plantsUserService.get(map);
			view.setViewName("users/speciesInfo");
		}catch(Exception e){
			view.setViewName("error/error");
            e.printStackTrace();
        }
		return view;
	}
	
	@RequestMapping(value="/auto/{q}/{limit}")
	@ResponseBody
	public List<AutoJson> auto(@PathVariable("q")String q,@PathVariable("limit")int limit) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("q", q);
		map.put("limit", limit);
		List<AutoJson> list = plantsUserService.auto(map);
		return list;
	}
	
	
}
 