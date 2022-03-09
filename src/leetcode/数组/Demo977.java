package leetcode.数组;

import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-05 20:58
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class Demo977 {
    public static void main(String[] args) {
        Demo977 demo = new Demo977();
        int[] arr = {-7, -3, 2, 3, 11};
        int[] ints = demo.sortedSquares(arr);
        System.out.println(Arrays.toString(ints));


    }
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            // 每次哪个大保存哪个
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;


    }
}
