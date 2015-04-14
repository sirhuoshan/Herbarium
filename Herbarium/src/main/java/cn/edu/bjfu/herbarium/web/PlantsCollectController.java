/** 
 * Project Name:Herbarium 
 * File Name:PlantsCollectService.java 
 * Package Name:cn.edu.bjfu.herbarium.service 
 * Date:2015年3月12日 上午12:30:30 
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cn.edu.bjfu.herbarium.domain.PlantsCollect;
import cn.edu.bjfu.herbarium.domain.PlantsSpeciesInfo;
import cn.edu.bjfu.herbarium.service.PlantsCollectService;
import cn.edu.bjfu.herbarium.util.ObjectToMap;
import cn.edu.bjfu.herbarium.util.Pagination;
import cn.edu.bjfu.herbarium.util.ResponseObject;
import cn.edu.bjfu.herbarium.web.common.CommonController;

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
@RequestMapping("/pcollect")
@Controller
public class PlantsCollectController implements CommonController<PlantsCollect>{
    private static Logger log = Logger.getLogger(PlantsCollectController.class);
	@Autowired
	private PlantsCollectService plantsCollectService;
	
	@RequestMapping("/collects")
	public ModelAndView species() {
		ModelAndView view = new ModelAndView();
		view.setViewName("plants/plantsSpecimen");
		return view;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Pagination getPage(PlantsCollect obj, int page, int rows) {
		Pagination pagination = new Pagination(page, rows);
        try{
            Map<String,Object> searchMap = ObjectToMap.toMap(obj);
            pagination = plantsCollectService.get(pagination, searchMap);
            return pagination;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
	}
	
	@RequestMapping("/new")
	public ModelAndView add() {
		ModelAndView view = new ModelAndView();
		view.setViewName("plants/pCollectAdd");
		return view;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView post1(PlantsCollect t){
		ModelAndView view = new ModelAndView();
		try{
			plantsCollectService.post(t);
			view.setViewName("redirect:pstorage/new/"+t.getSpecimen_id());
		}catch(Exception e){
			view.setViewName("error/error");
			e.printStackTrace();
		}
		return view;
	}
	
	public ResponseObject post(PlantsCollect t) {
		return null;
	}
	
	@RequestMapping("/edit/{specimen_id}")
	public ModelAndView edit(@PathVariable("specimen_id")Long id) {
		ModelAndView view  = new ModelAndView();
   	 	Map<String,Object> searchMap = new HashMap<String,Object>();
        searchMap.put("specimen_id", id);
        try{
           List<PlantsCollect> pcList = plantsCollectService.get(searchMap);
           if(pcList != null && pcList.size() == 1){
        	   PlantsCollect pc = (PlantsCollect) pcList.get(0);
               view.setViewName("plants/pCollectOp");
               view.addObject("pcollect", pc);
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
	public ResponseObject put(PlantsCollect t) {
		ResponseObject responseObj;
    	try{
    		plantsCollectService.put(t);
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

	public ResponseObject delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
 