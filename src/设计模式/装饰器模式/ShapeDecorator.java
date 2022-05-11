package 设计模式.装饰器模式;

/**
 * @ClassName ShapeDecorator
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 19:11
 *
 * 创建实现了 Shape 接口的抽象装饰类。
 * 把 Shape 对象作为实例变量。
 *
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;
    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }


    public void draw(){
        decoratedShape.draw();
    }
}
