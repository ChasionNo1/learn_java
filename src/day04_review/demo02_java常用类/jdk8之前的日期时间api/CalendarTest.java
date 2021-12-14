package day04_review.demo02_java常用类.jdk8之前的日期时间api;

import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Calendar日历类（抽象类）的使用
 * @program: test
 * @author: chasion
 * @create: 2021-12-14 20:11
 */
public class CalendarTest {
    /*
    1.实例化
    方式一：创建其子类（GregorianCalendar）的对象
    方式二：调用其静态方法getInstance()

    2、常用方法
    get()
    set()
    add()
    getTime()
    setTime()

    * */
    @Test
    public void test1(){
        Calendar instance = Calendar.getInstance();
        Calendar calendar = new GregorianCalendar();

        int i = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        System.out.println(instance.get(Calendar.DAY_OF_WEEK));

        instance.set(Calendar.DAY_OF_WEEK, 2);
        System.out.println(instance.get(Calendar.DAY_OF_WEEK));

        instance.add(Calendar.DAY_OF_WEEK, 2);
        System.out.println(instance.get(Calendar.DAY_OF_WEEK));

        Date time = instance.getTime();
        System.out.println(time);

        instance.setTime(time);

    }
}
