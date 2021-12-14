package day04_review.demo02_java常用类.字符串相关的类.exer1;

/**
 * 获取两个字符串中最大相同子串。比如：
 * str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
 * 提示：将短的那个串进行长度依次递减的子串与较长的串比较。
 *
 * @program: test
 * @author: chasion
 * @create: 2021-12-14 08:54
 */
public class GetMaxSampleSubSequence {
    public static void main(String[] args) {
        StringBuilder subSeq = getSubSeq("abcwerthelloeeyuiodef", "abcwevhellobnm");
        System.out.println(subSeq);
    }

    public static StringBuilder getSubSeq(String source, String sub) {
        // 字串的长度依次递减，同时滑动窗口去搜索
        boolean isFlag = false;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = sub.length(); i > 0; i--) {
            for (int j = 0; j <= sub.length() - i; j++) {
                String str = sub.substring(j, i + j);
                // 没有考虑多个相同长度的字串
                if (source.contains(str)) {
                    stringBuilder.append(str + " ");
                    isFlag = true;
                }
                if (isFlag && j == (sub.length() - i)){
                    return stringBuilder;
                }
            }
        }
        return new StringBuilder("没有找到");
    }
}

