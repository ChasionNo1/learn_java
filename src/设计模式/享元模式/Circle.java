package 设计模式.享元模式;

/**
 * @ClassName Circle
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 21:08
 *
 * 创建实现接口的实体类。
 */
public class Circle implements Shape {

    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color
                +", x : " + x +", y :" + y +", radius :" + radius + "]");
    }
}
