package 设计模式.装饰器模式;

/**
 * @ClassName RedShapeDecorator
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 19:14
 */
public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
