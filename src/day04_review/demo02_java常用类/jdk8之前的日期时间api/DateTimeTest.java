package day04_review.demo02_java常用类.jdk8之前的日期时间api;

import org.testng.annotations.Test;

import java.util.Date;

/**
 * jdk 8 之前的日期和时间的api测试
 * @program: test
 * @author: chasion
 * @create: 2021-12-14 10:54
 */
public class DateTimeTest {
    /*
    1. java.lang.System类
    System类提供的public static long currentTimeMillis()用来返回当前时
    间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
     此方法适于计算时间差。
    * */
    @Test
    public void test1(){
        long l = System.currentTimeMillis();
        System.out.println(l);
    }

    /*
    2. java.util.Date类
    表示特定的瞬间，精确到毫秒
     构造器：
     Date()： 使用无参构造器创建的对象可以获取本地当前时间。
     Date(long date)
     常用方法
     getTime():返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象
    表示的毫秒数。
     toString():把此 Date 对象转换为以下形式的 String： dow mon dd
    hh:mm:ss zzz yyyy 其中： dow 是一周中的某一天 (Sun, Mon, Tue,
    Wed, Thu, Fri, Sat)， zzz是时间标准。
     其它很多方法都过时了。
    * */
    @Test
    public void test2(){
        // 构造器一：Date()，创建当前时间的data对象
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        // 构造器2：创建指定毫秒日期
        Date date1 = new Date(1639463487650l);
        System.out.println(date1);
    }

    /*
     3. java.sql.Date对应着数据库中的日期类型的变量
        >如何实例化
        >如何将java.util.Date对象转换为java.sql.Date对象
    * */

    @Test
    public void test3(){
        // 创建java.sql.Data对象
        java.sql.Date date = new java.sql.Date(1639463487650l);
        System.out.println(date);

        // 如何将java.util.Date对象转为java.sql.Date对象
        //情况一：
//        Date date4 = new java.sql.Date(2343243242323L);
//        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二:
        Date date1 = new Date();
        java.sql.Date date2 = new java.sql.Date(date1.getTime());
    }
}
