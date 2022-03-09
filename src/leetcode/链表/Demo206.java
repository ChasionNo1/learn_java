package leetcode.链表;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-08 10:58
 * <p>
 * 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class Demo206 {
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
        Demo206 demo = new Demo206();
        ListNode head = demo.reverseList(node1);
        while (head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
    }


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // 递归方法
    public ListNode reverse(ListNode pre, ListNode cur){
        if (cur == null){
            return pre;
        }
        ListNode temp = null;
        temp = cur.next;
        pre = cur;
        return reverse(pre, temp);
    }
}

