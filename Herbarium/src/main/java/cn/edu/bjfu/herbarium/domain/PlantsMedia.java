package cn.edu.bjfu.herbarium.domain;

public class PlantsMedia {
	
	private Long media_id;
	private Long specimen_id;
	private String media_path;
	private String media_type_id;
	private String media_discribe;
	private String media_compress_path;
	public Long getMedia_id() {
		return media_id;
	}
	public void setMedia_id(Long media_id) {
		this.media_id = media_id;
	}
	public Long getSpecimen_id() {
		return specimen_id;
	}
	public void setSpecimen_id(Long specimen_id) {
		this.specimen_id = specimen_id;
	}
	public String getMedia_path() {
		return media_path;
	}
	public void setMedia_path(String media_path) {
		this.media_path = media_path;
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
	public String getMedia_compress_path() {
		return media_compress_path;
	}
	public void setMedia_compress_path(String media_compress_path) {
		this.media_compress_path = media_compress_path;
	}
}
