package Spring5.day03AOP.动态代理简单实现;

//（2）创建接口实现类，实现方法

public class UserDaoImpl implements UserDao{
    @Override
    public int add(int a, int b) {
        System.out.println("执行add方法");
        return a + b;
    }

    @Override
    public String update(String s) {
        return s;
    }
}
