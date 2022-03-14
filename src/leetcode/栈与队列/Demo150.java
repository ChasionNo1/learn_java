package leetcode.栈与队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-14 09:06
 *
 * 逆波兰表达式
 *
 */
public class Demo150 {
    public static void main(String[] args) {
        Demo150 demo = new Demo150();
        String[] arr = {"1","2","+","3","-"};
        int i = demo.evalRPN(arr);
        System.out.println(i);
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])){
                stack.push(stack.pop() + stack.pop());
            }else if ("-".equals(tokens[i])){
                stack.push(-stack.pop() + stack.pop());
            }else if ("/".equals(tokens[i])){
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            }else if ("*".equals(tokens[i])){
                stack.push(stack.pop() * stack.pop());
            }else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
