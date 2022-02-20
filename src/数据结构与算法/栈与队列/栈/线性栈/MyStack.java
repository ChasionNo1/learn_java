package 数据结构与算法.栈与队列.栈.线性栈;

/**
 * 顺序栈的实现
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/10 20:17
 **/
public class MyStack<E> implements IStack<E>{
    private E[] data;
    private int maxSize;
    private int top;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        data = (E[]) new Object[maxSize];
        top = -1;
    }

    @Override
    public void clear() {
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int getTop() {
        return top;
    }

    @Override
    public void push(E e) throws Exception {
        if (top == maxSize - 1){
            throw new Exception("栈满了");
        }
        top++;
        data[top] = e;
    }

    @Override
    public E pop() throws Exception {
        if (top == -1){
            throw new Exception("已经是空栈了，无法再删除");
        }
        E popData = data[top];
        data[top] = null;
        top--;

        return popData;
    }

    @Override
    public void display() {
        for (int i = 0; i < top + 1; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();

    }
}
