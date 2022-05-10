package 设计模式.工厂方法模式.模板方法;

/**
 * @ClassName Main
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/8 14:09
 *
 *
 * 模板方法模式：
 * 父类中定义处理流程的框架，在子类中实现具体处理的模式
 *
 * AbstractClass(抽象类):抽象类角色不仅负责实现模板方法，还负责声明在模板方法中所使用到的抽象方法。
 *                      这些抽象方法由子类具体类角色负责实现。
 * ConcreteClass(具体类):该角色负责具体实现AbstractClass角色中定义的方法，这里实现的发将会在抽象类角色的模板方法中被调用
 *
 *
 * 父类中定义了抽象方法，还用final修饰了这些抽象方法的使用模板，这个不需要子类去实现，只需要实现具体的操作即可
 *
 */
public class Main {

    public static void main(String[] args) {
        AbstractDisplay d1 = new CharDisplay('H');
        AbstractDisplay d2 = new StringDisplay("Hello, world.");
        AbstractDisplay d3 = new StringDisplay("你好，世界。");
        d1.display();
        d2.display();
        d3.display();
    }
}
