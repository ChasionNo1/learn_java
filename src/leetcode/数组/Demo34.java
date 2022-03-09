package leetcode.数组;

import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-05 14:45
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 */
public class Demo34 {
    public static void main(String[] args) {
        Demo34 demo = new Demo34();
        int[] arr = {0, 1, 2, 2, 2, 3};
        int target = 2;
        int[] ints = demo.searchRange(arr, target);
        System.out.println(Arrays.toString(ints));
    }


    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0){
            return new int[]{-1, -1};
        }

        int first = firstIndexSearch(nums, target);
        if (first == -1){
            return new int[]{-1, -1};
        }

        int last = lastIndexSearch(nums, target);
        if (last == -1){
            return new int[]{-1, -1};
        }

        return new int[]{first, last};

    }

    public int lastIndexSearch(int[] nums, int target){
        int start = 0, end = nums.length - 1;
        while (start < end){
            int mid = (start + end + 1) >>> 1;
            if (nums[mid] > target){
                // 在左侧
                end = mid - 1;
            }else if (nums[mid] == target){
                // 继续二分查找
                start = mid;
            }else {
                // 在右侧
                start = mid + 1;
            }
        }
        return start;
    }

    public int firstIndexSearch(int[] nums, int target){
        int start = 0, end = nums.length - 1;
        while (start < end){
            int mid = (start + end) >>> 1;
            if (nums[mid] > target){
                // 在左侧
                end = mid - 1;
            }else if (nums[mid] == target){
                // 继续二分查找
                end = mid;
            }else {
                // 在右侧
                start = mid + 1;
            }
        }
        if (nums[start] == target){
            // 跳出循环时，start == end == mid
            return start;
        }
        // 没有找到
        return -1;
    }
}
