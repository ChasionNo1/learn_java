package Spring5.day02IOC操作Bean管理.基于注解方式;

import Spring5.day02IOC操作Bean管理.基于注解方式.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class AnnotationTest {

    /*
    1、什么是注解
    （1）注解是代码特殊标记，格式：@注解名称(属性名称=属性值, 属性名称=属性值..)
    （2）使用注解，注解作用在类上面，方法上面，属性上面
    （3）使用注解目的：简化 xml 配置
    2、Spring 针对 Bean 管理中创建对象提供注解
    （1）@Component  普通组件
    （2）@Service  业务逻辑层
    （3）@Controller  web层
    （4）@Repository  dao层，持久层
    * 上面四个注解功能是一样的，都可以用来创建 bean 实例
    3、基于注解方式实现对象创建
    第一步 引入依赖
    第二步 开启组件扫描

    4、开启组件扫描细节配置

    5、基于注解方式实现属性注入
    （1）@Autowired：根据属性类型进行自动装配
    第一步 把 service 和 dao 对象创建，在 service 和 dao 类添加创建对象注解
    第二步 在 service 注入 dao 对象，在 service 类添加 dao 类型属性，在属性上面使用注解

    （2）@Qualifier：根据名称进行注入
    这个@Qualifier 注解的使用，和上面@Autowired 一起使用

    （3）@Resource：可以根据类型注入，可以根据名称注入
    不是spring官方的注解，是扩展包里的javax提供的

    （4）@Value：注入普通类型属性

    6、完全注解开发
    （1）创建配置类，替代 xml 配置文件
    （2）编写测试类






    * */

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring5/day02IOC操作Bean管理/基于注解方式/bean.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }


    @Test
    public void test2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }


}
