package 设计模式.迭代器模式.homework;

/**
 * @ClassName Iterator
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/5 21:37
 */
public interface Iterator<T> {

    boolean hasNext();
    T next();
}
