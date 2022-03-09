package 数据结构和算法刷题.查找;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-03 14:54
 *
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] arr = {5,7,7,8,8,10};
        int search = solution4.search(arr, 8);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0){
            return 0;
        }

        int firstPosition = findFirstPostion(nums, target);
        if (firstPosition == -1){
            return 0;
        }

        int lastPosition = findLastPostion(nums, target);
        if (lastPosition == -1){
            return 0;
        }
        return lastPosition - firstPosition + 1;

    }

    private int findFirstPostion(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right){
            // 当出现两个连续的 8 8，mid就是第一个8，也就是left的位置
            int mid = (left + right) / 2;
            if (nums[mid] < target){
                // 下一轮搜索空间为[mid+1,right]
                left = mid + 1;
            }else if (nums[mid] == target){
                // 下一轮搜索空间为[left,mid]
                right = mid;
            }else {
                right = mid - 1;
            }
        }
        if (nums[left] == target){
            return left;
        }
        return -1;
    }
    private int findLastPostion(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right){
            // 这里为什么向上取整
            // 当出现连续的 8 8，mid是第二个8，也就是8的LastPostion
            int mid = (left + right + 1) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] == target){
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

}
