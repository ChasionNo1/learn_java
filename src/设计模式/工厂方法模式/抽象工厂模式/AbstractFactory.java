package 设计模式.工厂方法模式.抽象工厂模式;

/**
 * @ClassName AbstractFactor
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 16:20
 *
 * 为 Color 和 Shape 对象创建抽象类来获取工厂。
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);

}
