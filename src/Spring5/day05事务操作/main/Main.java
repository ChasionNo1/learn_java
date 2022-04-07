package Spring5.day05事务操作.main;

import Spring5.day05事务操作.config.TxConfig;
import Spring5.day05事务操作.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

    事务操作（声明式事务管理参数配置）
    1、在 service 类上面添加注解@Transactional，在这个注解里面可以配置事务相关参数
    2、propagation：事务传播行为
    （1）多事务方法直接进行调用，这个过程中事务 是如何进行管理的
    事务方法：对数据库表数据进行变化的操作
    @Transactional
    public void add(){
        update();
    }
    public void update(){};
    Spring框架事务传播行为有7种
    REQUIRED:如果add方法本身有事务，调用update方法之后，update使用当前add方法里面事务，如果add方法本身没有事务，调用update方法之后，创建新事物
    REQUIRED_NEW:使用add方法调用update方法，如果add方法无论是否有事务，update都创建新的事务

    3、ioslation：事务隔离级别
    （1）事务有特性成为隔离性，多事务操作之间不会产生影响。不考虑隔离性产生很多问题
    （2）有三个读问题：脏读、不可重复读、虚（幻）读
    （3）脏读：一个未提交事务读取到另一个未提交事务的数据
     (4) 不可重复读：一个未提交的事务读取到另一个提交事务修改数据 （重复读结果不一样，是一种现象）
    （5）幻读：一个未提交事务读取到另一个提交事务添加的数据
    （6）解决：通过设置事务隔离级别，解决读问题
                        脏读      不可重复读       幻读
    READ UNCOMMITTED    no          no             no
    (读未提交）
    READ COMMITTED      yes         no             no
    (读已提交）
    REPEATABLE READ     yes         yes            no
    (可重复读）
    SERIALIZABLE        yes         yes            yes
    (串行化）


    4、timeout：超时时间
    （1）事务需要在一定时间内进行提交，如果不提交进行回滚
    （2）默认值是 -1（不超时） ，设置时间以秒单位进行计算
    5、readOnly：是否只读
    （1）读：查询操作，写：添加修改删除操作
    （2）readOnly 默认值 false，表示可以查询，可以添加修改删除操作
    （3）设置 readOnly 值是 true，设置成 true 之后，只能查询
    6、rollbackFor：回滚
    （1）设置出现哪些异常进行事务回滚
    7、noRollbackFor：不回滚
    （1）设置出现哪些异常不进行事务回滚


    事务操作（XML 声明式事务管理）
    1、在 spring 配置文件中进行配置
    第一步 配置事务管理器
    第二步 配置通知
    第三步 配置切入点和切面



    * */

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring5/day05事务操作/druid.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring5/day05事务操作/bean.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    @Test
    public void test3(){
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
}
