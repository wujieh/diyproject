package dynamicproxy.dynamicproxyformybatis;

public class Entrance {
    public static void main(String[] args) {
        MapperProxy mapperProxy = new MapperProxy();
        UserMapper proxy = mapperProxy.newInstance(UserMapper.class);
        User u = proxy.getUserById("1001");
        System.out.println(u.toString());
    }
}
