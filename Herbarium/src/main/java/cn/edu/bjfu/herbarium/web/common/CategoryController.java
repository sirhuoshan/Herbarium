/** 
 * Project Name:Herbarium 
 * File Name:CategoryController.java 
 * Package Name:cn.edu.bjfu.herbarium.web 
 * Date:2015年3月7日 下午4:58:01 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.web.common;  

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjfu.herbarium.domain.BacteriumCategory;
import cn.edu.bjfu.herbarium.domain.PlantsCategory;
import cn.edu.bjfu.herbarium.util.Pagination;
import cn.edu.bjfu.herbarium.util.ResponseObject;

/** 
 * ClassName:CategoryController <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月7日 下午4:58:01 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface CategoryController<T> extends CommonController<T>{
	
	/**
	 * 
	 * tree:<br />
	 * TODO 去分类树的页面
	 *
	 * @author wangcan
	 * 2015年3月7日
	 * @return
	 */
	public ModelAndView tree();
	
	/**
	 * 
	 * add:<br />
	 * TODO 跳转到新增类别的页面
	 *
	 * @author wangcan
	 * 2015年3月7日
	 * @param class_id
	 * @return
	 */
    public abstract ModelAndView add(Long class_id);
    
    /**
     * 
     * getCategoriesInPath:<br />
     * TODO 获取在路径上的类别的子类别
     *
     * @author wangcan
     * 2015年3月7日
     * @param category_path
     * @return
     */
    public abstract List getCategoriesInPath(String category_path);
    
    /**
     * 
     * getChildCategory:<br />
     * TODO 获取子类别
     * 
     * @author wangcan
     * 2015年3月7日
     * @param parent_id
     * @return
     */
    public abstract ResponseObject getChildCategory(Long parent_id);
    
    /**
     * 
     * post:<br />
     * TODO 保存
     *
     * @author wangcan
     * 2015年3月8日
     * @param t
     * @return
     */
    public abstract ResponseObject post(T t);
    
    /**
     * 
     * search:<br />
     * TODO 自动补全的查询
     *
     * @author wangcan
     * 2015年3月10日
     * @param t
     * @return
     */
	public List<T> getAutoData(T t);    
    
    /**
     * 
     * getCategoryInPath:<br />
     * TODO 获取在路径上的类别
     *
     * @author wangcan
     * 2015年3月7日
     * @param category_path
     * @return
     */
    public abstract ResponseObject getCategoryInPath(String category_path);
}
 