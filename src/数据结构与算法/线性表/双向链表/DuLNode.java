package 数据结构与算法.线性表.双向链表;

/**
 * 双向链表结点
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/10 15:03
 **/
public class DuLNode<E> {
    private E data;
    private DuLNode<E> prior;
    private DuLNode<E> next;

    public DuLNode(){
        this(null);
    }

    public DuLNode(E data){
        this.data = data;
        this.prior = null;
        this.next = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public DuLNode<E> getPrior() {
        return prior;
    }

    public void setPrior(DuLNode<E> prior) {
        this.prior = prior;
    }

    public DuLNode<E> getNext() {
        return next;
    }

    public void setNext(DuLNode<E> next) {
        this.next = next;
    }
}
