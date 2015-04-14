// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CategoryJson.java

package cn.edu.bjfu.herbarium.domain;

import java.util.List;

public class CategoryJson
{

    public CategoryJson()
    {
    }

    public Long getClass_id()
    {
        return class_id;
    }

    public void setClass_id(Long class_id)
    {
        this.class_id = class_id;
    }

    public String getClass_name()
    {
        return class_name;
    }

    public void setClass_name(String class_name)
    {
        this.class_name = class_name;
    }

    public String getClass_latin()
    {
        return class_latin;
    }

    public void setClass_latin(String class_latin)
    {
        this.class_latin = class_latin;
    }

    public List getChildren()
    {
        return children;
    }

    public void setChildren(List children)
    {
        this.children = children;
    }

    private Long class_id;
    private String class_name;
    private String class_latin;
    private List children;
}
