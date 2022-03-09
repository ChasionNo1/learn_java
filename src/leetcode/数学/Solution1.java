package leetcode.数学;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-03 20:30
 *
 * 258.各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int i = solution1.addDigits(22);
        System.out.println(i);
    }

    public int addDigits(int num) {
//        String s = String.valueOf(num);
//        while (s.length() > 1){
//            int sum = 0;
//            for (char c :
//                    s.toCharArray()) {
//                sum += c - '0';
//            }
//            s = String.valueOf(sum);
//        }
//        return Integer.parseInt(s);
        return (num - 1) % 9 + 1;


    }
}
