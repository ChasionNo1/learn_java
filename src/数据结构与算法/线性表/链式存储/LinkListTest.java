package 数据结构与算法.线性表.链式存储;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/9 22:42
 **/
public class LinkListTest {
    public static void main(String[] args) throws Exception {
        Integer[] arr = {1, 16, 23, 9, 10, 10, 16};
        LinkList<Integer> integerLinkList = new LinkList<>(arr, true);
        int length = integerLinkList.length();
        System.out.println(length);
        integerLinkList.display();
        integerLinkList.removeRepeatElem();
        integerLinkList.display();
        integerLinkList.remove(1);
        integerLinkList.display();
        Integer[] arr1 = {23, 10, 30, 3, 9};
        LinkList<Integer> integerLinkList1 = new LinkList<>(arr1, true);
        integerLinkList1.display();
        LinkList<Integer> integerLinkList2 = integerLinkList.mergeList(integerLinkList, integerLinkList1);
        integerLinkList2.display();

    }
}
