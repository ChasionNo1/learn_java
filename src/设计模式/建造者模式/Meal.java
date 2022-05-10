package 设计模式.建造者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Meal
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 19:14
 *
 * 创建一个 Meal 类，带有上面定义的 Item 对象。
 */
public class Meal {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;
        for (Item item :
                items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item :
                items) {
            System.out.print("item:" + item.name());
            System.out.print(", packing:" + item.packing().pack());
            System.out.println(", price:" + item.price());
        }
    }

}
