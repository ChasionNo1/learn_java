package 设计模式.迭代器模式.homework;

/**
 * @ClassName Aggregate
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/5 21:37
 *
 * 集合使用泛型
 */
public interface Aggregate<T> {

    public abstract Iterator<T> iterator();

    public abstract int getLength();

    void append(T t);

    T get(int index);

}
