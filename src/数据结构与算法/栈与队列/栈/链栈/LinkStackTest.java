package 数据结构与算法.栈与队列.栈.链栈;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/10 21:59
 **/
public class LinkStackTest {
    public static void main(String[] args) throws Exception {
        LinkStack<Integer> integerLinkStack = new LinkStack<>();
        integerLinkStack.push(1);
        integerLinkStack.push(4);
        integerLinkStack.push(2);
        integerLinkStack.push(3);
        integerLinkStack.display();
        Integer pop = integerLinkStack.pop();
        System.out.println(pop);

    }
}
