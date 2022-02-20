package 数据结构与算法.栈与队列.队列;

import java.util.Arrays;

/**
 *
 * 数组队列的实现，单向队列
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/12 14:21
 **/
public class ArrayQueue<T> {
    private final int DEFAULT_SIZE = 10; // 设置默认大小
    private int capacity; // 保存当前数组长度
    private int addCapacity; // 扩容
    private Object[] data;
    private int size; // 队列中元素个数

    // 创建默认长度的空队列
    public ArrayQueue(){
        capacity = DEFAULT_SIZE;
        data = new Object[capacity];
    }

    // 创建指定长度的空队列
    public ArrayQueue(int capacity){
        this.capacity = capacity;
        data = new Object[capacity];
    }

    // 创建指定长度的空队列，并指定超出数组范围后的增量
    public ArrayQueue(int capacity, int addCapacity){
        this.capacity = capacity;
        this.addCapacity = addCapacity;
        data = new Object[capacity];
    }

    // 获取队列的长度
    public int getSize(){
        return size;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 确保数组长度，如果超出就扩容
    private void ensureCapacity(int inputCapacity){
        // 如果输入的数组长度大于原有数组的长度
        if (inputCapacity > capacity){
            // 如果设定数组增量
            if (addCapacity > 0){
                while (inputCapacity > capacity){
                    //按照增量扩容，直到大于所需的数组容量
                    capacity += addCapacity;
                }
            }else {
                //如果未设定数组增量
                while (inputCapacity > capacity){
                    //将capacity左移,使其为大于所需容量
                    capacity <<= 1;
                }
            }
        }
        //扩容后，将原数组复制到新数组中
        data = Arrays.copyOf(data, capacity);
    }

    // 入丢列，向队列添加一个元素
    public void add(T element){
        ensureCapacity(size+1);
        data[size++] = element;
    }

    // 出队列，移除队头元素
    public T remove(){
        if (isEmpty()){
            return null;
        }else {
            T removeValue = (T) data[0];
            data[0] = null;
            size--;
            // 将队列头后的元素整体前移
            for (int i = 1; i < size; i++) {
                data[i-1] = data[i];
            }
            return removeValue;
        }
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    public void display(){
        if (isEmpty()){
            System.out.println("[]");
        }else {
            for (int i = 0; i < size; i++) {
                System.out.print(data[i] + "\t");
            }
        }
        System.out.println();
    }

}
