package 设计模式.迭代器模式.example;

/**
 * @ClassName Aggregate
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/5 20:49
 *
 * 接口里可以有：
 * 局部变量 public static final
 * 抽象方法 abstract
 * 默认方法 default
 * 静态方法 static
 * 私有方法 private
 *
 * 表示集合的接口
 */
public interface Aggregate {
    // 定义了一个抽象方法，迭代方法
    public abstract Iterator iterator();
}
