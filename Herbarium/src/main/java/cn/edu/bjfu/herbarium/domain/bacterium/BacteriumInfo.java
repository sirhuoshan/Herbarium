// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BacteriumInfo.java

package cn.edu.bjfu.herbarium.domain.bacterium;

import java.io.Serializable;

public class BacteriumInfo
    implements Serializable
{

    public BacteriumInfo()
    {
    }

    public Long getSpecimen_id()
    {
        return specimen_id;
    }

    public void setSpecimen_id(Long specimen_id)
    {
        this.specimen_id = specimen_id;
    }

    public String getCollect_id()
    {
        return collect_id;
    }

    public void setCollect_id(String collect_id)
    {
        this.collect_id = collect_id;
    }

    public String getBacterium_name()
    {
        return bacterium_name;
    }

    public void setBacterium_name(String bacterium_name)
    {
        this.bacterium_name = bacterium_name;
    }

    public String getBacterium_latin()
    {
        return bacterium_latin;
    }

    public void setBacterium_latin(String bacterium_latin)
    {
        this.bacterium_latin = bacterium_latin;
    }

    public String getOrder()
    {
        return order;
    }

    public void setOrder(String order)
    {
        this.order = order;
    }

    public String getFamily()
    {
        return family;
    }

    public void setFamily(String family)
    {
        this.family = family;
    }

    public String getGenus()
    {
        return genus;
    }

    public void setGenus(String genus)
    {
        this.genus = genus;
    }

    public String getClassify()
    {
        return classify;
    }

    public void setClassify(String classify)
    {
        this.classify = classify;
    }

    public String getCollecter()
    {
        return collecter;
    }

    public void setCollecter(String collecter)
    {
        this.collecter = collecter;
    }

    public String getSpecimen_number()
    {
        return specimen_number;
    }

    public void setSpecimen_number(String specimen_number)
    {
        this.specimen_number = specimen_number;
    }

    private static final long serialVersionUID = 0xed6b64612196946cL;
    private Long specimen_id;
    private String collect_id;
    private String bacterium_name;
    private String bacterium_latin;
    private String order;
    private String family;
    private String genus;
    private String classify;
    private String collecter;
    private String specimen_number;
}
