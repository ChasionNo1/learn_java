package leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-24 16:48
 */
public class Demo93_2 {
    List<String> res;
    StringBuilder sb;

    public static void main(String[] args) {
        Demo93_2 solution = new Demo93_2();
        List<String> strings = solution.restoreIpAddresses("11112");
        System.out.println(strings);
    }


    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        sb = new StringBuilder();
        backtracking(s, 0, 0);
        return res;

    }

    // number表示stringbuilder中ip段的数量
    private void backtracking(String s, int start, int number){
        // 如果到了字符串的末尾并且ip段的数量是4，则加入结果集，并返回
        if (start == s.length() && number == 4){
            res.add(sb.toString());
            return;
        }

        // 如果到了字符串末尾，要结束本层递归，如果ip地址已经有4段了，也要结束本层递归
        // 至于每段是否满足在0-255之间，或者是否最多3位数，在for循环里考虑，如果不满足则直接结束递归
        if (start == s.length() || number == 4){
            return;
        }

        // 相当于单个集合的组合
        for (int i = start; i < s.length(); i++) {
//             ip每段长度小于4
            if (i - start > 3){
                break;
            }
            // 每段在0-255之间
            // 取[start,i]之间的数，看看是否在0-255之间
            int num = Integer.parseInt(s.substring(start, i + 1));
            if (num > 255 || num < 0){
                break;
            }
            // 如果ip段的长度大于1，并且第一位为0的话，continue
            // 像 01. 是非法的，此时字符串长度大于1，且第一位为0
            if (i + 1 - start > 1 && s.charAt(start) - '0' == 0) {
                continue;
            }
            // 此时字段合法，添加
            sb.append(s, start, i + 1);
            // 前三段需要补充一个"."，第四段不需要
            if (number < 3){
                sb.append(".");
            }
            // 点计数加1
            number++;
            // 递归
            backtracking(s, i + 1, number);
            // 回溯
            number--;
            // 删除
            // 10.23.  --> 10.
            // 删除当前stringBuilder最后一个网段，注意考虑点的数量的问题
            // 点的位置为i + 1，删除的长度就是从 [start, i + 1]，number是偏移量
            /*
             * 111123 ---> 1.1.1.123
             * 如果删除后面的123，由于前面加了三个点，使得123的索引向后偏移了三位
             * 所以删除方式如下：
             **/
            sb.delete(start + number, i + number + 2);
        }
    }
}
