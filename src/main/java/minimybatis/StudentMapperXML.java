package minimybatis;

import java.util.HashMap;
import java.util.Map;

public class StudentMapperXML {
    public static final String namespace = "minimybatis.dao.StudentMapper";
    private static Map<String,String> methodSqlMap = new HashMap<String, String>();
    static{
        methodSqlMap.put("findStudentById","select * from student where id=%s");
    }
     public static String getMethodSQL(String method){
        return methodSqlMap.get(method);
     }
}
