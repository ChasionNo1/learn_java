package 数据结构和算法刷题.排序;

import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-02 21:50
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        // 30 3 35 5 9
        Solution2 solution2 = new Solution2();
        String s = solution2.minNumber(arr);
        System.out.println(s);
    }


    public String minNumber(int[] nums) {
        // 对数组排序

        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (String o1, String o2)->{return -(o2+o1).compareTo(o1+o2);});
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();


    }


}
