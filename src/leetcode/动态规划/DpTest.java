package leetcode.动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName DpTest
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/13 10:26
 */
public class DpTest {

    @Test
    public void test1() {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagsize = 4;
        testWeightBagProblem2(weight, value, bagsize);
        testCompletePack(weight, value, bagsize);

    }

    /**
     * 01背包
     **/
    // 二维dp数组
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int wlen = weight.length, value0 = 0;
        //定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[wlen + 1][bagSize + 1];
        //初始化：背包容量为0时，能获得的价值都为0
        for (int i = 0; i <= wlen; i++) {
            dp[i][0] = value0;
        }
        // 遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i <= wlen; i++) {

            for (int j = 1; j <= bagSize; j++) {
                // 由于value和weight 矩阵是索引从0开始的，但是它们却没有一开始等于0的值，所以，要偏移一下
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        for (int i = 0; i <= wlen; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // 一维dp数组（滚动数组）
    public static void testWeightBagProblem2(int[] weight, int[] value, int bagSize) {
        int wlen = weight.length;
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < wlen; i++) {
            // 背包容量
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        //打印dp数组
        for (int j = 0; j <= bagSize; j++) {
            System.out.print(dp[j] + " ");
        }
    }


    /**
     * 完全背包
     **/
    // 完全背包与01背包的不同就是在背包容量的遍历顺序上
    public static void testCompletePack(int[] weight, int[] value, int bagSize) {
        int wlen = weight.length;
        int[] dp = new int[bagSize + 1];
        // 遍历物品
        for (int i = 0; i < wlen; i++) {
            // 遍历背包容量
            for (int j = weight[i]; j <= bagSize; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println();
        System.out.println("========完全背包===========");
        for (int maxValue : dp) {
            System.out.print(maxValue + "   ");
        }
        System.out.println();
        System.out.println("========完全背包===========");

    }

}
