package day04_review.demo02_java常用类.jdk8之前的日期时间api;

import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  * jdk 8之前的日期时间的API测试
 *  * 1. System类中currentTimeMillis();
 *  * 2. java.util.Date和子类java.sql.Date
 *  * 3. SimpleDateFormat
 *  * 4. Calendar
 * @program: test
 * @author: chasion
 * @create: 2021-12-14 16:28
 */
public class DateTimeTest1 {

    /*
       SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

       1.两个操作：
       1.1 格式化：日期 --->字符串
       1.2 解析：格式化的逆过程，字符串 ---> 日期

       2.SimpleDateFormat的实例化

        */
    @Test
    public void test1(){
        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        //格式化：日期 --->字符串
        Date date = new Date();
        System.out.println(date);
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        //解析：格式化的逆过程，字符串 ---> 日期
        String str = "21-12-14 下午4:30";
        try {
            Date date1 = simpleDateFormat.parse(str);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /*
    按照指定方式格式化和解析：调用带参构造器
    * */
    @Test
    public void test2(){
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        //   HH:24小时制，hh：12小时制
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String format = simpleDateFormat.format(date);
        // 2021-12-14 04:35:55
        System.out.println(format);
        Date parse = null;
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现),
        //否则，抛异常
        try {
            parse = simpleDateFormat.parse("2021-12-14 04:35:55");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parse);
    }

    /*
    练习一：字符串“2020-08-09”转换为java.sql.Date
    * */

    @Test
    public void test4(){
        String birth = "2020-09-08";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parse);
        java.sql.Date date = new java.sql.Date(parse.getTime());
        System.out.println(date);
    }

    /*
    练习二："三天打渔两天晒网"   1990-01-01  xxxx-xx-xx 打渔？晒网？

    举例：2020-09-08 ？ 总天数

    总天数 % 5 == 1,2,3 : 打渔
    总天数 % 5 == 4,0 : 晒网

    总天数的计算？
    方式一：( date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1
    方式二：1990-01-01  --> 2019-12-31  +  2020-01-01 -->2020-09-08
    * */
    @Test
    public void test5(){
        String start = "1990-10-1";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(start);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert parse != null;
        long l = new Date().getTime() - parse.getTime();
        int day = (int) l / (24*60*60*1000) + 1;
        switch (day % 5){
            case 1:
            case 2:
            case 3:
                System.out.println("打鱼");
                break;
            case 4:
            case 0:
                System.out.println("晒网");
                break;
        }
    }

}
