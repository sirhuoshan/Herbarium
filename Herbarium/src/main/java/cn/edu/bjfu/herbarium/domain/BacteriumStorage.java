// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BacteriumStorage.java

package cn.edu.bjfu.herbarium.domain;

import java.io.Serializable;

public class BacteriumStorage
    implements Serializable
{

    public BacteriumStorage()
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

    public String getSpecimen_number()
    {
        return specimen_number;
    }

    public void setSpecimen_number(String specimen_number)
    {
        this.specimen_number = specimen_number;
    }

    public String getKeep_location()
    {
        return keep_location;
    }

    public void setKeep_location(String keep_location)
    {
        this.keep_location = keep_location;
    }

    public String getSpecimen_attribute()
    {
        return specimen_attribute;
    }

    public void setSpecimen_attribute(String specimen_attribute)
    {
        this.specimen_attribute = specimen_attribute;
    }

    public String getStorage_way()
    {
        return storage_way;
    }

    public void setStorage_way(String storage_way)
    {
        this.storage_way = storage_way;
    }

    public String getSpecemen_source()
    {
        return specemen_source;
    }

    public void setSpecemen_source(String specemen_source)
    {
        this.specemen_source = specemen_source;
    }

    public Long getStorage_num()
    {
        return storage_num;
    }

    public void setStorage_num(Long storage_num)
    {
        this.storage_num = storage_num;
    }

    public char getDisplay()
    {
        return display;
    }

    public void setDisplay(char display)
    {
        this.display = display;
    }

    private static final long serialVersionUID = 0x840ee6245daece78L;
    private Long specimen_id;
    private String specimen_number;
    private String keep_location;
    private String specimen_attribute;
    private String storage_way;
    private String specemen_source;
    private Long storage_num;
    private char display;
}
