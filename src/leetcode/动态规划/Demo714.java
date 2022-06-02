package leetcode.动态规划;

/**
 * @ClassName Demo714
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/31 9:38
 * 给定一个整数数组prices，其中 prices[i]表示第i天的股票价格 ；整数fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 */
public class Demo714 {

    public int maxProfit(int[] prices, int fee) {
        int l = prices.length;
        int[][] dp = new int[l][2];
        dp[0][0] = -prices[0] - fee;
        dp[0][1] = 0;
        for (int i = 1; i < l; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[l - 1][1];

    }
}
