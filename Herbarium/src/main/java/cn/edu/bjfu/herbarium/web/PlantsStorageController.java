/** 
 * Project Name:Herbarium 
 * File Name:PlantsStorageService.java 
 * Package Name:cn.edu.bjfu.herbarium.service 
 * Date:2015年3月12日 上午12:33:05 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.web;  

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjfu.herbarium.domain.PlantsCollect;
import cn.edu.bjfu.herbarium.domain.PlantsStorage;
import cn.edu.bjfu.herbarium.service.PlantsCollectService;
import cn.edu.bjfu.herbarium.service.PlantsStorageService;
import cn.edu.bjfu.herbarium.util.Pagination;
import cn.edu.bjfu.herbarium.util.ResponseObject;
import cn.edu.bjfu.herbarium.web.common.CommonController;

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
@RequestMapping("/pstorage")
@Controller
public class PlantsStorageController  implements CommonController<PlantsStorage>{
	private static Logger log = Logger.getLogger(PlantsStorageController.class);
	@Autowired
	private PlantsCollectService plantsCollectService;
	@Autowired
	private PlantsStorageService plantsStorageService;
	
	public Pagination getPage(PlantsStorage obj, int page, int rows) {
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
				view.setViewName("plants/pStorageAdd");
			}else{
				view.setViewName("error/error");
			}
		}catch(Exception e){
			view.setViewName("error/error");
			e.printStackTrace();
		}
		return view;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseObject post(PlantsStorage t) {
		ResponseObject responseObject;
		try{
			plantsStorageService.post(t);
			responseObject = new ResponseObject(true, ResponseObject.saveSucMsg);
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
           List<PlantsStorage> psList = plantsStorageService.get(searchMap);
           if(psList.size() == 1){
        	   PlantsStorage ps = (PlantsStorage) psList.get(0);
               view.setViewName("plants/pStorageOp");
               view.addObject("pstorage", ps);
           }else if(psList.size() == 0){
        	   
	   			List<PlantsCollect> list = plantsCollectService.get(searchMap);
	   			if(list.size() == 1){
	   				PlantsCollect pc = list.get(0);
	   				view.addObject("specimen_id", pc.getSpecimen_id());
	   				view.addObject("latin_name", pc.getLatin_name());
	   				view.addObject("chinese_name", pc.getChinese_name());
	   				view.setViewName("plants/pStorageAdd");
	   			}else{
	   				view.setViewName("error/error");
	   			}
           }else{
        	   view.setViewName("error/error");
           	   view.addObject("msg", "获取信息失败");
           }
        }
        catch(Exception e){
       	     view.setViewName("error/error");
        	 view.addObject("msg", "获取信息失败");
             e.printStackTrace();
        }
        return view;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public ResponseObject put(PlantsStorage t) {
		ResponseObject responseObj;
    	try{
    		plantsStorageService.put(t);
    		responseObj = new ResponseObject(true,ResponseObject.editSucMsg);
    	}catch(Exception e){
    		responseObj = new ResponseObject(false,ResponseObject.editErrorMsg);
    		e.printStackTrace();
    	}
		return responseObj;
	}

	public ResponseObject get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value="/{specimen_id}",method= RequestMethod.DELETE)
	@ResponseBody
	public ResponseObject delete(@PathVariable("specimen_id")Long id) {
		ResponseObject responseObj;
    	try{
    		plantsStorageService.delete(id);
    		responseObj = new ResponseObject(true,ResponseObject.delSucMsg);
    	}catch(Exception e){
    		responseObj = new ResponseObject(false,ResponseObject.delErrorMsg);
    		e.printStackTrace();
    	}
		return responseObj;
	}
	public ModelAndView add() {
		// TODO Auto-generated method stub
		return null;
	}

}
 