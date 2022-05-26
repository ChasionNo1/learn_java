package leetcode.哈希表;

import org.junit.Test;

import java.util.HashMap;

/**
 * @ClassName Demo3
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/25 10:51
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Demo3 {
    public static void main(String[] args) {
        String s = "au";
        Demo3 demo = new Demo3();
        int res = demo.lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int res = 0;
        for (int i = 0, j = 2; i < j && j <= s.length(); i++, j++) {
            // 字串没有重复的，j指针后移，继续判断，取不到j，[i,j)
            // 先判断是否超出范围，否则后面取字串会越界
            while (j <= s.length()  && isNotRepeat(s.substring(i, j))) {
                j++;
            }
            // 如果有重复的了，记录一下结果
            res = Math.max(res, j - i - 1);
        }
        return res;
    }

    private boolean isNotRepeat(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c :
                s.toCharArray()) {
            if (map.containsKey(c)) {
                return false;
            } else {
                map.put(c, 1);
            }
        }
        return true;
    }


    @Test
    public void test1(){
        String s = "123";
        System.out.println(s.substring(0, 3));
    }
}
