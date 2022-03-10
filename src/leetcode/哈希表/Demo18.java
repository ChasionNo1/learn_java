package leetcode.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-10 10:02
 * <p>
 * 四数之和
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 */
public class Demo18 {
    public static void main(String[] args) {
        Demo18 demo = new Demo18();
        int[] arr = {2, 2, 2, 2, 2};
        int target = 8;
        List<List<Integer>> lists = demo.fourSum(arr, target);
        System.out.println(lists);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return list;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 跳过i的重复元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 跳过j的重复元素
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        --right;
                    } else if (sum < target) {
                        ++left;
                    } else {
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (right > left && nums[right] == nums[right - 1]) --right;
                        while (right > left && nums[left] == nums[left + 1]) ++left;

                        --right;
                        ++left;
                    }
                }

            }
        }
        return list;

    }
}
