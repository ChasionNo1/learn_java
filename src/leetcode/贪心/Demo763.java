package leetcode.贪心;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Demo763
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/13 17:05
 *
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 */
public class Demo763 {
    public List<Integer> partitionLabels(String s) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] edge = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i] - 'a'] = i;
        }
        int idx = 0;
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            // 随着遍历，不断更新目前最远的索引，如果正好当前的索引等于这个最远的索引，就找到了边界
            idx = Math.max(idx, edge[chars[i] - 'a']);
            if (i == idx){
                // 划分片段的长度
                list.add(i - last);
                last = i;
            }
        }
        return list;

    }
}
