package leetcode.回溯;

import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-23 16:36
 * <p>
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Demo17 {
    List<String> res;
    String[] numString;
    StringBuilder sb;

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        // 数字和字母的映射
        numString = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        sb = new StringBuilder();
        backtracking(digits, 0);
        return res;

    }

    private void backtracking(String digits, int index) {
        // 如果索引到字符串的结尾，就可以结束了
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String str = numString[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backtracking(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);

        }
    }
}
