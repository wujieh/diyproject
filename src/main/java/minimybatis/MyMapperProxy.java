package minimybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyMapperProxy implements InvocationHandler{
    private MySqlSession sqlSession;
    public MyMapperProxy(MySqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    public Object invoke(Object proxy,Method method,Object[] args){
        String mapperClass = method.getDeclaringClass().getName();
        if(StudentMapperXML.namespace.equals(mapperClass)){
            String methodName = method.getName();
            String originSql = StudentMapperXML.getMethodSQL(methodName);
            String formattedSql = String.format(originSql,String.valueOf(args[0]));
            return sqlSession.selectOne(formattedSql);
        }
        return null;
    }
}
