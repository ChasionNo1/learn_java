package leetcode.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-10 09:18
 *
 * 三数之和
 *
 */
public class Demo15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3){
            return list;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0){
                return list;
            }
            // 跳过i重复元素
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0){
                    --right;
                }else if (sum < 0){
                    ++left;
                }else {
                    // 如果相等
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // left和right的重复元素
                    while (right > left && nums[right] == nums[right - 1]) --right;
                    while (right > left && nums[left] == nums[left + 1]) ++left;
                    ++left;
                    --right;
                }
            }
        }
        return list;
    }
}
