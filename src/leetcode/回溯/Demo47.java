package leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-26 13:30
 *
 * 全排列II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class Demo47 {
    List<List<Integer>> res;
    LinkedList<Integer> temp;

    public static void main(String[] args) {
        Demo47 demo = new Demo47();
        int[] arr = {1, 1, 2};
        List<List<Integer>> lists = demo.permuteUnique(arr);
        for (List<Integer> list:lists
        ) {
            System.out.println(list);
        }
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        temp = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums, used);
        return res;

    }

    private void backtracking(int[] nums, boolean[] used){
        // 同枝去重和同层去重
        if (temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 同枝去重和同层去重
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1] || used[i]){
                continue;
            }else {
                temp.addLast(nums[i]);
            }
            used[i] = true;
            backtracking(nums, used);
            temp.removeLast();
            used[i] = false;
        }
    }
}
