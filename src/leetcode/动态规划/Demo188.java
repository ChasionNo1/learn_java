package leetcode.动态规划;

/**
 * @ClassName Demo188
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/27 11:16
 *
 * 给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 */
public class Demo188 {

    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        if (length == 0) return 0;
        int[][] dp = new int[length][2 * k + 1];
        for (int i = 1; i < 2 * k; i+=2) {
            dp[0][i] = -prices[0];
        }
        // 第i天
        for (int i = 1; i < length; i++) {
            // 操作状态，奇数是买入，偶数是卖出，0是不操作
            for (int j = 0; j < 2 * k - 1; j+=2) {
                // j是偶数开始
                // j+1表示当前这笔交易的持有状态，是保持前一天持有状体和前一天卖出，今天买入状态的最大值
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                // j+2是不持有状态，可以是延续前一天不持有，或者前一天持有并且今天卖出
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);

            }
        }
        return dp[length - 1][k * 2];


    }
}
