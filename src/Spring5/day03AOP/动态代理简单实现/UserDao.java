package Spring5.day03AOP.动态代理简单实现;


//（1）创建接口，定义方法
public interface UserDao {
    public int add(int a, int b);
    public String update(String s);
}
