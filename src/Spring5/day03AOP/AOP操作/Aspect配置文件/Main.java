package Spring5.day03AOP.AOP操作.Aspect配置文件;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class Main {


    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring5/day03AOP/AOP操作/Aspect配置文件/bean.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }
}
