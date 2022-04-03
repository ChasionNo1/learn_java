package Spring5.day02IOC操作Bean管理.基于注解方式.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("dao add....");
    }
}
