package leetcode.哈希表;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @ClassName Demo953
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/18 9:14
 * <p>
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 */
public class Demo953 {
    public static void main(String[] args) {
        Demo953 demo = new Demo953();
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        boolean alienSorted = demo.isAlienSorted(words, order);
        System.out.println(alienSorted);
    }

    public boolean isAlienSorted(String[] words, String order) {
        // 将新的顺序映射好
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        // 将每个单词映射成一个新的顺序
        String[] newOrder = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                // 判断每个单词里的字符是否出现在map里
                if (map.containsKey(words[i].charAt(j))) {
                    tmp.append((char) (map.get(words[i].charAt(j)) + 'a'));
                }
            }
            newOrder[i] = tmp.toString();
        }
        for (int i = 0; i < newOrder.length - 1; i++) {
            if (newOrder[i].compareTo(newOrder[i + 1]) > 0){
                return false;
            }
        }
        return true;

    }

}
