// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BaseService.java

package cn.edu.bjfu.herbarium.service;

import cn.edu.bjfu.herbarium.util.Pagination;

import java.util.List;
import java.util.Map;

public interface BaseService<T>
{

    public abstract Pagination get(Pagination pagination, Map<String, Object> map) throws Exception;

    public abstract List<T> get(Map<String, Object> map) throws Exception;
    
    public abstract void post(T t) throws Exception;
    
    public abstract void put(T t) throws Exception;
    
    public abstract void delete(Long id) throws Exception;
}
