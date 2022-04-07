package Spring5.day06新功能;

import Spring5.day05事务操作.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  // 指定单元测试框架
@ContextConfiguration("classpath:Spring5/day05事务操作/bean.xml") // 加载配置文件
public class UseJUnit4 {

    /*
    5、Spring5 支持整合 JUnit5
    （1）整合 JUnit4
    第一步 引入 Spring 相关针对测试依赖
    第二步 创建测试类，使用注解方式完成

    （2）Spring5 整合 JUnit5
    第一步 引入 JUnit5 的 jar 包



    * */
    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        userService.accountMoney();
    }

}
