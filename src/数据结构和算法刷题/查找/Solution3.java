package 数据结构和算法刷题.查找;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-03 14:29
 *
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        char c = solution3.firstUniqChar("leetcode");
        System.out.println(c);
    }


    public char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char c :
                s.toCharArray()) {
            if (map.containsKey(c)){
                Integer value = map.get(c);
                map.put(c, ++value);
            }else {
                map.put(c, 1);
            }
        }
        System.out.println(map);

        Set<Character> characters = map.keySet();
        Iterator<Character> iterator = characters.iterator();
        while (iterator.hasNext()){
            Character next = iterator.next();
            System.out.println(next);
            Integer value = map.get(next);
            if (value == 1){
                return next;
            }
        }
        return ' ';
    }
}
