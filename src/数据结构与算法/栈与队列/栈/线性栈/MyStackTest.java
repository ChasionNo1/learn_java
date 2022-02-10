package 数据结构与算法.栈与队列.栈.线性栈;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/10 20:40
 **/
public class MyStackTest {
    public static void main(String[] args) throws Exception {
        Integer[] arr = {1, 4, 9, 3, 7};
        MyStack<Integer> integerMyStack = new MyStack<Integer>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            integerMyStack.push(arr[i]);
        }
//        integerMyStack.display();
        Integer popItem = integerMyStack.pop();
        System.out.println(popItem);
        int top = integerMyStack.getTop();
        System.out.println(top);

    }
}
