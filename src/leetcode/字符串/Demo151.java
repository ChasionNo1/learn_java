package leetcode.字符串;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-11 10:04
 *
 * 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 *
 */
public class Demo151 {
    public static void main(String[] args) {
        Demo151 demo = new Demo151();
        String s = demo.reverseWords("  Bob    Loves  Alice   ");
        System.out.println(s);
    }

    public String reverseWords(String s) {
        // 1、移除多余空格
        StringBuilder sb = removeSpace(s);
//        System.out.println(sb);
        // 2、将整个字符串反转
        reverseString(sb, 0, sb.length() - 1);
        // 3、将每个单词反转
        reverseEachWords(sb);

        return sb.toString();

    }

    private void reverseEachWords(StringBuilder sb) {
        // 反转每个单词
        // 找到每个单词的开始和结束位置
        int start = 0, end = 0;
        while (start < sb.length()){
            // 找到一个单词结束位置，最有一个单词结束时，因为长度不符合跳出循环
            while (end < sb.length() && sb.charAt(end) != ' '){
                ++end;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            ++end;
        }
    }

    private StringBuilder removeSpace(String s){
        int start = 0;
        int end = s.length() - 1;
        // 去除两端的空格
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;

        // 去除中间的空格
        StringBuilder sb = new StringBuilder();
        while (start <= end){
            // 将内容每个单词组添加到sb中
            char c = s.charAt(start);
            // 如果当前字符不是空的，或者当前字符的前一个不为空
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' '){
                sb.append(c);
            }
            ++start;
        }
        return sb;
    }

    private void reverseString(StringBuilder sb, int start, int end){
        while (start <= end){
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            ++start;
            --end;
        }
    }

}
