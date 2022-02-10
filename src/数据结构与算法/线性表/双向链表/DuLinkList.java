package 数据结构与算法.线性表.双向链表;

import 数据结构与算法.线性表.抽象数据类型.IList;

/**
 * 带头结点的双向循环链表
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/10 15:01
 **/
public class DuLinkList<E> implements IList<E> {
    private DuLNode<E> head;



    public DuLinkList(){
        head = new DuLNode<>();
        head.setPrior(head);
        head.setNext(head);
    }

    // 头插法逆向创建双向循环链表
    public DuLinkList(E[] es) throws Exception{
        this();
        for (int j = 0; j < es.length; j++) {
            insert(0, es[j]);
        }
    }

    public DuLNode<E> getHead() {
        return head;
    }

    public void setHead(DuLNode<E> head) {
        this.head = head;
    }


    @Override
    public void clear() {
        head.setPrior(head);
        head.setNext(head);
    }

    @Override
    public boolean isEmpty() {
        return head.getNext().equals(head);
    }

    @Override
    public int length() {
        DuLNode<E> p = head.getNext();
        int length = 0;
        while (!p.equals(head)){
            length++;
            p = p.getNext();
        }
        return length;
    }

    @Override
    public E get(int i) throws Exception {
        DuLNode<E> p = head.getNext();
        int j = 0;
        while (!p.equals(head) && j < i){
            p = p.getNext();
            j++;
        }
        if (j > i || p.equals(head)){
            throw new Exception("第" + i + "个元素不存在");
        }
        return p.getData();
    }

    @Override
    public void insert(int i, E x) throws Exception {
        // 注意这里：双向链表的增加找的是当前结点，而单向链表的增加找的是前驱
        // 获得首元素
        DuLNode<E> p = head.getNext();
        int j = 0;
        // 找到i-1的位置，一直往前推进，如果到了末尾了，跳出循环
        // j == i跳出循环
        while (!p.equals(head) && j < i){
             p = p.getNext();
             j++;
        }
        if (j != i){
            // 说明没有到i的位置上
            throw new Exception("插入位置不合法");
        }

        DuLNode<E> eDuLNode = new DuLNode<E>(x);
        p.getPrior().setNext(eDuLNode);
        eDuLNode.setPrior(p.getPrior());
        eDuLNode.setNext(p);
        p.setPrior(eDuLNode);

    }

    @Override
    public void remove(int i) throws Exception {
        DuLNode<E> p = head.getNext();
        int j = 0;
        while (!p.equals(head) && j < i){
            p = p.getNext();
            j++;
        }
        if ( j != i || p.equals(head)){
            throw new Exception("删除位置不合法");
        }
        p.getPrior().setNext(p.getNext());
        p.getNext().setPrior(p.getPrior());

    }

    @Override
    public int indexOf(E x) {
        DuLNode<E> p = head.getNext();
        int j = 0;
        while (!p.equals(head) && !p.getData().equals(x)){
            p = p.getNext();
            j++;
        }
        // 不是末尾结束循环的，而是找到结束循环
        if (!p.equals(head)){
            return j;
        }else {
            return -1;
        }
    }

    @Override
    public void display() {
        DuLNode<E> p = head.getNext();
        while (!p.equals(head)){
            System.out.print(p.getData() + "\t");
            p = p.getNext();
        }
        System.out.println();
    }
}
