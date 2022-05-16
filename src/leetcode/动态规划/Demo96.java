package leetcode.动态规划;

/**
 * @ClassName Demo96
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/12 9:24
 *
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class Demo96 {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 左子树的节点数量的dp值 * 右子树节点数量的dp值
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];

    }
}
