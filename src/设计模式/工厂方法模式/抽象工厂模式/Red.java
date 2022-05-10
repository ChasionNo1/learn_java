package 设计模式.工厂方法模式.抽象工厂模式;

/**
 * @ClassName Red
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 16:18
 *
 * 创建实现接口的实体类。
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
