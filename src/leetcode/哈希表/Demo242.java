package leetcode.哈希表;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-09 14:48
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 */
public class Demo242 {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (char c :
                s.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (char c :
                t.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        for (int i :
                record) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
