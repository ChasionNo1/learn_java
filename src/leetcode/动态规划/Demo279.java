package leetcode.动态规划;

/**
 * @ClassName Demo279
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/23 9:13
 *
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 */
public class Demo279 {
    public static void main(String[] args) {
        Demo279 demo = new Demo279();
        int res = demo.numSquares(13);
        System.out.println(res);
    }
    
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j*j <= n; j++) {
                if (i - j * j >= 0){
                    dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
                }
            }
        }
        return dp[n];
    }
}
