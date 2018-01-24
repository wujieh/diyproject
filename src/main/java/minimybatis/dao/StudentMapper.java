package minimybatis.dao;

import minimybatis.pojo.Student;

public interface StudentMapper {
    public Student findStudentById(int id);
}
