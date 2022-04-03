package 数据结构和算法刷题.day02;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-27 14:35
 */
public class Solution1 {
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
        Solution1 solution1 = new Solution1();
        ListNode node = solution1.reverseList(node1);
        while (node != null){
            System.out.print(node.val);
            node = node.next;

        }


    }
    public ListNode reverseList(ListNode head) {
//        ListNode cur = head;
//        ArrayList<Integer> list = new ArrayList<>();
//        while (cur != null){
//            list.add(cur.val);
//            cur = cur.next;
//        }
//        if (list.size() == 0){
//            return head;
//        }
//        if (list.size() == 1){
//            return new ListNode(list.get(list.size() - 1));
//        }
//        head = new ListNode(list.get(list.size() - 1));
//        cur = head;
//        for (int i = list.size() - 2; i >= 0 ; i--) {
//            cur.next = new ListNode(list.get(i));
//            cur = cur.next;
//        }
//        return head;

        // 双指针
//        ListNode pre = null;
//        ListNode cur = null;
//        while (head != null){
//            cur = head;
//            head = head.next;
//            cur.next = pre;
//            pre = cur;
//        }
//        return cur;

        // 使用递归的方式
        return recur(head, null);
    }

    // 考虑使用递归法遍历链表，当越过尾节点后终止递归，在回溯时修改各节点的 next 引用指向。
    public ListNode recur(ListNode cur, ListNode pre){
        if (cur == null){
            return pre;
        }
        // 递归到cur == null，此时cur->null, pre->5, res -> pre，也就是反转链表的头节点
        ListNode res = recur(cur.next, cur);

        cur.next = pre;
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
