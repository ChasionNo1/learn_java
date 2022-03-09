package 数据结构与算法.线性表.链式存储;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-22 16:55
 */
public class MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        int length = list.length();
        System.out.println(length);
    }
    private Node head;

    public MyLinkedList(){
        head = new Node();
    }

    public int length(){
        Node cur = head.getNext();
        int len = 0;
        /*
        当前指针不为空，进入循环，当指向最后一个时，指针指向下一个，为空指针，下一次循环条件不成立，后面不再使用该指针
         **/
        while (cur != null){
            len++;
            cur = cur.getNext();
        }
        return len;
    }

    public void insert(int value){
        Node node = new Node(value);
        Node cur = head;
        if (head == null){
            head = node;
        }
        /*
        这里后面用到指针操作，当下一个为空时，进入循环，指针指向最后一个，跳出循环
         **/
        while (cur.getNext() != null){
            cur = cur.getNext();
        }

        cur.setNext(node);
    }
}
