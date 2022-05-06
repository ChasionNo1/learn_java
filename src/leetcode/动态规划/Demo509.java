package leetcode.动态规划;

/**
 * @ClassName Demo509
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/6 10:21
 */
public class Demo509 {

    public int fib(int n) {
        int[] dp = new int[n + 1];
        if (n <= 1){
            return n;
        }
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }
}
