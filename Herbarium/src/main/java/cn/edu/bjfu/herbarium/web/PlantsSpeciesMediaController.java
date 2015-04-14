/** 
 * Project Name:Herbarium 
 * File Name:PlantsSpeciesMediaController.java 
 * Package Name:cn.edu.bjfu.herbarium.web 
 * Date:2015年3月11日 上午10:34:03 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.web;  

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjfu.herbarium.domain.PlantsSpeciesMedia;
import cn.edu.bjfu.herbarium.service.PlantsSpeciesMediaService;
import cn.edu.bjfu.herbarium.util.Pagination;
import cn.edu.bjfu.herbarium.util.ResponseObject;
import cn.edu.bjfu.herbarium.web.common.SpeciesMediaController;

/** 
 * ClassName:PlantsSpeciesMediaController <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月11日 上午10:34:03 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
@RequestMapping("/pspeciesMedia")
@Controller
public class PlantsSpeciesMediaController implements SpeciesMediaController<PlantsSpeciesMedia>{
    private static Logger log = Logger.getLogger(PlantsSpeciesMediaController.class);
    @Autowired
    private PlantsSpeciesMediaService<PlantsSpeciesMedia> plantsSpeciesMediaService;
	
	@RequestMapping("/medias/{species_id}")
	public ModelAndView media(@PathVariable("species_id")Long species_id) {
		ModelAndView view =  new ModelAndView();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("species_id", species_id);
		try{
			List<PlantsSpeciesMedia> medias = plantsSpeciesMediaService.get(map);
			view.addObject("medias", medias);
			view.addObject("species_id", species_id);
			view.setViewName("plants/plantsSpeciesMedia");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return view;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseObject post(@RequestParam("Filedata") MultipartFile file,@RequestParam("Filename") String filename, PlantsSpeciesMedia t) {
		ResponseObject responseObject;
		try {
			plantsSpeciesMediaService.post(file,filename,t);
			responseObject = new ResponseObject(true, t);
			return responseObject;
		} catch (Exception e) {
			e.printStackTrace();
			responseObject = new ResponseObject(true,ResponseObject.saveErrorMsg);
			return responseObject;
		}
	}


	public Pagination getPage(PlantsSpeciesMedia obj, int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}

	public ModelAndView add() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseObject post(PlantsSpeciesMedia t) {
		// TODO Auto-generated method stub
		return null;
	}

	public ModelAndView edit(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public ResponseObject put(PlantsSpeciesMedia t) {
		ResponseObject responseObject;
		try {
			plantsSpeciesMediaService.put(t);
			responseObject = new ResponseObject(true, ResponseObject.editSucMsg);
			return responseObject;
		} catch (Exception e) {
			e.printStackTrace();
			responseObject = new ResponseObject(true,ResponseObject.editErrorMsg);
			return responseObject;
		}
	}
	
	@RequestMapping(value="/{media_id}")
	@ResponseBody
	public ResponseObject get(@PathVariable("media_id")Long media_id) {
		ResponseObject responseObject;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("media_id", media_id);
		try{
			List<PlantsSpeciesMedia> lists = plantsSpeciesMediaService.get(map);
			
			if(lists.size() == 1){
				responseObject = new ResponseObject(true, lists.get(0));
			}else{
				responseObject = new ResponseObject(false, ResponseObject.getErrorMsg);
			}
			
		}catch(Exception e){
			responseObject = new ResponseObject(false, ResponseObject.getErrorMsg);
			e.printStackTrace();
		}
		return responseObject;
	}
	@RequestMapping(value="/{media_id}",method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseObject delete(@PathVariable("media_id")Long id) {
		ResponseObject responseObject;
		try {
			plantsSpeciesMediaService.delete(id);
			responseObject = new ResponseObject(true, ResponseObject.delSucMsg);
			return responseObject;
		} catch (Exception e) {
			e.printStackTrace();
			responseObject = new ResponseObject(true,ResponseObject.delErrorMsg);
			return responseObject;
		}
	}
}
 