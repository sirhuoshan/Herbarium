package cn.edu.bjfu.herbarium.domain;

import java.util.Date;
import java.util.Set;

//import java.util.Date;

public class PlantsIdentify {
	private Long identify_id;
	private Long specimen_id;
	private Long identifier_id;
	private String scientific_name;
	private String chinese_name;
	private String famaly_name;
	private String identify_info;
	private String identify_date;
	private String identify_remark;
	public Long getIdentify_id() {
		return identify_id;
	}
	public void setIdentify_id(Long identify_id) {
		this.identify_id = identify_id;
	}
	public Long getSpecimen_id() {
		return specimen_id;
	}
	public void setSpecimen_id(Long specimen_id) {
		this.specimen_id = specimen_id;
	}
	public Long getIdentifier_id() {
		return identifier_id;
	}
	public void setIdentifier_id(Long identifier_id) {
		this.identifier_id = identifier_id;
	}
	public String getScientific_name() {
		return scientific_name;
	}
	public void setScientific_name(String scientific_name) {
		this.scientific_name = scientific_name;
	}
	public String getChinese_name() {
		return chinese_name;
	}
	public void setChinese_name(String chinese_name) {
		this.chinese_name = chinese_name;
	}
	public String getFamaly_name() {
		return famaly_name;
	}
	public void setFamaly_name(String famaly_name) {
		this.famaly_name = famaly_name;
	}
	public String getIdentify_info() {
		return identify_info;
	}
	public void setIdentify_info(String identify_info) {
		this.identify_info = identify_info;
	}
	public String getIdentify_date() {
		return identify_date;
	}
	public void setIdentify_date(String identify_date) {
		this.identify_date = identify_date;
	}
	public String getIdentify_remark() {
		return identify_remark;
	}
	public void setIdentify_remark(String identify_remark) {
		this.identify_remark = identify_remark;
	}
}
