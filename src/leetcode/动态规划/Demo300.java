package leetcode.动态规划;

import java.util.Arrays;

/**
 * @ClassName Demo300
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/31 10:10
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 */
public class Demo300 {
    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        Demo300 demo = new Demo300();
        int res = demo.lengthOfLIS(nums);
        System.out.println(res);
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().getAsInt();

    }
}
