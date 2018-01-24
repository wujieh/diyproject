package minimybatis;

import java.lang.reflect.Proxy;

public class MyDefaultSqlSession implements MySqlSession{
    private MyExecutor executor = new MyBaseExecutor();
    public <T> T selectOne(String sql){
        return executor.query(sql);
    }
    public <T> T getMapper(Class<T> cls){
        return (T) Proxy.newProxyInstance(cls.getClassLoader(),new Class[]{cls},new MyMapperProxy(this));
    }
}
