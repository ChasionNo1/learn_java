package Spring5.day02IOC操作Bean管理.xml方式.注入集合属性;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SetPropertyTest {
    /*
    xml 注入集合属性

    1、注入数组类型属性
    2、注入 List 集合类型属性
    3、注入 Map 集合类型属性
    （1）创建类，定义数组、list、map、set 类型属性，生成对应 set 方法
    （2）在 spring 配置文件进行配置


    4、在集合里面设置对象类型值
        ref

    5、把集合注入部分提取出来
    （1）在 spring 配置文件中引入名称空间 util



    * */

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring5/day02IOC操作Bean管理/xml方式/注入集合属性/stu.xml");
        Stu stu = context.getBean("stu", Stu.class);
        System.out.println(stu);
    }


//    5、把集合注入部分提取出来
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring5/day02IOC操作Bean管理/xml方式/注入集合属性/book.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }
}
