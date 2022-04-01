package Spring5.day02IOC操作Bean管理.xml方式.xml自动装配;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class AutoWireTest {
    /*
    （xml 自动装配）
    1、什么是自动装配
    （1）根据指定装配规则（属性名称或者属性类型），Spring 自动将匹配的属性值进行注入
    2、演示自动装配过程
    （1）根据属性名称自动注入

    * */

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring5/day02IOC操作Bean管理/xml方式/xml自动装配/emp.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
