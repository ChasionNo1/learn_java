package day04_review.demo08_java反射机制.反射概述;

import day04_review.demo03_枚举类和注解.枚举类的使用.EnumTest;
import org.testng.annotations.Test;

import java.util.Random;

/**
 *
 *  通过反射创建对应的运行时类的对象
 *
 * @program: test
 * @author: chasion
 * @create: 2022-01-15 19:17
 */
public class NewInstanceTest {

    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;
         /*
        newInstance():调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参的构造器。

        要想此方法正常的创建运行时类的对象，要求：
        1.运行时类必须提供空参的构造器
        2.空参的构造器的访问权限得够。通常，设置为public。


        在javabean中要求提供一个public的空参构造器。原因：
        1.便于通过反射，创建运行时类的对象
        2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器

         */
        Person p1 = personClass.newInstance();
        System.out.println(p1);
    }

    @Test
    public void test2(){
        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);
            String classPath = "";
            switch (num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "day04_review.demo08_java反射机制.反射概述.Person";
                    break;
            }
            Object instance = getInstance(classPath);
            System.out.println(instance);
        }
    }

    public Object getInstance(String classPath){
        Class<?> aClass = null;
        try {
            aClass = Class.forName(classPath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            assert aClass != null;
            return aClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
