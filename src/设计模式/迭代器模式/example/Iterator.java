package 设计模式.迭代器模式.example;

/**
 * @ClassName Iteator
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/5 20:50
 *
 * 遍历集合的接口
 */
public interface Iterator {
    // 迭代器里定义了两个用于迭代的方法
    public abstract boolean hasNext();
    public abstract Object next();
}
