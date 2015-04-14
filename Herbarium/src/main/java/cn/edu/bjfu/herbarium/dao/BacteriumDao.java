// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BacteriumDao.java

package cn.edu.bjfu.herbarium.dao;

import java.util.List;
import java.util.Map;

public interface BacteriumDao
{

    public abstract List queryBacteriumInfoPage(Map map);

    public abstract Integer queryTotalRecord(Map map);
}
