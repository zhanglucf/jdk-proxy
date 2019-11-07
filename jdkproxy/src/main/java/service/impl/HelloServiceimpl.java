package service.impl;

import service.HelloService;

public class HelloServiceimpl implements HelloService {
    public void sayHello(String str) {
        System.out.println("HelloService --->" + str);
    }
}
