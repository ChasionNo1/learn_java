package leetcode.数组;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-06 21:34
 *
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 */
public class Demo209 {
    public static void main(String[] args) {
        Demo209 demo = new Demo209();
        int[] arr = {2, 3, 1, 2, 4, 3};
        int length = demo.minSubArrayLen(7, arr);
        System.out.println(length);
    }

    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int start = 0, end = 0, sum = 0;
        int ans = Integer.MAX_VALUE;
        // 遍历完一遍
        while (end < nums.length){
            // 从0开始，叠加求和
            sum += nums[end];
            // 如果滑动区间和大于目标值
            while (sum > target){
                // 比较得到最小的区间长度
                ans = Math.min(ans, end - start + 1);
                // 去掉区间开头元素
                sum -= nums[start];
                // 头指针后移
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
