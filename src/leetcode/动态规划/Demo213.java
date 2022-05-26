package leetcode.动态规划;

import java.util.Arrays;

/**
 * @ClassName Demo213
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/25 9:20
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 */
public class Demo213 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Demo213 demo = new Demo213();
        int res = demo.rob(nums);
        System.out.println(res);
    }
    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        // 长度大于3时，考虑两种情况
        return Math.max(robRoom(nums, 0 , nums.length - 1), robRoom(nums, 1, nums.length));


    }

    /**
     * 每一种情况的计算和普通打家劫舍一致，只不过是数组范围不同
     * 数组长度为 n
     * (0, n-1)
     * */
    public int robRoom(int[] nums, int start, int end){
        int[] dp = new int[end - start + 1];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[end - 1];
    }

}
