package 设计模式.建造者模式;

/**
 * @ClassName Bottle
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 19:05
 *
 * 创建实现 Packing 接口的实体类。
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
