package leetcode.链表;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-07 21:30
 * <p>
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val和next。val是当前节点的值，
 * next是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性prev以指示链表中的上一个节点。
 * 假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。
 * 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引index 有效，则删除链表中的第index 个节点。
 */
public class Demo707 {
    public static void main(String[] args) {
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(13);
//        MyLinkedList linkedList = new MyLinkedList();
//        Node head = linkedList.getHead();
//        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;
////        int size = linkedList.size();
////        System.out.println(size);
//        System.out.println("size:" + linkedList.size());
//        linkedList.addAtHead(6);
//        System.out.println("size:" + linkedList.size());
//        System.out.println(linkedList.get(0));
//        linkedList.addAtTail(8);
//        System.out.println("size:" + linkedList.size());
//        linkedList.display();
//        linkedList.addAtIndex(5, 90);
//        linkedList.display();
//        linkedList.deleteAtIndex(1);
//        linkedList.display();
//        linkedList.deleteAtIndex(1);
//        linkedList.display();
        MyLinkedList list = new MyLinkedList();
//        list.addAtHead(1);
//        list.deleteAtIndex(0);
//        list.addAtHead(2);
        list.addAtIndex(0, 10);
        list.addAtIndex(0, 20);
        list.addAtIndex(1, 30);
        System.out.println(list.get(0));
        list.display();


    }
}

class MyLinkedList {
    Node head;
    int length;

    public Node getHead() {
        return head;
    }

    public MyLinkedList() {
        head = new Node();
        length = 0;
    }

    public int size() {
        Node cur = head.next;
        int size = 0;
        while (cur != null) {
            ++size;
            cur = cur.next;
        }
        length = size;
        return size;
    }

    public int get(int index) {
        if (index > size() - 1) {
            return -1;
        }
        int i = 0;
        Node cur = head.next;
        while (i < index) {
            cur = cur.next;
            ++i;
        }
        return cur.val;

    }

    public void add(int index, int val) {
        int i = -1;
        Node cur = head;
        Node node = new Node(val);
        while (i < index - 1) {
            cur = cur.next;
            ++i;
        }
        node.next = cur.next;
        cur.next = node;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        head.next = newNode;
    }

    public void addAtTail(int val) {
        // 将值为 val 的节点追加到链表的最后一个元素。
        Node node = new Node(val);
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    public void addAtIndex(int index, int val) {
        // 在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。
        // 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
//        Node node = new Node(val);
        if (index > size()) {
            return;
        }
        if (index == size()) {
            addAtTail(val);
        } else if (index < 0) {
            addAtHead(val);
        } else {
            add(index, val);
        }
    }

    public void deleteAtIndex(int index) {
        // 如果索引 index 有效，则删除链表中的第 index 个节点。
        if (index < 0 || index >= size()) {
            return;
        }
        Node cur = head;
        int i = -1;
        // 找到要删除节点的前一个节点
        while (i < index - 1){
            ++i;
            cur = cur.next;
        }
        cur.next = cur.next.next;

    }

    public void display() {
        Node cur = head.next;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }
}

class Node {
    int val;
    Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }
}