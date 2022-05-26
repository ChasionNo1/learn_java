package leetcode.动态规划;

/**
 * @ClassName Demo121
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/26 10:40
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在未来的某一个不同的日子卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 */
public class Demo121 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        // dp[i][j]:表示下标为i时，持有状态为j时，获得的最大利润
        // j=0表示，不持股，反之
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];

    }
}
