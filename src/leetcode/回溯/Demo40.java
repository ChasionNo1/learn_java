package leetcode.回溯;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-24 10:20
 * <p>
 * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * <p>
 * candidates中的每个数字在每个组合中只能使用一次。
 * <p>
 * 注意：解集不能包含重复的组合。
 */
public class Demo40 {
    List<List<Integer>> res;
    LinkedList<Integer> temp;
    int sum;

    public static void main(String[] args) {
        Demo40 demo = new Demo40();
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = demo.combinationSum2(arr, target);
        for (List<Integer> l:lists
        ){
            System.out.println(l);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        temp = new LinkedList<>();
        sum = 0;
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backtracking(candidates, target, used, 0);
        return res;


    }

    private void backtracking(int[] candidates, int target, boolean[] used, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length && sum + candidates[i] <= target; i++) {
            //出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            // used[i - 1] == true，说明同一树枝candidates[i - 1]使用过，因为在一次递归中标记，
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过，使用过在回溯时标记为false了，所以同层是false
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            sum += candidates[i];
            temp.addLast(candidates[i]);
            backtracking(candidates, target, used, i + 1);
            sum -= candidates[i];
            temp.removeLast();
            used[i] = false;
        }
    }
}
