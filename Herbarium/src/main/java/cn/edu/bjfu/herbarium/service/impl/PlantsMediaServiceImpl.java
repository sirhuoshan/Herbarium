/** 
 * Project Name:Herbarium 
 * File Name:PlantsMediaService.java 
 * Package Name:cn.edu.bjfu.herbarium.service 
 * Date:2015年3月12日 上午12:31:43 
 * Copyright (c) 2015, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package cn.edu.bjfu.herbarium.service.impl;  

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjfu.herbarium.dao.PlantsMediaDao;
import cn.edu.bjfu.herbarium.domain.PlantsMedia;
import cn.edu.bjfu.herbarium.domain.PlantsSpeciesMedia;
import cn.edu.bjfu.herbarium.service.PlantsMediaService;
import cn.edu.bjfu.herbarium.service.ServiceException;
import cn.edu.bjfu.herbarium.util.CompressPic;
import cn.edu.bjfu.herbarium.util.FileOperator;
import cn.edu.bjfu.herbarium.util.Pagination;
import cn.edu.bjfu.herbarium.util.ResourceLoader;

/** 
 * ClassName:PlantsMediaService <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月12日 上午12:31:43 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
@Service
public class PlantsMediaServiceImpl implements PlantsMediaService{
	@Autowired
	private PlantsMediaDao plantsMediaDao;
	public Pagination get(Pagination pagination, Map<String, Object> map)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PlantsMedia> get(Map<String, Object> map) throws Exception {
		return plantsMediaDao.get(map);
	}
	
	public PlantsMedia post1(MultipartFile file,String filename,PlantsMedia t) throws Exception {
		if(!file.isEmpty()){
			String path = "";
			String pathCompress = "";
			try {
				//取得文件上传的文件夹
				String uploaddir = ResourceLoader.getUploadDir()+  "photo/"+t.getSpecimen_id()+"/";
				
				File filedir = new File(uploaddir);
				if(!filedir.exists())
					filedir.mkdirs();
				//取得后缀
				String suffix = filename.substring(filename.lastIndexOf("."));
				filename = filename.substring(0, filename.lastIndexOf("."));
				
				t.setMedia_discribe(filename);
				//默认图片为 1
				t.setMedia_type_id("1");
				
				//设置上传到服务器的新的文件名
				long currentTime = System.currentTimeMillis();
				String newFileName = currentTime+suffix;
				
				t.setMedia_path("photo/"+t.getSpecimen_id()+"/"+newFileName);
				
				path = uploaddir+newFileName;
				// 上传文件
				file.transferTo(new File(path));
				//生成缩略图
				CompressPic compress = new CompressPic();
				//压缩图片名
				String compressFilename = currentTime + "100_70"+suffix;
				//压缩图片的存储路径
				String uploadCompress = uploaddir + "compress/";
				//生成图片存储目录
				File filedirCompress = new File(uploadCompress);
				if(!filedirCompress.exists())
					filedirCompress.mkdirs();
				pathCompress = uploadCompress + compressFilename;
				boolean compressStatus = compress.compressPic(uploaddir, uploadCompress, newFileName, compressFilename,100,70,true);
				if(!compressStatus)
					throw new ServiceException("compress image faile");
				t.setMedia_compress_path("photo/"+t.getSpecimen_id()+"/compress/"+compressFilename);
				plantsMediaDao.post(t);
				return t;
			} catch (Exception e) {
				FileOperator.deleteFile(path);
				FileOperator.deleteFile(pathCompress);
				e.printStackTrace();
			} 
		}
		return null;
	}
	
	public void post(PlantsMedia t) throws Exception {
		plantsMediaDao.post(t);
	}

	public void put(PlantsMedia t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void delete(Long id) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("media_id", id);
		List<PlantsMedia> list = plantsMediaDao.get(map);
		if(list.size() == 1){
			PlantsMedia pm = list.get(0);
			String uploaddir = ResourceLoader.getUploadDir();
			plantsMediaDao.delete(id);
			FileOperator.deleteFile(uploaddir + pm.getMedia_compress_path());
			FileOperator.deleteFile(uploaddir + pm.getMedia_path());
		}
	}

}
 