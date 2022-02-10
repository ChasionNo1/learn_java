package 数据结构与算法.线性表.抽象数据类型;

/**
 * 线性表的抽象数据类型描述
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/9 14:16
 **/
public interface IList<E> {
    // 定义了链表一些抽象方法
    public void clear();
    public boolean isEmpty();
    public int length();
    public E get(int i) throws Exception;
    public void insert(int i, E x) throws Exception;
    public void remove(int i) throws Exception;
    public int indexOf(E x);
    public void display();
}
