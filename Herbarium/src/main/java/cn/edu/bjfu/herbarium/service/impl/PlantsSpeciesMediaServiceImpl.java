/** 
 * Project Name:Herbarium 
 * File Name:PlantsSpeciesMediaImpl.java 
 * Package Name:cn.edu.bjfu.herbarium.service.impl 
 * Date:2015年3月11日 上午10:57:56 
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

import cn.edu.bjfu.herbarium.dao.PlantsSpeciesMediaDao;
import cn.edu.bjfu.herbarium.domain.PlantsSpeciesInfo;
import cn.edu.bjfu.herbarium.domain.PlantsSpeciesMedia;
import cn.edu.bjfu.herbarium.service.PlantsSpeciesMediaService;
import cn.edu.bjfu.herbarium.service.ServiceException;
import cn.edu.bjfu.herbarium.util.CompressPic;
import cn.edu.bjfu.herbarium.util.FileOperator;
import cn.edu.bjfu.herbarium.util.ObjectToMap;
import cn.edu.bjfu.herbarium.util.Pagination;
import cn.edu.bjfu.herbarium.util.ResourceLoader;

/** 
 * ClassName:PlantsSpeciesMediaImpl <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015年3月11日 上午10:57:56 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
@Service
public class PlantsSpeciesMediaServiceImpl implements PlantsSpeciesMediaService<PlantsSpeciesMedia>{
	@Autowired 
	private PlantsSpeciesMediaDao plantsSpeciesMediaDao;
	
	public Pagination get(Pagination pagination, Map<String, Object> map)
			throws Exception {
		Map<String,Object> pageMap = ObjectToMap.toMap(pagination);
		map.putAll(pageMap);
        int total = plantsSpeciesMediaDao.getTotal(map);
        List<PlantsSpeciesMedia> rows = plantsSpeciesMediaDao.getPage(map);
        pagination.setRows(rows);
        pagination.setTotal(total);
        return pagination;
	}

	public List<PlantsSpeciesMedia> get(Map<String, Object> map)
			throws Exception {
		return plantsSpeciesMediaDao.get(map);
	}

	public void post(PlantsSpeciesMedia t) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public PlantsSpeciesMedia post(MultipartFile file,String filename, PlantsSpeciesMedia t) throws Exception {
		if(!file.isEmpty()){
			String path = "";
			String pathCompressSmall = "";
			String pathCompressBig = "";
			try {
				//取得文件上传的文件夹
				String uploaddir = ResourceLoader.getUploadDir()+  "photo/"+t.getSpecies_id()+"/";
				
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
				
				t.setMedia_path("photo/"+t.getSpecies_id()+"/"+newFileName);
				
				path = uploaddir+newFileName;
				// 上传文件
				file.transferTo(new File(path));
				//生成缩略图
				CompressPic compress = new CompressPic();
				//压缩图片名
				String compressFilenameSmall = currentTime + "100_70"+suffix;
				String compressFilenameBig = currentTime + "430_300"+suffix;
				//压缩图片的存储路径
				String uploadCompressSmall = uploaddir + "compress/small/";
				String uploadCompressBig = uploaddir + "compress/big/";
				//生成图片存储目录
				File filedirCompressSmall = new File(uploadCompressSmall);
				File filedirCompressBig = new File(uploadCompressBig);

				if(!filedirCompressSmall.exists())
					filedirCompressSmall.mkdirs();
				
				if(!filedirCompressBig.exists())
					filedirCompressBig.mkdirs();
				
				pathCompressSmall = uploadCompressSmall + compressFilenameSmall;
				pathCompressBig = uploadCompressBig + compressFilenameBig;
				
				boolean compressStatusSmall = compress.compressPic(uploaddir, uploadCompressSmall, newFileName, compressFilenameSmall,100,70,true);
				boolean compressStatusBig = compress.compressPic(uploaddir, uploadCompressBig, newFileName, compressFilenameBig,430,300,true);
				if(!compressStatusSmall)
					throw new ServiceException("compress small image faile");
				if(!compressStatusBig)
					throw new ServiceException("compress big image faile");
				t.setMedia_compress_path("photo/"+t.getSpecies_id()+"/compress/small/"+compressFilenameSmall);
				t.setMedia_compress_big_path("photo/"+t.getSpecies_id()+"/compress/big/"+compressFilenameBig);
				plantsSpeciesMediaDao.post(t);
				return t;
			} catch (Exception e) {
				FileOperator.deleteFile(path);
				FileOperator.deleteFile(pathCompressSmall);
				FileOperator.deleteFile(pathCompressBig);
				e.printStackTrace();
			} 
		}
		return null;
	}

	public void put(PlantsSpeciesMedia t) throws Exception {
		plantsSpeciesMediaDao.put(t);
	}

	public void delete(Long id) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("media_id", id);
		List<PlantsSpeciesMedia> list = plantsSpeciesMediaDao.get(map);
		if(list.size() == 1){
			PlantsSpeciesMedia pm = list.get(0);
			String uploaddir = ResourceLoader.getUploadDir();
			plantsSpeciesMediaDao.delete(id);
			FileOperator.deleteFile(uploaddir + pm.getMedia_compress_path());
			FileOperator.deleteFile(uploaddir + pm.getMedia_path());
		}
	}
}
 