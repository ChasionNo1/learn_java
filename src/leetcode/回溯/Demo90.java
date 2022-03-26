package leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-25 16:05
 *
 * 子集II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 */
public class Demo90 {
    List<List<Integer>> res;
    LinkedList<Integer> temp;

    public static void main(String[] args) {
        Demo90 demo = new Demo90();
        int[] arr = {1, 2, 2};
        List<List<Integer>> lists = demo.subsetsWithDup(arr);
        for (List<Integer> list:lists
             ) {
            System.out.println(list);
        }
    }



    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        temp = new LinkedList<>();
        // 要排序
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        res.add(new ArrayList<>());
        backtracking(nums, 0, used);
        return res;



    }
    private void backtracking(int[] nums, int startIndex, boolean[] used){
        if (startIndex > nums.length - 1){
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            // 同层去重
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            temp.addLast(nums[i]);
            res.add(new ArrayList<>(temp));
            used[i] = true;
            backtracking(nums, i + 1, used);
            temp.removeLast();
            used[i] = false;
        }
    }
}
