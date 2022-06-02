package leetcode.链表;

/**
 * @ClassName Demo21
 * @Description TODO
 * @Author chasion
 * @Date 2022/6/1 14:34
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Demo21 {
    public static void main(String[] args) {
        Demo21 demo = new Demo21();
        ListNode list1 = new ListNode(-9);
        ListNode list2 = new ListNode(3);
        ListNode list3 = new ListNode(4);
        ListNode list4 = new ListNode(5);
        ListNode list5 = new ListNode(7);
        ListNode list6 = new ListNode(7);
        list1.next = list2;
//        list2.next = list3;
        list4.next = list5;
//        list5.next = list6;
        ListNode res = demo.mergeTwoLists(list1, list4);
        while (res != null){
            System.out.print(res.val + "->");
            res = res.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        // 当两个链表不为空时
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }
        if (list1 == null){
            cur.next = list2;
        }
        if (list2 == null){
            cur.next = list1;
        }
        return head.next;
    }
}

