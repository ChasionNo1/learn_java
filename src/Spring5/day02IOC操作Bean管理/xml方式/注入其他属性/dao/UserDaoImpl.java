package Spring5.day02IOC操作Bean管理.xml方式.注入其他属性.dao;

public class UserDaoImpl implements UserDao {
    @Override
    public void update() {
        System.out.println("dao update");
    }
}
