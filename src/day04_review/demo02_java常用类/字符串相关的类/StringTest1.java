package day04_review.demo02_java常用类.字符串相关的类;

import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * String涉及到的类型转换
 * @program: test
 * @author: chasion
 * @create: 2021-12-13 19:51
 */
public class StringTest1 {

    @Test
    public void test1(){
        int num = 10;
        String s1 = num + "";
        String s2 = String.valueOf(num);
        int num1 = Integer.parseInt(s1);
    }

    @Test
    public void test2(){
        /*
        String 与 char[] 之间的转换

        * */
        String s1 = "abc123";
        // String ---> char[]
        char[] chars = s1.toCharArray();
        for (char a :
                chars) {
            System.out.println(a);
        }
        // char[] ---> String
        char[] arr = new char[]{'a', 'b', 'c', '1'};
        String s2 = new String(arr);
        System.out.println(s2);
    }

    @Test
    public void test3(){
        /*
        String 与 byte[] 之间的转换
        编码：String --> byte[]:调用String的getBytes()
        解码：byte[] --> String:调用String的构造器

        编码：字符串 -->字节  (看得懂 --->看不懂的二进制数据)
        解码：编码的逆过程，字节 --> 字符串 （看不懂的二进制数据 ---> 看得懂）

        说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。
        * */
        String s1 = "abc中国";
        byte[] bytes = s1.getBytes();//使用默认的字符集，进行编码。
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = new byte[0];
        try {
            gbks = s1.getBytes("gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(gbks);

        String s = new String(bytes);//使用默认的字符集，进行解码。
        System.out.println(s);

        String s2 = new String(gbks);
        System.out.println(s2);//出现乱码。原因：编码集和解码集不一致！

        String gbk = null;
        try {
            gbk = new String(gbks, "gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(gbk);


    }
}
