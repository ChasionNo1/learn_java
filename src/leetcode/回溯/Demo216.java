package leetcode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-23 14:53
 *
 * 找出所有相加之和为n 的k个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *
 */
public class Demo216 {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    int sum;

    public static void main(String[] args) {
        Demo216 demo = new Demo216();
        List<List<Integer>> lists = demo.combinationSum3(3, 7);
        for (List<Integer> l:lists
        ){
            System.out.println(l);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        sum = 0;
        backtracking(k, n, 1);
        return res;

    }

    private void backtracking(int k, int n, int startIndex){
        // 在修剪的时候，栈溢出。因为找不到结束递归条件，找到k个数，但不满足，就要结束本层递归换换别的数
//        if (path.size() == k && sum == n){
//            res.add(new ArrayList<>(path));
//            return;
//        }
        if(sum > n){
            return;
        }
        if (path.size() == k){
            if (sum == n){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        // 枝剪
        for (int i = startIndex; i < 10 - (k - path.size()) + 1; i++) {
            path.addLast(i);
            sum += i;
            backtracking(k, n, i + 1);
            path.removeLast();
            sum -= i;
        }
    }


}
