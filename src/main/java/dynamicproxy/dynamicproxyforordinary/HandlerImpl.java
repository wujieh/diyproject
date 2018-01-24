package dynamicproxy.dynamicproxyforordinary;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HandlerImpl implements InvocationHandler{
    private Object object;

    public HandlerImpl(Person c){
        this.object = c ;
    }

    public Object invoke(Object proxy, Method method ,Object[] args) throws Throwable{
        System.out.println("在方法调用之前");
        System.out.println("Method:"+ method);
        Object result = method.invoke(object,args);
        System.out.println("方法调用之后");
        return result;
    }
}
