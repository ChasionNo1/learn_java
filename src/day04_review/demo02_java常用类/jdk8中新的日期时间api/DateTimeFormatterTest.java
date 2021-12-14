package day04_review.demo02_java常用类.jdk8中新的日期时间api;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * DateTimeFormatter:格式化或解析日期、时间
 * 类似于SimpleDateFormat
 *
 * @program: test
 * @author: chasion
 * @create: 2021-12-14 21:27
 */
public class DateTimeFormatterTest {
    /*
     预定义的标准格式。如：
    ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
     本地化相关的格式。如： ofLocalizedDateTime(FormatStyle.LONG)
     自定义的格式。如： ofPattern(“yyyy-MM-dd hh:mm:ss”)
    * */

    @Test
    public void test1() {
        // 格式化：日期--->字符串
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        String format = formatter.format(now);
        System.out.println(format);

        // 解析：字符串--->日期
        TemporalAccessor parse = formatter.parse("2021-12-14T21:33:54.263");
        System.out.println(parse);
    }

    @Test
    public void test2() {
        // 本地化相关的格式, ofLocalizedDateTime()
//        FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        LocalDateTime now = LocalDateTime.now();
        String format = dateTimeFormatter.format(now);
        System.out.println(format);

        // 本地化相关的格式。如：ofLocalizedDate()
//      FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        //格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);//2019-2-18
    }

    @Test
    public void test3() {
//        重点： 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(format);
        // 解析
        TemporalAccessor parse = dateTimeFormatter.parse("2021-12-14 21:46:31");
        System.out.println(parse);
    }
}
