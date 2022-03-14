package leetcode.栈与队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-13 15:59
 *
 * 用队列实现栈
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 */
public class Demo225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }

}

class MyStack {
    Queue<Integer> A;
    Queue<Integer> B;

    public MyStack() {
        A = new LinkedList<>();
        B = new LinkedList<>();

    }

    public void push(int x) {
        A.offer(x);
    }

    public int pop() {
        if (A.size() == 0){
            return -1;
        }
        int value;
        int len = A.size(), j = 0;
        while (j < len - 1){
            B.offer(A.poll());
            ++j;
        }
        value = A.poll();
        while (!B.isEmpty()){
            A.offer(B.poll());
        }
        return value;
    }

    public int top() {
        int value = 0;
        if (A.size() == 0){
            value = -1;
        }
        int len = A.size(), j = 0;
        while (j < len){
            value = A.poll();
            B.offer(value);
            ++j;
        }
        while (!B.isEmpty()){
            A.offer(B.poll());
        }
        return value;

    }

    public boolean empty() {
        return A.isEmpty();

    }
}
