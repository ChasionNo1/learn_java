package 数据结构与算法.栈与队列.栈.java自带;

import org.testng.annotations.Test;

import java.util.LinkedList;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-13 21:01
 */
public class Demo332_2 {
    @Test
    public void test1(){
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addLast(1);
        stack.addLast(2);
        stack.addLast(3);
        // java中栈的模拟

//        Integer pop = stack.pop();
//        System.out.println(pop);
        System.out.println(stack.removeLast());
    }
}
