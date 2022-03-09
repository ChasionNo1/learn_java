package 数据结构和算法刷题.查找;

import java.util.HashMap;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-03 10:36
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *

 */
public class Solution1 {


    public static int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
//                Integer value = map.get(nums[i]);
//                map.put(nums[i], ++value);
                return nums[i];
            }else {
                map.put(nums[i], 1);
            }
        }
        return -1;
    }
}
