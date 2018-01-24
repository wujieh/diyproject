package minimybatis;

public interface MyExecutor {
    public <T> T query(String statement);
}
