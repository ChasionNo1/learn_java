package day04_review.demo02_java常用类.字符串相关的类.exer1;

import java.util.Arrays;

/**
 * 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反
 * 转为”abfedcg”
 *
 * @program: test
 * @author: chasion
 * @create: 2021-12-13 21:49
 */
public class ReverseTest {
    public static void main(String[] args) {
        String s1 = "abcd1234";
        String s = myReverse(s1, 0, 3);
        System.out.println(s);
    }

    public static String myReverse(String s, int start, int end) {
        char[] arr = s.toCharArray();
        char[] arr1 = Arrays.copyOfRange(arr, start, end);
        char[] arr2 = reverse(arr1);
        String substring = s.substring(end, s.length() - 1);
        if (start == 0){
            return new String(arr2) + substring;
        }else {
            return s.substring(0, start) + new String(arr2) + substring;
        }
    }

    public static char[] reverse(char[] chars) {
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        return chars;
    }
}
