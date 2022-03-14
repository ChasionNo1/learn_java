package leetcode.字符串;

import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-12 15:13
 * <p>
 * 重复字串
 */
public class Demo459 {
    public static void main(String[] args) {
        Demo459 demo = new Demo459();
        boolean b = demo.repeatedSubstringPattern("aa");
        System.out.println(b);
    }

    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 0) {
            return false;
        }
        int[] next = getNext(s);
        System.out.println(Arrays.toString(next));
        int len = s.length();
        if (next[len - 1] != -1 && len % (len - (next[len - 1] + 1)) == 0) {
            return true;
        }
        return false;


    }

    public int[] getNext(String ps) {
        // 这里是求包含当前元素的重复前后缀
        // 也就是用j和k+1进行比较
        int[] next = new int[ps.length()];
        next[0] = -1; // 表示第一个元素，k=0 表示指向第一个元素
        int k = -1;
        for (int j = 1; j < ps.length(); j++) {
            // 不同的时候，就要找到当前k的位置，找到相同的前后缀
            while (k >= 0 && ps.charAt(j) != ps.charAt(k + 1)){
                k = next[k];
            }
            // 当j和k+1指向元素相同时，next[j] = k+1
            if (ps.charAt(j) == ps.charAt(k + 1)){
                ++k;
            }
            next[j] = k;
        }

        return next;


    }

    public boolean repeatedSubstringPattern1(String s) {
        if (s.equals("")) return false;

        int len = s.length();
        // 原串加个空格(哨兵)，使下标从1开始，这样j从0开始，也不用初始化了
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];

        // 构造 next 数组过程，j从0开始(空格)，i从2开始
        for (int i = 2, j = 0; i <= len; i++) {
            // 匹配不成功，j回到前一位置 next 数组所对应的值
            while (j > 0 && chars[i] != chars[j + 1]) j = next[j];
            // 匹配成功，j往后移
            if (chars[i] == chars[j + 1]) j++;
            // 更新 next 数组的值
            next[i] = j;
        }
        System.out.println(Arrays.toString(next));

        // 最后判断是否是重复的子字符串，这里 next[len] 即代表next数组末尾的值
        if (next[len] > 0 && len % (len - next[len]) == 0) {
            return true;
        }
        return false;
    }
}

