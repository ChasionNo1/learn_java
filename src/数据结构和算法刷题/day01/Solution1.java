package 数据结构和算法刷题.day01;

import java.util.LinkedList;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-22 14:51
 *
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 *
 */
public class Solution1 {
    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(1);
        queue.deleteHead();
        int result = queue.deleteHead();
        System.out.println(result);
    }

}

class CQueue{
    LinkedList<Integer> A, B;

    public CQueue(){
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void appendTail(int value){
        A.addLast(value);
    }
    /**
     * @Description: A栈首先添加元素，压入栈底，当删除队首元素时，将A栈元素弹出，压入到B栈中，这时就实现了反转
     * @Author: chasion
     * @Date: 2022/2/22 14:55

     * @return: int
     **/
    public int deleteHead(){
        if (!B.isEmpty()){
            // 栈弹出，操作最后一个元素
            return B.removeLast();
        }
        // 没有元素
        if (A.isEmpty()){
            return -1;
        }
        // 将A栈元素压入B栈中，实现反转
        while (!A.isEmpty()){
            B.addLast(A.removeLast());
        }
        return B.removeLast();
    }
}
