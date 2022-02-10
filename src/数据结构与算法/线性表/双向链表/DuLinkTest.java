package 数据结构与算法.线性表.双向链表;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/10 15:42
 **/
public class DuLinkTest {
    public static void main(String[] args) throws Exception {
        Integer[] arr = {1, 4, 9, 2, 5, 8};
        DuLinkList<Integer> integerDuLinkList = new DuLinkList<>(arr);
        int length = integerDuLinkList.length();
        System.out.println(length);
        integerDuLinkList.display();
        Integer integer = integerDuLinkList.get(5);
        System.out.println(integer);

    }
}
