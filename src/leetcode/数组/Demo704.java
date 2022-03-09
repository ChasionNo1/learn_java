package leetcode.数组;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-04 21:28
 * 二分查找
 */
public class Demo704 {
    public static void main(String[] args) {
        Demo704 demo = new Demo704();
        int[] arr = {-1,0,3,5,9,12};
        int target = 9;
        int index = demo.search(arr, target);
        System.out.println(index);
    }
    public int search(int[] nums, int target) {
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
       return -1;
    }



}
