package leetcode.字符串;

import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-11 09:12
 *
 * 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 */
public class Demo344 {
    public static void main(String[] args) {
        Demo344 demo = new Demo344();
        char[] s = {'a', 'b', 'd', 'h', 'g'};
        demo.reverseString(s);
        System.out.println(Arrays.toString(s));

    }
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j){
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            ++i;
            --j;
        }

    }
}
