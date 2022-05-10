package 设计模式.工厂方法模式.抽象工厂模式;

/**
 * @ClassName Rectangle
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 16:16
 *
 * 创建实现接口的实体类。
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
