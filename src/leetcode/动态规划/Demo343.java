package leetcode.动态规划;

/**
 * @ClassName Demo343
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 16:52
 *
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *
 * 返回 你可以获得的最大乘积 。
 */
public class Demo343 {
    public static void main(String[] args) {
        Demo343 demo = new Demo343();
        int res = demo.integerBreak(10);
        System.out.println(res);
    }

    public int integerBreak(int n) {

        // 从0开始
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                // 这里的 j 其实最大值为 i-j,再大只不过是重复而已，
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
