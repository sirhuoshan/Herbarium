// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CustomerMapper.java

package cn.edu.bjfu.herbarium.service;

import cn.edu.bjfu.herbarium.domain.Customer;
import java.util.List;

public interface CustomerMapper
{

    public abstract Customer getCustomer(long l);

    public abstract List getCustomerByProperty(String s, String s1);
}
