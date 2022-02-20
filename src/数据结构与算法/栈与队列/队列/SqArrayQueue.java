package 数据结构与算法.栈与队列.队列;

import java.lang.reflect.Array;


/**
 *
 * 循环队列，数组实现
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/12 14:50
 **/
public class SqArrayQueue<T> {
    private T[] data;
    private int front; // 头指针
    private int rear; // 尾指针
    private int maxSize; // 队列长度
    private int size;  // 队列实际元素个数

    public SqArrayQueue(Class<T> type, int maxSize){
        this.front = 0;
        this.rear = 0;
        this.maxSize = maxSize;
        this.size = 0;
        data = (T[]) Array.newInstance(type, maxSize);
    }

    public T[] getData(){
        return data;
    }

    public int getLength(){
        return (rear - front + maxSize) % maxSize;
    }

    public void add(T t)throws Exception{
        if ((rear + 1) % maxSize == front){
            throw new Exception("队列已满");
        }
        data[rear] = t;
        rear = (rear + 1) % maxSize;
        size++;
    }

    public T remove() throws Exception{
        if (rear == front){
            throw new Exception("队列为空");
        }

        T removeValue = data[front];
        data[front] = null;
        front = (front + 1) % maxSize;
        size--;
        return removeValue;
    }

    public void display(){
        if (rear == front){
            System.out.println("[]");
        }
        if (rear > front){
            for (int i = front; i < rear; i++) {
                System.out.print(data[i] + "\t") ;
            }
            System.out.println();
        }
        if (rear < front){
            for (int i = front; i < maxSize; i++) {
                System.out.print(data[i] + "\t");
            }
            for (int i = 0; i < rear; i++) {
                System.out.print(data[i] + "\t");
            }
            System.out.println();
        }

    }
}
