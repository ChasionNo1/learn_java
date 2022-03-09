package 数据结构与算法.排序.堆排序;

import 数据结构与算法.堆.Heap;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-23 19:55
 */
public class HeapTest {
    public static void main(String[] args) {
        Heap<String> heap = new Heap<String>(20);
        heap.insert("s");
        heap.insert("a");
        heap.insert("d");
        heap.insert("g");
        heap.insert("e");
        heap.insert("k");
        heap.insert("m");
        heap.insert("l");
        heap.insert("c");

        String del;
        while ((del = heap.delMax()) != null){
            System.out.println("del:" + del);
        }
    }
}
