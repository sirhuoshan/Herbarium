// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BacteriumSpeInfo.java

package cn.edu.bjfu.herbarium.domain;

import java.io.Serializable;

public class BacteriumSpeInfo
    implements Serializable
{

    public BacteriumSpeInfo()
    {
    }

    public Long getSpecies_id()
    {
        return species_id;
    }

    public void setSpecies_id(Long species_id)
    {
        this.species_id = species_id;
    }

    public String getLatin_name()
    {
        return latin_name;
    }

    public void setLatin_name(String latin_name)
    {
        this.latin_name = latin_name;
    }

    public String getChinese_name()
    {
        return chinese_name;
    }

    public void setChinese_name(String chinese_name)
    {
        this.chinese_name = chinese_name;
    }

    public String getOther_name()
    {
        return other_name;
    }

    public void setOther_name(String other_name)
    {
        this.other_name = other_name;
    }

    public String getCharacter()
    {
        return character;
    }

    public void setCharacter(String character)
    {
        this.character = character;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getUse()
    {
        return use;
    }

    public void setUse(String use)
    {
        this.use = use;
    }

    public Long getGenus()
    {
        return genus;
    }

    public void setGenus(Long genus)
    {
        this.genus = genus;
    }

    private static final long serialVersionUID = 0x845f05d93f06fb3L;
    private Long species_id;
    private String latin_name;
    private String chinese_name;
    private String other_name;
    private String character;
    private String location;
    private String use;
    private Long genus;
}
