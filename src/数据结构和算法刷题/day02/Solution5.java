package 数据结构和算法刷题.day02;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-28 19:00
 *
 * 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 */
public class Solution5 {
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        int i = maxQueue.max_value();
        System.out.println(i);
        maxQueue.pop_front();
        System.out.println(maxQueue.max_value());
        maxQueue.push_back(3);
        System.out.println(maxQueue.max_value());
    }

}

class MaxQueue {
    // 双向队列，A队列存储数据，B队列管理最大值
    Queue<Integer> A;
    Deque<Integer> B;

    public MaxQueue() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public int max_value() {
        if (B.isEmpty()) {
            return -1;
        } else {
            return B.peek();
        }

    }

    public void push_back(int value) {
        // B队列维持非严格升序
        // 当后续值大时，替换B队列末尾的值，直到当前值小于队列末尾值
        A.offer(value);
        while (!B.isEmpty() && value > B.peekLast()) {
            B.pollLast();
        }
        B.offerLast(value);

    }

    public int pop_front() {
        if (A.isEmpty()) {
            return -1;
        }
        if (A.peek().equals(B.peekFirst())) {
            B.pollFirst();
        }
        return A.poll();
    }
}
