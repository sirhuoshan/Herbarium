/** 
 * Project Name:Herbarium 
 * File Name:PlantsCategory.java 
 * Package Name:cn.edu.bjfu.herbarium.domain 
 * Date:2015年3月7日 下午4:42:49 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.domain;  

import java.util.List;

/**
 * 
 * ClassName: PlantsCategory <br />
 * Function: TODO ADD FUNCTION. <br />
 * date: 2015年3月7日 下午4:44:38 <br />
 * 
 * @author wangcan
 * @version  
 * @since JDK 1.6
 */
public class PlantsCategory {
	private Long class_id;
    private Long parent_id;
    private String class_name;
    private String class_latin;
    private String class_describe;
    private String class_level;
    private String class_path;
    private List children;
	public Long getClass_id() {
		return class_id;
	}
	public void setClass_id(Long class_id) {
		this.class_id = class_id;
	}
	public Long getParent_id() {
		return parent_id;
	}
	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getClass_latin() {
		return class_latin;
	}
	public void setClass_latin(String class_latin) {
		this.class_latin = class_latin;
	}
	public String getClass_describe() {
		return class_describe;
	}
	public void setClass_describe(String class_describe) {
		this.class_describe = class_describe;
	}
	public String getClass_level() {
		return class_level;
	}
	public void setClass_level(String class_level) {
		this.class_level = class_level;
	}
	public String getClass_path() {
		return class_path;
	}
	public void setClass_path(String class_path) {
		this.class_path = class_path;
	}
	public List getChildren() {
		return children;
	}
	public void setChildren(List children) {
		this.children = children;
	}
}
 