package dynamicproxy.dynamicproxyformybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模仿mybatis的动态代理类
 */
public class MapperProxy implements InvocationHandler{
    public  <T> T newInstance(Class<T> T){
       return (T)Proxy.newProxyInstance(T.getClassLoader(), new Class[]{T},this);
    }

    public Object invoke(Object proxy, Method method, Object[] args){
        if(Object.class.equals(method.getDeclaringClass())){
            try{
                return method.invoke(this,args);
            }catch (Throwable t){

            }
        }

        return new User((String)args[0],"jason","27");
    }

}
