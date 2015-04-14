// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Pagination.java

package cn.edu.bjfu.herbarium.util;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

public class Pagination
{

    public Pagination()
    {
    }

    public Pagination(int page, int limit)
    {
        this.page = page;
        this.limit = limit;
    }

    public int getLimit()
    {
        return limit;
    }

    public void setLimit(int limit)
    {
        this.limit = limit;
    }

    public int getStart()
    {
        if(page == 0)
            return 0;
        else
            return (page - 1) * limit;
    }

    public void setStart(int start)
    {
        this.start = start;
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        if(total % limit == 0)
            totalPage = total / limit;
        else
            totalPage = total / limit + 1;
        setTotalPage(totalPage);
        this.total = total;
    }

    public int getTotalPage()
    {
        if(total % limit == 0)
            totalPage = total / limit;
        else
            totalPage = total / limit + 1;
        return totalPage;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }

    public int getPage()
    {
        if(page <= 0)
            page = 1;
        else if(getTotalPage() == 0){
        	return page;
        }else{
        	if(page > getTotalPage())
        	   page = getTotalPage();
        }
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }

    public List getRows()
    {
        return rows;
    }

    public void setRows(List rows)
    {
        this.rows = rows;
    }

    public static void main(String args[])
        throws Exception
    {
        Class demo = Class.forName("cn.edu.bjfu.herbarium.util.Pagination");
        java.lang.reflect.Constructor cons[] = demo.getConstructors();
        Pagination pagination = (Pagination)demo.newInstance();
        Field fields[] = demo.getDeclaredFields();
        Field afield[];
        int j = (afield = fields).length;
        for(int i = 0; i < j; i++)
        {
            Field field = afield[i];
            int mo = field.getModifiers();
            String preffix = Modifier.toString(mo);
            Class type = field.getType();
            String name = field.getName();
            Field fi = demo.getDeclaredField(name);
            System.out.println(fi.get(pagination));
            System.out.println((new StringBuilder(String.valueOf(preffix))).append("  ").append(type).append(" ").append(field.getName()).toString());
        }

    }

    private int limit;
    private int start;
    private int total;
    private int totalPage;
    private int page;
    private List rows;
}
