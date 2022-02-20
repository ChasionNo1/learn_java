package 数据结构与算法.串;


import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/14 13:38
 **/
public class KMPMatch {
    public static void main(String[] args) {
//        String ts = "abcdefabd";
//        String ps = "abd";
//        System.out.println(KMP(ts, ps));
        String s = "abacdababc";
        int[] next = getNext(s);
        System.out.println(Arrays.toString(next));
    }

    public static int KMP(String ts, String ps){
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        int i = 0;  // 主串指针
        int j = 0;  // 模式串指针
        int[] next = getNext(ps);
        while (i < t.length && j < p.length){
            // 两个指针前移的条件:两个字符匹配或者j=-1
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

    @Test
    public void test1(){
        int[] arr = {1, 2, 3, 4};
        int j = 0;
//        System.out.println(arr[++j]);
        System.out.println(arr[j++]);
    }
}
