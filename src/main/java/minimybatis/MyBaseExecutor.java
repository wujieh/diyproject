package minimybatis;

import minimybatis.pojo.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyBaseExecutor implements MyExecutor{
    private final String URL = "jdbc:mysql://localhost:3306/play?useUnicode=true&amp;characterEncoding=utf-8";
    private final String USERNAME = "root";
    private final String PASSWORD = "goodrock";

    public <T> T query(String statement){
        //JDBC完成DB操作获取结果
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student student = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            preparedStatement = con.prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                student = new Student();
                student.setId(resultSet.getInt("ID"));
                student.setAddress(resultSet.getString("ADDRESS"));
                student.setAge(resultSet.getString("AGE"));
                student.setName(resultSet.getString("NAME"));
                student.setSex(resultSet.getString("SEX"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                resultSet.close();
                preparedStatement.close();
                con.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
            return (T)student;
        }


    }
}
