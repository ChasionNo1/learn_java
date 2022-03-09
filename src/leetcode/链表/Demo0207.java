package leetcode.链表;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-08 19:12
 * <p>
 * 给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 */
public class Demo0207 {
    public static void main(String[] args) {
        Demo0207 demo = new Demo0207();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

//        ListNode node6 = new ListNode(3);
//        ListNode node7 = new ListNode(4);
//        ListNode node8 = new ListNode(5);
//        node6.next = node7;
//        node7.next = node8;
        ListNode head = demo.getIntersectionNode(node1, node3);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = size(headA);
        int lengthB = size(headB);
        if (lengthA == 0 || lengthB == 0) {
            return null;
        }
        int gap;
        if (lengthA > lengthB) {
            gap = lengthA - lengthB;
            return search(gap, headA, headB);
        } else {
            gap = lengthB - lengthA;
            return search(gap, headB, headA);
        }

    }

    public int size(ListNode head) {
        int l = 0;
        while (head != null) {
            ++l;
            head = head.next;
        }
        return l;
    }

    /**
     *
     * @param gap: 两个链表的长度差
     * @param headA: 长链表
     * @param headB: 短链表
     * @return: leetcode.链表.ListNode
     **/
    public ListNode search(int gap, ListNode headA, ListNode headB) {
        int i = 0;
        while (i < gap) {
            ++i;
            headA = headA.next;
        }
        System.out.println(headA.val);
        while (headA != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
