package 数据结构和算法刷题.day02;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-27 19:49
 *
 * 复杂链表的复制
 * 给定链表的头节点 head ，复制普通链表很简单，只需遍历链表，每轮建立新节点 + 构建前驱节点 pre 和当前节点 node 的引用指向即可。
 * 本题链表的节点新增了 random 指针，指向链表中的 任意节点 或者 nullnull 。这个 random 指针意味着在复制过程中，除了构建前驱
 * 节点和当前节点的引用指向 pre.next ，还要构建前驱节点和其随机节点的引用指向 pre.random 。
 * 本题难点： 在复制链表的过程中构建新链表各节点的 random 引用指向。
 *
 */
public class Solution3 {

    public Node copyRandomList(Node head) {
        /*
         *
        方法一：哈希表
        利用哈希表的查询特点，考虑构建 原链表节点 和 新链表对应节点 的键值对映射关系，再遍历构建新链表各节点的 next 和 random 引用指向即可。

         **/
//        if (head == null){
//            return null;
//        }
//        Node cur = head;
//        HashMap<Node, Node> map = new HashMap<>();
//        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
//        while (cur != null){
//            map.put(cur, new Node(cur.val));
//            cur = cur.next;
//        }
//        cur = head;
//        // 4. 构建新链表的 next 和 random 指向
//        while (cur != null){
//            // 获取对应key的value，由于key和value是镜像关系
//            // 我们获取key的next，random得到的原来的关系，再用这个key去获取value，就得到镜像的value之间的关系了
//            map.get(cur).next = map.get(cur.next);
//            map.get(cur).random = map.get(cur.random);
//            cur = cur.next;
//        }
//        return map.get(head);

        // 方法二：拼接 + 拆分
        // 考虑构建 原节点 1 -> 新节点 1 -> 原节点 2 -> 新节点 2 -> …… 的拼接链表，
        // 如此便可在访问原节点的 random 指向节点的同时找到新对应新节点的 random 指向节点。
        if (head == null){
            return null;
        }
        Node cur = head;
        // 1. 复制各节点，并构建拼接链表
        while (cur != null){
            // 新建节点，接在cur后面
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next;
        }
        // 2. 构建各新节点的 random 指向
        cur = head;
        while (cur != null){
            if (cur.random != null){
                // 新节点的随机节点，是当前节点的随机节点的下一个
                cur.next.random = cur.random.next;
            }
            // 跳两个，是原节点的索引
            cur = cur.next.next;
        }
        // 3. 拆分两链表
        cur = head.next;
        Node pre = head, res = head.next;
        while (cur.next != null){
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res; // 返回新链表头节点
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
