package leetcode.字符串;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-12 14:09
 *
 * KMP
 *
 */
public class Demo28 {
    public int strStr(String haystack, String needle){
        char[] t = haystack.toCharArray();
        char[] p = needle.toCharArray();
        // 空字符串时我们应当返回 0
        if (needle.length() == 0){
            return 0;
        }
        int i = 0;  // 主串指针
        int j = 0;  // 模式串指针

        int[] next = getNext(needle);
        while (i < t.length && j < p.length){
            // 两个指针前移的条件:两个字符匹配或者j=-1
            // j = -1就是在开头，两个串开头开始匹配
            if (j == -1 || t[i] == p[j]){
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        /*
        结束循环的情况，j指针到最后一位了，同时也匹配成功，进入if语句
        j++后就等于p.length
        没找到的情况，从开头匹配到结尾，j等于-1，进入到if语句
        i++结束循环，

        如果当j指针一直在第一个位置上，此时又一直匹配不到时，i指针前移，但如果
        当i指针后面的字符串长度小于子串时，能跳出循环吗？

        * */
        if (j == p.length){
            return i-j;
        }else {
            return -1;
        }
    }
    public static int[] getNext(String ps){
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1){
            if (k == -1 || p[j] == p[k]){
                if (p[++j] == p[++k]){
                    // 当两个字符相同时，要跳过
                    // A B C D A B C D，当最后一个D已经不匹配了，再把指针移动到第一个D时，还要根据前一个D接着找，所以可以跳过到第一个D的位置上
                    // 直接从D的位置开始找即可
                    next[j] = next[k];
                }else {
                    next[j] = k;
                }
            }else {
                k = next[k];
            }
        }
        return next;
    }
}
