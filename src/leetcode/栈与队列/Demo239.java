package leetcode.栈与队列;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-14 10:02
 * <p>
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 */
public class Demo239 {
    public static void main(String[] args) {
        Demo239 demo = new Demo239();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = demo.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int j = 0;
        MyQueue1 myQueue = new MyQueue1();
        // 先把窗口造好
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[j++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            // 每次循环就是一次滑动
            //滑动窗口移除最前面的元素
            //自定义函数判断移除元素是否和对顶元素相同，是的话，队列中元素也要poll
            myQueue.poll(nums[i - k]);
            //滑动窗口加入最后面的元素，加入元素是否和队顶最大值相同，是则替换
            myQueue.add(nums[i]);
            res[j++] = myQueue.peek();
        }
        return res;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        // 解法2：利用双端队列手动实现单调队列
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int j = 0;
        for (int i = 0; i < n; i++) {
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // deque存放的是最大值的下标
            deque.offer(i);
            if (i >= k - 1) {
                res[j++] = nums[deque.peek()];
            }
        }
        return res;
    }
}

// 解法一：自定义数组
class MyQueue1 {
    Deque<Integer> deque = new LinkedList<>();

    // 弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
    // 同时判断队列当前是否为空
    public void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    // 添加元素时，如果添加的元素大于入口处的元素，就替换
    // 保证队列元素单调递减
    public void add(int val) {
        // 维持单调递减
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }

    // 队列队顶元素始终为最大值
    public int peek() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peek();
    }

    @Override
    public String toString() {
        return "MyQueue1{" +
                "deque=" + deque +
                '}';
    }
}
