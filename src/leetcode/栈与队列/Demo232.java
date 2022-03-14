package leetcode.栈与队列;

import java.util.LinkedList;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-13 10:17
 *
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 */
public class Demo232 {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        int peek = queue.peek();
        System.out.println(peek);
        int pop = queue.pop();
        System.out.println(pop);

    }

}

class MyQueue {
    // A是进栈，B是出栈
    LinkedList<Integer> A;
    LinkedList<Integer> B;

    public MyQueue() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void push(int x) {
        A.addLast(x);
    }

    public int pop() {
        // 出栈
        int value;
        if (A.isEmpty()){
            return -1;
        }else {
            while (!A.isEmpty()){
                B.addLast(A.removeLast());
            }
            value = B.removeLast();
            while (!B.isEmpty()){
                A.addLast(B.removeLast());
            }
        }
        return value;
    }

    public int peek() {
        int value;
        if (A.isEmpty()){
            return -1;
        }else {
            while (!A.isEmpty()){
                B.addLast(A.removeLast());
            }
            value = B.getLast();
            while (!B.isEmpty()){
                A.addLast(B.removeLast());
            }
        }
        return value;
    }

    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
