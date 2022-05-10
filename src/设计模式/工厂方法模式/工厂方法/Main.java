package 设计模式.工厂方法模式.工厂方法;

import 设计模式.工厂方法模式.工厂方法.framework.Product;
import 设计模式.工厂方法模式.工厂方法.idcard.IDCard;
import 设计模式.工厂方法模式.工厂方法.idcard.IDCardFactory;

/**
 * @ClassName Main
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/8 15:52
 *
 *  Product（产品）：由factory生产，产品本身具有一些接口，比如生产手机的厂商生产手机，具有打电话，发短信，听音乐，拍照等功能（api）
 *  creator（创建者）：抽象工厂类，定义生产产品的模板方法，具有实现由子类完成
 *  concreteProduct（具体的产品）：决定具体产品的属性，功能等
 *  concreteCreator（具体的创建者）：负责生产具体的产品
 *
 */
public class Main {

    public static void main(String[] args) {

        IDCardFactory idCardFactory = new IDCardFactory();
        Product card1 = idCardFactory.create("小明");
        Product card2 = idCardFactory.create("小红");
        card1.use();
        card2.use();
    }
}
