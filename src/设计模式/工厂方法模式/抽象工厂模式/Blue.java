package 设计模式.工厂方法模式.抽象工厂模式;

/**
 * @ClassName Blue
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 16:19
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
