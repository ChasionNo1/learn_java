package leetcode.贪心;

import java.util.*;

/*
1005. K 次取反后最大化的数组和
给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：

选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
重复这个过程恰好 k 次。可以多次选择同一个下标 i 。

以这种方式修改数组后，返回数组 可能的最大和 。
* */
public class Demo1005 {
    public static void main(String[] args) {
        int[] arr = {2,-3,-1,5,-4};
        Demo1005 demo = new Demo1005();
        int res = demo.largestSumAfterKNegations(arr, 2);
        System.out.println(res);
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        // 如果在每一次的转换中都重新排序，复杂度太高了
        // 可以按照绝对值排序，这样就可以保证变化后的顺序不变了
        nums = Arrays.stream(nums).boxed().sorted(((o1, o2) -> Math.abs(o1) - Math.abs(o2))).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(nums));
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < 0 && k > 0){
                nums[i] = -nums[i];
                k--;
            }
        }
        // 如果k还剩，剩余偶数个，则抵消改变，奇数个则反转一个
        if (k % 2 == 1){
            nums[0] = -nums[0];
        }
        return Arrays.stream(nums).sum();


    }
}
