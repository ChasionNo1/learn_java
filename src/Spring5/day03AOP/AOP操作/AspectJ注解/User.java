package Spring5.day03AOP.AOP操作.AspectJ注解;


import org.springframework.stereotype.Component;

//1、创建类，在类里面定义方法
@Component
public class User {

    public void add(){
        System.out.println("add.....");
    }
}
