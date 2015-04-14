// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UserController.java

package cn.edu.bjfu.herbarium.web.System;

import cn.edu.bjfu.herbarium.domain.Customer;
import cn.edu.bjfu.herbarium.web.common.CommonController;

import org.springframework.web.servlet.ModelAndView;

public class UserController extends CommonController
{

    public UserController()
    {
    }

    public ModelAndView login(Customer customer)
    {
        ModelAndView view = new ModelAndView();
        view.setViewName("bacterium/bacteriumAdmin");
        return view;
    }
}
