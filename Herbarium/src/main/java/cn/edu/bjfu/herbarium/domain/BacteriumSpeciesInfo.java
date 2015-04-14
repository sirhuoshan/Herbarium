/** 
 * Project Name:Herbarium 
 * File Name:BacteriumSpeciesInfo.java 
 * Package Name:cn.edu.bjfu.herbarium.domain 
 * Date:2015年3月7日 下午3:31:12 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.domain;  
/** 
 * ClassName:BacteriumSpeciesInfo <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月7日 下午3:31:12 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class BacteriumSpeciesInfo {
	//主键
	private Long speciesID;
	//物种拉丁名
	private String latinName;
	//物种中文名
	private String chineseName;
	//菌物特征
	private String character;
	//产地分布
	private String location;
	//生境
	private String liveEnvironment;
	//用途
	private String useage;
	//物种类别
	private String classification;
	
	public Long getSpeciesID() {
		return speciesID;
	}
	public void setSpeciesID(Long speciesID) {
		this.speciesID = speciesID;
	}
	public String getLatinName() {
		return latinName;
	}
	public void setLatinName(String latinName) {
		this.latinName = latinName;
	}
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
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
	public String getLiveEnvironment() {
		return liveEnvironment;
	}
	public void setLiveEnvironment(String liveEnvironment) {
		this.liveEnvironment = liveEnvironment;
	}
	public String getUseage() {
		return useage;
	}
	public void setUseage(String useage) {
		this.useage = useage;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
}
 