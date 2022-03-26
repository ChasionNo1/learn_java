package leetcode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-26 13:12
 * 全排列
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Demo46 {
    List<List<Integer>> res;
    LinkedList<Integer> temp;

    public static void main(String[] args) {
        Demo46 demo = new Demo46();
        int[] arr = {1, 2, 3};
        List<List<Integer>> lists = demo.permute(arr);
        for (List<Integer> list:lists
        ) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        temp = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return res;


    }

    private void backtracking(int[] nums, boolean[] used){
        if (temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 因为每次递归都是从0开始的，所以如果一个元素添加过，例如：1  ->  [1,2,3]，从1开始考虑添加，由于1
            // 添加过了，直接跳过，考虑2，以此类推
            if (!used[i]){
                temp.addLast(nums[i]);
            }else {
                continue;
            }
            used[i] = true;
            backtracking(nums, used);
            temp.removeLast();
            used[i] = false;
        }
    }
}
