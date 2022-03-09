package leetcode.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-09 15:55
 *
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * 同一组字母异位词中的字符串具备相同点，可以使用相同点作为一组字母异位词的标志，
 * 使用哈希表存储每一组字母异位词，哈希表的键为一组字母异位词的标志，哈希表的值为一组字母异位词列表。
 * 遍历每个字符串，对于每个字符串，得到该字符串所在的一组字母异位词的标志，
 * 将当前字符串加入该组字母异位词的列表中。遍历全部字符串之后，哈希表中的每个键值对即为一组字母异位词。
 *
 */
public class Demo49 {

    // 排序
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s :
                strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            // 将排序后的字符数组转为字符串，用于字母异位组的key
            String key = new String(chars);
            // 用key去查找，如果没有就创建一个list，有则返回
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    // 计数
    public List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s :
                strs) {
            int[] count = new int[26];
            for (char c :
                    s.toCharArray()) {
                count[c - 'a'] += 1;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuilder sb = new StringBuilder();
            for (int i :
                    count) {
                if (i != 0){
                    // 字母和出现的次数
                    sb.append((char) ('a' + i));
                    sb.append(i);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }


}
