package 设计模式.建造者模式;

/**
 * @ClassName VegBurger
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 19:09
 *
 * 创建扩展了 Burger 和 ColdDrink 的实体类。
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
