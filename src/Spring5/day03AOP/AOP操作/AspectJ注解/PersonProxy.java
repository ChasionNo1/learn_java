package Spring5.day03AOP.AOP操作.AspectJ注解;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class PersonProxy {

    @Before(value = "execution(* Spring5.day03AOP.AOP操作.AspectJ注解.User.add(..))")
    public void before(){
        System.out.println("person before");
    }
}
