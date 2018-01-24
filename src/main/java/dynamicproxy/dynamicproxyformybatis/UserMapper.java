package dynamicproxy.dynamicproxyformybatis;

/*
模拟mybatis的mapper接口类
 */
public interface UserMapper {
    public User getUserById(String id);
    public User getAgeById(String id);
}
