package 数据结构与算法.栈与队列.栈.双栈共享空间;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/10 21:24
 **/
public class ShareStackTest {
    public static void main(String[] args) throws Exception {
        ShareStack<Integer> integerShareStack = new ShareStack<>(10);
        integerShareStack.push(1, 1);
        integerShareStack.push(3, 2);
        integerShareStack.push(5, 1);
        integerShareStack.push(2, 2);
        integerShareStack.push(56, 1);
        integerShareStack.push(23, 2);
        integerShareStack.display(1);
        integerShareStack.display(2);
        Integer pop = integerShareStack.pop(1);
        System.out.println(pop);
    }
}
