package leetcode.贪心;

/**
 * @ClassName Demo942
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/9 10:23
 *
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 *
 * 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I' 
 * 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D' 
 * 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个
 *
 * 双指针加贪心
 */
public class Demo942 {

    public int[] diStringMatch(String s) {
        int[] res = new int[s.length() + 1];
        int high = s.length();
        int low = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I'){
                // 增加，放置最小的
                res[i] = low;
                low++;
            }else {
                // 减少，放置最大的
                res[i] = high;
                high--;
            }
        }
        // 最后一个时，low == high
        res[s.length()] = low;
        return res;
    }
}
