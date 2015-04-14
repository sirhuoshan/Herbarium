// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CommonController.java

package cn.edu.bjfu.herbarium.web.common;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjfu.herbarium.domain.PlantsCategory;
import cn.edu.bjfu.herbarium.util.Pagination;
import cn.edu.bjfu.herbarium.util.ResponseObject;


public interface CommonController<T>{

	/**
	 * 
	 * getPage:<br />
	 * TODO 分页
	 *
	 * @author wangcan
	 * 2015年3月7日
	 * @param obj
	 * @param page
	 * @param rows
	 * @return
	 */
	public abstract Pagination getPage(T obj, int page, int rows);
	
	
	/**
	 * 
	 * categoryNew:<br />
	 * TODO 跳转到新增的页面
	 *
	 * @author wangcan
	 * 2015年3月7日
	 * @param class_id
	 * @return
	 */
    public abstract ModelAndView add();
	
    /**
     * 
     * post:<br />
     * TODO 新增
     *
     * @author wangcan
     * 2015年3月10日
     * @param t
     * @return
     */
    public abstract ResponseObject post(T t);
	
	 /**
     * 
     * edit:<br />
     * TODO 跳转到编辑页面 并且获取要编辑信息
     *
     * @author wangcan
     * 2015年3月10日
     * @param id
     * @return
     */
    public abstract ModelAndView edit(Long id);
    
    /**
     * 
     * put:<br />
     * TODO 修改
     *
     * @author wangcan
     * 2015年3月10日
     * @param t
     * @return
     */
    public abstract ResponseObject put(T t);
    
    /**
     * 
     * get:<br />
     * TODO 通过id取得信息
     *
     * @author wangcan
     * 2015年3月10日
     * @param id
     * @return
     */
    public abstract ResponseObject get(Long id);
    
    /**
     * 
     * delete:<br />
     * TODO 通过id删除信息
     *
     * @author wangcan
     * 2015年3月10日
     * @param id
     * @return
     */
    public abstract ResponseObject delete(Long id);

}
