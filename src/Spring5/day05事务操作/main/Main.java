package Spring5.day05事务操作.main;

import Spring5.day05事务操作.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class Main {
    /*
    事务操作（搭建事务操作环境）
    1、创建数据库表，添加记录
    2、创建 service，搭建 dao，完成对象创建和注入关系
    （1）service 注入 dao，在 dao 注入 JdbcTemplate，在 JdbcTemplate 注入 DataSource
    3、在 dao 创建两个方法：多钱和少钱的方法，在 service 创建方法（转账的方法）
    4、上面代码，如果正常执行没有问题的，但是如果代码执行过程中出现异常，有问题
     // 转账的方法
    public void accountMoney(){
        userDao.reduceMoney();
        // 模拟异常
        int i = 10 / 0;
        userDao.addMoney();
    }
    （1）上面问题如何解决呢？
    * 使用事务进行解决
    （2）事务操作过程
     public void accountMoney(){
        try{
            // 第一步 开启事务
            // 第二步 进行业务操作

            userDao.reduceMoney();
            // 模拟异常
            int i = 10 / 0;
            userDao.addMoney();
            // 第三步 没有发生异常，提交事务
        }catch(Exception e){
            // 第四步 出现异常，事务回滚
        }
    }


    事务操作（Spring 事务管理介绍）
    1、事务添加到 JavaEE 三层结构里面 Service 层（业务逻辑层）
    2、在 Spring 进行事务管理操作
    （1）有两种方式：编程式事务管理和声明式事务管理（使用）
    3、声明式事务管理
    （1）基于注解方式（使用）
    （2）基于 xml 配置文件方式
    4、在 Spring 进行声明式事务管理，底层使用 AOP 原理
    5、Spring 事务管理 API
    （1）提供一个接口，代表事务管理器，这个接口针对不同的框架提供不同的实现类


    事务操作（注解声明式事务管理）
    1、在 spring 配置文件配置事务管理器
    2、在 spring 配置文件，开启事务注解
    （1）在 spring 配置文件引入名称空间 tx
    （2）开启事务注解
    3、在 service 类上面（或者 service 类里面方法上面）添加事务注解
    （1）@Transactional，这个注解添加到类上面，也可以添加方法上面
    （2）如果把这个注解添加类上面，这个类里面所有的方法都添加事务
    （3）如果把这个注解添加方法上面，为这个方法添加事务


    * */

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring5/day05事务操作/druid.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
}
