// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PageInterceptor.java

package cn.edu.bjfu.herbarium.util.Interceptor;

import cn.edu.bjfu.herbarium.util.Pagination;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Properties;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

public class PageInterceptor
    implements Interceptor
{
    private static class ReflectUtil
    {

        public static Object getFieldValue(Object obj, String fieldName)
        {
            Object result = null;
            Field field = getField(obj, fieldName);
            if(field != null)
            {
                field.setAccessible(true);
                try
                {
                    result = field.get(obj);
                }
                catch(IllegalArgumentException e)
                {
                    e.printStackTrace();
                }
                catch(IllegalAccessException e)
                {
                    e.printStackTrace();
                }
            }
            return result;
        }

        private static Field getField(Object obj, String fieldName)
        {
            Field field = null;
            for(Class clazz = obj.getClass(); clazz != obj;)
                try
                {
                    field = clazz.getDeclaredField(fieldName);
                    break;
                }
                catch(NoSuchFieldException nosuchfieldexception)
                {
                    clazz = clazz.getSuperclass();
                }

            return field;
        }

        public static void setFieldValue(Object obj, String fieldName, String fieldValue)
        {
            Field field = getField(obj, fieldName);
            if(field != null)
                try
                {
                    field.setAccessible(true);
                    field.set(obj, fieldValue);
                }
                catch(IllegalArgumentException e)
                {
                    e.printStackTrace();
                }
                catch(IllegalAccessException e)
                {
                    e.printStackTrace();
                }
        }

        private ReflectUtil()
        {
        }
    }


    public PageInterceptor()
    {
    }

    public Object intercept(Invocation invocation)
        throws Throwable
    {
        RoutingStatementHandler handler = (RoutingStatementHandler)invocation.getTarget();
        StatementHandler delegate = (StatementHandler)ReflectUtil.getFieldValue(handler, "delegate");
        BoundSql boundSql = delegate.getBoundSql();
        MappedStatement mappedStatement = (MappedStatement)ReflectUtil.getFieldValue(delegate, "mappedStatement");
        Connection connection = (Connection)invocation.getArgs()[0];
        String sql = boundSql.getSql();
        System.out.println(sql);
        return invocation.proceed();
    }

    public Object plugin(Object target)
    {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties)
    {
        databaseType = properties.getProperty("databaseType");
    }

    private String getPageSql(Pagination page, String sql)
    {
        StringBuffer sqlBuffer = new StringBuffer(sql);
        if("mysql".equalsIgnoreCase(databaseType))
            return getMysqlPageSql(page, sqlBuffer);
        if("oracle".equalsIgnoreCase(databaseType))
            return getOraclePageSql(page, sqlBuffer);
        else
            return sqlBuffer.toString();
    }

    private String getMysqlPageSql(Pagination page, StringBuffer sqlBuffer)
    {
        int offset = (page.getStart() - 1) * page.getLimit();
        sqlBuffer.append(" limit ").append(offset).append(",").append(page.getLimit());
        return sqlBuffer.toString();
    }

    private String getOraclePageSql(Pagination page, StringBuffer sqlBuffer)
    {
        int offset = (page.getPage() - 1) * page.getLimit() + 1;
        sqlBuffer.insert(0, "select u.*, rownum r from (").append(") u where rownum < ").append(offset + page.getLimit());
        sqlBuffer.insert(0, "select * from (").append(") where r >= ").append(offset);
        return sqlBuffer.toString();
    }

    private void setTotalRecord(Pagination pagination, MappedStatement mappedstatement, Connection connection)
    {
        throw new Error("Unresolved compilation problem: \n\tThe method setTotalRecord(int) is undefined for the type Pagination<capture#18-of ?>\n");
    }

    private String getCountSql(String sql)
    {
        int index = sql.indexOf("from");
        return (new StringBuilder("select count(*) ")).append(sql.substring(index)).toString();
    }

    private String databaseType;
}
