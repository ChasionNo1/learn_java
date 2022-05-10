package 设计模式.工厂方法模式.抽象工厂模式;

/**
 * @ClassName Square
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 16:17
 *
 *
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
