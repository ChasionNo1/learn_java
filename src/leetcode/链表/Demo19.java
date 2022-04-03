package leetcode.链表;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-08 15:07
 */
public class Demo19 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Demo19 demo = new Demo19();
        ListNode head = demo.removeNthFromEnd1(node1, 1);
        while (head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = size(head);
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode cur = dummyNode;
//        ListNode pre = dummyNode;
        int index = size - n;
        int i = -1;
        while (i < index - 1){
            ++i;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummyNode.next;
    }
    public int size(ListNode head){
        int size = 0;
        while (head != null){
            ++size;
            head = head.next;
        }
        return size;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n){
        // 双指针
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;
        int i = -1;
        while (i < n){
            ++i;
            fast = fast.next;
        }
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }
}
