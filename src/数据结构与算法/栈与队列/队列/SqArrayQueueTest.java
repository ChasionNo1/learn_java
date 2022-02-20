package 数据结构与算法.栈与队列.队列;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/12 15:03
 **/
public class SqArrayQueueTest {
    public static void main(String[] args) throws Exception {
        Class<Integer> aClass = (Class<Integer>) Class.forName("java.lang.Integer");
        SqArrayQueue<Integer> queue = new SqArrayQueue<Integer>(aClass, 5);
        queue.add(10);
        queue.add(12);
        queue.add(3);
        queue.add(9);
        int length = queue.getLength();
        System.out.println(length);
        queue.display();
        queue.remove();
        queue.display();
        queue.add(45);
        queue.display();
    }
}
