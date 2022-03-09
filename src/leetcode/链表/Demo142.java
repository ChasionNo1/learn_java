package leetcode.链表;

import java.util.HashSet;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-09 14:09
 * <p>
 * 环形链表
 * <p>
 * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 */
public class Demo142 {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                // 相遇了
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2) {
                    // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }

    // 哈希表
    // 一个非常直观的思路是：我们遍历链表中的每个节点，并将它记录下来；
    // 一旦遇到了此前遍历过的节点，就可以判定链表中存在环。借助哈希表可以很方便地实现。
    public ListNode detectCycle1(ListNode head){
        ListNode pos = head;
        HashSet<ListNode> set = new HashSet<>();
        while (pos != null){
            if (set.contains(pos)){
                return pos;
            }else {
                set.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

}
