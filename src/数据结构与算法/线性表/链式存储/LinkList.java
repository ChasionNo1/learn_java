package 数据结构与算法.线性表.链式存储;

import 数据结构与算法.线性表.抽象数据类型.IList;

/**
 * 带头结点的单向链表
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/9 21:39
 **/
public class LinkList<E> implements IList<E> {
    private Node<E> head;


    public LinkList(){
        head = new Node<>();
    }

    public LinkList(E[] es, boolean Order) throws Exception{
        this(); // 创建head
        if (Order){
            create1(es);
        }else {
            create2(es);
        }
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    // 尾插法顺序建立单链表
    private void create1(E[] es) throws Exception{
        for (int i = 0; i < es.length; i++) {
            insert(length(), es[i]);
        }

    }

    // 头插法逆序建立单链表
    private void create2(E[] es) throws Exception{
        for (int i = 0; i < es.length; i++) {
            insert(0, es[i]);
        }

    }


    @Override
    public void clear() {
        head.setNext(null);
    }

    @Override
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    @Override
    public int length() {
        Node<E> p = head.getNext();
        int length = 0;
        while (p != null){
            length++;
            p = p.getNext();
        }
        return length;
    }

    @Override
    public E get(int i) throws Exception {
        // p指向首结点
        Node<E> p = head.getNext();
        int j = 0;
        while (p != null && j < i){
            p = p.getNext();
            j++;
        }
        // p == null 代表i超出length() - 1
        if (i < 0 || p == null){
            throw new Exception("第" + i + "个元素不存在");
        }
        return p.getData();
    }

    @Override
    public void insert(int i, E x) throws Exception {
        Node<E> p = head;
        int j = -1;
        // 插入在i处，首先要找到i的位置
        while (p != null && j < i - 1){
            j++;
            p = p.getNext();
        }
        if (j != i -1 || p == null){
            throw new Exception("插入位置不合法");
        }
        // 创建一个新的结点
        /*
        当前结点位置p:i-1，
        p的下一个结点改为新的结点node，
        node的下一个结点为原本p的下一个结点
        要先连接新结点与下一个结点
        然后再连接当前结点与新结点
        * */
        Node<E> node = new Node<>(x);
        node.setNext(p.getNext());
        p.setNext(node);
    }

    @Override
    public void remove(int i) throws Exception {
        Node<E> p = head;
        int j = -1;
        while (p.getNext() != null && j < i -1){
            p = p.getNext();
            j++;
        }
        if (j != i -1 || p.getNext() == null){
            throw new Exception("删除位置不合法");
        }

        /*
        删除第i个结点：
        当前第i-1个结点的下一个结点设置为i+1
        * */
        p.setNext(p.getNext().getNext());
    }

    @Override
    public int indexOf(E x) {
        Node<E> p = head.getNext();
        int j = 0;
        // 没有找到，继续向前推进，如果到末尾也没有找到，也结束循环
        while (p != null && !p.getData().equals(x)){
            p = p.getNext();
            j++;
        }
        if ( p != null){
            return j;
        }else {
            return -1;
        }
    }

    @Override
    public void display() {
        Node<E> p = head.getNext();
        while (!p.equals(head)){
            System.out.print(p.getData() + "\t");
            p = p.getNext();
        }
        System.out.println();
    }

    public void removeRepeatElem() throws Exception{
        // 除单链表中重复的结点 从单链表首结点开始依次将单链表中每个结点与它后面的所有结点进行比较.
        Node<E> p = head.getNext(), q;
        while (p != null){
            int order = indexOf(p.getData());
            q = p.getNext();
            while (q != null){
                if (p.getData().equals(q.getData())){
                    remove(order + 1);
                }else {
                    order++;
                }
                q = q.getNext();
            }
            p = p.getNext();
        }
    }

    public LinkList<E> mergeList(LinkList<E> la, LinkList<E> lb){
        // 将两个有序单链表la和lb合并成一个新的有序单链表，借助3个指针pa，pb，pc，pa指向la首结点，pb指向lb首结点，pc指向la头结点
        // 当pa.getData()<pb.getData(),则将pa链接到pc之后；反之则将pb链接到pc后。
        Node<E> ahead = la.getHead();
        Node<E> pa = ahead.getNext();
        Node<E> pb = lb.getHead().getNext();

        int da, db;
        while (pa != null && pb != null){
            da = Integer.parseInt(pa.getData().toString());
            db = Integer.parseInt(pb.getData().toString());
            if (da <= db){
                ahead.setNext(pa);
                ahead = pa;
                pa = pa.getNext();
            }else {
                ahead.setNext(pb);
                ahead = pb;
                pb = pb.getNext();
            }
        }
        ahead.setNext(pa != null ? pa : pb);
        return la;
    }


}
