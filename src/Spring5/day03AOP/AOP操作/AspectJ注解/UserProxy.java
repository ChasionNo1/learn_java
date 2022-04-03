package Spring5.day03AOP.AOP操作.AspectJ注解;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//2、创建增强类（编写增强逻辑）
//（1）在增强类里面，创建方法，让不同方法代表不同通知类型
@Component
@Aspect //生成代理对象
@Order(2)
public class UserProxy {

//    5、相同的切入点抽取
    @Pointcut(value = "execution(* Spring5.day03AOP.AOP操作.AspectJ注解.User.add(..))")
    public void pointdemo(){

    }

    // 前置通知
    @Before(value = "pointdemo()")
    public void before(){
        System.out.println("before...");
    }

    // 后置通知（返回通知）  有异常不执行
    @AfterReturning(value = "pointdemo()")
    public void afterReturning(){
        System.out.println("afterReturning...");
    }

    //最终通知  有没有异常都会执行，像finally
    @After(value = "pointdemo()")
    public void after(){
        System.out.println("after...");
    }

    //异常通知
    @AfterThrowing(value = "pointdemo()")
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }

    @Around(value = "pointdemo()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("环绕之前。。。");
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后...");
    }


}
