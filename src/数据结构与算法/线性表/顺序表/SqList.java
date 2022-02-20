package 数据结构与算法.线性表.顺序表;

import 数据结构与算法.线性表.抽象数据类型.IList;

/**
 * 线性表的顺序存储
 *
 * 顺序表的特点
 * 在线性表中逻辑上相邻的数据元素，在物理存储位置上也是相邻的。
 * 存储密度高，但要预先分配，可能会造成空间的浪费。
 * 便于随机存取
 * 不便于插入和删除操作，会引起大量的数据元素的移动
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/9 14:20
 **/
public class SqList<E> implements IList<E> {
    private E[] listElem; // 线性表存储空间
    private int curLen; // 线性表的当前长度

    public SqList(int maxSize){
        curLen = 0;
        listElem = (E[]) new Object[maxSize];
    }

    @Override
    public void clear() {
        curLen = 0;
    }

    @Override
    public boolean isEmpty() {
        return curLen == 0;
    }

    @Override
    public int length() {
        return curLen;
    }

    @Override
    public E get(int i) throws Exception {
        if (i < 0 || i > curLen - 1){
            throw new Exception("第" + i + "个元素不存在");
        }
        return listElem[i];
    }

    @Override
    public void insert(int i, E x) throws Exception {
        if (curLen == listElem.length){
            throw new Exception("顺序表已满");
        }
        if (i > curLen || i < 0){
            throw new Exception("插入位置不合法");
        }
        // 对数据元素进行平行向后移动，遵循存储单元存储的后入为主的原则，否则将造成数据丢失
        // 对于算法实现时，应该从后向前移动
//        最坏的情况是插在第一个位置上，最好的情况是插在最后一个位置上，时间复杂度为O(n)
        for (int j = curLen; j > i; j--) {
            listElem[j] = listElem[j - 1];
        }
        listElem[i] = x;
        curLen++;
    }

    @Override
    public void remove(int i) throws Exception {
        if (i < 0 || i > curLen - 1){
            throw new Exception("删除位置不合法");
        }
        // 删除线性表的第i个元素
        // 从前往后移动
        for (int j = i; j < curLen - 1; j++) {
            listElem[j] = listElem[j + 1];
        }
        curLen--;
    }

    @Override
    //返回线性表中首次出现指定的数据元素的位序号；若线性表中不包含此数据元素，则返回-1
    public int indexOf(E x) {
        int j = 0;
        while (j < curLen && !listElem[j].equals(x)){
            j++;
        }
        // 当跳出循环时，可能是指针到末尾了，或者是找到数据了
        // 当指针还在链表内，就说明找到了，大于则没找到。
        if (j < curLen){
            return j;
        }else {
            return -1;
        }
    }

    @Override
    public void display() {
        for (int j = 0; j < curLen; j++) {
            System.out.print(listElem[j] + " ");
        }
        System.out.println();
    }
}
