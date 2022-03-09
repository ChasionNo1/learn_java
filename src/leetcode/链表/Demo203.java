package leetcode.链表;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-07 19:14
 * <p>
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class Demo203 {
    public static void main(String[] args) {
        Demo203 demo = new Demo203();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode head = demo.removeElements1(node1, 6);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;

    }
    // 递归方法
//    public ListNode removeElements(ListNode head, int val) {
//        if (head == null) {
//            return head;
//        }
//        head.next = removeElements(head.next, val);
//        return head.val == val ? head.next : head;
//    }

    /**
     * 不添加虚拟头节点的方式
     * @param head:
     * @param val:
     * @return: leetcode.链表.ListNode
     **/
    public ListNode removeElements1(ListNode head, int val) {
        while (head != null && head.val == val){
            head = head.next;
        }

        if (head == null){
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
            }else {
                // 如果不相等pre指针不动
                pre = cur;
            }
            cur = cur.next;

        }
        return head;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


