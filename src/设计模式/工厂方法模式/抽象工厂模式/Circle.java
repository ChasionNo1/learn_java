package 设计模式.工厂方法模式.抽象工厂模式;

/**
 * @ClassName Circle
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 16:17
 *
 *
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
