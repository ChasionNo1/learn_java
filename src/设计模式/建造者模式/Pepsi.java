package 设计模式.建造者模式;

/**
 * @ClassName Pepsi
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 19:11
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "百事可乐";
    }

    @Override
    public float price() {
        return 3.5f;
    }
}
