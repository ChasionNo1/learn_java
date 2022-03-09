package leetcode.数组;

import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-04 19:56
 *
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 *
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] arr = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(arr));
        solution2.sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; i++) {
            /*
             *
             * 两个指针分别维护0和1的位置，当出现0或者1时就要往前放，但0要放在1前面
             * 如果前面放了1后面再遇到0时，需要将放1的位置和0交换，然后再这个1交换到p1处
             *
             **/
            if (nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            }else if (nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1){
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                // 放0时，p0和p1指针同时移动的，所以不会出现p1在p0的后面
                ++p0;
                ++p1;
            }
        }

    }

}
