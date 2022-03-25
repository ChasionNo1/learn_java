package leetcode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-24 14:58
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class Demo131 {

    List<List<String>> res;
    LinkedList<String> temp;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        temp = new LinkedList<>();
        backtracking(s, 0);
        return res;


    }

    private void backtracking(String s, int index){
        // 递归结束条件，到字符串末尾，判断结束
        if (index >= s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }

        //
        for (int i = index; i < s.length(); i++) {
            // 判断是否为回文串，是，就添加，不是就结束本层递归
            if (isPalindrome(s, index, i)){
                String str = s.substring(index, i + 1);
                temp.addLast(str);
            }else {
                continue;
            }
            backtracking(s, i + 1);
            temp.removeLast();
        }
    }
    // 双指针判断是否为回文串
    private boolean isPalindrome(String s, int start, int end){
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
