package 数据结构与算法.栈与队列.队列;

/**
 *
 * 链表实现循环队列
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/12 15:17
 **/
public class LinkQueue<E> {
    private Node<E> front; // 定义队首
    private Node<E> rear; // 定义队尾
    private int size; // 数据长度

    public LinkQueue() {
        front = rear = new Node<>();
    }

    public int size(){
        return size;
    }

    // 入队
    public void add(E element){
        Node<E> node = new Node<>(element);
        // 当队列为空
        if (rear == front){
             front = node;
             rear.setPreNode(node);
        }else {
            Node<E> preNode = rear.getPreNode();
            preNode.setNextNode(node);
            node.setPreNode(preNode);
            rear.setPreNode(node);
        }
        size++;
    }

    // 出队
    public E remove(){
        if (rear == front){
            System.out.println("队列已空，无法再删除");
        }
        E element = front.getElement();
        Node<E> nextNode = front.getNextNode();
        // 置空处理
        front.setPreNode(null);
        front.setNextNode(null);
        front.setElement(null);
        front = nextNode;
        size--;
        return element;
    }

    public void display(){
        if (rear == front){
            System.out.println("[]");
        }
        Node<E> cur = front;
        /*
        * rear是最后一个元素的下一个,rear本身为空的
        * */
        for (int i = 0; i < size; i++) {
            System.out.print(cur.getElement() + "\t");
            cur = cur.getNextNode();
        }
    }


}
class Node<E>{
    private E element;
    private Node<E> preNode;
    private Node<E> nextNode;

    public Node() {
    }

    public Node(E element) {
        this.element = element;
    }

    public Node(E element, Node<E> preNode, Node<E> nextNode) {
        this.element = element;
        this.preNode = preNode;
        this.nextNode = nextNode;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getPreNode() {
        return preNode;
    }

    public void setPreNode(Node<E> preNode) {
        this.preNode = preNode;
    }

    public Node<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<E> nextNode) {
        this.nextNode = nextNode;
    }
}

