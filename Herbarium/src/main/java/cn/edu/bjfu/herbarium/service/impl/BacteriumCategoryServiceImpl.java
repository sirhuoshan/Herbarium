// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BacteriumCategoryServiceImpl.java

package cn.edu.bjfu.herbarium.service.impl;

import cn.edu.bjfu.herbarium.dao.BacteriumCategoryDao;
import cn.edu.bjfu.herbarium.domain.BacteriumCategory;
import cn.edu.bjfu.herbarium.service.BacteriumCategoryService;
import cn.edu.bjfu.herbarium.util.ObjectToMap;
import cn.edu.bjfu.herbarium.util.Pagination;

import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BacteriumCategoryServiceImpl
    implements BacteriumCategoryService
{

    public BacteriumCategoryServiceImpl()
    {
    }

    public Pagination get(Pagination pagination, Map searchMap)throws Exception{
        Map pageMap = ObjectToMap.toMap(pagination);
        searchMap.putAll(pageMap);
        int total = bacteriumCategoryDao.getTotal(searchMap);
        List rows = bacteriumCategoryDao.getPage(searchMap);
        pagination.setRows(rows);
        pagination.setTotal(total);
        return pagination;
    }

    public List get(Map searchMap)
        throws Exception
    {
        List list = bacteriumCategoryDao.get(searchMap);
        return list;
    }

    public List<BacteriumCategory> getCategoriesInPath(String category_path)
        throws Exception
    {
        List categories = new ArrayList();
        if(!StringUtils.isEmpty(category_path))
        {
            String parent_ids[] = category_path.split("_");
            for(int i = parent_ids.length - 1; i >= 0; i--)
            {
                Map searchMap = new HashMap();
                searchMap.put("parent_id", parent_ids[i]);
                List list = get(searchMap);
                categories.add(list);
            }

        }
        return categories;
    }
    
    public List<BacteriumCategory> getCategoryInPath(String category_path)throws Exception{
        List<BacteriumCategory> categories = new ArrayList<BacteriumCategory>();
        if(!StringUtils.isEmpty(category_path))
        {
            String class_ids[] = category_path.split("_");
            for(int i = class_ids.length - 1; i >= 0; i--)
            {
                Map<String,String> searchMap = new HashMap<String,String>();
                searchMap.put("class_id", class_ids[i]);
                List<BacteriumCategory> list = get(searchMap);
                if(list.size() == 1){
                	BacteriumCategory bc = (BacteriumCategory) list.get(0);
                	categories.add(bc);
                }
            }
        }
        return categories;
    }

    public List getJson()
    {
        List list = bacteriumCategoryDao.getCategoryJson();
        return list;
    }

    private static Logger log = Logger.getLogger(BacteriumCategoryServiceImpl.class);
    @Autowired
    private BacteriumCategoryDao bacteriumCategoryDao;
    
	public void post(BacteriumCategory bc) throws Exception {
		bacteriumCategoryDao.post(bc);
	}

	public void put(BacteriumCategory bc) throws Exception {
		bacteriumCategoryDao.put(bc);
	}

	public void delete(Long id) throws Exception {
		bacteriumCategoryDao.delete(id);
	}
}
