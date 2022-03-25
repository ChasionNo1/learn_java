package leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-24 15:30
 *
 * 复原 IP 地址
 */
public class Demo93 {
    List<String> res;
    StringBuilder sb;
    int pointNum;

    public static void main(String[] args) {
        Demo93 demo = new Demo93();
        List<String> strings = demo.restoreIpAddresses("25525511135");
        System.out.println(strings);
    }

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        sb = new StringBuilder();
        pointNum = 0;
        if (s.length() > 12){
            return res;
        }
        backtracking(s, 0, 0);
        return res;

    }

    private void backtracking(String s, int startIndex, int pointNum){
        if (pointNum == 3){
            // 判断第四段子字符串是否合法，如果合法就放进result中
            if (isValid(s, startIndex, s.length() - 1)){
                res.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)){
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum++;
                backtracking(s, i + 2, pointNum);
                pointNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            }else {
                break;
            }
        }
    }

    // 判断每个段位是否合法
//    段位以0为开头的数字不合法
//    段位里有非正整数字符不合法
//    段位如果大于255了不合法
    private boolean isValid(String s, int start, int end){
        if (start > end){
            return false;
        }
        // 0开头的数字不合法
        if (s.charAt(start) == '0' && start != end){
            return false;
        }
        int num = 0;
        // 遍历每一个字符，是否是数字，以及最终结果是否在255内
        for (int i = start; i <= end; i++) {
            // 遇到⾮数字字符不合法
            if (s.charAt(i) > '9' || s.charAt(i) < '0'){
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255){
                return false;
            }

        }
        return true;

    }
}

