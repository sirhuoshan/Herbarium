/** 
 * Project Name:Herbarium 
 * File Name:PlantsSpeciesController.java 
 * Package Name:cn.edu.bjfu.herbarium.web 
 * Date:2015年3月9日 上午11:12:51 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.web;  

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjfu.herbarium.domain.PlantsCategory;
import cn.edu.bjfu.herbarium.domain.PlantsSpeciesInfo;
import cn.edu.bjfu.herbarium.service.PlantsSpeciesInfoService;
import cn.edu.bjfu.herbarium.util.ObjectToMap;
import cn.edu.bjfu.herbarium.util.Pagination;
import cn.edu.bjfu.herbarium.util.ResponseObject;
import cn.edu.bjfu.herbarium.web.common.SpeciesController;

/** 
 * ClassName:PlantsSpeciesController <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月9日 上午11:12:51 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
@Controller
@RequestMapping("/pspecies")
public class PlantsSpeciesInfoController implements SpeciesController<PlantsSpeciesInfo>{
	private static Logger log = Logger.getLogger(PlantsSpeciesInfoController.class);
	@Autowired
	private PlantsSpeciesInfoService<PlantsSpeciesInfo> plantsSpeciesInfoService;
		
	@RequestMapping("/species")
	public ModelAndView species() {
		ModelAndView view = new ModelAndView();
		view.setViewName("plants/plantsSpecies");
		return view;
	}
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Pagination getPage(PlantsSpeciesInfo obj, int page, int rows) {
		 Pagination pagination = new Pagination(page, rows);
	        try{
	            Map<String,Object> searchMap = ObjectToMap.toMap(obj);
	            pagination = plantsSpeciesInfoService.get(pagination, searchMap);
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
		view.setViewName("plants/pSpeciesAdd");
		return view;
	}
	
    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public ResponseObject post(PlantsSpeciesInfo psi){
    	ResponseObject responseObj;
    	try{
    		plantsSpeciesInfoService.post(psi);
    		responseObj = new ResponseObject(true,ResponseObject.saveSucMsg);
    	}catch(Exception e){
    		responseObj = new ResponseObject(false,ResponseObject.saveErrorMsg);
    		e.printStackTrace();
    	}
		return responseObj;
    }
    
    @RequestMapping(value="/edit/{species_id}",method=RequestMethod.GET)
    public ModelAndView edit(@PathVariable("species_id")Long species_id){
    	ModelAndView view  = new ModelAndView();
    	 Map<String,Object> searchMap = new HashMap<String,Object>();
         searchMap.put("species_id", species_id);
         try{
            List<PlantsSpeciesInfo> psiList = plantsSpeciesInfoService.get(searchMap);
            if(psiList != null && psiList.size() == 1){
            	PlantsSpeciesInfo psi = (PlantsSpeciesInfo) psiList.get(0);
                view.setViewName("plants/pSpeciesEdit");
                view.addObject("pspecies", psi);
            }else{
            	view.setViewName("error/error");
            	view.addObject("msg", "获取物种失败");
            }
         }
         catch(Exception e){
        	 view.setViewName("error/error");
         	 view.addObject("msg", "获取物种失败");
             e.printStackTrace();
         }
    	return view;
    }
    
    
    @RequestMapping(method=RequestMethod.PUT)
    @ResponseBody
	public ResponseObject put(PlantsSpeciesInfo t) {
    	ResponseObject responseObj;
    	try{
    		plantsSpeciesInfoService.put(t);
    		responseObj = new ResponseObject(true,ResponseObject.editSucMsg);
    	}catch(Exception e){
    		responseObj = new ResponseObject(false,ResponseObject.editErrorMsg);
    		e.printStackTrace();
    	}
		return responseObj;
	}
    
    
    @RequestMapping(value="/{species_id}",method=RequestMethod.GET)
    @ResponseBody
    public ResponseObject get(@PathVariable("species_id")Long species_id){
    	ResponseObject responseObj;
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("species_id", species_id);
        try{
        	List<PlantsSpeciesInfo> list = plantsSpeciesInfoService.get(map);
        	if(list.size() == 1){
        		PlantsSpeciesInfo psi = list.get(0);
        		responseObj = new ResponseObject(true,psi);
        	}else{
        		responseObj = new ResponseObject(true,ResponseObject.getErrorMsg);
        	}
        } catch(Exception e){
        		responseObj = new ResponseObject(true,ResponseObject.getErrorMsg);
            e.printStackTrace();
        }
    	return responseObj;
    }
    
    /**
     * 
     * delete:<br />
     * TODO 删除
     *
     * @author huoshansir
     * 2015年2月25日
     * @param class_id
     * @return
     */
    @RequestMapping(value="/{species_id}",method=RequestMethod.DELETE)
    @ResponseBody
    public ResponseObject delete(@PathVariable("species_id") Long species_id){
    	ResponseObject responseObj;
    	try{
    		plantsSpeciesInfoService.delete(species_id);
    		responseObj = new ResponseObject(true,ResponseObject.delSucMsg);
    	}catch(Exception e){
    		responseObj = new ResponseObject(false,ResponseObject.delErrorMsg);
    		e.printStackTrace();
    	}
		return responseObj;
    	
    }
  
    @RequestMapping("/auto")
    @ResponseBody
	public List<PlantsSpeciesInfo> getAutoData(PlantsSpeciesInfo t) {
    	List<PlantsSpeciesInfo> list = new ArrayList<PlantsSpeciesInfo>();
        try{
        	Map<String,Object> searchMap = ObjectToMap.toMap(t);
        	list = plantsSpeciesInfoService.getAutoData(searchMap);
        } catch(Exception e){
            e.printStackTrace();
        }
    	return list;
	}
	
}
 