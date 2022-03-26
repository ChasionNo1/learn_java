package leetcode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-25 19:48
 * <p>
 * 递增子序列
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * <p>
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 */
public class Demo491 {
    List<List<Integer>> res;
    LinkedList<Integer> temp;

    public static void main(String[] args) {
        Demo491 demo = new Demo491();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 1};
        List<List<Integer>> lists = demo.findSubsequences(arr);
        for (List<Integer> list : lists
        ) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();
        temp = new LinkedList<>();
        backtracking(nums, 0);
        return res;

    }


    public void backtracking(int[] nums, int startIndex) {
        if (temp.size() > 1) {
            res.add(new ArrayList<>(temp));
        }

        int[] used = new int[201];
        for (int i = startIndex; i < nums.length; i++) {
            if (!temp.isEmpty() && nums[i] < temp.getLast() || (used[nums[i] + 100] == 1)){
                continue;
            }
            used[nums[i] + 100] = 1;
            temp.addLast(nums[i]);
            backtracking(nums, i + 1);
            temp.removeLast();

        }
    }
}
