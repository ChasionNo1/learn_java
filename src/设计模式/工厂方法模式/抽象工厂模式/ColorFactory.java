package 设计模式.工厂方法模式.抽象工厂模式;

/**
 * @ClassName ColorFactory
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 16:26
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if (color == null){
            return null;
        }
        if (color.equalsIgnoreCase("red")){
            return new Red();
        }else if (color.equalsIgnoreCase("green")){
            return new Green();
        }else if (color.equalsIgnoreCase("blue")){
            return new Blue();
        }

        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
