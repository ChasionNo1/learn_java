package Spring5.day02IOC操作Bean管理.xml方式.注入其他属性.service;

import Spring5.day02IOC操作Bean管理.xml方式.注入其他属性.dao.UserDao;
import Spring5.day02IOC操作Bean管理.xml方式.注入其他属性.dao.UserDaoImpl;

public class UserService {
    // 创建UserDao的属性，生成set方法
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("service add");
        userDao.update();


        // 创建对象，原始方式
//        UserDao userDao = new UserDaoImpl();
//        userDao.update();
    }
}
