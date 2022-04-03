package Spring5.day02IOC操作Bean管理.基于注解方式.service;

import Spring5.day02IOC操作Bean管理.基于注解方式.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


//在注解里面 value 属性值可以省略不写，
//默认值是类名称，首字母小写
//UserService -- userService

@Component(value = "userService")  //<bean id="userService" class=".."/>
public class UserService {
    // 定义dao类型属性
    // 不需要添加set方法
    // 添加注入属性注解

//    @Autowired  // 根据属性类型自动注入
//    @Qualifier(value = "userDaoImpl")  // 根据名称进行注入，和Autowire一起使用，要保持名称一致，否则找不到
//    private UserDao userDao;

//    @Resource  // 根据属性进行注入
    @Resource(name = "userDaoImpl")  // 根据名称进行注入
    private UserDao userDao;

    @Value(value = "abc")
    private String name;

    public void add(){
        System.out.println("userService add...." + name);
        userDao.add();
    }
}
