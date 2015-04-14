/** 
 * Project Name:Herbarium 
 * File Name:PlantsStorage.java 
 * Package Name:cn.edu.bjfu.herbarium.domain 
 * Date:2015年3月11日 下午11:50:59 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.domain;  
/** 
 * ClassName:PlantsStorage <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月11日 下午11:50:59 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class PlantsStorage {
	private Long specimen_id;
	private String barcode_id;
	private String keep_location;
	private String specimen_state;
	private String specimen_source;
	private String specimen_attribute;
	private Integer storage_num;
	private String storage_remark;
	private String display;
	public Long getSpecimen_id() {
		return specimen_id;
	}
	public void setSpecimen_id(Long specimen_id) {
		this.specimen_id = specimen_id;
	}
	public String getBarcode_id() {
		return barcode_id;
	}
	public void setBarcode_id(String barcode_id) {
		this.barcode_id = barcode_id;
	}
	public String getKeep_location() {
		return keep_location;
	}
	public void setKeep_location(String keep_location) {
		this.keep_location = keep_location;
	}
	public String getSpecimen_state() {
		return specimen_state;
	}
	public void setSpecimen_state(String specimen_state) {
		this.specimen_state = specimen_state;
	}
	public String getSpecimen_source() {
		return specimen_source;
	}
	public void setSpecimen_source(String specimen_source) {
		this.specimen_source = specimen_source;
	}
	public String getSpecimen_attribute() {
		return specimen_attribute;
	}
	public void setSpecimen_attribute(String specimen_attribute) {
		this.specimen_attribute = specimen_attribute;
	}
	public Integer getStorage_num() {
		return storage_num;
	}
	public void setStorage_num(Integer storage_num) {
		this.storage_num = storage_num;
	}
	public String getStorage_remark() {
		return storage_remark;
	}
	public void setStorage_remark(String storage_remark) {
		this.storage_remark = storage_remark;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
}
 