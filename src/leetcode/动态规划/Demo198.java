package leetcode.动态规划;

import java.util.Arrays;

/**
 * @ClassName Demo198
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/23 10:35
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 */
public class Demo198 {


    public int rob(int[] nums) {
        int size = nums.length;
        if (size == 1){
            return nums[0];
        }
        int[] dp = new int[size];
        dp[0] = nums[0];
        // dp[1]取前两个的最大值，长度为2的情况
        dp[1] = Math.max(nums[0], nums[1]);
        // 这里长度大于2了
        for (int i = 2; i < size; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[size - 1];

    }
}
