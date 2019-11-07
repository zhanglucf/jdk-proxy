import service.HelloService;
import service.impl.HelloServiceimpl;
import service.impl.Myinterceptor;
import service.impl.ProxyBean;

public class Test {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceimpl();
        Myinterceptor myinterceptor = new Myinterceptor();
        HelloService proxy = (HelloService)ProxyBean.geteProxyBean(helloService, myinterceptor);
        proxy.sayHello("hello");
    }
}
