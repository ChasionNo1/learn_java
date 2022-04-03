package Spring5.day03AOP.AOP操作.AspectJ注解;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class AopTest {

    /*
    AspectJ注解
    1、创建类，在类里面定义方法
    2、创建增强类（编写增强逻辑
    （1）在增强类里面，创建方法，让不同方法代表不同通知类型）
    3、进行通知的配置
    （1）在 spring 配置文件中，开启注解扫描
    （2）使用注解创建 User 和 UserProxy 对象
    （3）在增强类上面添加注解 @Aspect
    （4）在 spring 配置文件中开启生成代理对象
    4、配置不同类型的通知
    （1）在增强类的里面，在作为通知方法上面添加通知类型注解，使用切入点表达式配置
    （2）执行顺序：环绕之前 before  add  afterReturning after 环绕之后
       @Around  @Before  @After @AfterReturning @AfterThrowing

    5、相同的切入点抽取

    6、有多个增强类多同一个方法进行增强，设置增强类优先级
    （1）在增强类上面添加注解 @Order(数字类型值)，数字类型值越小优先级越高

    7、完全使用注解开发
    （1）创建配置类，不需要创建 xml 配置文件

    * */


    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring5/day03AOP/AOP操作/AspectJ注解/bean.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
}
