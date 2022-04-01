package Spring5.day02IOC操作Bean管理.xml方式.bean作用域;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class BeanFieldTest {
    /*
    1、在 Spring 里面，设置创建 bean 实例是单实例还是多实例
    2、在 Spring 里面，默认情况下，bean 是单实例对象
    3、如何设置单实例还是多实例
    （1）在 spring 配置文件 bean 标签里面有属性（scope）用于设置单实例还是多实例
    （2）scope 属性值
    第一个值 默认值，singleton，表示是单实例对象
    第二个值 prototype，表示是多实例对象
    （3）singleton 和 prototype 区别
    第一 singleton 单实例，prototype 多实例
    第二 设置 scope 值是 singleton 时候，加载 spring 配置文件时候就会创建单实例对象
     设置 scope 值是 prototype 时候，不是在加载 spring 配置文件时候创建 对象，在调用
    getBean 方法时候创建多实例对象


    * */

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring5/day02IOC操作Bean管理/xml方式/bean作用域/book.xml");
        Book book1 = context.getBean("book", Book.class);
        Book book2 = context.getBean("book", Book.class);
        System.out.println(book1 == book2);  //true
    }
}
