// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BacteriumCollect.java

package cn.edu.bjfu.herbarium.domain;

import java.io.Serializable;
import java.util.Date;

public class BacteriumCollect
    implements Serializable
{

    public BacteriumCollect()
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

    public Long getSpecies_id()
    {
        return species_id;
    }

    public void setSpecies_id(Long species_id)
    {
        this.species_id = species_id;
    }

    public String getCollect_id()
    {
        return collect_id;
    }

    public void setCollect_id(String collect_id)
    {
        this.collect_id = collect_id;
    }

    public String getCollecter()
    {
        return collecter;
    }

    public void setCollecter(String collecter)
    {
        this.collecter = collecter;
    }

    public Date getCollect_date()
    {
        return collect_date;
    }

    public void setCollect_date(Date collect_date)
    {
        this.collect_date = collect_date;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getDistrict()
    {
        return district;
    }

    public void setDistrict(String district)
    {
        this.district = district;
    }

    public String getCounty()
    {
        return county;
    }

    public void setCounty(String county)
    {
        this.county = county;
    }

    public String getTown()
    {
        return town;
    }

    public void setTown(String town)
    {
        this.town = town;
    }

    public String getDetail_area()
    {
        return detail_area;
    }

    public void setDetail_area(String detail_area)
    {
        this.detail_area = detail_area;
    }

    public Double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(Double longitude)
    {
        this.longitude = longitude;
    }

    public Double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(Double latitude)
    {
        this.latitude = latitude;
    }

    public Integer getElevation()
    {
        return elevation;
    }

    public void setElevation(Integer elevation)
    {
        this.elevation = elevation;
    }

    public String getBasic_goods()
    {
        return basic_goods;
    }

    public void setBasic_goods(String basic_goods)
    {
        this.basic_goods = basic_goods;
    }

    public String getHost()
    {
        return host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public String getHost_latin()
    {
        return host_latin;
    }

    public void setHost_latin(String host_latin)
    {
        this.host_latin = host_latin;
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

    public String getTrivial_name()
    {
        return trivial_name;
    }

    public void setTrivial_name(String trivial_name)
    {
        this.trivial_name = trivial_name;
    }

    public String getLive_environment()
    {
        return live_environment;
    }

    public void setLive_environment(String live_environment)
    {
        this.live_environment = live_environment;
    }

    public String getUseage()
    {
        return useage;
    }

    public void setUseage(String useage)
    {
        this.useage = useage;
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

    public Long getClassify()
    {
        return classify;
    }

    public void setClassify(Long classify)
    {
        this.classify = classify;
    }

    private static final long serialVersionUID = 0x70fb4f76af967114L;
    private Long specimen_id;
    private Long species_id;
    private String collect_id;
    private String collecter;
    private Date collect_date;
    private String country;
    private String province;
    private String city;
    private String district;
    private String county;
    private String town;
    private String detail_area;
    private Double longitude;
    private Double latitude;
    private Integer elevation;
    private String basic_goods;
    private String host;
    private String host_latin;
    private String bacterium_name;
    private String bacterium_latin;
    private String trivial_name;
    private String live_environment;
    private String useage;
    private String character;
    private String location;
    private Long classify;
}
