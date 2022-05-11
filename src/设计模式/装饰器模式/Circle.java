package 设计模式.装饰器模式;

/**
 * @ClassName Circle
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 19:11
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
