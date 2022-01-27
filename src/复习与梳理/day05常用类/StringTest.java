package 复习与梳理.day05常用类;

import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * String类的使用
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/25 16:03
 **/
public class StringTest {

    @Test
    public void test1(){
        /*
        * 1.概述
            String:字符串，使用一对""引起来表示。
            1.String声明为final的，不可被继承
            2.String实现了Serializable接口：表示字符串是支持序列化的。
                    实现了Comparable接口：表示String可以比较大小
            3.String内部定义了final char[] value用于存储字符串数据
            4.通过字面量的方式（区别于new给一个字符串赋值，此时的字符串值声明在字符串常量池中)。
            5.字符串常量池中是不会存储相同内容(使用String类的equals()比较，返回true)的字符串的。
        * */
    }

    @Test
    public void test2(){
        /*
        * 2.String的不可变性
        2.1 说明
        1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值。
        2.当对现的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
        3.当调用String的replace()方法修改指定字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
        * */
        String s1 = "abc";//字面量的定义方式
        String s2 = "abc";
        s1 = "hello";
//        4.通过字面量的方式（区别于new给一个字符串赋值，此时的字符串值声明在字符串常量池中)。
//        5.字符串常量池中是不会存储相同内容(使用String类的equals()比较，返回true)的字符串的。
        System.out.println(s1 == s2);//比较s1和s2的地址值

        System.out.println(s1);//hello
        System.out.println(s2);//abc

        System.out.println("*****************");

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);//abcdef
        System.out.println(s2);

        System.out.println("*****************");

        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4);//abc
        System.out.println(s5);//mbc
    }

    @Test
    public void test3(){
        /*
        * 3.String实例化的不同方式
        3.1 方式说明
        方式一：通过字面量定义的方式
        方式二：通过new + 构造器的方式
        *
        * String s = new String("abc");方式创建对象，在内存中创建了几个对象？
            两个:一个是堆空间中new结构，另一个是char[]对应的常量池中的数据："abc"
        * */
        //通过字面量定义的方式：此时的s1和s2的数据javaEE声明在方法区中的字符串常量池中。
        String s1 = "javaEE";
        String s2 = "javaEE";
        //通过new + 构造器的方式:此时的s3和s4保存的地址值，是数据在堆空间中开辟空间以后对应的地址值。
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false
    }

    @Test
    public void test4(){
        /*
        * 4. 字符串拼接方式赋值的对比
        4.1 说明
        1.常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
        2.只要其中一个是变量，结果就在堆中。
        3.如果拼接的结果调用intern()方法，返回值就在常量池中
        * */
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false

        String s8 = s6.intern();//返回值得到的s8使用的常量值中已经存在的“javaEEhadoop”
        System.out.println(s3 == s8);//true

    }

    @Test
    public void test5(){
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2 + "hadoop";
        System.out.println(s1 == s3);//false

        final String s4 = "javaEE";//s4:常量
        String s5 = s4 + "hadoop";
        System.out.println(s1 == s5);//true
    }

    @Test
    public void test6(){
        /*
        *5.常用方法：
        int length()：返回字符串的长度： return value.length
        char charAt(int index)： 返回某索引处的字符return value[index]
        boolean isEmpty()：判断是否是空字符串：return value.length == 0
        String toLowerCase()：使用默认语言环境，将 String 中的所字符转换为小写
        String toUpperCase()：使用默认语言环境，将 String 中的所字符转换为大写
        String trim()：返回字符串的副本，忽略前导空白和尾部空白
        boolean equals(Object obj)：比较字符串的内容是否相同
        boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
        String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
        int compareTo(String anotherString)：比较两个字符串的大小
        String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
        String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。

        boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
        boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
        boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始

        boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
        int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
        int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
        int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
        int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索

        注：indexOf和lastIndexOf方法如果未找到都是返回-1

        替换：
        String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所 oldChar 得到的。
        String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串所匹配字面值目标序列的子字符串。
        String replaceAll(String regex, String replacement)：使用给定的 replacement 替换此字符串所匹配给定的正则表达式的子字符串。
        String replaceFirst(String regex, String replacement)：使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
        匹配:
        boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
        切片：
        String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
        String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
        * */
    }

    @Test
    public void test7(){
//        String与其它结构的转换
//        6.1 与基本数据类型、包装类之间的转换
//        String --> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
//        基本数据类型、包装类 --> String:调用String重载的valueOf(xxx)
        String str1 = "123";
//        int num = (int)str1;//错误的
        int num = Integer.parseInt(str1);

        String str2 = String.valueOf(num);//"123"
        String str3 = num + "";

        System.out.println(str1 == str3);


    }
    @Test
    public void test8(){
        //        6.2 与字符数组之间的转换
//        String --> char[]:调用String的toCharArray()
//        char[] --> String:调用String的构造器
        String str1 = "abc123";  //题目： a21cb3

        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }

        char[] arr = new char[]{'h','e','l','l','o'};
        String str2 = new String(arr);
        System.out.println(str2);
    }

    @Test
    public void test9() throws UnsupportedEncodingException {
//        6.3 与字节数组之间的转换
//        编码：String --> byte[]:调用String的getBytes()
//        解码：byte[] --> String:调用String的构造器
//
//        编码：字符串 -->字节  (看得懂 --->看不懂的二进制数据)
//        解码：编码的逆过程，字节 --> 字符串 （看不懂的二进制数据 ---> 看得懂
//
//        说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。

        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认的字符集，进行编码。
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("gbk");//使用gbk字符集进行编码。
        System.out.println(Arrays.toString(gbks));

        System.out.println("******************");

        String str2 = new String(bytes);//使用默认的字符集，进行解码。
        System.out.println(str2);

        String str3 = new String(gbks);
        System.out.println(str3);//出现乱码。原因：编码集和解码集不一致！


        String str4 = new String(gbks, "gbk");
        System.out.println(str4);//没出现乱码。原因：编码集和解码集一致！
    }
    @Test
    public void test10(){
//        6.4 与StringBuffer、StringBuilder之间的转换
//        String -->StringBuffer、StringBuilder:调用StringBuffer、StringBuilder构造器
//        StringBuffer、StringBuilder -->String:①调用String构造器；②StringBuffer、StringBuilder的toString()
        String str = "abc";
        StringBuffer stringBuffer = new StringBuffer(str);
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuffer.append("dff");
        stringBuilder.append("sffg");
        System.out.println(stringBuffer);
        System.out.println(stringBuilder);

    }

    @Test
    public void test11(){
        /*
        * 7. JVM中字符串常量池存放位置说明：
        jdk 1.6 (jdk 6.0 ,java 6.0):字符串常量池存储在方法区（永久区）
        jdk 1.7:字符串常量池存储在堆空间
        jdk 1.8:字符串常量池存储在方法区（元空间）
        * */
    }

    @Test
    public void test12(){
        /*
        * 8. 常见算法题目的考查：
        1）模拟一个trim方法，去除字符串两端的空格。

        2）将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”

        3）获取一个字符串在另一个字符串中出现的次数。
              比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数

        4）获取两个字符串中最大相同子串。比如：
           str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
           提示：将短的那个串进行长度依次递减的子串与较长的串比较。

        5）对字符串中字符进行自然顺序排序。
        提示：
        1字符串变成字符数组。
        2对数组排序，择，冒泡，Arrays.sort();
        3将排序后的数组变成字符串。

        * */
    }
}
