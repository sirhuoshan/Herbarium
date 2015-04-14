/** 
 * Project Name:WildPlant 
 * File Name:FileOperator.java 
 * Package Name:com.bjfu.wildplant.util 
 * Date:2014年2月16日 上午9:37:48 
 * Copyright (c) 2014, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.util;  

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;



/** 
 * ClassName:FileOperator <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2014年2月16日 上午9:37:48 <br/> 
 * @author   huoshansir 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class FileOperator {
	
	private static Logger log = Logger.getLogger(FileOperator.class) ;
	
	/**
	 * 
	 * deleteFile:<br />
	 * TODO
	 *
	 * @author huoshansir
	 * @param path 删除文件的路径
	 * @return
	 */
	public static boolean deleteFile(String path){
		try{
			File file = new File(path);
			if(file.exists()){
				file.delete();
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 
	 * download:<br />
	 * TODO  下载文件
	 *
	 * @author huoshansir
	 * @param request  下载文件的请求
	 * @param response 返回 就可以下载文件
	 * @param downloadName 下载的文件名
	 * @param file 要下载的文件
	 */
	
	public static void download(HttpServletRequest request,HttpServletResponse response,String downloadName,File file){

		
		ServletOutputStream outm = null;
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try{
            outm = response.getOutputStream();
        }catch(Exception e){
            log.error("get response outputsream failed", e.getCause());
        }
        
        //对文件名进行编码 
        downloadName = encodeFileName(request, downloadName);
        		
        response.setContentType( "application/octet-stream;charset=UTF-8" ); // MIME type for exe
        response.setHeader("Content-disposition","attachment; filename="+downloadName+".doc");
        try{
        	
             FileInputStream fis=new FileInputStream(file);
             bis = new BufferedInputStream(fis);
             bos = new BufferedOutputStream(outm);
             byte[] buff = new byte[2048];
             int bytesRead;
             while(-1 != (bytesRead = bis.read(buff, 0, buff.length)))
             {
                 bos.write(buff, 0, bytesRead);
             }
             
        }catch(Exception e){
        	log.error("output file failed",e.getCause());
        }finally{
        	try{
        		bos.close();
        		bis.close();
        		outm.close();
        	}catch(Exception e){
        		log.error("download file fialed",e.getCause());
        		e.printStackTrace();
        	}
        }
	}
	
	/**
	 * 
	 * encodeFileName:<br />
	 * TODO
	 *
	 * @author huoshansir
	 * @param request
	 * @param fileName 要编码的文件名
	 * @return
	 */
	
	public static String encodeFileName(HttpServletRequest request, String fileName) {
		
		String returnFileName = "";
		String agent = request.getHeader("User-Agent");
		boolean isMSIE = (agent != null && agent.indexOf("MSIE") != -1);
		try {
			
			if (isMSIE) {
				returnFileName = URLEncoder.encode(fileName, "UTF-8");  
			} else {
				returnFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			}
			
			if (returnFileName.length() > 150) {  
				returnFileName = new String(fileName.getBytes("GB2312"), "ISO8859-1");  	
				returnFileName = StringUtils.replace(returnFileName, " ", "%20");  
			} 
			
		} catch (Exception e) {
			log.error("encode file name failed", e.getCause());
			e.printStackTrace();
		}
		
		return returnFileName;
	}
	
	/**
	 * 
	 * downFileFromUrl:<br />
	 * TODO
	 *
	 * @author huoshansir
	 * @param destUrl 通过网上的url 获取图片
	 * @return
	 */
	public static File downFileFromUrl(String destUrl){
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		HttpURLConnection httpUrl = null;
		URL url = null;
		try{
			url = new URL(destUrl);
			httpUrl = (HttpURLConnection)url.openConnection();
			httpUrl.connect();
			bis = new BufferedInputStream(httpUrl.getInputStream());
			File file = File.createTempFile("temp", ".png");
			fos = new FileOutputStream(file);
			
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = bis.read(buf))!=-1){
				fos.write(buf, 0, size);
			}
			fos.flush();
			return file;
		}catch(Exception e){
			log.error("get the location from the baidu map failed", e.getCause());
			e.printStackTrace();
		}finally{
			try{
				fos.close();
				bis.close();
				httpUrl.disconnect();
			}catch(Exception e){
				log.error("close the io source failed", e.getCause());
				e.printStackTrace();
			}
		}
		return null;
	}
}	
 