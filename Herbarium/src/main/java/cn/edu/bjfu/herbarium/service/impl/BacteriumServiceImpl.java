// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BacteriumServiceImpl.java

package cn.edu.bjfu.herbarium.service.impl;

import cn.edu.bjfu.herbarium.dao.BacteriumDao;
import cn.edu.bjfu.herbarium.service.BacteriumService;
import cn.edu.bjfu.herbarium.service.ServiceException;
import cn.edu.bjfu.herbarium.util.Pagination;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BacteriumServiceImpl
    implements BacteriumService
{

    public BacteriumServiceImpl()
    {
    }

    public List queryBacteriumInfoPage(Map map)
        throws ServiceException
    {
        List list = bacteriumDao.queryBacteriumInfoPage(map);
        return list;
    }

    public Integer queryTotalRecord(Map map)
    {
        Integer totalRecord = bacteriumDao.queryTotalRecord(map);
        return totalRecord;
    }

    public List queryByProperty(String key, String value)
        throws ServiceException
    {
        return null;
    }

    public List queryAll()
        throws ServiceException
    {
        return null;
    }
    
    @Autowired
    private BacteriumDao bacteriumDao;

	public Pagination get(Pagination pagination, Map map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List get(Map map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void post(Object t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void put(Object t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
