package leetcode.数组;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-04 21:46
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 */
public class Demo35 {
    public static void main(String[] args) {
        Demo35 demo = new Demo35();
        int[] arr = {1,3};
        int target = 2;
        int index = demo.searchInsert(arr, target);
        System.out.println(index);
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) >>> 1;
            if (nums[mid] > target){
                // target在mid左侧
                end = mid - 1;
            }else if (nums[mid] < target){
                start = mid + 1;
            }else {
                return mid;
            }
        }
        return end + 1;

    }
}
