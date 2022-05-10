package 设计模式.工厂方法模式.抽象工厂模式;

/**
 * @ClassName Green
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 16:19
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
