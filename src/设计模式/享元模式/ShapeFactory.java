package 设计模式.享元模式;

import java.util.HashMap;

/**
 * @ClassName ShapeFactory
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 21:10
 *
 * 创建一个工厂，生成基于给定信息的实体类的对象。
 */
public class ShapeFactory {

    // ShapeFactory 有一个 Circle 的 HashMap，其中键名为 Circle 对象的颜色。
    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    // 无论何时接收到请求，都会创建一个特定颜色的圆。ShapeFactory 检查它的 HashMap 中的 circle 对象，
    // 如果找到 Circle 对象，则返回该对象，否则将创建一个存储在 hashmap 中以备后续使用的新对象，并把该对象返回到客户端。
    public static Shape getCircle(String color){
        // 根据颜色是否存在，选择创建对象
        Circle circle =  (Circle) circleMap.get(color);
        if (circle == null){
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}
