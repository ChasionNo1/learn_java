package leetcode.贪心;
/*
122. 买卖股票的最佳时机 II
给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。

在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
返回 你能获得的 最大 利润 。
* */
public class Demo122 {

    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i -1] > 0){
                sum += prices[i] - prices[i -1];
            }
        }
        return sum;

    }
}
