package leetcode.动态规划;

import java.util.Arrays;

/**
 * @ClassName Demo494
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/17 11:04
 */
public class Demo494 {
    public static void main(String[] args) {
        Demo494 demo = new Demo494();
        int[] arr = {1,1,1,1,1};
        int res = demo.findTargetSumWays(arr, 3);
        System.out.println(res);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 == 1 || Math.abs(target) > sum){
            return 0;
        }
        int x = (sum + target) / 2;
        if (x < 0) x = - x;
        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = x; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[x];

    }
}
