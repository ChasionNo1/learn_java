package leetcode.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-09 16:29
 * <p>
 * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 */
public class Demo483 {
    public static void main(String[] args) {
        Demo483 demo = new Demo483();
        List<Integer> list = demo.findAnagrams1("abab", "ab");
        System.out.println(list);
    }
    // 暴力
    public List<Integer> findAnagrams(String s, String p) {
        char[] chars = p.toCharArray();
        Arrays.sort(chars);
        String p1 = new String(chars);
        ArrayList<Integer> list = new ArrayList<>();
        int m = p.length(); // 滑动窗口大小
        for (int i = 0; i <= s.length() - m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + m; j++) {
                sb.append(s.charAt(j));
            }
            String sub = sb.toString();
            char[] chars1 = sub.toCharArray();
            Arrays.sort(chars1);
            String s1 = new String(chars1);
            System.out.println("i:" + i);
            System.out.println("s1:" + s1);
            if (s1.equals(p1)) {
                list.add(i);
            }
        }
        return list;
    }
    // 滑动窗口
    public List<Integer> findAnagrams1(String s, String p) {
        int n = s.length();
        int m = p.length();
        ArrayList<Integer> list = new ArrayList<>();
        if (n < m){
            return list;
        }

        // s和p计数数组，s每滑动一次，就更新，然后和p数组比较
        int[] sCnt = new int[26];
        int[] pCnt = new int[26];

        // 先把滑动窗口造好
        for (int i = 0; i < m; i++) {
            sCnt[s.charAt(i) - 'a'] += 1;
            pCnt[p.charAt(i) - 'a'] += 1;
        }
        if (Arrays.equals(sCnt, pCnt)){
            list.add(0);
        }

        // 从m开始到最后一位
        for (int i = m; i < n; i++) {
            // 去掉前一位
            sCnt[s.charAt(i - m) - 'a'] -= 1;
            // 添加后一位
            sCnt[s.charAt(i) - 'a'] += 1;
            if (Arrays.equals(sCnt, pCnt)){
                list.add(i - m + 1);
            }
        }
        return list;
    }
}
