package leetcode.动态规划;

import java.util.List;

/**
 * @ClassName Demo139
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/23 9:51
 *
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 */
public class Demo139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int capacity = s.length();
        boolean[] dp = new boolean[capacity + 1];
        dp[0] = true;
        // 外层遍历字符串容量
        for (int i = 1; i <= capacity; i++) {
            // 内层遍历物品，i上容量，而j从0开始索引，所以小于i是字串长度
            for (int j = 0; j < i; j++) {
                // 如果之前的在字典里，且(j,i)也在
                if (wordDict.contains(s.substring(j, i)) && dp[j]){
                    dp[i] = true;
                }
            }
        }
        return dp[capacity];
    }
}
