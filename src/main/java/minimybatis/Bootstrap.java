package minimybatis;

import minimybatis.dao.StudentMapper;
import minimybatis.pojo.Student;

public class Bootstrap {
    public static void main(String[] args){
        start();
    }

    private static void start(){
        MySqlSession sqlSession = new MyDefaultSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.findStudentById(1);
        System.out.println(student.getAge());
    }
}
