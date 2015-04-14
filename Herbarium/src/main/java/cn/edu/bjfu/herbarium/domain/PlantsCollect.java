/** 
 * Project Name:Herbarium 
 * File Name:PlantsCollect.java 
 * Package Name:cn.edu.bjfu.herbarium.domain 
 * Date:2015年3月11日 下午11:41:30 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.domain;  
/** 
 * ClassName:PlantsCollect <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月11日 下午11:41:30 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class PlantsCollect {
	//标本序号
	private Long specimen_id;
	private Long species_id;
	private String chinese_name;
	private String latin_name;
	private String collect_id;
	private String collecter;
	private String collect_date;
	private String country;
	private String province;
	private String city;
	private String district;
	private String county;
	private String town;
	private String detail_area;
	private String longitude;
	private String latitude;
	private Double elevation;
	private String live_environment;
	private String live_type_id;
	private String trivial_name;
	private String intenational_codes;
	private Double height;
	private String bark;
	private String branch;
	private String leaf;
	private String flower;
	private String fruit;
	private Double dbh;
	private String resource_state;
	private String isidentified;
	private String collect_remark;
	private String genus;
	private String family;
	private String barcode_id;
	public Long getSpecimen_id() {
		return specimen_id;
	}
	public void setSpecimen_id(Long specimen_id) {
		this.specimen_id = specimen_id;
	}
	public Long getSpecies_id() {
		return species_id;
	}
	public void setSpecies_id(Long species_id) {
		this.species_id = species_id;
	}
	public String getChinese_name() {
		return chinese_name;
	}
	public void setChinese_name(String chinese_name) {
		this.chinese_name = chinese_name;
	}
	public String getLatin_name() {
		return latin_name;
	}
	public void setLatin_name(String latin_name) {
		this.latin_name = latin_name;
	}
	public String getCollect_id() {
		return collect_id;
	}
	public void setCollect_id(String collect_id) {
		this.collect_id = collect_id;
	}
	public String getCollecter() {
		return collecter;
	}
	public void setCollecter(String collecter) {
		this.collecter = collecter;
	}
	public String getCollect_date() {
		return collect_date;
	}
	public void setCollect_date(String collect_date) {
		this.collect_date = collect_date;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getDetail_area() {
		return detail_area;
	}
	public void setDetail_area(String detail_area) {
		this.detail_area = detail_area;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public Double getElevation() {
		return elevation;
	}
	public void setElevation(Double elevation) {
		this.elevation = elevation;
	}
	public String getLive_environment() {
		return live_environment;
	}
	public void setLive_environment(String live_environment) {
		this.live_environment = live_environment;
	}
	public String getLive_type_id() {
		return live_type_id;
	}
	public void setLive_type_id(String live_type_id) {
		this.live_type_id = live_type_id;
	}
	public String getTrivial_name() {
		return trivial_name;
	}
	public void setTrivial_name(String trivial_name) {
		this.trivial_name = trivial_name;
	}
	public String getIntenational_codes() {
		return intenational_codes;
	}
	public void setIntenational_codes(String intenational_codes) {
		this.intenational_codes = intenational_codes;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public String getBark() {
		return bark;
	}
	public void setBark(String bark) {
		this.bark = bark;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getLeaf() {
		return leaf;
	}
	public void setLeaf(String leaf) {
		this.leaf = leaf;
	}
	public String getFlower() {
		return flower;
	}
	public void setFlower(String flower) {
		this.flower = flower;
	}
	public String getFruit() {
		return fruit;
	}
	public void setFruit(String fruit) {
		this.fruit = fruit;
	}
	public Double getDbh() {
		return dbh;
	}
	public void setDbh(Double dbh) {
		this.dbh = dbh;
	}
	public String getResource_state() {
		return resource_state;
	}
	public void setResource_state(String resource_state) {
		this.resource_state = resource_state;
	}
	public String getIsidentified() {
		return isidentified;
	}
	public void setIsidentified(String isidentified) {
		this.isidentified = isidentified;
	}
	public String getCollect_remark() {
		return collect_remark;
	}
	public void setCollect_remark(String collect_remark) {
		this.collect_remark = collect_remark;
	}
	public String getGenus() {
		return genus;
	}
	public void setGenus(String genus) {
		this.genus = genus;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getBarcode_id() {
		return barcode_id;
	}
	public void setBarcode_id(String barcode_id) {
		this.barcode_id = barcode_id;
	}
	
}
 