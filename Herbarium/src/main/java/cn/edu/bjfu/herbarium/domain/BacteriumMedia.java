// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BacteriumMedia.java

package cn.edu.bjfu.herbarium.domain;

import java.io.Serializable;

public class BacteriumMedia
    implements Serializable
{

    public BacteriumMedia()
    {
    }

    public Long getMedia_id()
    {
        return media_id;
    }

    public void setMedia_id(Long media_id)
    {
        this.media_id = media_id;
    }

    public Long getSpecimen_id()
    {
        return specimen_id;
    }

    public void setSpecimen_id(Long specimen_id)
    {
        this.specimen_id = specimen_id;
    }

    public String getMedia_contact()
    {
        return media_contact;
    }

    public void setMedia_contact(String media_contact)
    {
        this.media_contact = media_contact;
    }

    public String getMedia_type_id()
    {
        return media_type_id;
    }

    public void setMedia_type_id(String media_type_id)
    {
        this.media_type_id = media_type_id;
    }

    public String getMedia_discribe()
    {
        return media_discribe;
    }

    public void setMedia_discribe(String media_discribe)
    {
        this.media_discribe = media_discribe;
    }

    private static final long serialVersionUID = 0x1893d2c96f9fa026L;
    private Long media_id;
    private Long specimen_id;
    private String media_contact;
    private String media_type_id;
    private String media_discribe;
}
