package 设计模式.建造者模式;

/**
 * @ClassName Coke
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 19:10
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "可口可乐";
    }

    @Override
    public float price() {
        return 3.0f;
    }
}
