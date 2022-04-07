package Spring5.day06新功能;

import Spring5.day05事务操作.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:Spring5/day05事务操作/bean.xml")
@SpringJUnitConfig(locations = "classpath:Spring5/day05事务操作/bean.xml")  //复合注解
public class UseJUnit5 {

    /*
    （2）Spring5 整合 JUnit5
    第一步 引入 JUnit5 的 jar 包
    第二步 创建测试类，使用注解完成
    （3）使用一个复合注解替代上面两个注解完成整合
        SpringJUnitConfig

    * */

    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        userService.accountMoney();
    }



}
