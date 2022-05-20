package leetcode.动态规划;

/**
 * @ClassName Demo70
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/6 15:17
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Demo70 {


    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        // 没有初始化dp[0]，没有实际意义
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }

    /**
     * 进阶版：一步一个台阶、两个台阶、三个台阶、... 直到n个台阶，问有多少种不同方法可以爬到楼顶
     * */
    public int climbStairs(int n, int[] steps){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < steps.length; j++) {
                if (i >= steps[j]){
                    dp[i] += dp[i - steps[j]];
                }
            }
        }
        return dp[n];
    }
}
