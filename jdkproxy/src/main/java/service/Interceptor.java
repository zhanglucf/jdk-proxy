package service;

import entity.Invocation;

import java.lang.reflect.InvocationTargetException;

public interface Interceptor {

    public boolean before();

    public void after();

    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;
}
