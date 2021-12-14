package day04_review.demo02_java常用类.字符串相关的类.exer1;

import java.util.Arrays;

/**
 * 对字符串中字符进行自然顺序排序。
 * 提示：
 * 1）字符串变成字符数组。
 * 2）对数组排序，选择，冒泡， Arrays.sort();
 * 3）将排序后的数组变成字符串。
 * @program: test
 * @author: chasion
 * @create: 2021-12-14 10:31
 */
public class SortTest {
    public static void main(String[] args) {
        String str = "1234sga63agfasgsa";
        System.out.println(mySort(str));
    }
    public static String mySort(String str){
        // 将字符串变成字符数组
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
