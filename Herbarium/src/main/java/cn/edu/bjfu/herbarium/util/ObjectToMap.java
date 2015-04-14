// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ObjectToMap.java

package cn.edu.bjfu.herbarium.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ObjectToMap
{

    public ObjectToMap()
    {
    }

    public static Map<String,Object> toMap(Object t)throws Exception
    {
        Map<String,Object> map = new HashMap<String,Object>();
        Class obj = t.getClass();
        Field fields[] = obj.getDeclaredFields();
        Field afield[];
        int j = (afield = fields).length;
        for(int i = 0; i < j; i++)
        {
            Field field = afield[i];
            String name = field.getName();
            if(!"serialVersionUID".equals(name))
            {
                String methodName = (new StringBuilder("get")).append(name.substring(0, 1).toUpperCase()).append(name.substring(1)).toString();
                Method method = obj.getMethod(methodName, new Class[0]);
                Object value = method.invoke(t, new Object[0]);
                if(value != null)
                    map.put(name, value);
            }
        }

        return map;
    }
}
