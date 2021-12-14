package day04_review.demo02_java常用类.字符串相关的类.exer;

/**
 * @program: test
 * @author: chasion
 * @create: 2021-12-14 10:49
 */
public class StringBufferTest {
    public static void main(String[] args) {
        String str = null;
        StringBuffer stringBuffer = new StringBuffer();
        // append方法将null转为字符添加进去了
        stringBuffer.append(str);
        System.out.println(stringBuffer.length());
        System.out.println(stringBuffer);

        StringBuffer stringBuffer1 = new StringBuffer(str);
        System.out.println(stringBuffer1);
    }
}
