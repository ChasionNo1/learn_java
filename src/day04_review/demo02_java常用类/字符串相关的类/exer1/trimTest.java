package day04_review.demo02_java常用类.字符串相关的类.exer1;

import sun.security.krb5.internal.PAData;

/**
 * 模拟trim方法，去除字符串两端的空格
 * @program: test
 * @author: chasion
 * @create: 2021-12-13 21:36
 */
public class trimTest {
    public static void main(String[] args) {
        String s = "123 ";
        String s1 = " 1234 ";
        String s2 = " 123";
        String s3 = "123";
        System.out.println(myTrim(s));
        System.out.println(myTrim(s1));
        System.out.println(myTrim(s2));
        System.out.println(myTrim(s3));

    }

    public static String myTrim(String s){
        //  先判断是否都满足
        if (s.startsWith(" ") && s.endsWith(" ")){
            return s.substring(1, s.length() - 1);
        }else if (s.endsWith(" ")){
            return s.substring(0, s.length() - 1);
        }else if (s.startsWith(" ")){
            return s.substring(1);
        }else{
            return s;
        }


    }
}

