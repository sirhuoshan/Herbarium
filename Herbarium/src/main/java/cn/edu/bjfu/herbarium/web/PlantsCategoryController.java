/** 
 * Project Name:Herbarium 
 * File Name:PlantsCategoryController.java 
 * Package Name:cn.edu.bjfu.herbarium.web 
 * Date:2015年3月7日 下午4:45:43 
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjfu.herbarium.domain.BacteriumCategory;
import cn.edu.bjfu.herbarium.domain.PlantsCategory;
import cn.edu.bjfu.herbarium.service.BacteriumCategoryService;
import cn.edu.bjfu.herbarium.service.PlantsCategoryService;
import cn.edu.bjfu.herbarium.util.ObjectToMap;
import cn.edu.bjfu.herbarium.util.Pagination;
import cn.edu.bjfu.herbarium.util.ResponseObject;
import cn.edu.bjfu.herbarium.web.common.CategoryController;

/** 
 * ClassName:PlantsCategoryController <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月7日 下午4:45:43 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
@Controller
@RequestMapping("/pcategory")
public class PlantsCategoryController implements CategoryController<PlantsCategory>{
	private static Logger log = Logger.getLogger(PlantsCategoryController.class);
    @Autowired
    private PlantsCategoryService plantsCategoryService;
    
    @RequestMapping("/tree")
    public ModelAndView tree(){
        ModelAndView view = new ModelAndView();
        view.setViewName("plants/plantsTree");
        return view;
    }
    
    @RequestMapping(value="/category",method=RequestMethod.GET)
    @ResponseBody
    public Pagination getPage(PlantsCategory pc, int page, int rows){
        Pagination pagination = new Pagination(page, rows);
        try{
            Map<String,Object> searchMap = ObjectToMap.toMap(pc);
            pagination = plantsCategoryService.get(pagination, searchMap);
            return pagination;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    @RequestMapping("/new/{class_id}")
	public ModelAndView add(@PathVariable("class_id") Long class_id) {
    	 ModelAndView view = new ModelAndView();
         List<PlantsCategory> pcList = new ArrayList<PlantsCategory> ();
         Map<String,Object> searchMap = new HashMap<String,Object>();
         searchMap.put("class_id", class_id);
         try{
        	 pcList = plantsCategoryService.get(searchMap);
             if(pcList != null && pcList.size() == 1)
             {
            	 PlantsCategory pc = (PlantsCategory)pcList.get(0);
                 view.addObject("class_path", pc.getClass_path());
                 view.addObject("class_id", pc.getClass_id());
             }
         }catch(Exception e){
             e.printStackTrace();
         }
         view.setViewName("plants/pCategoryAdd");
         return view;
	}
    
   
    @RequestMapping("/pathes/{category_path}")
    @ResponseBody
    public List getCategoriesInPath(@PathVariable("category_path")String category_path){
        List categories = new ArrayList();
        try{
            categories = plantsCategoryService.getCategoriesInPath(category_path);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return categories;
    }
    
    @RequestMapping("/category/{parent_id}")
    @ResponseBody
    public ResponseObject getChildCategory(@PathVariable("parent_id")Long parent_id)
    {
    	ResponseObject responseObject;
        List<PlantsCategory> pcList = new ArrayList<PlantsCategory>();
        Map<String,Object> searchMap = new HashMap<String,Object> ();
        searchMap.put("parent_id", parent_id);
        try{
        	pcList = plantsCategoryService.get(searchMap);
        	responseObject = new ResponseObject(true, pcList);
        }
        catch(Exception e){
        	responseObject = new ResponseObject(false, ResponseObject.getErrorMsg);
            e.printStackTrace();
        }
        return responseObject;
    }
    
    /**
     * 
     * post:<br />
     * TODO
     *
     * @author huoshansir
     * 2015年2月19日
     * @param bc
     * @return
     */
    @RequestMapping(value="/category",method=RequestMethod.POST)
    @ResponseBody
    public ResponseObject post(PlantsCategory pc){
    	ResponseObject responseObj;
    	try{
    		plantsCategoryService.post(pc);
    		responseObj = new ResponseObject(true,ResponseObject.saveSucMsg);
    	}catch(Exception e){
    		responseObj = new ResponseObject(false,ResponseObject.saveErrorMsg);
    		e.printStackTrace();
    	}
		return responseObj;
    }
    
    
    @RequestMapping(value="/edit/{class_id}",method=RequestMethod.GET)
    public ModelAndView edit(@PathVariable("class_id")Long class_id){
    	ModelAndView view  = new ModelAndView();
    	 Map<String,Object> searchMap = new HashMap<String,Object>();
         searchMap.put("class_id", class_id);
         try{
            List<PlantsCategory> pcList = plantsCategoryService.get(searchMap);
            if(pcList != null && pcList.size() == 1){
            	PlantsCategory pc = (PlantsCategory) pcList.get(0);
                view.setViewName("plants/pCategoryEdit");
                view.addObject("category", pc);
            }else{
            	view.setViewName("error/error");
            	view.addObject("msg", "获取标本类别失败");
            }
         }
         catch(Exception e){
        	 view.setViewName("error/error");
         	 view.addObject("msg", "获取标本类别失败");
             e.printStackTrace();
         }
    	return view;
    }
    

    @RequestMapping(value="/category",method=RequestMethod.PUT)
    @ResponseBody
    public ResponseObject put(PlantsCategory pc){
    	ResponseObject responseObj;
    	try{
    		plantsCategoryService.put(pc);
    		responseObj = new ResponseObject(true,ResponseObject.editSucMsg);
    	}catch(Exception e){
    		responseObj = new ResponseObject(false,ResponseObject.editErrorMsg);
    		e.printStackTrace();
    	}
		return responseObj;
    	
    }
    
    @RequestMapping(value="/{class_id}",method=RequestMethod.GET)
    @ResponseBody
    public ResponseObject get(@PathVariable("class_id")Long class_id){
    	ResponseObject responseObj;
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("class_id", class_id);
        try{
        	List<PlantsCategory> list = plantsCategoryService.get(map);
        	if(list.size() == 1){
        		PlantsCategory pc = list.get(0);
        		responseObj = new ResponseObject(true,pc);
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
    @RequestMapping(value="/{class_id}",method=RequestMethod.DELETE)
    @ResponseBody
    public ResponseObject delete(@PathVariable("class_id") Long class_id){
    	ResponseObject responseObj;
    	try{
    		plantsCategoryService.delete(class_id);
    		responseObj = new ResponseObject(true,ResponseObject.delSucMsg);
    	}catch(Exception e){
    		responseObj = new ResponseObject(false,ResponseObject.delErrorMsg);
    		e.printStackTrace();
    	}
		return responseObj;
    	
    }
    
    
    /**
     * 
     * getCategoryInPath:<br />
     * TODO 获取在路径上的类别
     *
     * @author Administrator
     * 2015年3月7日
     * @param category_path
     * @return
     */
    @RequestMapping("/path/{category_path}")
    @ResponseBody
    public ResponseObject getCategoryInPath(@PathVariable("category_path")String category_path){
    	List<PlantsCategory> categories = new ArrayList<PlantsCategory>();
    	ResponseObject responseObj;
    	try{
            categories = plantsCategoryService.getCategoryInPath(category_path);
            responseObj = new ResponseObject(true,categories);
        }
        catch(Exception e){
        	responseObj = new ResponseObject(false,ResponseObject.getErrorMsg);
            e.printStackTrace();
        }
        return responseObj;
    }
    
    /**
     * 
     * search:<br />
     * TODO 查询标本类别 不带分页的
     *
     * @author search
     * 2015年3月7日
     * @param t
     * @return
     */
    @RequestMapping("/auto")
    @ResponseBody
	public List<PlantsCategory> getAutoData(PlantsCategory t) {
    	List<PlantsCategory> list = new ArrayList<PlantsCategory>();
        try{
        	Map<String,Object> searchMap = ObjectToMap.toMap(t);
        	list = plantsCategoryService.getAutoData(searchMap);
        } catch(Exception e){
            e.printStackTrace();
        }
    	return list;
	}

	public ModelAndView add() {
		return null;
	}
}
 