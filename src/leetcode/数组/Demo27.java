package leetcode.数组;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-05 20:43
 *
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *

 */
public class Demo27 {
    public static void main(String[] args) {
        int[] arr = {3, 3};
        Demo27 demo = new Demo27();
        int length = demo.removeElement(arr, 3);
        System.out.println(length);
    }

    public int removeElement(int[] nums, int val) {
        int i = 0, j = -1;
        while (i < nums.length){
            if (nums[i] != val){
                nums[++j] = nums[i];
            }
            ++i;
        }
        return j + 1;
    }
}
