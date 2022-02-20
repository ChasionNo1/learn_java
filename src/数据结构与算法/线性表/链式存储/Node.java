package 数据结构与算法.线性表.链式存储;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/9 17:36
 **/
public class Node<E> {
    private E data;
    private Node<E> next;

    public Node(){
    }

    public Node(E data) {
        this.data = data;
    }

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
