package 设计模式.工厂方法模式.工厂方法.idcard;

import 设计模式.工厂方法模式.工厂方法.framework.Product;

/**
 * @ClassName IDCard
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/8 15:47
 */
public class IDCard extends Product {

    private String owner;
    private long id;

    // 构造函数不是public的，只能由同一个包下使用，也就是由工厂内部生产
    IDCard(String owner, long id){
        System.out.println("制作" + owner + "的ID卡");
        this.owner = owner;
        this.id = id;
    }
    @Override
    public void use() {
        System.out.println("使用" + owner + "的ID卡");
    }

    public String getOwner(){
        return owner;
    }

    public long getId() {
        return id;
    }
}
