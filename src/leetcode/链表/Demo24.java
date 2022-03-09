package leetcode.链表;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-08 14:34
 *
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class Demo24 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Demo24 demo = new Demo24();
        ListNode head = demo.swapPairs(node1);
        while (head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        // 头节点
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = head;
        while (cur != null && cur.next != null){
            ListNode temp = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = temp;
            pre = cur;
            cur = temp;

        }
        return dummyNode.next;
    }
}
