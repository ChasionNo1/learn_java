package 设计模式.建造者模式;

/**
 * @ClassName ColdDrink
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 19:
 *
 * 创建实现 Item 接口的抽象类，该类提供了默认的功能。
 */
public abstract class ColdDrink implements Item{

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
