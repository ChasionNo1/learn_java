package 数据结构与算法.栈与队列.栈.双栈共享空间;


/**
 * 双栈共享空间的实现
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/10 21:02
 **/
public class ShareStack<E>{
    private int maxSize;
    private E[] data;
    private int top1;
    private int top2;

    public ShareStack(int maxSize){
        this.maxSize = maxSize;
        data = (E[]) new Object[maxSize];
        // 两个栈底
        this.top1 = -1;
        this.top2 = maxSize;
    }

    public void clear(int stackIdx) {
        if (stackIdx == 1){
            this.top1 = -1;
        }else if (stackIdx == 2){
            this.top2 = maxSize;
        }else {
            this.top1 = -1;
            this.top2 = maxSize;
        }
    }

    public boolean isEmpty(int stackIdx) {
        if (stackIdx == 1){
            return this.top1 == -1;
        }else if (stackIdx == 2){
           return this.top2 == maxSize;
        }else
        return this.top1 == -1 && this.top2 == maxSize;
    }

    public int getTop(int stackIdx) throws Exception {
        if (stackIdx == 1){
            return top1;
        }else if (stackIdx == 2){
            return top2;
        }else
        throw new Exception("链表的编号错误");
    }

    public void push(E e, int stackIdx) throws Exception {
        if (stackIdx != 1 && stackIdx != 2){
            throw new Exception("链表的编号错误");
        }

        if (top1 >= top2 - 1){
            throw new Exception("栈满了");
        }
        if (stackIdx == 1){
            top1++;
            data[top1] = e;
        }else {
            top2--;
            data[top2] = e;
        }

    }

    public E pop(int stackIdx) throws Exception {
        if (stackIdx != 1 && stackIdx != 2){
            throw new Exception("链表的编号错误");
        }

        if (stackIdx == 1){
            if (top1 == -1){
                throw new Exception("栈已经空了");
            }
            E popData = data[top1];
            data[top1] = null;
            top1--;
            return popData;
        }else {
            if (top2 == maxSize){
                throw new Exception("栈已经空了");
            }
            E popData = data[top2];
            data[top2] = null;
            top2++;
            return popData;
        }

    }

    public void display(int stackIdx) throws Exception {
        if (stackIdx != 1 && stackIdx != 2){
            throw new Exception("链表的编号错误");
        }

        if (stackIdx == 1){
            System.out.println("栈1为：");
            for (int i = 0; i < top1 + 1; i++) {
                System.out.print(data[i] + "\t");
            }
            System.out.println();
        }else {
            System.out.println("栈2为：");
            for (int i = maxSize - 1; i > top2 - 1; i--) {
                System.out.print(data[i] + "\t");
            }
            System.out.println();
        }

    }
}
