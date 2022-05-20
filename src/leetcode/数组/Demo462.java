package leetcode.数组;

import java.util.Arrays;

/**
 * @ClassName Demo462
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/19 10:22
 * <p>
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
 * <p>
 * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
 */
public class Demo462 {
    public static void main(String[] args) {
        Demo462 demo = new Demo462();
        int[] nums = {1, 1, 2};
        int res = demo.minMoves2(nums);
        System.out.println(res);

    }

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        int mid = nums[N / 2];
        int res = 0;
        for (int n : nums) {
            res += Math.abs(n - mid);
        }
        return res;
    }


}
