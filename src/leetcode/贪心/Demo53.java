package leetcode.贪心;
/*
53. 最大子数组和
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

子数组 是数组中的一个连续部分。
* */
public class Demo53 {
    public static void main(String[] args) {
        Demo53 demo = new Demo53();
        int[] arr = {-2, -1};
        int res = demo.maxSubArray(arr);
        System.out.println(res);
    }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if (sum <= 0){
                sum = 0;
            }
        }
        return maxSum;
    }
}
