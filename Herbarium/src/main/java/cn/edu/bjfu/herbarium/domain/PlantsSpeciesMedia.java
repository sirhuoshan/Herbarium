/** 
 * Project Name:Herbarium 
 * File Name:PlantsSpeciesMedia.java 
 * Package Name:cn.edu.bjfu.herbarium.domain 
 * Date:2015年3月11日 上午10:35:45 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.domain;  
/** 
 * ClassName:PlantsSpeciesMedia <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月11日 上午10:35:45 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class PlantsSpeciesMedia {
	
	private Long media_id;
	private Long species_id;
	private String media_path; //多媒体路径
	private String media_compress_path;//压缩图片路径
	private String media_compress_big_path;//大一号的压缩图片
	private String media_type_id; //多媒体类型
	private String media_discribe; //多媒体名
	private String photographer; //拍摄者
	private String shooting_time; //拍摄时间
	private String shooting_area; //拍摄地点
	private String shooting_part;//拍摄部位
	private String identifiers;//鉴定人
	public Long getMedia_id() {
		return media_id;
	}
	public void setMedia_id(Long media_id) {
		this.media_id = media_id;
	}
	public Long getSpecies_id() {
		return species_id;
	}
	public void setSpecies_id(Long species_id) {
		this.species_id = species_id;
	}
	public String getMedia_path() {
		return media_path;
	}
	public void setMedia_path(String media_path) {
		this.media_path = media_path;
	}
	public String getMedia_compress_path() {
		return media_compress_path;
	}
	public void setMedia_compress_path(String media_compress_path) {
		this.media_compress_path = media_compress_path;
	}
	public String getMedia_type_id() {
		return media_type_id;
	}
	public void setMedia_type_id(String media_type_id) {
		this.media_type_id = media_type_id;
	}
	public String getMedia_discribe() {
		return media_discribe;
	}
	public void setMedia_discribe(String media_discribe) {
		this.media_discribe = media_discribe;
	}
	public String getPhotographer() {
		return photographer;
	}
	public void setPhotographer(String photographer) {
		this.photographer = photographer;
	}
	public String getShooting_time() {
		return shooting_time;
	}
	public void setShooting_time(String shooting_time) {
		this.shooting_time = shooting_time;
	}
	public String getShooting_area() {
		return shooting_area;
	}
	public void setShooting_area(String shooting_area) {
		this.shooting_area = shooting_area;
	}
	public String getShooting_part() {
		return shooting_part;
	}
	public void setShooting_part(String shooting_part) {
		this.shooting_part = shooting_part;
	}
	public String getIdentifiers() {
		return identifiers;
	}
	public void setIdentifiers(String identifiers) {
		this.identifiers = identifiers;
	}
	public String getMedia_compress_big_path() {
		return media_compress_big_path;
	}
	public void setMedia_compress_big_path(String media_compress_big_path) {
		this.media_compress_big_path = media_compress_big_path;
	}
}
 