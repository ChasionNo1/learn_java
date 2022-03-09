package 数据结构和算法刷题.day02;

import java.util.LinkedList;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-27 16:27
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * min()不需要查找，直接返回
 * 借助辅助栈实现
 * 数据栈A:用于正常存储数据
 * 辅助栈：用于存储A的非严格降序元素的子序列
 */
public class Solution2 {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-1);
        int min = stack.min();
        System.out.println(min);
        stack.pop();
        stack.top();
        int min1 = stack.min();
        System.out.println(min1);
    }

}


class MinStack {
    private LinkedList<Integer> A;
    private LinkedList<Integer> B;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void push(int x) {
        A.addLast(x);
        if (B.isEmpty() || x <= B.getLast()){
            B.addLast(x);
        }
    }

    public void pop() {
        Integer y = A.removeLast();
        if (y.equals(B.getLast())){
            B.removeLast();
        }
    }

    public int top() {
        return A.getLast();

    }

    public int min() {
        return B.getLast();
    }
}
