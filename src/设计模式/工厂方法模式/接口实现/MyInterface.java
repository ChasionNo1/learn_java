package 设计模式.工厂方法模式.接口实现;

/**
 * @ClassName MyInterface
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/8 15:00
 */
public interface MyInterface {

    public abstract void open();
    void print();
    void close();
    // 接口里可以使用默认方法实现模板方法
    public default void display(){
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
