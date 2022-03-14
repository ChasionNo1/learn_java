package leetcode.栈与队列;

import java.util.LinkedList;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-13 19:27
 *
 * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 */
public class Demo1047 {
    public static void main(String[] args) {
        Demo1047 demo = new Demo1047();
        String s = demo.removeDuplicates("abbacd");
        System.out.println(s);
    }


    public String removeDuplicates(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.getLast() == ch){
                // 当栈不为空时，栈顶元素和当前元素相同，剔除这两个
                stack.removeLast();
            }else {
                stack.offer(ch);
            }
        }
        if (stack.size() == 0){
            return "";
        }
        char[] chars = new char[stack.size()];
        int j = stack.size() - 1;
        while (!stack.isEmpty()){
            chars[j--] = stack.removeLast();
        }
        return String.valueOf(chars);

    }

}
