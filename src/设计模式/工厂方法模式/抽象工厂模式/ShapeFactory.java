package 设计模式.工厂方法模式.抽象工厂模式;

/**
 * @ClassName ShapeFactory
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 16:22
 *
 * 创建扩展了 AbstractFactory 的工厂类，基于给定的信息生成实体类的对象。
 */
public class ShapeFactory extends AbstractFactory{

    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {

        if (shape == null){
            return null;
        }
        if (shape.equalsIgnoreCase("circle")){
            return new Circle();
        }else if (shape.equalsIgnoreCase("rectangle")){
            return new Rectangle();
        }else if (shape.equalsIgnoreCase("square")){
            return new Square();
        }
        return null;
    }
}
