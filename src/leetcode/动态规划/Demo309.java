package leetcode.动态规划;

/**
 * @ClassName Demo309
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/30 10:39
 *
 * 给定一个整数数组prices，其中第prices[i]表示第i天的股票价格 。
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 */
public class Demo309 {

    public int maxProfit(int[] prices) {
        // 一共有4中状态
        int l = prices.length;
        int[][] dp = new int[l][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < l; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3] - prices[i], dp[i - 1][1] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[l - 1][3], Math.max(dp[l - 1][1], dp[l - 1][2]));


    }
}
