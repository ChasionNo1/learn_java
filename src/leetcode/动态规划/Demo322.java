package leetcode.动态规划;

/**
 * @ClassName Demo322
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/20 11:07
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 */
public class Demo322 {
    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        Demo322 demo = new Demo322();
        int res = demo.coinChange(coins, amount);
        System.out.println(res);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        //当金额为0时需要的硬币数目为0
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < coins.length; i++) {
            //正序遍历：完全背包每个硬币可以选择多次
            for (int j = coins[i]; j <= amount; j++) {
                // 这个判断是必须的，因为如果dp[j - coins[i]]==Integer.MAX_VALUE，再加1就越界了，变成负的，再取最小，当然是越界的数字
                if (dp[j - coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }

}
