package leetcode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-23 09:59
 * <p>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 */
public class Demo77 {
    List<List<Integer>> res;
    LinkedList<Integer> path;

    public static void main(String[] args) {
        Demo77 demo = new Demo77();
        List<List<Integer>> list = demo.combine(4, 2);
        for (List<Integer> l:list
        ){
            System.out.println(l);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        backtracking(n, k, 1);
        return res;


    }

    private void backtracking(int n, int k, int startIndex) {
        if (path.size() == k){
            // 创建一个新的path对象，保存当前的结果
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.addLast(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }

    }
}
