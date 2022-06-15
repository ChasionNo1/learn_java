package leetcode.动态规划;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-06-15 10:53
 *
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 */
public class Demo647 {

    public int countSubstrings(String s) {
        int len, ans = 0;
        if (s == null || (len = s.length()) < 1){
            return 0;
        }
        boolean[][] dp = new boolean[len][len];

        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j)){
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }else {
                    dp[i][j] = false;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (dp[i][j]){
                    ans++;
                }
            }
        }
        return ans;

    }

}
