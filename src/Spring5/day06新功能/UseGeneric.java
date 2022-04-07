package Spring5.day06新功能;

import Spring5.day03AOP.AOP操作.AspectJ注解.User;
import org.springframework.context.support.GenericApplicationContext;

public class UseGeneric {
    /*
    4、Spring5 核心容器支持函数式风格 GenericApplicationContext
    //函数式风格创建对象，交给 spring 进行管理
    * */

    public void testGenericApplicationContext(){
        // 1 创建GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
        //2 调用 context 的方法对象注册
        context.refresh();
        context.registerBean("user1", User.class, () -> new User());
        //3 获取在 spring 注册的对象
        // User user = (User)context.getBean("com.atguigu.spring5.test.User");
        User user1 = (User) context.getBean("user1");
        System.out.println(user1);
    }
}
