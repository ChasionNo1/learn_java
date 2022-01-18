package day04_review.demo08_java反射机制.获取运行时类的结构;

import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *
 * 获取运行时类的方法结构
 *
 * @program: test
 * @author: chasion
 * @create: 2022-01-17 09:29
 */
public class MethodTest {

    @Test
    public void test1(){
        Class<Person> personClass = Person.class;
        //getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = personClass.getMethods();
        for (Method m :
                methods) {
            System.out.println(m);
        }
        System.out.println("-------------------");
        //getDeclaredMethods():获取当前运行时类中声明的所有方法。（不包含父类中声明的方法）
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method m :
                declaredMethods) {
            System.out.println(m);
        }
    }

    /*
      @Xxxx
      权限修饰符  返回值类型  方法名(参数类型1 形参名1,...) throws XxxException{}
   */
    @Test
    public void test2(){
        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method method:
             declaredMethods) {
            //1.获取方法声明的注解
            Annotation[] annotations = method.getAnnotations();
            for (Annotation a :
                    annotations) {
                System.out.println(a);
            }
            //2.权限修饰符
            System.out.print(Modifier.toString(method.getModifiers()) + "\t");
            //3.返回值类型
            System.out.print(method.getReturnType() + "\t");
            //4.方法名
            System.out.print(method.getName());
            System.out.print("(");
            // 5.参数列表
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)){
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1){
                        System.out.print(parameterTypes[i].getName() + "args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + "args_" + i + ",");
                }
            }
            System.out.println(")");

            //6.抛出的异常
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes.length > 0){
                System.out.print("throws");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }
            System.out.println();
        }
    }
}
