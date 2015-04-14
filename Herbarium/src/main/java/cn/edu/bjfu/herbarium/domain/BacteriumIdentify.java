// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BacteriumIdentify.java

package cn.edu.bjfu.herbarium.domain;

import java.io.Serializable;

public class BacteriumIdentify
    implements Serializable
{

    public BacteriumIdentify()
    {
    }

    public Long getIdentify_id()
    {
        return identify_id;
    }

    public void setIdentify_id(Long identify_id)
    {
        this.identify_id = identify_id;
    }

    public Long getSpecimen_id()
    {
        return specimen_id;
    }

    public void setSpecimen_id(Long specimen_id)
    {
        this.specimen_id = specimen_id;
    }

    public String getIdentifier_name()
    {
        return identifier_name;
    }

    public void setIdentifier_name(String identifier_name)
    {
        this.identifier_name = identifier_name;
    }

    public String getIdentify_info()
    {
        return identify_info;
    }

    public void setIdentify_info(String identify_info)
    {
        this.identify_info = identify_info;
    }

    public String getIdentify_remark()
    {
        return identify_remark;
    }

    public void setIdentify_remark(String identify_remark)
    {
        this.identify_remark = identify_remark;
    }

    private static final long serialVersionUID = 0x6c9297545cb72e78L;
    private Long identify_id;
    private Long specimen_id;
    private String identifier_name;
    private String identify_info;
    private String identify_remark;
}
