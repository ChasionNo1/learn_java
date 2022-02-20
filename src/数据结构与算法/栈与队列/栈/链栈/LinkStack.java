package 数据结构与算法.栈与队列.栈.链栈;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/10 21:46
 **/
public class LinkStack<E> {
    private int count;
    private StackNode<E> top;

    public LinkStack() {
        count = 0;
        top = new StackNode<>();
    }

    public void push(E e){
        StackNode<E> node = new StackNode<>();
        node.data = e;
        // top是此时的顶部，新添加的node要在top的上面，所以，node的next设置为top
        node.next = top;
        // 此时的node由变成了top
        top = node;
        count++;
    }

    public E pop() throws Exception {
        if (count == 0){
            throw new Exception("无内容可删除");
        }
        E data = top.data;
        top = top.next;
        count--;
        return data;
    }

    public void display(){
        StackNode<E> p = top;
        for (int i = 0; i < count; i++) {
            System.out.print(p.data + "\t");
            p = p.next;
        }
        System.out.println();
    }
}
