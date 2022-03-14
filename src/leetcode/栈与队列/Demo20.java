package leetcode.栈与队列;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-13 16:58
 *
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 */
public class Demo20 {


    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '('){
                deque.push(')');
            }else if (ch == '{'){
                deque.push('}');
            }else if (ch == '['){
                deque.push(']');
                // 还没未匹配完。栈已经空了，还剩很多右括号
                // 栈里的元素没有要匹配的
            }else if (deque.isEmpty() || deque.peek() != ch){
                return false;
            }else {
                deque.pop();
            }
        }
        // 栈不为空，匹配结束了
        return deque.isEmpty();
    }

    public boolean isValid1(String s){
        int n = s.length();
        // 数量不对称
        if (n % 2 == 1){
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Deque<Character> stack = new LinkedList<>();
        // ([{}]))
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // 包含的是右括号
            if (map.containsKey(ch)){
                if (stack.isEmpty() || stack.peek() != map.get(ch)){
                    return false;
                }
                stack.pop();
                // 不包含的是左括号，左括号进栈
            }else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
