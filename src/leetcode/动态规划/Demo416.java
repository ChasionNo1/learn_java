package leetcode.动态规划;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @ClassName Demo416
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/16 10:44
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class Demo416 {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int[] dp = new int[sum / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            // 倒序
            for (int j = sum / 2; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[sum / 2] == sum / 2;
    }


    @Test
    public void test() {
        int i = 10;
        int j = i / 2;
        System.out.println(j);
    }
}
