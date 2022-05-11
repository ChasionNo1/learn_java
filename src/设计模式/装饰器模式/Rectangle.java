package 设计模式.装饰器模式;

/**
 * @ClassName Rectangle
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 19:10
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
