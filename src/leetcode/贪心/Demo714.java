package leetcode.贪心;

/**
 * @ClassName Demo714
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/14 19:30
 *
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
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
        int minPrice = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            // 遇到更低的价格，买入，更新最低价
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }
            // 买入价更高，卖出亏本，在不操作，躺平
            if (prices[i] >= minPrice && prices[i] <= minPrice + fee){
                continue;
            }
            // 卖出是赚的，但是后面不清楚
            if (prices[i] > minPrice + fee){
                // 卖出，获得收益
                result += prices[i] - minPrice - fee;
                // 相当于再买入，但是不用交手续费，续上了
                // 如果后面还有得赚，例如[1, 6, 8, ...]，就假装卖出，如果后面还进入这里买入，不计算手续费的
                minPrice = prices[i] - fee;
            }
        }
        return result;


    }
}
