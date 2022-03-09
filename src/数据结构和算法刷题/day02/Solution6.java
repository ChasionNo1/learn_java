package 数据结构和算法刷题.day02;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-28 20:09
 */
public class Solution6 {
    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        int i = solution6.strToInt("-5421 pass node");
        System.out.println(i);

    }

    public int strToInt(String str){
        int res = 0;
        int bndry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = str.length();
        if (length == 0){
            return 0;
        }
        // 跳过前面的空格
        while (str.charAt(i) == ' '){
            if (++i == length){
                return 0;
            }
        }
        // 当出现符号时，sign设置为-1
        if (str.charAt(i) == '-'){
            sign = -1;
        }
        // 跳过符号位
        if (str.charAt(i) == '+' || str.charAt(i) == '-'){
            i++;
        }
        // 判断后续数字
        for (int j = i; j < length; j++) {
            // 如果不是数字，结束循环
            if (str.charAt(j) < '0' || str.charAt(j) > '9'){
                break;
            }
            // 如果超出范围，截断
//            ndry=2147483647//10=214748364
//           情况一：执行拼接10×res≥2147483650越界
//           情况二：拼接后是2147483648或2147483649越界
            // 等于bndry时，最后一位数字要小于等于7才行
            if (res > bndry || res == bndry && str.charAt(j) > '7'){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 4，43，432，将字符串转化为数字
            res = res * 10 + (str.charAt(j) - '0');
        }
        return sign * res;
    }

}
