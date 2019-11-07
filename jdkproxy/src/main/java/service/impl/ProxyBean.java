package service.impl;

import entity.Invocation;
import service.HelloService;
import service.Interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBean implements InvocationHandler {
    private Object target;
    private Interceptor interceptor;


    public static Object geteProxyBean(Object target, Interceptor interceptor) {
        ProxyBean proxyBean = new ProxyBean();
        proxyBean.target = target;
        proxyBean.interceptor = interceptor;
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyBean);
        return proxy;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Invocation invocation = new Invocation(args, method, target);
        Object invoke =  null;
        if (interceptor.before()) {
            invoke = interceptor.around(invocation);
        } else {
            invoke = method.invoke(target, args);
        }
        interceptor.after();
        return invoke;
    }


}
