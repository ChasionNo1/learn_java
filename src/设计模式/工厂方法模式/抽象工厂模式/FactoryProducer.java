package 设计模式.工厂方法模式.抽象工厂模式;

/**
 * @ClassName FactoryProducer
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 16:28
 *
 * 创建一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂。
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if (choice.equalsIgnoreCase("shape")){
            return new ShapeFactory();
        }else if (choice.equalsIgnoreCase("color")){
            return new ColorFactory();
        }
        return null;
    }
}
