package day04_review.demo02_java常用类.jdk8中新的日期时间api;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * LocalDate、 LocalTime、 LocalDateTime 类是其中较重要的几个类，它们的实例
 * 是不可变的对象，分别表示使用 ISO-8601日历系统的日期、时间、日期和时间。
 * 它们提供了简单的本地日期或时间，并不包含当前的时间信息，也不包含与时区
 * 相关的信息。
 * LocalDate代表IOS格式（yyyy-MM-dd）的日期,可以存储 生日、纪念日等日期。
 * LocalTime表示一个时间，而不是日期。
 * LocalDateTime是用来表示日期和时间的， 这是一个最常用的类之一。
 *
 * @program: test
 * @author: chasion
 * @create: 2021-12-14 21:01
 */
public class TimeDateTest {

    @Test
    public void test3(){
        // now():获取当前的日期、时间、日期+时间
        LocalDate now = LocalDate.now();
        LocalTime now1 = LocalTime.now();
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now1);
        System.out.println(now2);

        //of():设置指定的年、月、日、时、分、秒，没有偏移量
        LocalDateTime of = LocalDateTime.of(2021, 12, 15, 12, 12);
        System.out.println(of);

        //getXxx():
        System.out.println(now2.getDayOfMonth());
        System.out.println(now2.getDayOfWeek());
        System.out.println(now2.getHour());

        //体现不可变性
        // withXxx():设置相关属性
        LocalDateTime localDateTime = now2.withDayOfMonth(10);
        System.out.println(localDateTime);
        System.out.println(now2);

        // 加减操作
        LocalDateTime localDateTime1 = now2.plusDays(1);
        System.out.println(localDateTime1);
        LocalDateTime localDateTime2 = now2.minusDays(1);
        System.out.println(localDateTime2);

    }
}
