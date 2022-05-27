package leetcode.动态规划;

/**
 * @ClassName Demo123
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/27 10:05
 * 困难题
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 */
public class Demo123 {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0;
        dp[0][1]= -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            // 第一次持股
            dp[i][1] = Math.max(dp[i- 1][1], dp[i - 1][0] - prices[i]);
            // 第一次不持股
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            // 第二次持股
            dp[i][3] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][3]);
            // 第二次不持股
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];

    }
}
