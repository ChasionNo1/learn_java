package 数据结构和算法刷题.查找;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-03 18:58
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 */
public class Solution5 {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int[] arr = {0, 1, 2, 4, 5, 6, 7};
        int i = solution5.missingNumber(arr);
        System.out.println(i);
    }


    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j){
            int mid = (i + j) / 2;
            System.out.println("nums=" + nums[mid]);
            System.out.println("mid" + mid);
           if (nums[mid] == mid){
               // 当满足这个条件时，一定是不丢失数字的，向右搜索
               // 当i == j时，且nums[mid] == mid，那么后一个就是缺失的数字
               i = mid + 1;
           }else {
               j = mid - 1;
           }
        }
        return i;
    }
}
