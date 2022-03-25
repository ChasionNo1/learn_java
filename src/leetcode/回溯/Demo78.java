package leetcode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-24 20:53
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Demo78 {
    List<List<Integer>> res;
    LinkedList<Integer> temp;

    public static void main(String[] args) {
        Demo78 demo = new Demo78();
        int[] arr = {1, 2, 3};
        List<List<Integer>> lists = demo.subsets(arr);
        for (List<Integer> l:lists
        ){
            System.out.println(l);
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        temp = new LinkedList<>();
        res.add(new ArrayList<>());
        backtracking(nums, 0);
        return res;

    }

    private void backtracking(int[] nums, int startIndex){
        if (startIndex > nums.length - 1){
//            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            temp.addLast(nums[i]);
//            System.out.println("i = "  +  i  + ",temp " + temp);
            res.add(new ArrayList<>(temp));
            backtracking(nums, i + 1);
            temp.removeLast();
        }
    }
}
