/** 
 * Project Name:Herbarium 
 * File Name:PlantsIdentifyService.java 
 * Package Name:cn.edu.bjfu.herbarium.service 
 * Date:2015年3月12日 上午12:31:09 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.web;  

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjfu.herbarium.domain.PlantsCollect;
import cn.edu.bjfu.herbarium.domain.PlantsIdentify;
import cn.edu.bjfu.herbarium.domain.PlantsSpeciesInfo;
import cn.edu.bjfu.herbarium.service.BaseService;
import cn.edu.bjfu.herbarium.service.PlantsCollectService;
import cn.edu.bjfu.herbarium.service.PlantsIdentifyService;
import cn.edu.bjfu.herbarium.util.Pagination;
import cn.edu.bjfu.herbarium.util.ResponseObject;
import cn.edu.bjfu.herbarium.web.common.CommonController;

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
@RequestMapping("/pidentify")
@Controller
public class PlantsIdentifyController implements CommonController<PlantsIdentify>{
	
	@Autowired
	private PlantsCollectService plantsCollectService;
	@Autowired
	private PlantsIdentifyService plantsIdentifyService;
	
	public Pagination getPage(PlantsIdentify obj, int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}
	@RequestMapping("/new/{specimen_id}")
	public ModelAndView add1(@PathVariable("specimen_id")Long specimen_id) {
		ModelAndView view = new ModelAndView();
		try{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("specimen_id", specimen_id);
			List<PlantsCollect> list = plantsCollectService.get(map);
			if(list.size() == 1){
				PlantsCollect pc = list.get(0);
				view.addObject("specimen_id", pc.getSpecimen_id());
				view.addObject("latin_name", pc.getLatin_name());
				view.addObject("chinese_name", pc.getChinese_name());
				view.setViewName("plants/pIdentifyAdd");
			}else{
				view.setViewName("error/error");
			}
		}catch(Exception e){
			view.setViewName("error/error");
			e.printStackTrace();
		}
		return view;
	}
	
	public ModelAndView add() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseObject post(PlantsIdentify t) {
		ResponseObject responseObject;
		try{
			plantsIdentifyService.post(t);
			responseObject = new ResponseObject(true, t);
		}catch(Exception e){
			responseObject = new ResponseObject(false, ResponseObject.saveErrorMsg);
			e.printStackTrace();
		}
		return responseObject;
	}

	@RequestMapping("/edit/{specimen_id}")
	public ModelAndView edit(@PathVariable("specimen_id")Long id) {
		ModelAndView view  = new ModelAndView();
   	 	Map<String,Object> searchMap = new HashMap<String,Object>();
        searchMap.put("specimen_id", id);
        try{
           List<PlantsIdentify> piList = plantsIdentifyService.get(searchMap);
           view.addObject("piList", piList);
           view.addObject("specimen_id", id);
           view.setViewName("plants/pIdentifyOp");
        }
        catch(Exception e){
       	     view.setViewName("error/error");
        	 view.addObject("msg", "获取信息失败");
             e.printStackTrace();
        }
        return view;
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	@ResponseBody
	public ResponseObject put(PlantsIdentify t) {
		ResponseObject responseObject;
		try{
			plantsIdentifyService.put(t);
			responseObject = new ResponseObject(true, t);
		}catch(Exception e){
			responseObject = new ResponseObject(false, ResponseObject.saveErrorMsg);
			e.printStackTrace();
		}
		return responseObject;
	}
	
	
	@RequestMapping(value="/{identify_id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseObject get(@PathVariable("identify_id")Long id) {
		ResponseObject responseObj;
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("identify_id", id);
        try{
        	List<PlantsIdentify> list = plantsIdentifyService.get(map);
        	if(list.size() == 1){
        		PlantsIdentify pi = list.get(0);
        		responseObj = new ResponseObject(true,pi);
        	}else{
        		responseObj = new ResponseObject(false,ResponseObject.getErrorMsg);
        	}
        } catch(Exception e){
        		responseObj = new ResponseObject(true,ResponseObject.getErrorMsg);
            e.printStackTrace();
        }
    	return responseObj;
	}
	
	@RequestMapping(value="/{identify_id}",method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseObject delete(@PathVariable("identify_id")Long id) {
		ResponseObject responseObject;
		try{
			plantsIdentifyService.delete(id);
			responseObject = new ResponseObject(true, ResponseObject.delSucMsg);
		}catch(Exception e){
			responseObject = new ResponseObject(false, ResponseObject.delErrorMsg);
			e.printStackTrace();
		}
		return responseObject;
	}
}
 