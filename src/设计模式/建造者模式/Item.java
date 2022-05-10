package 设计模式.建造者模式;

/**
 * @ClassName Item
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 19:03
 *
 * 创建一个表示食物条目接口
 */
public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
