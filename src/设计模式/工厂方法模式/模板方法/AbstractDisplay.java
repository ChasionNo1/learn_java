package 设计模式.工厂方法模式.模板方法;

/**
 * @ClassName AbstractDisplay
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/8 14:10
 */
public abstract class AbstractDisplay {

    public abstract void open();
    public abstract void print();
    public abstract void close();
    public final void display(){
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
