package 设计模式.观察者模式;

/**
 * @ClassName Observer
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 20:19
 *
 * 创建 Observer 类。
 */
public abstract class Observer {
    // 被公共观察的对象
    protected Subject subject;
    public abstract void update();
}
