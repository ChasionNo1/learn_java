package 数据结构与算法.堆;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-23 19:29
 *
 * 堆的实现 （数组操作）
 */
public class Heap<T extends Comparable<T>> {
    private T[] items; // 存储堆中的元素
    private int N; // 记录堆中元素的个数

    public Heap(int capacity){
        this.items = (T[]) new Comparable[capacity+1];
        this.N = 0;
    }

    // 判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i, int j){
        return items[i].compareTo(items[j]) < 0;
    }

    // 交换堆中i索引和j索引处的值
    private void exch(int i, int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    // 往堆中插入一个元素
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    //删除堆中最大的元素,并返回这个最大元素
    public T delMax(){
        T max = items[1];
        //交换索引1处和索引N处的值
        exch(1, N);
        items[N] = null;
        //删除最后位置上的元素
        N--;
        // 将1上元素调整到位
        sink(1);
        return max;
    }

    // 使用上浮算法，使得索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        while (k > 1){
            // 比较当前节点与父节点的大小
            if (less(k/2, k)){
                exch(k/2, k);
            }
            k = k / 2;
        }
    }

    public void sink(int k){
        while (2 * k <= N){
            int max;
            // 存在右子节点
            if (2 * k + 1 <= N){
                if (less(2 * k, 2 * k + 1)){
                    // 右子节点大
                    max = 2 * k + 1;
                }else {
                    max = 2 * k;
                }
            }else {
                max = 2 * k;
            }
            //比较当前结点和子结点中的较大者，如果当前结点不小，则结束循环
            if ( !less(k, max)){
                break;
            }
            //当前结点小，则交换，
            exch(k, max);
            k = max;
        }
    }

}
