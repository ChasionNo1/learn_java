package 复习与梳理.day05常用类;

import org.testng.annotations.Test;

/**
 * StringBuffer\StringBuilder的使用
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/25 16:51
 **/
public class StringBuilderTest {

    @Test
    public void test1(){
        /*
        1.String、StringBuffer、StringBuilder三者的对比
        String:不可变的字符序列；底层使用char[]存储
        StringBuffer:可变的字符序列；线程安全的，效率低；底层使用char[]存储
        StringBuilder:可变的字符序列；jdk5.0新增的，线程不安全的，效率高；底层使用char[]存储
        * */
    }

    @Test
    public void test2(){
        /*
        * 2.StringBuffer与StringBuilder的内存解析
        以StringBuffer为例：
        String str = new String();//char[] value = new char[0];
        String str1 = new String("abc");//char[] value = new char[]{'a','b','c'};

        StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];底层创建了一个长度是16的数组。
        System.out.println(sb1.length());//
        sb1.append('a');//value[0] = 'a';
        sb1.append('b');//value[1] = 'b';

        StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length() + 16];

        //问题1. System.out.println(sb2.length());//3
        //问题2. 扩容问题:如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组。
          默认情况下，扩容为原来容量的2倍 + 2，同时将原数组中的元素复制到新的数组中。

        指导意义：开发中建议大家使用：StringBuffer(int capacity) 或 StringBuilder(int capacity)
        * */
    }

    @Test
    public void test3(){
        /*
        * 3.对比String、StringBuffer、StringBuilder三者的执行效率
            从高到低排列：StringBuilder > StringBuffer > String
        * */
    }

    @Test
    public void test4(){
        /*
        * 4.StringBuffer、StringBuilder中的常用方法
        增：append(xxx)
        删：delete(int start,int end)
        改：setCharAt(int n ,char ch) / replace(int start, int end, String str)
        查：charAt(int n )
        插：insert(int offset, xxx)
        长度：length();
        *遍历：for() + charAt() / toString()
        * */

        StringBuffer stringBuffer = new StringBuffer(31);
        stringBuffer.append("you are very good");
        char c = stringBuffer.charAt(10);
        System.out.println(c);
        stringBuffer.setCharAt(0, 'Y');
        System.out.println(stringBuffer);
    }
}
