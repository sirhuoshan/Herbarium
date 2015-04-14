// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ServiceException.java

package cn.edu.bjfu.herbarium.service;


public class ServiceException extends Exception
{

    public ServiceException(String msg)
    {
        super(msg);
    }

    public ServiceException(String msg, Throwable cause)
    {
        super(msg, cause);
    }

    private static final long serialVersionUID = 0xd04dd8a25fef1811L;
}
