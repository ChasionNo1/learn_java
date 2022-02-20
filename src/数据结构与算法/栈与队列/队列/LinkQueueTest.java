package 数据结构与算法.栈与队列.队列;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/12 16:49
 **/
public class LinkQueueTest {
    public static void main(String[] args) {
        LinkQueue<Integer> queue = new LinkQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        int size = queue.size();
        System.out.println(size);
        Integer remove = queue.remove();
        System.out.println(remove);
        System.out.println(queue.size());
        queue.display();
    }
}
