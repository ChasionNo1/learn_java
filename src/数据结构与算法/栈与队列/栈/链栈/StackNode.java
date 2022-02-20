package 数据结构与算法.栈与队列.栈.链栈;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/10 21:44
 **/
public class StackNode<E> {
    public E data;
    public StackNode<E> next;

    public StackNode() {
        this.data = null;
        this.next = null;
    }
}

