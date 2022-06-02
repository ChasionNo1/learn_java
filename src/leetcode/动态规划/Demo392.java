package leetcode.动态规划;

/**
 * @ClassName Demo392
 * @Description TODO
 * @Author chasion
 * @Date 2022/6/2 10:13
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 */
public class Demo392 {
    public static void main(String[] args) {
        Demo392 demo = new Demo392();
        boolean b = demo.isSubsequence("twn", "xxxtxxxxxxxwxxxn");
        System.out.println(b);
    }

    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        if (n == 0){
            return true;
        }
        // 这里n不等于0
        if (m == 0 || m < n){
            return false;
        }

        // 到这里n和m都不能为0
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n] == n;
    }
}
