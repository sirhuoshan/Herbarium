// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BacteriumService.java

package cn.edu.bjfu.herbarium.service;

import java.util.List;
import java.util.Map;

// Referenced classes of package cn.edu.bjfu.herbarium.service:
//            BaseService, ServiceException

public interface BacteriumService
    extends BaseService
{

    public abstract List queryBacteriumInfoPage(Map map)
        throws ServiceException;

    public abstract Integer queryTotalRecord(Map map);
}
