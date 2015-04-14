/** 
 * File Name:ResourceLoader.java 
 * Package Name:com.bjfu.wildplant.util 
 * Date:2014年2月15日 下午9:34:04 
 * Copyright (c) 2014, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.util;  

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/** 
 * ClassName:ResourceLoader <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2014年2月15日 下午9:34:04 <br/> 
 * @author   huoshansir 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class ResourceLoader {
	
	/**
	 * 
	 * getUploadDir:<br />
	 * TODO 获取图片上传的路径
	 *
	 * @author huoshansir
	 * @return
	 * @throws IOException 
	 */
	public static String getUploadDir() throws IOException{
		Resource resource = new ClassPathResource("uploaddir.properties");
		
		Properties prop = PropertiesLoaderUtils.loadProperties(resource);
		String uploaddir = prop.getProperty("uploaddir");
		return uploaddir;
	}
	
	public static void main(String[] args) throws IOException{
		getUploadDir();
	}
}
 