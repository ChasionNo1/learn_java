package 设计模式.建造者模式;

/**
 * @ClassName Burger
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 19:05
 *
 * 创建实现 Item 接口的抽象类，该类提供了默认的功能。
 * 对于汉堡来说，打包方式是统一的
 */
public abstract class Burger implements Item{

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
