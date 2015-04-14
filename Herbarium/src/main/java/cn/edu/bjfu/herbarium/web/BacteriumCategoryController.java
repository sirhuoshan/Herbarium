// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BacteriumCategoryController.java

package cn.edu.bjfu.herbarium.web;

import cn.edu.bjfu.herbarium.domain.BacteriumCategory;
import cn.edu.bjfu.herbarium.service.BacteriumCategoryService;
import cn.edu.bjfu.herbarium.util.ObjectToMap;
import cn.edu.bjfu.herbarium.util.Pagination;
import cn.edu.bjfu.herbarium.util.ResponseObject;
import cn.edu.bjfu.herbarium.web.common.CommonController;

import java.io.UnsupportedEncodingException;
import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

// Referenced classes of package cn.edu.bjfu.herbarium.web:
//            CommonController
@Controller
@RequestMapping("/bcategory")
public class BacteriumCategoryController 
{
	

    private static Logger log = Logger.getLogger(BacteriumCategoryController.class);
    @Autowired
    private BacteriumCategoryService bacteriumCategoryService;
	
    public BacteriumCategoryController()
    {
    }
    @RequestMapping("/tree")
    public ModelAndView bcTree()
    {
        ModelAndView view = new ModelAndView();
        view.setViewName("bacterium/bacteriumTree");
        return view;
    }
    
    @RequestMapping("/new/{class_id}")
    public ModelAndView categoryNew(@PathVariable("class_id") Long class_id)
    {
        ModelAndView view = new ModelAndView();
        List bcList = new ArrayList();
        Map searchMap = new HashMap();
        searchMap.put("class_id", class_id);
        try
        {
            bcList = bacteriumCategoryService.get(searchMap);
            if(bcList != null && bcList.size() == 1)
            {
                BacteriumCategory bc = (BacteriumCategory)bcList.get(0);
                view.addObject("class_path", bc.getClass_path());
                view.addObject("class_id", bc.getClass_id());
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        view.setViewName("bacterium/bCategoryAdd");
        return view;
    }
    
    
    @RequestMapping(value="/category",method=RequestMethod.GET)
    @ResponseBody
    public Pagination getPage(BacteriumCategory bc, int page, int rows)
    {
        Pagination pagination = new Pagination(page, rows);
        try
        {
            Map searchMap = ObjectToMap.toMap(bc);
            pagination = bacteriumCategoryService.get(pagination, searchMap);
            return pagination;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 
     * get:<br />
     * TODO 通过class_id 获取标本类别
     *
     * @author Administrator
     * 2015年3月7日
     * @param class_id
     * @return
     */
    @RequestMapping(value="/{class_id}",method=RequestMethod.GET)
    @ResponseBody
    public ResponseObject get(@PathVariable("class_id")Long class_id){
    	ResponseObject responseObj;
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("class_id", class_id);
        try{
        	List<BacteriumCategory> list = bacteriumCategoryService.get(map);
        	if(list.size() == 1){
        		BacteriumCategory bc = list.get(0);
        		responseObj = new ResponseObject(true,bc);
        	}else{
        		responseObj = new ResponseObject(true,ResponseObject.getErrorMsg);
        	}
        } catch(Exception e){
        		responseObj = new ResponseObject(true,ResponseObject.getErrorMsg);
            e.printStackTrace();
        }
    	return responseObj;
    }
    
    @RequestMapping("/category/{parent_id}")
    @ResponseBody
    public List getChildCategory(@PathVariable("parent_id")Long parent_id)
    {
        List bcList = new ArrayList();
        Map searchMap = new HashMap();
        searchMap.put("parent_id", parent_id);
        try
        {
            bcList = bacteriumCategoryService.get(searchMap);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return bcList;
    }
    
    
    /**
     * 
     * getCategoriesInPath:<br />
     * TODO 获取在路径上的类别的子类别
     *
     * @author Administrator
     * 2015年3月7日
     * @param category_path
     * @return
     */
    @RequestMapping("/pathes/{category_path}")
    @ResponseBody
    public List getCategoriesInPath(@PathVariable("category_path")String category_path){
        List categories = new ArrayList();
        try{
            categories = bacteriumCategoryService.getCategoriesInPath(category_path);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return categories;
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
    	List<BacteriumCategory> categories = new ArrayList<BacteriumCategory>();
    	ResponseObject responseObj;
    	try{
            categories = bacteriumCategoryService.getCategoryInPath(category_path);
            responseObj = new ResponseObject(true,categories);
        }
        catch(Exception e){
        	responseObj = new ResponseObject(false,ResponseObject.getErrorMsg);
            e.printStackTrace();
        }
        return responseObj;
    }

    
    public List getJson()
    {
        List bcList = bacteriumCategoryService.getJson();
        return bcList;
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
    public ResponseObject post(BacteriumCategory bc){
    	ResponseObject responseObj;
    	try{
    		bacteriumCategoryService.post(bc);
    		responseObj = new ResponseObject(true,ResponseObject.saveSucMsg);
    	}catch(Exception e){
    		responseObj = new ResponseObject(false,ResponseObject.saveErrorMsg);
    		e.printStackTrace();
    	}
		return responseObj;
    }
    
    /**
     * 
     * get:<br />
     * TODO 获取修改的类别
     *
     * @author huoshansir
     * 2015年2月24日
     * @param class_id
     * @return
     */
    @RequestMapping(value="/edit/{class_id}",method=RequestMethod.GET)
    public ModelAndView getCategory(@PathVariable("class_id")Long class_id){
    	ModelAndView view  = new ModelAndView();
    	 Map searchMap = new HashMap();
         searchMap.put("class_id", class_id);
         try
         {
            List bcList = bacteriumCategoryService.get(searchMap);
            if(bcList != null && bcList.size() == 1){
            	BacteriumCategory bc = (BacteriumCategory) bcList.get(0);
                view.setViewName("bacterium/bCategoryEdit");
                view.addObject("category", bc);
            }else{
            	view.setViewName("error/error");
            	view.addObject("msg", "获取标本类别失败");
            }
         }
         catch(Exception e)
         {
        	 view.setViewName("error/error");
         	 view.addObject("msg", "获取标本类别失败");
             e.printStackTrace();
         }
    	return view;
    }
    
    /**
     * 
     * put:<br />
     * TODO 修改
     *
     * @author huoshansir
     * 2015年2月24日
     * @param bc
     * @return
     */
    @RequestMapping(value="/category",method=RequestMethod.PUT)
    @ResponseBody
    public ResponseObject put(BacteriumCategory bc){
    	ResponseObject responseObj;
    	try{
    		bacteriumCategoryService.put(bc);
    		responseObj = new ResponseObject(true,ResponseObject.editSucMsg);
    	}catch(Exception e){
    		responseObj = new ResponseObject(false,ResponseObject.editErrorMsg);
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
    		bacteriumCategoryService.delete(class_id);
    		responseObj = new ResponseObject(true,ResponseObject.delSucMsg);
    	}catch(Exception e){
    		responseObj = new ResponseObject(false,ResponseObject.delErrorMsg);
    		e.printStackTrace();
    	}
		return responseObj;
    	
    }
}
