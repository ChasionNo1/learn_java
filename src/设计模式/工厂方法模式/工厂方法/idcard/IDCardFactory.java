package 设计模式.工厂方法模式.工厂方法.idcard;

import 设计模式.工厂方法模式.工厂方法.framework.Factory;
import 设计模式.工厂方法模式.工厂方法.framework.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName IDCardFactory
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/8 15:49
 */
public class IDCardFactory extends Factory {
    private List owners = new ArrayList();
    private HashMap<String, Long> map = new HashMap<>();
    private long id = 10000;

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
        map.put(((IDCard)product).getOwner(), ((IDCard)product).getId());
    }

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner, id++);
    }

    public List getOwners(){
        return owners;
    }
}
