package day04_review.demo02_java常用类.java比较器;

/**
 * @program: test
 * @author: chasion
 * @create: 2021-12-15 09:58
 */
public class Goods implements Comparable {
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    // 指明商品比较大小的方式:按照价格
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            // 方式一：
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else {
                return -1;
            }
//            方式二
            //return Double.compare(this.price, goods.price);
        }
        throw new RuntimeException("传入数据类型不一致");
    }
}
