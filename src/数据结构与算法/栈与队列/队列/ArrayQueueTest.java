package 数据结构与算法.栈与队列.队列;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/12 14:49
 **/
public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        queue.add(1);
        queue.add(3);
        queue.add(5);
        queue.add(2);
        queue.display();
    }
}
