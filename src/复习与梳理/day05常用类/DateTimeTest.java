package 复习与梳理.day05常用类;

import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期类的使用
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/25 20:30
 **/
public class DateTimeTest {

    @Test
    public void test1(){
        /*
        * 1.获取系统当前时间：System类中的currentTimeMillis()
        * */
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
        //称为时间戳
        System.out.println(time);
    }

    @Test
    public void test2(){
        /*
        *     java.util.Date类
                 |---java.sql.Date类

            1.两个构造器的使用
                >构造器一：Date()：创建一个对应当前时间的Date对象
                >构造器二：创建指定毫秒数的Date对象
            2.两个方法的使用
                >toString():显示当前的年、月、日、时、分、秒
                >getTime():获取当前Date对象对应的毫秒数。（时间戳）

            3. java.sql.Date对应着数据库中的日期类型的变量
                >如何实例化
                >如何将java.util.Date对象转换为java.sql.Date对象
        * */
        //构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//Sat Feb 16 16:35:31 GMT+08:00 2019

        System.out.println(date1.getTime());//1550306204104

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(155030620410L);
        System.out.println(date2.toString());

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(35235325345L);
        System.out.println(date3);//1971-02-13

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一：
//        Date date4 = new java.sql.Date(2343243242323L);
//        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二：
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
    }

    @Test
    public void test3() throws ParseException {
        /*
        * 3. java.text.SimpleDataFormat类
        *
        * SimpleDateFormat对日期Date类的格式化和解析
        1.两个操作：
        1.1 格式化：日期 --->字符串
        1.2 解析：格式化的逆过程，字符串 ---> 日期

        2.SimpleDateFormat的实例化:new + 构造器
        * */

//*************照指定的方式格式化和解析：调用带参的构造器*****************
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        Date date = new Date();
        String format1 = sdf1.format(date);
        System.out.println(format1);//2019-02-18 11:48:27
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现),
        //否则，抛异常
        Date date2 = sdf1.parse("2020-02-18 11:48:27");
        System.out.println(date2);

    }

    @Test
    public void test4(){
        /*
        *   4.Calendar类：日历类、抽象类
        * */

        //1.实例化
        //方式一：创建其子类（GregorianCalendar的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        //calendar可变性
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }

    @Test
    public void test5(){
        /*
        * jdk8之后的日期类
        * 2.前两代存在的问题举例：
            可变性：像日期和时间这样的类应该是不可变的。
            偏移性：Date中的年份是从1900开始的，而月份都从0开始。
            格式化：格式化只对Date用，Calendar则不行。
            此外，它们也不是线程安全的；不能处理闰秒等。
            *
       * 4.本地日期、本地时间、本地日期时间的使用：LocalDate / LocalTime / LocalDateTime
       * ① 分别表示使用 ISO-8601日历系统的日期、时间、日期和时间。它们提供了简单的本地日期或时间，并不包含当前的时间信息，也不包含与时区相关的信息。
         ② LocalDateTime相较于LocalDate、LocalTime，使用频率要高
         ③ 类似于Calendar
        * */
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

    @Test
    public void test6(){
        /*
        * 5.时间点：Instant
            5.1 说明：
            ① 时间线上的一个瞬时点。 概念上讲，它只是简单的表示自1970年1月1日0时0分0秒（UTC开始的秒数。）
            ② 类似于 java.util.Date类
        * */
        Instant now = Instant.now();
        System.out.println(now);
        // 添加时间的偏移量
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        // 时间戳是指格林威治时间1970年01月01日00时00分00秒(北京时间1970年01月01
        //日08时00分00秒)起至现在的总秒数。
        long l = now.toEpochMilli();
        System.out.println(l);

        //通过毫秒数 ，获取Instant实例
        Instant instant = Instant.ofEpochMilli(1639488314440L);
        System.out.println(instant);
    }

    @Test
    public void test7(){
        /*
        *   6.日期时间格式化类：DateTimeFormatter
        *    预定义的标准格式。如：
            ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
             本地化相关的格式。如： ofLocalizedDateTime(FormatStyle.LONG)
             自定义的格式。如： ofPattern(“yyyy-MM-dd hh:mm:ss”)
        *
        * */
        // 格式化：日期--->字符串
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        String format = formatter.format(now);
        System.out.println(format);

        // 解析：字符串--->日期
        TemporalAccessor parse = formatter.parse("2021-12-14T21:33:54.263");
        System.out.println(parse);

        // 本地化相关的格式, ofLocalizedDateTime()
//        FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        format = dateTimeFormatter.format(now);
        System.out.println(format);

        // 本地化相关的格式。如：ofLocalizedDate()
//      FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        //格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);//2019-2-18

        //        重点： 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        format = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(format);
        // 解析
        parse = dateTimeFormatter.parse("2021-12-14 21:46:31");
        System.out.println(parse);
    }
}
