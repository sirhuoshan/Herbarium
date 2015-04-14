/** 
 * Project Name:Herbarium 
 * File Name:PlantsMediaService.java 
 * Package Name:cn.edu.bjfu.herbarium.service 
 * Date:2015年3月12日 上午12:31:43 
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjfu.herbarium.domain.PlantsCollect;
import cn.edu.bjfu.herbarium.domain.PlantsMedia;
import cn.edu.bjfu.herbarium.domain.PlantsSpeciesMedia;
import cn.edu.bjfu.herbarium.service.PlantsCollectService;
import cn.edu.bjfu.herbarium.service.PlantsMediaService;
import cn.edu.bjfu.herbarium.util.Pagination;
import cn.edu.bjfu.herbarium.util.ResponseObject;
import cn.edu.bjfu.herbarium.web.common.CommonController;

/** 
 * ClassName:PlantsMediaService <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月12日 上午12:31:43 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
@RequestMapping("/pmedia")
@Controller
public class PlantsMediaController  implements CommonController<PlantsMedia>{
	@Autowired
	private PlantsCollectService plantsCollectService;
	@Autowired
	private PlantsMediaService plantsMediaService;
	
	public Pagination getPage(PlantsMedia obj, int page, int rows) {
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
				view.setViewName("plants/pMediaAdd");
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

	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseObject post1(@RequestParam("Filedata") MultipartFile file,@RequestParam("Filename") String filename,PlantsMedia t) {
		ResponseObject responseObject;
		try {
			plantsMediaService.post1(file,filename,t);
			responseObject = new ResponseObject(true, t);
			return responseObject;
		} catch (Exception e) {
			e.printStackTrace();
			responseObject = new ResponseObject(false,ResponseObject.saveErrorMsg);
			return responseObject;
		}
	}
	
	public ResponseObject post(PlantsMedia t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping("/edit/{specimen_id}")
	public ModelAndView edit(@PathVariable("specimen_id")Long id) {
		ModelAndView view =  new ModelAndView();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("specimen_id", id);
		try{
			List<PlantsMedia> medias = plantsMediaService.get(map);
			view.addObject("medias", medias);
			view.addObject("specimen_id", id);
			view.setViewName("plants/pMediaOp");
		}catch(Exception e){
			e.printStackTrace();
		}
		return view;
	}

	public ResponseObject put(PlantsMedia t) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseObject get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value="/{media_id}",method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseObject delete(@PathVariable("media_id")Long id) {
		ResponseObject responseObject;
		try {
			plantsMediaService.delete(id);
			responseObject = new ResponseObject(true, ResponseObject.delSucMsg);
			return responseObject;
		} catch (Exception e) {
			e.printStackTrace();
			responseObject = new ResponseObject(true,ResponseObject.delErrorMsg);
			return responseObject;
		}
	}
}
 