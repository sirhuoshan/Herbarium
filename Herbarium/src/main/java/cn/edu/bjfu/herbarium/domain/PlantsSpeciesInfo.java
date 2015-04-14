/** 
 * Project Name:Herbarium 
 * File Name:PlantsSpeciesInfo.java 
 * Package Name:cn.edu.bjfu.herbarium.domain 
 * Date:2015年3月9日 上午10:20:09 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.domain;  
/** 
 * ClassName:PlantsSpeciesInfo <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月9日 上午10:20:09 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class PlantsSpeciesInfo {
	//主键
	private Long species_id;
	//物种拉丁名
	private String latin_name;
	//物种中文名
	private String chinese_name;
	//物种异名
	private String other_name;
	//形态特征
	private String character;
	//产地分布
	private String location;
	//花果期
	private String fruit_period;
	//用途
	private String use;
	//栽培和繁殖
	private String growth;
	//科
	private String family;
	//属
	private String genus;
	//供展示的属
	private String genus_val;
	//保护等级
	private String protect_id;
	//iucn等级
	private String iucn_id;
	//cites等级
	private String cites_id;
	//红皮书等级
	private String redbook_id;
	public Long getSpecies_id() {
		return species_id;
	}
	public void setSpecies_id(Long species_id) {
		this.species_id = species_id;
	}
	public String getLatin_name() {
		return latin_name;
	}
	public void setLatin_name(String latin_name) {
		this.latin_name = latin_name;
	}
	public String getChinese_name() {
		return chinese_name;
	}
	public void setChinese_name(String chinese_name) {
		this.chinese_name = chinese_name;
	}
	public String getOther_name() {
		return other_name;
	}
	public void setOther_name(String other_name) {
		this.other_name = other_name;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getFruit_period() {
		return fruit_period;
	}
	public void setFruit_period(String fruit_period) {
		this.fruit_period = fruit_period;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getGrowth() {
		return growth;
	}
	public void setGrowth(String growth) {
		this.growth = growth;
	}
	public String getGenus() {
		return genus;
	}
	public void setGenus(String genus) {
		this.genus = genus;
	}
	public String getProtect_id() {
		return protect_id;
	}
	public void setProtect_id(String protect_id) {
		this.protect_id = protect_id;
	}
	public String getIucn_id() {
		return iucn_id;
	}
	public void setIucn_id(String iucn_id) {
		this.iucn_id = iucn_id;
	}
	public String getCites_id() {
		return cites_id;
	}
	public void setCites_id(String cites_id) {
		this.cites_id = cites_id;
	}
	public String getRedbook_id() {
		return redbook_id;
	}
	public void setRedbook_id(String redbook_id) {
		this.redbook_id = redbook_id;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getGenus_val() {
		return genus_val;
	}
	public void setGenus_val(String genus_val) {
		this.genus_val = genus_val;
	}
}
 