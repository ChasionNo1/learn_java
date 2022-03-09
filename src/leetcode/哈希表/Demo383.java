package leetcode.哈希表;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-09 15:19
 * <p>
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
public class Demo383 {
    public static void main(String[] args) {
        Demo383 demo = new Demo383();
        boolean b = demo.canConstruct("aa", "aab");
        System.out.println(b);
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] record = new int[26];
        for (char c :
                magazine.toCharArray()) {
                record[c - 'a'] += 1;
        }
        for (char c :
                ransomNote.toCharArray()) {
            record[c - 'a'] -= 1;
        }

        for (int i :
                record) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
