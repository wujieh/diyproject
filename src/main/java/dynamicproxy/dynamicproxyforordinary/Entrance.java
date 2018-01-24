package dynamicproxy.dynamicproxyforordinary;

import java.lang.reflect.Proxy;

public class Entrance {
    public static void main(String[] args) {
        Person p = new Chinese();
        HandlerImpl handler = new HandlerImpl(p);
        ClassLoader loader = p.getClass().getClassLoader();
        Class[] interfaces = p.getClass().getInterfaces();

        Person proxyForPerson = (Person) Proxy.newProxyInstance(loader,interfaces,handler);
        System.out.println("动态代理对象的类型："+proxyForPerson.getClass().getName());

        proxyForPerson.sayHello("萨瓦迪卡");
    }
}
