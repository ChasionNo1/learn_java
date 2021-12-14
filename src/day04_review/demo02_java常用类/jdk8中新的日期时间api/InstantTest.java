package day04_review.demo02_java常用类.jdk8中新的日期时间api;

import org.testng.annotations.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 *
 *
 * @program: test
 * @author: chasion
 * @create: 2021-12-14 21:13
 */
public class InstantTest {

    @Test
    public void test1(){
        // 差8个小时，本初子午线对应的标准时间
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
}
