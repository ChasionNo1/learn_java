package leetcode.动态规划;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-06-03 16:57
 *
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE"是"ABCDE"的一个子序列，而"AEC"不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 */
public class Demo115 {

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n){
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        // 从最后开始遍历，
        for (int i = m - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                // s[i] == t[j]的时候, s[i] 可以选择自己是否跟 t[j]匹配
                // 如果匹配，那么 dp[i][j] 其中一部分数量就是 dp[i+1][j+1]
                // 如果选择不匹配（这样可以让前面的字符跟t[j]匹配，毕竟t 短的,s 长) dp[i][j] 另外一部分就是 dp[i+1][j]
                if (sChar == tChar){
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                }else {
                    // 如果不相等时，匹配点是t串，所以t串不能变，只能用t串去匹配s串的字串
                    // 相等的时候，可以用t串的字串去匹配s串的字串，相当于两个串同时增加了1个，两个差值不变
                    dp[i][j] = dp[i + 1][j];
                }
            }

        }
        return dp[0][0];
    }
}
