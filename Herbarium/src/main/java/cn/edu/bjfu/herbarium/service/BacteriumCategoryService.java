// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BacteriumCategoryService.java

package cn.edu.bjfu.herbarium.service;

import java.util.List;

import cn.edu.bjfu.herbarium.domain.BacteriumCategory;

// Referenced classes of package cn.edu.bjfu.herbarium.service:
//            BaseService

public interface BacteriumCategoryService
    extends BaseService<BacteriumCategory>
{

    public abstract List getJson();

    public abstract List getCategoriesInPath(String category_path)throws Exception;
    
    public abstract List<BacteriumCategory> getCategoryInPath(String category_path) throws Exception;

}
