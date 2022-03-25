package leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-24 09:02
 *
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，
 * 找出candidates中可以使数字和为目标数target 的所有不同组合 ，并以列表形式返回。你可以按 任意顺序返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 *
 */
public class Demo39 {
    List<List<Integer>> res;
    LinkedList<Integer> temp;
    int sum;

    public static void main(String[] args) {
        Demo39 demo = new Demo39();
        int[] arr = {2, 3, 6, 7};
        List<List<Integer>> lists = demo.combinationSum(arr, 7);
        for (List<Integer> l:lists
        ){
            System.out.println(l);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        temp = new LinkedList<>();
        sum = 0;
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return res;

    }
    private void backtracking(int[] candidates, int target, int index){
        // 枝剪，需要先从小到大排序，如果此时，sum大于target，后序的也一定大，可以结束循环
//        if (sum > target){
//            return;
//        }
        if (sum == target){
            res.add(new ArrayList<>(temp));
            return;
        }
        // 枝剪，需要先从小到大排序，如果此时，sum大于target，后序的也一定大，可以结束循环
        for (int i = index; i < candidates.length && sum + candidates[i] <= target; i++) {
//            if (sum + candidates[i] > target) break;
            temp.add(candidates[i]);
            sum += candidates[i];

            backtracking(candidates, target, i);
            sum -= candidates[i];
            temp.remove(temp.size() - 1);
        }
    }
}
