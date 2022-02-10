package 数据结构与算法.栈与队列.栈.线性栈;

/**
 * 栈的抽象数据类型
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/10 20:01
 **/
public interface IStack<E> {
    public void clear();
    public boolean isEmpty();
    public int getTop();
    public void push(E e) throws Exception;
    public E pop() throws Exception;
    public void display();
}
