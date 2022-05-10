package 设计模式.建造者模式;

/**
 * @ClassName Wrapper
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 19:04
 *
 * 创建实现 Packing 接口的实体类。
 */
public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "Wrapper";
    }
}
