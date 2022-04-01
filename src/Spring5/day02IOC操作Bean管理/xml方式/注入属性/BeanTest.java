package Spring5.day02IOC操作Bean管理.xml方式.注入属性;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class BeanTest {

    /*
    * IOC操作Bean管理（概念）
    * 1、什么是Bean管理
    *   Bean管理指的是两个操作：Spring创建对象和Spring注入属性
    * 2、Bean管理操作有两种方式
    *   基于xml配置文件方式实现
    *   基于注解方式实现
    *
    *
    * 基于xml方式的IOC操作Bean管理
    * 1、基于xml方式创建对象
    * <!-- 配置User对象创建-->
      <bean id="user" class="Spring5.day01入门.User"></bean>
    * （1）在 spring 配置文件中，使用 bean 标签，标签里面添加对应属性，就可以实现对象创建
      （2）在 bean 标签有很多属性，介绍常用的属性
        * id 属性：唯一标识
        * class 属性：类全路径（包类路径）
      （3）创建对象时候，默认也是执行无参数构造方法完成对象创建
    *
    * 2、基于xml方式注入属性
    *   （1）DI:依赖注入，就是注入属性
    * 3、第一种注入方式：使用set方法进行注入
    *  （1）创建类，定义属性和对应的set方法
    *   (2) 在spring配置文件配置对象创建，配置属性注入
    *
    * 4、第二种注入方式：使用有参数构造进行注入
    *  （1）创建类，定义属性，创建属性对应有参构造方法
    *
    * 5、p名称空间注入
    *   （1）使用 p 名称空间注入，可以简化基于 xml 配置方式
    *       第一步 添加 p 名称空间在配置文件中
    *       xmlns:p="http://www.springframework.org/schema/p"
    *       第二步 进行属性注入，在 bean 标签里面进行操作
    *
    *

    * */


//    第一种注入方式：使用set方法进行注入
    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring5/day02IOC操作Bean管理/xml方式/注入属性/book.xml");
        Book book = context.getBean("book", Book.class);
        book.show();
    }


//    第二种注入方式：使用有参数构造进行注入
    @Test
    public void test2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring5/day02IOC操作Bean管理/xml方式/注入属性/Order.xml");
        Object order = context.getBean("order");
        System.out.println(order.toString());
    }
}
