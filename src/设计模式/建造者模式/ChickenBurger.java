package 设计模式.建造者模式;

/**
 * @ClassName ChickenBurger
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 19:10
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "chicken burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}
