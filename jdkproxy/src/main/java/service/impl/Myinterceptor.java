package service.impl;

import entity.Invocation;
import service.Interceptor;

import java.lang.reflect.InvocationTargetException;

public class Myinterceptor implements Interceptor {

    public boolean before() {
        System.out.println("######## before ######");
        return false;
    }

    public void after() {
        System.out.println("######## after ######");
    }

    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("######## around before ######");
        Object proceed = invocation.proceed();
        System.out.println("######## around after ######");
        return null;
    }
}
