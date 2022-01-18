package day04_review.demo08_java反射机制.获取运行时类的结构;

import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构：属性、方法、构造器
 *
 * @program: test
 * @author: chasion
 * @create: 2022-01-17 09:19
 */
public class ReflectionTest {

    @Test
    public void test1() throws Exception{
        Class<Person> personClass = Person.class;
        // 创建运行时类的对象
        Person person = personClass.newInstance();

        // 获取指定的属性：要求运行时类中属性为public
        Field id = personClass.getField("id");

        /*
        设置当前属性的值
        set():参数1：指定设置哪个对象的属性，参数2：将此属性值设置为多少
        * */
        id.set(person, 1002);

        /*
        获取当前属性的值
        get():参数1：获取哪个对象的当前属性值
        * */
        int pld = (int) id.get(person);
        System.out.println(pld);
    }

    /*
    如何操作运行时类中的指定的属性 -- 需要掌握
     */
    @Test
    public void test2() throws Exception{
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();

        //1. getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = personClass.getDeclaredField("name");
        //2.保证当前属性是可访问的
        name.setAccessible(true);
        //3.获取、设置指定对象的此属性值
        name.set(person, "jack");
        System.out.println(person);
    }

      /*
    如何操作运行时类中的指定的方法 -- 需要掌握
     */
    @Test
    public void test3() throws Exception{
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
          /*
        1.获取指定的某个方法
        getDeclaredMethod():参数1 ：指明获取的方法的名称  参数2：指明获取的方法的形参列表
         */
        Method show = personClass.getDeclaredMethod("show", String.class);
        //2.保证当前方法是可访问的
        show.setAccessible(true);
        /*
        3. 调用方法的invoke():参数1：方法的调用者  参数2：给方法形参赋值的实参
        invoke()的返回值即为对应类中调用的方法的返回值。
         */
        Object china = show.invoke(person, "china");
        System.out.println(china);
        System.out.println("*************如何调用静态方法*****************");
        Method showDesc = personClass.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //如果调用的运行时类中的方法没有返回值，则此invoke()返回null
        Object result = showDesc.invoke(null);
//        Object result = showDesc.invoke(Person.class);
        System.out.println(result);
    }

    /*
    如何调用运行时类中的指定的构造器
     */
    @Test
    public void test4() throws Exception{
        Class<Person> personClass = Person.class;
        //private Person(String name)
        /*
        1.获取指定的构造器
        getDeclaredConstructor():参数：指明构造器的参数列表
         */
        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class);
        //2.保证此构造器是可访问的
        constructor.setAccessible(true);
        //3.调用此构造器创建运行时类的对象
        Person tom = constructor.newInstance("tom");
        System.out.println(tom);
    }

}
